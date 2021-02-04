package com.example.sysUser.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sysUser.entity.User;
import com.example.sysUser.service.UserService;
import com.example.utils.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2021-02-04
 */
@Slf4j
@RestController
@RequestMapping("/sysUser/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/getbyid")
    @ApiOperation(value="根据id获取", notes="根据id获取")
    public Result<JSONObject> getbyid(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        Result<JSONObject> result = new Result<>();
        userQueryWrapper.eq("age",69);
        User user = userService.getOne(userQueryWrapper);
        result.setSuccess(true);
        result.setResult(JSON.parseObject(JSON.toJSONString(user)));
        return result;
    }

}

