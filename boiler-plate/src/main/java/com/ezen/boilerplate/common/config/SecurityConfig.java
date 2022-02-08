package com.ezen.boilerplate.common.config;

import com.ezen.boilerplate.common.config.loginHandler.LoginFailureHandler;
import com.ezen.boilerplate.common.config.loginHandler.LoginSuccessHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * 스프링 시큐리티 설정
 * 
 * @author 박태훈
 * @since 2022.01.25
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022.01.25	박태훈	    최초생성
 *  2022-02-07  박태훈      LoginFaliureHandler 추가
 *
 *      </pre>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  // 비밀번호 암호화 설정
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    return bCryptPasswordEncoder;
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    // 해당 경로에는 security 가 모두 무시할 수 있도록 설정
    web.ignoring().antMatchers("/resources/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable() // csrf 미적용
        .authorizeRequests() // 접근 권한 설정
        .antMatchers("/login/**").permitAll() // 로그인 페이지 모두 접속 가능
        .antMatchers("/error").permitAll() // 에러 페이지 모두 접속 가능
        .antMatchers("/**").authenticated() // 이 외의 페이지 허용된 사용자만 접속 가능
        //
        .and()
        .formLogin() // form로그인 기반으로 인증
        .loginPage("/login") // 로그인 페이지로 이동
        .usernameParameter("userId") // username parameter custom
        .passwordParameter("password") // password parameter custom
        .loginProcessingUrl("/login/process") // login을 실행할 URL
        .successHandler(new LoginSuccessHandler()) // login 성공시 실행
        .failureHandler(new LoginFailureHandler()) // login 실패시 실행
        //
        .and()
        .logout() // 로그아웃
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 실행 URL
        .logoutSuccessUrl("/login") // 로그아웃 성공시 이동할 페이지
        .invalidateHttpSession(true) // 세션 종료
    ;
  }
}
