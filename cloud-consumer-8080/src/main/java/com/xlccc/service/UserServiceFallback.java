package com.xlccc.service;

import com.xlccc.vo.ResponseResult;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceFallback implements UserService {
    @Override
    public ResponseResult getUserList() {
        System.out.println("断路器开启：UserServiceFallback.getUserList");
        return ResponseResult.fail("获取用户列表失败");
    }

    @Override
    public ResponseResult getUser(Integer id) {
        return ResponseResult.fail("获取指定用户失败");
    }

    @Override
    public ResponseResult postUser(String username, String password) {
        return ResponseResult.fail("添加用户失败");
    }

    @Override
    public ResponseResult putUser(Map<String, Object> map) {
        return ResponseResult.fail("更新用户失败");
    }

    @Override
    public ResponseResult deleteUser(Integer id) {
        return ResponseResult.fail("删除用户失败");
    }
}
