package com.chen.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
public class PageController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
