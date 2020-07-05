package chang.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "轮播图图片实体类")
public class Viewpager implements Serializable {
    @ApiModelProperty(value = "id",example = "1")
    private int id;
    @ApiModelProperty(value = "图片地址",allowEmptyValue = true)
    private String url;
}
