package com.example.login.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * <p>
 * 
 * </p>
 *
 * @author jjc
 * @since 2021-02-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "姓名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "角色")
    @TableField("role")
    private String role;

    @ApiModelProperty(value = "权限")
    @TableField("perms")
    private String perms;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time",fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    @ApiModelProperty(value = "最后修改时间")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;



    @ApiModelProperty(value = "逻辑删除（0 未删除、1 删除）")
    @TableLogic(value = "0",delval = "1")
    @TableField(value = "delete_flag",fill = FieldFill.INSERT)
    private Integer deleteFlag;

    @ApiModelProperty(value = "版本号（用于乐观锁， 默认为 1）")
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;

//    private Set<Role> roles;


}
