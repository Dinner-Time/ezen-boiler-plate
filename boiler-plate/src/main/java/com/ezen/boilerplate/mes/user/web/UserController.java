package com.ezen.boilerplate.mes.user.web;

import com.ezen.boilerplate.common.util.Pages;
import com.ezen.boilerplate.mes.user.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

  UserService userService;
  
  // 로그인 페이지
  @GetMapping("/login")
  public String loginPage() 
  {
    return Pages.LOGIN.getPage();
  }

  @PostMapping("/login/process")
  public String loginProcess() 
  {
    return Pages.LOGIN.getPage();
  }
}
