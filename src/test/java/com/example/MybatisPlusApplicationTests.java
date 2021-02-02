package com.example;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sysUser.entity.User;
import com.example.sysUser.mapper.UserMapper;
import com.example.sysUser.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }
    @Test
    public void testAutoFill() {
        User user = new User();
        user.setName("tom");
        user.setAge(12);
        user.setEmail("tom@163.com");

        if (userService.save(user)) {
            userService.list().forEach(System.out::println);
        } else {
            System.out.println("添加数据失败");
        }
    }

    @Test
    public void testDelete() {
        if (userService.removeById(1356443684786008065L)) {
            System.out.println("删除数据成功");
            userService.list().forEach(System.out::println);
        } else {
            System.out.println("删除数据失败");
        }
    }

    @Test
    public void testPage() {
        // Step1：创建一个 Page 对象
        Page<User> page = new Page<>();
        // Page<User> page = new Page<>(2, 5);
        // Step2：调用 mybatis-plus 提供的分页查询方法
        userService.page(page, null);
        // Step3：获取分页数据
        System.out.println(page.getCurrent()); // 获取当前页
        System.out.println(page.getTotal()); // 获取总记录数
        System.out.println(page.getSize()); // 获取每页的条数
        System.out.println(page.getRecords()); // 获取每页数据的集合
        System.out.println(page.getPages()); // 获取总页数
        System.out.println(page.hasNext()); // 是否存在下一页
        System.out.println(page.hasPrevious()); // 是否存在上一页
    }

    @Test
    public void testVersion() {
        User user = new User();
        user.setName("tom");
        user.setAge(12);
        user.setEmail("tom@163.com");
        userService.save(user);
        userService.list().forEach(System.out::println);
        user.setName("jarry");
        userService.update(user, null);
        userService.list().forEach(System.out::println);
    }


    @Test
    public void test1() {
        User user = new User();
        user.setName("ttt");
        user.setAge(16);
        user.setEmail("tom@163.com");
        user.setId(1356470619356344321L);
      //  userMapper.insert(user);
      //  userMapper.deleteById("1356470619356344321");
//        userMapper.updateById(user);
//        User user1 = userMapper.selectById(1356470619356344321L);
//        System.out.println(user1);
     /*   List<User> users = userMapper.selectList(null);
        for (User user1 : users) {
            System.out.println(user1);
        }*/
       /* List<User> list = userMapper.findall();
        for (User user1 : list) {
            System.out.println(user1);
        }*/

    }

}
