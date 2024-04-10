package com.shoppingmall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String content;

    private Long parentId;

    public Comment(String username, String content, Long parentId){
        this.username = username;
        this.content = content;
        this.parentId = parentId;
    }

}