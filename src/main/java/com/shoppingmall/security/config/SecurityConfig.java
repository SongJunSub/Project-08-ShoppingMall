package com.shoppingmall.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //BCryptPasswordEncoder Class (외부 클래스)를 의존성 주입(Dependency Injection)으로 사용
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CsrfTokenRepository csrfTokenRepository(){
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();

        repository.setHeaderName("X-XSRF-TOKEN");

        return repository;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //CSRF OFF
        http.csrf((csrf) -> csrf.disable());

        //CSRF 설정
//        http.csrf(csrf -> csrf
//                .csrfTokenRepository(csrfTokenRepository())
//                //CSRF 보안 끌 페이지
//                .ignoringRequestMatchers("/login")
//        );

        //특정 페이지 로그인 검사 진행
        http.authorizeHttpRequests((authorize) ->
                authorize.requestMatchers("/**").permitAll()
        );

        //form 형식으로 로그인
        http.formLogin((formLogin) -> formLogin
                //로그인 페이지 URL
                .loginPage("/login")
                //로그인 성공 시 이동할 URL
                .defaultSuccessUrl("/")
                //로그인 실패 시 이동할 URL (해당 로직 없으면 Default로 /login?error로 이동)
                //.failureUrl("/fail")
        );

        //로그아웃
        http.logout(logout -> logout
                .logoutUrl("/logout")
        );

        return http.build();
    }

}