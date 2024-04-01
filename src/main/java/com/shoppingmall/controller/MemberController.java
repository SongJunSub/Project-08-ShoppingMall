package com.shoppingmall.controller;

import com.shoppingmall.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/register")
    String register(){
        return "register";
    }

    @PostMapping("/register")
    String register(@RequestParam String username, @RequestParam String password, @RequestParam String displayName){
        memberService.register(username, password, displayName);

        return "redirect:/list";
    }

}