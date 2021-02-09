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
@Controller
public class LoginController {
    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
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
    }*/

    @RequestMapping(value = "/login")
    @ApiOperation(value="登录", notes="登录")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        if (subject.isAuthenticated()) {
           return "index";
        } else {
            token.clear();
            return "login";
        }
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String notRole(){
        return "无权限访问";
    }
        



}

