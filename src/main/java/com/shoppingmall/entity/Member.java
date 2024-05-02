package com.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String displayName;

    public Member(Long id){
        this.id = id;
    }

    public void setMember(String username, String password, String displayName){
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    @ToString.Exclude
    @OneToMany(mappedBy = "member")
    List<Sales> sales = new ArrayList<>();

}