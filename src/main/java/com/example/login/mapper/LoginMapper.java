package com.example.login.mapper;

import com.example.login.entity.Role;
import com.example.login.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2021-02-07
 */
public interface LoginMapper extends BaseMapper<User> {

     User getUserbyname(String name);
}
