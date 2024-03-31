package com.shoppingmall.controller;

import com.shoppingmall.entity.Item;
import com.shoppingmall.repository.ItemRepository;
import com.shoppingmall.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemService.findList();

        model.addAttribute("items", result);

        return "list";
    }

    @GetMapping("/write")
    String write(Model model){
        return "write";
    }

    @PostMapping("/write")
    String write(@RequestParam String title, @RequestParam Integer price){
        itemService.saveItem(title, price);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) throws Exception {
        Optional<Item> result = itemService.findById(id);

        if(result.isPresent()){
            model.addAttribute("result", result.get());

            return "detail";
        }
        else{
            return "redirect:/list";
        }
    }

}