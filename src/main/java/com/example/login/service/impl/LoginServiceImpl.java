package com.example.login.service.impl;

import com.example.login.entity.User;
import com.example.login.mapper.LoginMapper;
import com.example.login.service.LoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jjc
 * @since 2021-02-07
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, User> implements LoginService {

    @Override
    public User getUserByName(String getMapByName) {
        return null;
    }
}
