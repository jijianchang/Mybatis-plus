package com.example.login.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2021-02-07
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(value = "/user", method = RequestMethod.POST)
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


        
        @ApiOperation(value="浏览", notes="浏览")
        @PostMapping("/show")
        public String showUser() {
            return "这是学生信息";
        }


}

