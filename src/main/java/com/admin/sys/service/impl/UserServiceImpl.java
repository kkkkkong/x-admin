package com.admin.sys.service.impl;

import com.admin.sys.entity.User;
import com.admin.sys.mapper.UserMapper;
import com.admin.sys.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author kong
 * @since 2023-06-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public Map<String, Object> login(User user) {
//        根据用户名和密码查询用户
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        wrapper.eq(User::getPassword, user.getPassword());
        User user1 = this.baseMapper.selectOne(wrapper);

//        结果不为空，则生成token，存入redis
        if (user1 != null) {
//            暂时使用uuid，终极方案是使用jwt
            String token = "user:"+ UUID.randomUUID();
//            存入redis
            user1.setPassword(null);
            redisTemplate.opsForValue().set(token, user1, 30, TimeUnit.MINUTES);



//            返回数据
            Map<String, Object> map = new HashMap<>();
            map.put("token", token);
            return map;
        }
        return null;
    }
}
