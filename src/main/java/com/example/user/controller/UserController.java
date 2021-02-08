package com.example.user.controller;

import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jijianchang
 */
@RestController
public class UserController {

    @RequiresPermissions("user:show")
    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @ApiOperation(value="浏览", notes="浏览")
    public String showUser() {
        return "这是学生信息";
    }

    @RequiresPermissions("user:admin")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    @ApiOperation(value="管理员", notes="管理员")
    public String adminUser() {
        return "这是管理员信息";
    }


}

