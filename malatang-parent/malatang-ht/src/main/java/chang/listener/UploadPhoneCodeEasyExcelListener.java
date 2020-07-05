package chang.listener;

import chang.dao.PhoneCodeMapper;
import chang.pojo.PhoneCode;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.ParameterMapper;

import java.util.ArrayList;
import java.util.List;

public class UploadPhoneCodeEasyExcelListener extends AnalysisEventListener<PhoneCode> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadPhoneCodeEasyExcelListener.class);

    private static final int BATCH_COUNT = 50;
    List<PhoneCode> list = new ArrayList<PhoneCode>();

    private PhoneCodeMapper phoneCodeMapper;

    public UploadPhoneCodeEasyExcelListener(PhoneCodeMapper phoneCodeMapper) {
        this.phoneCodeMapper = phoneCodeMapper;
    }

    @Override
    public void invoke(PhoneCode data, AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        list.add(data);
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
        phoneCodeMapper.addPhoneCodeList(list);
        LOGGER.info("存储数据库成功！");
    }

}
