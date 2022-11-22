package com.chen.springboot.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private String status;//状态
    private String msg;// 返回提示信息
    private Object data;//数据

    //请求成功，不返回数据
    public static R success(){
        return new R(Constants.CODE_200,"",null);
    }

    //请求成功，返回数据data
    public static R success(Object data){
        return new R(Constants.CODE_200,"",data);
    }

    //请求失败，返回状态码和失败原因
    public static R error(String code, String msg) {
        return new R(code, msg, null);
    }

    //请求失败，返回状态码和失败原因
    public static R error() {
        return new R(Constants.CODE_500, "系统错误", null);
    }

}
