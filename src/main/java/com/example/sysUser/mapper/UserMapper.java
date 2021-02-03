package com.example.sysUser.mapper;

import com.example.sysUser.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jjc
 * @since 2021-02-02
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    public User findall();

    public List<User> selectall();

}
