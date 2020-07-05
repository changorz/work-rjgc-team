package chang.model.response.plus;

import chang.model.response.ResponseResult;
import chang.model.response.ResultCode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ObjectResult extends ResponseResult {

    // 这个Object是一个实体类
    Object result;

    public ObjectResult(ResultCode resultCode, Object result){
        super(resultCode);
        this.result = result;
    }
}
