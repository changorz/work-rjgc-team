package chang.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "分页查询")
@Data
public class Pager<T> implements Serializable {
/*
    value–字段说明
    name–重写属性名字
    dataType–重写属性类型
    required–是否必填
    example–举例说明
    hidden–隐藏
*/

    @ApiModelProperty(value = "分页起始页", example = "1")
    private int pageStart;
    @ApiModelProperty(value = "每页记录数", example = "1")
    private int pageSize;
    @ApiModelProperty(value = "返回的记录集合")
    private List<T> rows;
    @ApiModelProperty(value = "总记录条数",example = "1")
    private long total;

}
