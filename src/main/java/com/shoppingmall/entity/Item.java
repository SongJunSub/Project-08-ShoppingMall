package com.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(indexes = @Index(columnList = "title", name = "titleIndex"))
//Full Text Index
//Full Text Index를 사용하려면 Native Query를 사용해야 한다.
//N-Gram Parser 사용 이유 : 한글 때문에
//CREATE FULLTEXT INDEX 작명 ON 테이블명(컬럼명) WITHN PARSER NGRAM;
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