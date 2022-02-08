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
 *  2022-02-08  박태훈      에러 메세지 처리 (if => 삼항 연산자)
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
    // spring에서 처리한 에러 메세지
    String messageHandledBySpring = exception.getMessage();

    // attribute name
    String errorName = EzenErrorType.LOGIN_ERROR.toString();
    // session에 담을 에러 메세지
    String errorMessage = messageHandledBySpring == null
        ? EzenError.USER_NOT_FOUND.getMessage() // 존재하지 않는 ID를 입력한 경우(message == null)
        : EzenError.WRONG_PASSWORD.getMessage(); // 비밀번호를 잘못 입력한 경우(message != null)

    session.setAttribute(errorName, errorMessage);

    // redirect
    response.sendRedirect(redirectUrl);
  }

}
