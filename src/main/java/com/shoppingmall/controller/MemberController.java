package com.shoppingmall.controller;

import com.shoppingmall.entity.Member;
import com.shoppingmall.security.login.CustomUser;
import com.shoppingmall.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

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

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/mypage")
    public String myPage(Authentication authentication){
        CustomUser result = (CustomUser) authentication.getPrincipal();

        return "mypage";
    }

    @GetMapping("/user/1")
    @ResponseBody
    public String getUser(Long id){
        Optional<Member> member = memberService.findById(id);
        var result = member.get();

        MemberDto data = new MemberDto(result.getUsername(), result.getDisplayName());

        return "mypage";
    }

}

class MemberDto {

    public String username;
    public String displayName;

    MemberDto(String username, String displayName){
        this.username = username;
        this.displayName = displayName;
    }

}