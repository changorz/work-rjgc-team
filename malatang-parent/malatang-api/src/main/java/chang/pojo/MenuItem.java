package chang.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "菜单项实体类")
public class MenuItem implements Serializable {

    @ApiModelProperty(value = "id",example = "1")
    private int id;
    @ApiModelProperty(value = "权重",example = "1")
    private int weight;
    @ApiModelProperty(value = "分类标题", allowEmptyValue = true)
    private String title;
    @ApiModelProperty(value = "图标地址", allowEmptyValue = true)
    private String icon;
    @ApiModelProperty(value = "图标下的文字", allowEmptyValue = true)
    private String text;
    @ApiModelProperty(value = "重定向地址", allowEmptyValue = true)
    private String tourl;

}
