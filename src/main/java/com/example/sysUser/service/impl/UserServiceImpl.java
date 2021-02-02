package com.example.sysUser.service.impl;

import com.example.sysUser.entity.User;
import com.example.sysUser.mapper.UserMapper;
import com.example.sysUser.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjc
 * @since 2021-02-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
