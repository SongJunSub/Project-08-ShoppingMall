package com.shoppingmall.repository;

import com.shoppingmall.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Page<Item> findPageBy(Pageable pageable);

    //전체 페이지 Count 조회 안됨. Only 리스트만
    //Slice<Item> findPageBy(Pageable pageable);

    List<Item> findAllByTitleContains(String title);

    //@Query(value = "SELECT * FROM item WHERE MATCH(title) AGAINST(?1)", nativeQuery = true)
    //List<Item> rawQuery1(String text);

}