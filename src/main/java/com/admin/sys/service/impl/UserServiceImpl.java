package com.admin.sys.service.impl;

import com.admin.sys.entity.User;
import com.admin.sys.mapper.UserMapper;
import com.admin.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
