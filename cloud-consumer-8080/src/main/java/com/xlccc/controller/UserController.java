package com.xlccc.controller;

import com.xlccc.pojo.User;
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
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    //HttpClient 发送Http请求
    //RestTemplate 调用Rest服务
    private static final String GLOBAL_URL = "http://localhost:8001/users";
    @GetMapping
    public ResponseResult getUserList(){
        //发送get请求，参数分别表示：请求路径，响应数据类型（//将返回的Json转换为ResponseResult对象）
        return restTemplate.getForObject(GLOBAL_URL, ResponseResult.class);
    }

    @GetMapping("/{id}")
    public ResponseResult getUser(@PathVariable Integer id ){
        //发送get请求，参数分别表示：请求路径，响应数据类型，占位符的值，其中{id}表示占位符
        return restTemplate.getForObject(GLOBAL_URL+"/{id}",ResponseResult.class,id);
    }

    @PostMapping
    public ResponseResult postUser(User user){
        // 必须使用MultiValueMap来封装参数
        MultiValueMap params  = new LinkedMultiValueMap();
        params.add("username",user.getUsername());
        params.add("password",user.getPassword());
        //发送post请求，参数分别表示：请求路径，响应数据类型
        return restTemplate.postForObject(GLOBAL_URL,params,ResponseResult.class);
    }

    @DeleteMapping("/{id}")
    public ResponseResult deleteUser(@PathVariable Integer id ){
        /**
         * 对于delete和put请求，默认是无法接收返回值
         * 如果有返回值，则需要使用exchange()方法
         */
        ResponseEntity<ResponseResult> responseEntity = restTemplate.exchange(GLOBAL_URL + "/{id}", HttpMethod.DELETE, null, ResponseResult.class, id);
        return responseEntity.getBody();
    }

    @PutMapping
    public ResponseResult putUser(User user ){
        //此处只能在URL中通过键值对的形式进行参数的传递
        String url = new StringBuffer(GLOBAL_URL)
                .append("?tem=1")
                .append("&id={id}")
                .append("&username={username}")
                .append("&password={password}")
                .toString();
        Map params = new HashMap();
        params.put("id",user.getId());
        params.put("username",user.getUsername());
        params.put("password",user.getPassword());
        ResponseEntity<ResponseResult> responseEntity = restTemplate.exchange(url,HttpMethod.PUT,null,ResponseResult.class,params);
        return responseEntity.getBody();
    }


}
