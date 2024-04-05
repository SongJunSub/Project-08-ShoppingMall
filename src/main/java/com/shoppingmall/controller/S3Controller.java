package com.shoppingmall.controller;

import com.shoppingmall.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;

    @GetMapping("/presignedURL")
    @ResponseBody
    String uploadImage(@RequestParam String filename){
        String result = s3Service.createPriSignedURL("shoppingmall/" + filename);

        return result;
    }

}