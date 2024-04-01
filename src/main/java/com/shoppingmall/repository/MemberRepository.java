package com.shoppingmall.repository;

import com.shoppingmall.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    //결과 값이 없을 수도 있으니 Optional 처리
    Optional<Member> findByUsername(String username);

}