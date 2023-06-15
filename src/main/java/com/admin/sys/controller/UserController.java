package com.admin.sys.controller;

import com.admin.common.vo.Result;
import com.admin.sys.entity.User;
import com.admin.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author kong
 * @since 2023-06-10
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService UserService;

    @GetMapping("all")
    public Result<List<User>> getAllUser() {
        List<User> list = UserService.list();
        return Result.success("查询成功", list);
    }

    @PostMapping("login")
    public Result<Map<String, Object>> login(@RequestBody User user) {
        Map<String, Object> mapResult = UserService.login(user);
        if (mapResult != null) {
            return Result.success("登录成功", mapResult);
        }
        return Result.fail(20002, "用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<Map<String,Object>> getUserInfo(@RequestParam String token) {
        Map<String,Object> mapResult = UserService.getUserInfo(token);
        if (!mapResult.isEmpty()) {
            return Result.success("登录成功", mapResult);
        }
        return Result.fail(20003, "获取用户信息失败，请重新登录");
    }
    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token) {
        UserService.logout(token);
        return Result.success("退出成功");
    }
}
