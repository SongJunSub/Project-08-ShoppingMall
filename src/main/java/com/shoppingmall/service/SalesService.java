package com.shoppingmall.service;

import com.shoppingmall.dto.SalesDto;
import com.shoppingmall.entity.Member;
import com.shoppingmall.entity.Sales;
import com.shoppingmall.repository.SalesRepository;
import com.shoppingmall.security.login.CustomUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;

    public void postOrder(String title, Integer price, Integer count, Authentication auth) {
        CustomUser user = (CustomUser) auth.getPrincipal();
        Member member = new Member(user.id);
        Sales sales = new Sales(title, price, count, member);

        salesRepository.save(sales);
    }

    public List<Sales> getOrderAll() {
        List<Sales> result = salesRepository.customFindAll();

        SalesDto salesDto = new SalesDto();
        salesDto.setItemName(result.get(0).getItemName());
        salesDto.setPrice(result.get(0).getPrice());
        salesDto.setUsername(result.get(0).getMember().getUsername());

        return result;
    }

}