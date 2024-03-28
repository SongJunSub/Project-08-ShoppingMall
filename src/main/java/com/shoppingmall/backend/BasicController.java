package com.shoppingmall.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    @GetMapping("/")
    String mainPage(){
        return "index.html";
    }

    @GetMapping("/about")
    @ResponseBody
    String about(){
        return "Connection Test";
    }

}