package com.ezen.boilerplate.common.config.loginHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 로그인 성공시 실행
 * 
 * @author 박태훈
 * @since 2022-01-25
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-01-25  박태훈      최초 생성
 *
 *      </pre>
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    // 세션 객체 생성
    HttpSession session = request.getSession();

    // 로그인 정보 조회
    UserDetails user = (UserDetails) authentication.getPrincipal();
    // 로그인 정보 세션 저장
    session.setAttribute("user", user);

    // redirect
    response.sendRedirect("/login/success");
  }

}
