package com.ezen.boilerplate.common.config;

import javax.sql.DataSource;

import com.ezen.boilerplate.common.config.loginHandler.LoginFailureHandler;
import com.ezen.boilerplate.common.config.loginHandler.LoginSuccessHandler;

import org.springframework.beans.factory.annotation.Autowired;
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
 *
 *      </pre>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

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
                .disable()  // csrf 미적용
                .authorizeRequests()  // 접근 권한 설정
                .antMatchers("/login/**").permitAll()  // 로그인 페이지는 모두 접속 가능하도록
                .antMatchers("/error").permitAll()  // 에러 페이지 
                .antMatchers("/**").authenticated()
            .and()
                .formLogin()  // form로그인 기반으로 인증
                .loginPage("/login") // 로그인 페이지로 이동
                .usernameParameter("userId")  // username parameter custom
                .passwordParameter("password")  // password parameter custom
                .loginProcessingUrl("/login/process") // login을 실행할 URL
                .successHandler(new LoginSuccessHandler())
                .failureHandler(new LoginFailureHandler())
                // .failureUrl("/login?error=true")  // 로그인 실패시 이동할 페이지
            .and()
                .logout() // 로그아웃
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // 로그아웃 실행 URL
                .logoutSuccessUrl("/login")  // 로그아웃 성공시 이동할 페이지
                .invalidateHttpSession(true)  // 세션 종료
            .and()
                .exceptionHandling().accessDeniedPage("/login/denied")
            ;
            // // 아이디 저장 설정
            // .and()
            //     .rememberMe()
            //     .tokenRepository(this.persistentTokenRepository())
            //     .tokenValiditySeconds(1 * 24 * 60 * 60); // 24시간
    }

    // // 아이디 저장 여부를 서버 memory에 저장
    // @Bean
    // public PersistentTokenRepository persistentTokenRepository() {
    //   InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
    //   return memory;
    // }

    // 아이디 저장 여부를 DB에 저장
    // @Bean
    // public PersistentTokenRepository persistentTokenRepository() {
    //   JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
    //   db.setDataSource(dataSource);
    //   return db;
    // }
}
