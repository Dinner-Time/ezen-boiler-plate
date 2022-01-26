package com.ezen.boilerplate.mes.main;

import com.ezen.boilerplate.common.util.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * Main Controller
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
@Controller
public class MainController {

  // 메인페이지
  @GetMapping("/")
  public String main(Model model) 
  {
    model.addAttribute("responsePage", Pages.MAIN.getPage());
    return Pages.TEMPLATE.getPage();
  }

}
