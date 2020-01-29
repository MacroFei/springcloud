package com.xlccc.controller;

import com.xlccc.pojo.User;
import com.xlccc.service.UserService;
import com.xlccc.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserControllerFeign {

    @Autowired
    private UserService userService;
    //HttpClient 发送Http请求
    //RestTemplate 调用Rest服务
//    private static final String GLOBAL_URL = "http://localhost:8001/users";

    @GetMapping
    public ResponseResult getUserList() {
        //发送get请求，参数分别表示：请求路径，响应数据类型（//将返回的Json转换为ResponseResult对象）
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    public ResponseResult getUser(@PathVariable Integer id) {
        //发送get请求，参数分别表示：请求路径，响应数据类型，占位符的值，其中{id}表示占位符
        return userService.getUser(id);
    }

    @PostMapping
    public ResponseResult postUser(User user) {
        return userService.postUser(user.getUsername(),user.getPassword());
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteUser(@PathVariable Integer id) {
        /**
         * 对于delete和put请求，默认是无法接收返回值
         * 如果有返回值，则需要使用exchange()方法
         */
        return userService.deleteUser(id);
    }

//    @PutMapping
//    public ResponseResult putUser(User user) {
//        Map<String , Object> map = new HashMap<>();
//        map.put("id",user.getId());
//        map.put("username",user.getUsername());
//        map.put("password",user.getPassword());
//        return userService.putUser(map);
//    }
    //此处可以直接使用map来接收参数
    @PutMapping
    public ResponseResult putUser(@RequestParam Map map) {
        return userService.putUser(map);
    }

}
