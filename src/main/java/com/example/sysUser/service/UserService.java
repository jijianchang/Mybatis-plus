package com.example.sysUser.service;

import com.example.sysUser.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jjc
 * @since 2021-02-02
 */
public interface UserService extends IService<User> {

    User findAll();
}
