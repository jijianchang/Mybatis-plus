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
@Controller
@RequestMapping("/user")
public class UserController {

    @RequiresPermissions("user:add")
    @RequestMapping(value = "/add")
    @ApiOperation(value="浏览", notes="浏览")
    public String showUser() {
        return "user/add";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/update")
    @ApiOperation(value="管理员", notes="管理员")
    public String adminUser() {
        return "user/update";
    }


}

