package com.ezen.boilerplate.common.user.web;

import com.ezen.boilerplate.common.menu.service.MenuResponseService;
import com.ezen.boilerplate.common.util.EzenErrorType;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 사용자 controller
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
@Controller
@RequiredArgsConstructor
public class UserController {

  // 생성자 의존성 주입(자세한 내용은 MainController 참고)
  private final MenuResponseService menuService;

  // 로그인 페이지
  @GetMapping("/login")
  public String loginPage(Model model, HttpSession session) {
    // 로그인 실패 시 넘겨받는 message
    EzenErrorType errorType = EzenErrorType.LOGIN_ERROR;
    String message = (String) session.getAttribute(errorType.toString());

    // message가 존재할 경우
    if (message != null) {
      model.addAttribute("error", message); // model에 메세지를 담아 보내고
      session.removeAttribute(EzenErrorType.LOGIN_ERROR.toString()); // session에서 메세지를 삭제
    }
    return "user/login";
  }

  @GetMapping("/login/success")
  public String loginSuccess(HttpSession session) {
    session.setAttribute("menuList", menuService.leveledMenuList());
    return "redirect:/";
  }
}
