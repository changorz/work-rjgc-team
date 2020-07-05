package chang.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "电话号码实体类")
public class PhoneCode implements Serializable {

    @ApiModelProperty(value = "id", example = "1")
    private int id;
    @ApiModelProperty(value = "姓名")
    @ExcelProperty(value = "姓名", index = 0)
    private String name;
    @ApiModelProperty(value = "联系方式")
    @ExcelProperty(value = "联系方式", index = 1)
    private String number;

}
