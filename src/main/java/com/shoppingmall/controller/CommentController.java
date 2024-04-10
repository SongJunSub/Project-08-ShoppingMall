package com.shoppingmall.controller;

import com.shoppingmall.security.login.CustomUser;
import com.shoppingmall.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    String insertComment(@RequestParam String content, @RequestParam Long parentId, Authentication authentication){
        commentService.insertComment(content, parentId, authentication);

        return "redirect:/list";
    }

}