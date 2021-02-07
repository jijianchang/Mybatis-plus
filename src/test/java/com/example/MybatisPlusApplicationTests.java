package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.login.entity.User;
import com.example.login.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private LoginService loginService;

    /*@Test
    public void test1(){
        User user = new User();
        user.setUsername("jjc");
        user.setPassword("123");
        user.setAge(12);
        user.setEmail("tom@163.com");
        loginService.save(user);
    }
    @Test
    public void test2(){
        User user = new User();
        user.setUsername("jjc");
        user.setPassword("123");
        user.setAge(12);
        user.setEmail("tom@163.com");
        loginService.save(user);
    }*/
/*    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }
    @Test
    public void testAutoFill() {
        User user = new User();
        user.setUsername("tom");
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
        user.setUsername("tom");
        user.setAge(12);
        user.setEmail("tom@163.com");
        userService.save(user);
        userService.list().forEach(System.out::println);
        user.setUsername("jarry");
        userService.update(user, null);
        userService.list().forEach(System.out::println);
    }


    @Test
    public void test1() {
        User user = new User();
        user.setUsername("tom");
        user.setAge(16);
        user.setEmail("tom@163.com");
        user.setId(1356470619356344321L);
      //  userMapper.insert(user);
      //  userMapper.deleteById("1356470619356344321");
//        userMapper.updateById(user);
//        User user1 = userMapper.selectById(1356470619356344321L);
//        System.out.println(user1);
     *//*   List<User> users = userMapper.selectList(null);
        for (User user1 : users) {
            System.out.println(user1);
        }*//*
       *//* List<User> list = userMapper.findall();
        for (User user1 : list) {
            System.out.println(user1);
        }*//*

    }

    @Test
    public void test2(){
        User user = new User();
        user.setUsername("tyrtt");
        user.setAge(16);
        user.setEmail("ruy@163.com");
        user.setId(1356603225096060931L);
//        userService.save(user);
        userService.saveOrUpdate(user);

    }

 *//*   @Test
    public void testQueryWrapper() {
        // Step1：创建一个 QueryWrapper 对象
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // Step2： 构造查询条件
        queryWrapper
                .select("id", "name", "age")
                .eq("age", 20)
                .like("name", "j");

        // Step3：执行查询
        userService
                .list(queryWrapper)
                .forEach(System.out::println);
    }*//*

    @Test
    public void testQueryWrapper(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        *//*queryWrapper.eq("NAME","tom");
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);*//*
        queryWrapper.eq("age",12);
       *//* Integer count = userMapper.selectCount(queryWrapper);
        System.out.println(count);*//*
       *//* List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);*//*
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        System.out.println(maps);


    }

    @Test
    public void testLambdaQueryWrapper(){
       *//* LambdaQueryWrapper<User> lambdaQuery= Wrappers.<User>lambdaQuery();
        lambdaQuery.likeRight(User::getName,"t")
                .and(lqw->lqw.lt(User::getAge,15).or().isNotNull(User::getEmail));
        List<User> userList=userMapper.selectList(lambdaQuery);*//*
        List<User> userList=new LambdaQueryChainWrapper<User>(userMapper)
                .like(User::getUsername,"t").le(User::getAge,20).list();
        userList.forEach(System.out::println);
    }

    @Test
    public void testLambdaUpdateWrapper(){
        LambdaUpdateWrapper<User> lambdaUpdate = Wrappers.lambdaUpdate();
        lambdaUpdate.eq(User::getAge,12).set(User::getUsername,"jovk");
        userMapper.update(null,lambdaUpdate);


    }*/

}
