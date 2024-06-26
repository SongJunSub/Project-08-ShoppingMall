package com.shoppingmall.service;

import com.shoppingmall.entity.Member;
import com.shoppingmall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(String username, String password, String displayName){
        String encodedPassword = passwordEncoder.encode(password);

        Member member = new Member();
        member.setMember(username, encodedPassword, displayName);

        memberRepository.save(member);
    }

    public Optional<Member> findById(Long id){
        return memberRepository.findById(id);
    }

}