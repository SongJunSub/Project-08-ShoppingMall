package com.shoppingmall.controller;

import com.shoppingmall.entity.Item;
import com.shoppingmall.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();

        model.addAttribute("items", result);

        return "list";
    }

    @GetMapping("/write")
    String write(Model model){
        return "write";
    }

    @PostMapping("/write")
    String write(@RequestParam String title, @RequestParam Integer price){
        Item item = new Item(title, price);

        itemRepository.save(item);

        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) throws Exception {
        Optional<Item> result = itemRepository.findById(id);

        if(result.isPresent()){
            model.addAttribute("result", result.get());

            return "detail";
        }
        else{
            throw new Exception("잘못된 페이지입니다.");
        }
    }

}