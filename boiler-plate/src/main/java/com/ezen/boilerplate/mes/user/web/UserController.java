package com.ezen.boilerplate.mes.user.web;

import javax.servlet.http.HttpSession;

import com.ezen.boilerplate.common.util.EzenErrorType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

  private final String ERROR_PARAMETER = "error";

  // 로그인 페이지
  @GetMapping("/login")
  public String loginPage(Model model, HttpSession session) {

    // 로그인 실패 시 넘겨받는 message
    String message = (String) session.getAttribute(EzenErrorType.LOGIN_ERROR.toString());

    // message가 존재할 경우
    if (message != null) {
      model.addAttribute(ERROR_PARAMETER, message); // model에 메세지를 담아 보내고
      session.removeAttribute(EzenErrorType.LOGIN_ERROR.toString()); // session에서 메세지를 삭제
    }
    return "mes/login/login";
  }
}
