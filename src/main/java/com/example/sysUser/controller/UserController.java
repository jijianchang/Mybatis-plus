package com.example.sysUser.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sysUser.entity.User;
import com.example.sysUser.service.UserService;
import com.example.config.exception.RRException;
import com.example.utils.Result;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
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

    @GetMapping("/exception")
    @ApiOperation(value="全局异常", notes="全局异常")
    public Result<String> getexception(@RequestParam Integer id) {
        if (id == 1) {
            throw new RRException("id不能为空！");
        }
        int i=1/0;
        Result<String> result = new Result<>();
        result.setSuccess(true);
        result.setResult("id有值");
        return result;

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value="登录", notes="登录")
    public Result<JSONObject> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        Result<JSONObject> result = new Result();
        if (subject.isAuthenticated()) {
            result.setSuccess(true);
            result.setMessage("登录成功");
            return result;
        } else {
            token.clear();
            result.setSuccess(false);
            result.setMessage("登录失败");
            return result;
        }
    }




}

