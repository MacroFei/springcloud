package com.xlccc.pojo;

import com.xlccc.vo.ResponseResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer id ;
    private String username ;
    private String password;

    public static ResponseResult success(Object result ){
        ResponseResult rs = new ResponseResult();
        rs.setCode(200);
        rs.setMessage("success");
        rs.setResult(result);
        return rs;
    }

}
