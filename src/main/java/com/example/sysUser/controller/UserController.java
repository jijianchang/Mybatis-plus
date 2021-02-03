package com.example.sysUser.controller;


import com.example.sysUser.entity.User;
import com.example.sysUser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jjc
 * @since 2021-02-02
 */
@RestController
@RequestMapping("/sysUser/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/findall")
    public User findAll(){
       return userService.findAll();
    }

    @GetMapping("/selectall")
    public List<User> selectAll(){
        return userService.selectall();
    }

    @GetMapping("/updatebyid")
    public void updateById(){
         userService.updatebyid();
    }

}

