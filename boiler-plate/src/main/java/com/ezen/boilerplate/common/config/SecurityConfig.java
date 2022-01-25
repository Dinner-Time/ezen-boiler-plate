package com.ezen.boilerplate.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Override
  public void configure(WebSecurity web) throws Exception {
    // 해당 경로에는 security 가 모두 무시할 수 있도록 설정
    web.ignoring().antMatchers("/resources/**", "/mes/**");
  }

  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()  // 접근 권한 설정
                .antMatchers("/admin/**").hasRole("ADMIN")
                // .antMatchers("/**").permitAll()
            .and()
                .formLogin()  // form로그인 기반으로 인증
                .loginPage("/login") // 로그인 페이지로 이동
                .usernameParameter("userId")  // username parameter custom
                .passwordParameter("password")  // password parameter custom
                .loginProcessingUrl("/processLogin") // login을 실행할 URL
                .defaultSuccessUrl("/")  // 로그인 성공시 이동할 페이지
                .failureUrl("/")  // 실패시 이동할 페이지
            .and()
                .logout() // 로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 실행 URL
                .logoutSuccessUrl("/")  // 로그아웃 성공시 이동할 페이지
                .invalidateHttpSession(true)  // 세션 종료
            .and()
                .exceptionHandling().accessDeniedPage("/login/denied");
    }
}
