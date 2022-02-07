package com.ezen.boilerplate.common.config.loginHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    // 로그인 정보 조회
    UserDetails user = (UserDetails) authentication.getPrincipal();

    // 로그인 정보 세션 저장
    request.getSession().setAttribute("user", user);

    // 메인 페이지로 redirect
    response.sendRedirect("/");
  }

}
