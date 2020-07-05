package chang.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@ApiModel(value = "微信登录记录")
public class WxUser implements Serializable {

    @ApiModelProperty(value = "微信的openid",allowEmptyValue = false)
    private String openid;
    @ApiModelProperty(value = "昵称",allowEmptyValue = false)
    private String nickname;
    @ApiModelProperty(value = "微信头像的路径",allowEmptyValue = false)
    private String headImgUrl;
    @ApiModelProperty(value = "国家",allowEmptyValue = false)
    private String country;
    @ApiModelProperty(value = "省",allowEmptyValue = false)
    private String province;
    @ApiModelProperty(value = "城市",allowEmptyValue = false)
    private String city;
    @ApiModelProperty(value = "性别",allowEmptyValue = false)
    private String sex;
    @ApiModelProperty(value = "登录次数",allowEmptyValue = false)
    private int logincount;
    @ApiModelProperty(value = "最后登录时间",allowEmptyValue = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime endtimt;
    @ApiModelProperty(value = "学号",allowEmptyValue = true)
    private String xh;
    @ApiModelProperty(value = "锁定时间，单位:秒, 默认是0",allowEmptyValue = true)
    private String flag;

}
