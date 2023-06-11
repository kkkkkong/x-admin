package com.admin.sys.service;

import com.admin.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author kong
 * @since 2023-06-10
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(User user);
}
