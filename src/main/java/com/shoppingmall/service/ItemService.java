package com.shoppingmall.service;


import com.shoppingmall.entity.Item;
import com.shoppingmall.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> findList(){
        return itemRepository.findAll();
    }

    public void saveItem(String title, Integer price){
        Item item = new Item(title, price);

        itemRepository.save(item);
    }

    public Optional<Item> findById(Long id){
        return itemRepository.findById(id);
    }

}