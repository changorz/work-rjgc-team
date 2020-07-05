package chang.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("评分实体类")
public class Grade implements Serializable {

    @ApiModelProperty(value = "微信的openid")
    private String openid;
    @ApiModelProperty(value = "评分，0至5分", example = "1")
    private int number;

}
