package com.ezen.boilerplate.mes.main;

import javax.servlet.http.HttpSession;

import com.ezen.boilerplate.common.util.Pages;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/")
  public String main(Model model, HttpSession session) 
  {
    model.addAttribute("responsePage", "mes/main");
    return Pages.TEMPLATE;
  }

  @GetMapping("/login")
  public String loginPage(Model model, HttpSession session) 
  {
    return Pages.LOGIN;
  }
}
