package com.shoppingmall.dto;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class SalesDto {

    private String itemName;
    private Integer price;
    private String username;

}