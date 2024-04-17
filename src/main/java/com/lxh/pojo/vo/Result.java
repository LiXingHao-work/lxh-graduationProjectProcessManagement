package com.lxh.pojo.vo;

import com.lxh.exception.Code;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class Result {
    private int code;
    private String message;  //响应信息 描述字符串
    private Map<String,Object> data; //返回的数据

    //增删改 查询成功响应
    public static Result success(Map<String,Object> data){
        return Result.builder()
                .code(200)
                .build();
    }

    //失败响应
    public static Result error(Code code){
        return Result.builder()
                .code(code.getCode())
                .message(code.getMessage())
                .build();
    }

    public static Result error(int code, String msg) {
        return Result.builder().code(code).message(msg).build();
    }

    public static Result success(Code code, Map<String, Object> data) {
        return Result.builder()
                .code(code.getCode())
                .message(code.getMessage())
                .data(data)
                .build();
    }
}
