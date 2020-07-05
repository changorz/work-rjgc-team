package chang.listener;

import chang.dao.RepairMapper;
import chang.pojo.Repair;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UploadRepairEasyExcelListener extends AnalysisEventListener<Repair> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadRepairEasyExcelListener.class);

    private RepairMapper repairMapper;
    // private ESRepair esRepair;

    // 每隔1000条存储数据库，然后清理list，方便内存回收
    private static final int BATCH_COUNT = 100;
    List<Repair> list = new ArrayList<Repair>();

    // 存储解析excel条数
    private int count = 0;

    public UploadRepairEasyExcelListener(RepairMapper repairMapper) {
        this.repairMapper = repairMapper;
    }

    @Override
    public void invoke(Repair repair, AnalysisContext analysisContext) {
        if(StringUtils.isEmpty(repair.getXh()) ||  "学号".equals(repair.getXh())){
            return;
        }
        repair.setEndTime(LocalDateTime.now());
        list.add(repair);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        repairMapper.addRepairList(list);
        LOGGER.info("存储数据库成功！");
    }

}
