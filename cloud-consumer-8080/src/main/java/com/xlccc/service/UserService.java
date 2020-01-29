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
//@FeignClient(value = "user-provider",fallback = UserServiceFallback.class)
// 所有微服务的访问都要通过Zuul进行路由跳转
//@FeignClient(value = "zuul-gateway",fallback = UserServiceFallback.class)
@FeignClient(value = "zuul-gateway",fallback = UserServiceFallback.class)
@Service
public interface UserService {
//    @GetMapping("/users")
    @GetMapping("/v2/user-service/users")
    public ResponseResult getUserList();

//    @GetMapping("/users/{id}")
    @GetMapping("/v2/user-service/users/{id}")
    public ResponseResult getUser(@PathVariable("id") Integer id);

    /**xz
     * Feign传递对象参数
     * 方式一：将对象参数拆分为多个简单类型参数，且必须添加@RequestParam注解
     */
//    @PostMapping("/users")
    @PostMapping("/v2/user-service/users")
    public ResponseResult postUser(@RequestParam("username") String username, @RequestParam("password") String password);

    /**
     * 方式二：使用Map替代对象参数，且必须添加@RequestParam注解
     */
//    @PutMapping("/users")
    @PutMapping("/v2/user-service/users")
    public ResponseResult putUser(@RequestParam Map<String, Object> map);

//    @DeleteMapping("/users/{id}")
    @DeleteMapping("/v2/user-service/users/{id}")
    public ResponseResult deleteUser(@PathVariable Integer id);

}
