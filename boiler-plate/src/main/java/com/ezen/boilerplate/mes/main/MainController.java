package com.ezen.boilerplate.mes.main;

import javax.servlet.http.HttpSession;

import com.ezen.boilerplate.mes.menu.service.DTO.MenuDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

  private final String TEMPLATE = "layout/template";

  // 메인페이지
  @GetMapping("/")
  public String main(Model model) 
  {
    model.addAttribute("responsePage", "mes/main");
    return TEMPLATE;
  }

  @GetMapping("/mes/{pageNo}")
  public String page(Model model, HttpSession session, String pageLink, @PathVariable("pageNo") String pageNo){
    // TODO: db에 저장된 메뉴 정보 query
    
    MenuDTO menu = new MenuDTO();
    menu.setParentMenu("기준정보관리");
    menu.setChildMenu("공통관리");
    menu.setChildMenuNo(pageNo);

    session.setAttribute("menu", menu);
    model.addAttribute("responsePage", pageLink);
    return TEMPLATE;
  }
}
