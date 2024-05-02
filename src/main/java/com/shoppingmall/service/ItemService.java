package com.shoppingmall.service;

import com.shoppingmall.entity.Item;
import com.shoppingmall.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public void editItem(Long id, String title, Integer price){
        Item item = new Item(id, title, price);

        itemRepository.save(item);
    }

    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }

    public Page<Item> findPageBy(PageRequest of){
        return itemRepository.findPageBy(of);
    }

    public List<Item> searchItem(String searchText){
        return itemRepository.findAllByTitleContains(searchText);
    }

}