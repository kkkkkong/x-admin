package com.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class MyRedisConfig {
    @Autowired
    private RedisConnectionFactory factory;
    @Bean
    public RedisTemplate redisTemplate(){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
//        设置key的序列化方式
        template.setKeySerializer(RedisSerializer.string());
//        设置value的序列化方式
        template.setValueSerializer(RedisSerializer.json());
//        设置hash的key的序列化方式
        template.setHashKeySerializer(RedisSerializer.string());
//        设置hash的value的序列化方式
        template.setHashValueSerializer(RedisSerializer.json());
//        使设置生效
        template.afterPropertiesSet();
        return template;

    }
}
