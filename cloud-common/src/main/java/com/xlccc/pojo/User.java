package com.xlccc.pojo;

import com.xlccc.vo.ResponseResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@ApiModel(value = "User 用户对象")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @ApiModelProperty(value = "用户ID")
    private Integer id ;
    @ApiModelProperty(value = "用户名")
    private String username ;
    @ApiModelProperty(value = "用户密码")
    private String password;

    public static ResponseResult success(Object result ){
        ResponseResult rs = new ResponseResult();
        rs.setCode(200);
        rs.setMessage("success");
        rs.setResult(result);
        return rs;
    }

}
