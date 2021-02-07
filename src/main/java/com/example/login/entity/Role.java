package com.example.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * @author jijianchang
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="角色", description="")
public class Role {
    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty(value = "角色名")
    @TableField("rolename")
    private String roleName;

    @ApiModelProperty(value = "角色对应权限集合")
    private Set<Permissions> permissions;
}
