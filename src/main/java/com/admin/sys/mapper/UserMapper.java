package com.admin.sys.mapper;

import com.admin.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kong
 * @since 2023-06-10
 */
public interface UserMapper extends BaseMapper<User> {
    List<String> selectRoleNameByUserId(Integer userId);
}
