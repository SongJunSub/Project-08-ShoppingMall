package com.shoppingmall.security.login;

import com.shoppingmall.entity.Member;
import com.shoppingmall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> result = memberRepository.findByUsername(username);

        if(result.isPresent()){
            Member user = result.get();

            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("User"));

            CustomUser customUser = new CustomUser(user.getUsername(), user.getPassword(), authorities);

            customUser.displayName = user.getDisplayName();

            return customUser;
        }
        else{
            throw new UsernameNotFoundException("아이디나 패스워드가 일치하지 않습니다.");
        }
    }

}