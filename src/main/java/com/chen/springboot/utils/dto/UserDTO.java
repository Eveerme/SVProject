package com.chen.springboot.utils.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
* 接收前端登录参数的请求
* */
@Data   //省去代码中大量的get()、 set()、 toString()
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private String username;
    private String password;

}
