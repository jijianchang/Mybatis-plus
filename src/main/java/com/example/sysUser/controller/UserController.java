package com.example.sysUser.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}

