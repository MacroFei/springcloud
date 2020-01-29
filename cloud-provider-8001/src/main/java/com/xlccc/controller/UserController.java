package com.xlccc.controller;

import com.xlccc.pojo.User;
import com.xlccc.vo.ResponseResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    //模拟数据库
    static Map<Integer, User> users = new HashMap<>();
    static int id = 1;

    //获取用户列表
    @GetMapping
    public ResponseResult getUserList() {
        List<User> list = new ArrayList<>(users.values());
        return ResponseResult.success(list);
    }

    @GetMapping("/{id}")
    public ResponseResult getUser(@PathVariable Integer id) {
        return ResponseResult.success(users.get(id));
    }

    @PostMapping
    public ResponseResult postUser(User user) {
        user.setId(id++);
        users.put(user.getId(), user);
        return ResponseResult.success();
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteUser(@PathVariable Integer id ){
        users.remove(id);
        return  ResponseResult.success();
    }

    @PutMapping
    public ResponseResult putUser(User user ){
        User u = users.get(user.getId());
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
//        users.put(u.getId(),u);
        return ResponseResult.success();
    }


}
