package com.ezen.boilerplate.common.config.loginHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.boilerplate.common.util.EzenErrorType;
import com.ezen.boilerplate.common.util.EzenError;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {

    // session을 활용하여 flashAttribute 구현
    HttpSession session = request.getSession();

    // 이동할 url
    String redirectUrl = "/login";
    // 에러 메세지
    String message = exception.getMessage();

    // 존재하지 않는 ID를 입력한 경우(message = null)
    if (message == null) {
      session.setAttribute(EzenErrorType.LOGIN_ERROR.toString(), EzenError.USER_NOT_FOUND.getMessage());

      // 비밀번호를 잘못 입력한 경우(message = "자격 증명에 실패하였습니다.")
    } else {
      session.setAttribute(EzenErrorType.LOGIN_ERROR.toString(), EzenError.WRONG_PASSWORD.getMessage());
    }

    response.sendRedirect(redirectUrl);
  }

}
