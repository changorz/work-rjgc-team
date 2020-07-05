package chang.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@ApiModel("反馈实体类")
public class Feedback {

    @ApiModelProperty(value = "id",example = "1", hidden = true,allowEmptyValue = true)
    private int id;
    @ApiModelProperty(value = "微信的openid",  allowEmptyValue = false)
    private String openid;
    @ApiModelProperty(value = "反馈的内容", allowEmptyValue = false)
    private String context;
    @ApiModelProperty(value = "提交时间",  allowEmptyValue = false,hidden = true)
    private LocalDateTime time;
    @ApiModelProperty(value = "反馈状态",  hidden = true,allowEmptyValue = true)
    private int dispose;

}
