package com.ezen.boilerplate.mes.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
  
  // 로그인 페이지
  @GetMapping("/login")
  public String loginPage() 
  {
    return "mes/login/login";
  }
}
