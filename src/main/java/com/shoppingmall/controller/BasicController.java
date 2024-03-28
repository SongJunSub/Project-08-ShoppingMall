package com.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }

    @GetMapping("/about")
    @ResponseBody
    public String about(){
        return "Connection Test";
    }

}