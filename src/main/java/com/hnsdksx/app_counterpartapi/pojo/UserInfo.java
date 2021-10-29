package com.hnsdksx.app_counterpartapi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@TableName("user_info")
public class UserInfo {
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(hidden = true)
    private long id;
    @NotEmpty(message = "用户名不能为空")
    private String user_name;
    @NotEmpty(message = "密码不能为空")
    private String password;
    private String email;
    @ApiModelProperty(hidden = true)
    private String last_login_time;
    @ApiModelProperty(hidden = true)
    private String last_login_ip;

}
