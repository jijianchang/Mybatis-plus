package com.example.sysUser.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.sysUser.entity.User;
import com.example.sysUser.mapper.UserMapper;
import com.example.sysUser.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private UserMapper userMapper;
    @Override
    public User findAll() {
        return userMapper.findall();
    }

    @Override
    public List<User> selectall() {
        return userMapper.selectall();
    }

    @Override
    public void updatebyid() {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id",1356449881186443266L).set("age",69);
        userMapper.update(null,userUpdateWrapper);
    }
}
