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

/**
 * 로그인 실패 시 실행
 * 
 * @author 박태훈
 * @since 2022-02-07
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-02-07  박태훈      최초 생성
 *
 *      </pre>
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

  @Override
  public void onAuthenticationFailure(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {

    /**
     * session을 활용하여 flashAttribute 구현
     * -- loginFailureHandler에서 session에 flashAttribute를 담는다.
     * -- redirect되는 controller에서 필요한 처리를 완료한 이후 session의 flashAttribute를 삭제한다.
     */
    HttpSession session = request.getSession();

    // 이동할 url
    String redirectUrl = "/login";
    // 에러 메세지
    String message = exception.getMessage();

    // 존재하지 않는 ID를 입력한 경우(message == null)
    if (message == null) {
      // flashAttribute
      session.setAttribute(EzenErrorType.LOGIN_ERROR.toString(), EzenError.USER_NOT_FOUND.getMessage());

      // 비밀번호를 잘못 입력한 경우(message != null)
    } else {
      // flashAttribute
      session.setAttribute(EzenErrorType.LOGIN_ERROR.toString(), EzenError.WRONG_PASSWORD.getMessage());
    }

    // redirect
    response.sendRedirect(redirectUrl);
  }

}
