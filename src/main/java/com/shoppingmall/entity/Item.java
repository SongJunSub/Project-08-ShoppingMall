package com.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(indexes = @Index(columnList = "title", name = "titleIndex"))
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer price;

    public Item(String title, int price){
        this.title = title;
        this.price = price;
    }

    public Item(Long id, String title, Integer price){
        this.id = id;
        this.title = title;
        this.price = price;
    }

}