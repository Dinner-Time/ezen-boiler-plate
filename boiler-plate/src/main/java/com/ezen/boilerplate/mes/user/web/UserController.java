package com.ezen.boilerplate.mes.user.web;

import com.ezen.boilerplate.common.util.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
  
  // 로그인 페이지
  @GetMapping("/login")
  public String loginPage(
        Model model,//
        String error//
  ) 
  {
    model.addAttribute("error", error);
    return Pages.LOGIN.getPage();
  }
}
