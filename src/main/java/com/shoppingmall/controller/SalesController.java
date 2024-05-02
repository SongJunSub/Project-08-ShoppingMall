package com.shoppingmall.controller;

import com.shoppingmall.service.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @PostMapping("/order")
    public String postOrder(@RequestParam String title, @RequestParam Integer price, @RequestParam Integer count, Authentication auth) {
        salesService.postOrder(title, price, count, auth);

        return "list";
    }

    @GetMapping("/order/all")
    public String getOrderAll(){
        salesService.getOrderAll();
        return "list";
    }

}