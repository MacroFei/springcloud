package com.xlccc.service;

import com.xlccc.pojo.User;
import com.xlccc.vo.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;
import javax.xml.ws.Response;
import java.util.Map;

// 调用的服务器，到Eureka中查找对应的服务名，找到的是：微服务的ip：端口，即http://localhost:8001
@FeignClient(value = "user-provider")
@Service
public interface UserService {
    @GetMapping("/users")
    public ResponseResult getUserList();

    @GetMapping("/users/{id}")
    public ResponseResult getUser(@PathVariable("id") Integer id);

    @PostMapping("/users")
    public ResponseResult postUser(User user);

    @DeleteMapping("/users/{id}")
    public ResponseResult deleteUser(@PathVariable Integer id);

//    @PutMapping("/users")
//    public ResponseResult putUser(User user);
    @PutMapping("/users")
    public ResponseResult putUser(@RequestParam Map<String , Object> map);

}
