package chang.dao.es;

import chang.pojo.Repair;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Repository
public class ESRepair {

    @Qualifier("restHighLevelClient")
    @Autowired
    RestHighLevelClient client;

    /**
     * 添加数据
     * @param list
     * @throws IOException
     */
    public void addList(List<Repair> list) throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("20s");
        list.forEach((e)->{
            System.out.println(e);
            bulkRequest.add(new IndexRequest("repair")
                    .id(UUID.randomUUID().toString().replace("-",""))
                    .source(JSON.toJSONString(e), XContentType.JSON));
        });
        BulkResponse bulk = client.bulk(bulkRequest, RequestOptions.DEFAULT);
    }

    /**
     * 删除索引
     * @throws IOException
     */
    public void deleteRepair() throws IOException {
        GetIndexRequest repair = new GetIndexRequest("repair");
        boolean exists = client.indices().exists(repair, RequestOptions.DEFAULT);
        if(exists){
            DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("repair");
            client.indices().delete(deleteIndexRequest,RequestOptions.DEFAULT);
        }
    }

    /**
     * 创建索引
     */
    public void createRepair() throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("repair");
        client.indices().create(createIndexRequest,RequestOptions.DEFAULT);
    }

}
