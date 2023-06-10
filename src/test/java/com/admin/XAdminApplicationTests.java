package com.admin;

import com.admin.sys.entity.User;
import com.admin.sys.mapper.UserMapper;
import com.admin.sys.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class XAdminApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    void testUserMapper() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
