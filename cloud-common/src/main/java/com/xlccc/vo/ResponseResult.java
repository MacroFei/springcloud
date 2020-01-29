package com.xlccc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {

    private Integer code;
    private String message;
    private Object result;

    public static ResponseResult success (Object result){
        ResponseResult rs = new ResponseResult();
        rs.setCode(200);
        rs.setMessage("success");
        rs.setResult(result);
        return rs;
    }
    public static ResponseResult success ( ){
        ResponseResult rs = new ResponseResult();
        rs.setCode(200);
        rs.setMessage("success");
        return rs;
    }
}
