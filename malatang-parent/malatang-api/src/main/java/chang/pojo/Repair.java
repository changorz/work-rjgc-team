package chang.pojo;


import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "重修名单实体类")
public class Repair implements Serializable {
    @ApiModelProperty(value = "id",example = "1")
    private int id;
    @ExcelProperty(value = "学号", index = 0)
    @ApiModelProperty(value = "学号",allowEmptyValue = false)
    private String xh;
    @ExcelProperty(value = "姓名", index = 1)
    @ApiModelProperty(value = "姓名",allowEmptyValue = false)
    private String name;
    @ExcelProperty(value = "学年学期", index = 2)
    @ApiModelProperty(value = "学年学期",allowEmptyValue = false)
    private String xqid;
    @ExcelProperty(value = "课程编号", index = 3)
    @ApiModelProperty(value = "课程编号",allowEmptyValue = true)
    private String kcbh;
    @ExcelProperty(value = "课程名称", index = 4)
    @ApiModelProperty(value = "课程名称",allowEmptyValue = false)
    private String kcmc;
    @ExcelProperty(value = "课程属性", index = 5)
    @ApiModelProperty(value = "课程属性",allowEmptyValue = true)
    private String kcsx;
    @ExcelProperty(value = "课程性质", index = 6)
    @ApiModelProperty(value = "课程性质",allowEmptyValue = true)
    private String kcxz;
    @ExcelProperty(value = "总成绩", index = 7)
    @ApiModelProperty(value = "总成绩",allowEmptyValue = true)
    private String zcj;
    @ExcelProperty(value = "学分", index = 8)
    @ApiModelProperty(value = "学分",allowEmptyValue = false)
    private String xf;
    @ExcelProperty(value = "上课院系", index = 9)
    @ApiModelProperty(value = "上课院系",allowEmptyValue = true)
    private String skyx;
    @ExcelProperty(value = "上课年级", index = 10)
    @ApiModelProperty(value = "上课年级",allowEmptyValue = true)
    private String sknj;
    @ExcelProperty(value = "上课专业", index = 11)
    @ApiModelProperty(value = "上课专业",allowEmptyValue = true)
    private String skzy;
    @ExcelProperty(value = "上课班级", index = 12)
    @ApiModelProperty(value = "上课班级",allowEmptyValue = true)
    private String skbj;
    @ExcelProperty(value = "任课老师", index = 13)
    @ApiModelProperty(value = "任课老师",allowEmptyValue = true)
    private String rkls;
    @ExcelProperty(value = "更新时间", index = 14)
    @ApiModelProperty(value = "更新时间",allowEmptyValue = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime endTime;
}
