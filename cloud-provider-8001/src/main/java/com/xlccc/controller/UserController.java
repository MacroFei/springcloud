package com.xlccc.controller;

import com.xlccc.pojo.User;
import com.xlccc.vo.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "用户的API接口")
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     *     模拟数据库
     */
    static Map<Integer, User> users = new HashMap<>();
    static int id = 1;

    //获取用户列表
    @ApiOperation(value = "获取用户列表",notes = "获取所有用户信息（备注）")
    @GetMapping
    public ResponseResult getUserList() {

        System.out.println("访问...UserController.getUserList");
        int i = 5 / 0 ;

        List<User> list = new ArrayList<>(users.values());
        return ResponseResult.success(list);
    }

    @ApiOperation(value = "获取指定的用户",notes="根据url中的id获取指定用户信息")
    @ApiImplicitParam(name="id",value = "用户ID",dataType = "Integer",required = true)
    @GetMapping("/{id}")
    public ResponseResult getUser(@PathVariable Integer id) {
        return ResponseResult.success(users.get(id));
    }

    @ApiOperation(value = "添加用户",notes = "根据用户信息更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username" , value = "用户名",required = true),
            @ApiImplicitParam(name = "password" , value = "密码",required = true)
    })
    @PostMapping
    public ResponseResult postUser(User user) {
        user.setId(id++);
        users.put(user.getId(), user);
        return ResponseResult.success();
    }

    @ApiOperation(value = "删除用户",notes = "根据url中的id删除指定的用户")
    @ApiImplicitParam(name="id",value = "用户ID",dataType = "Integer",required = true)
    @ApiIgnore //使用swagger2路径id可能无法测试
    @DeleteMapping("/{id}")
    public ResponseResult deleteUser(@PathVariable Integer id ){
        users.remove(id);
        return  ResponseResult.success();
    }

    @ApiOperation(value = "修改用户" , notes = "根据ID修改指定用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username" , value = "用户名",required = true),
            @ApiImplicitParam(name = "password" , value = "密码",required = true)
    })
    @PutMapping
    public ResponseResult putUser(User user ){
        User u = users.get(user.getId());
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
//        users.put(u.getId(),u);
        return ResponseResult.success();
    }




}
