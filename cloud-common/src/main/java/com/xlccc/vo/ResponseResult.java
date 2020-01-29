package com.xlccc.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.ws.Response;
import java.io.Serializable;
@ApiModel(value = "ResponseResult 响应结果对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult implements Serializable {

    @ApiModelProperty(value = "响应码")
    private Integer code;
    @ApiModelProperty(value = "响应消息")
    private String message;
    @ApiModelProperty(value = "响应结果")
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
    public static ResponseResult fail(String message){
        ResponseResult rs = new ResponseResult();
        rs.setCode(500);
        rs.setMessage(message);
        return rs;
    }
}
