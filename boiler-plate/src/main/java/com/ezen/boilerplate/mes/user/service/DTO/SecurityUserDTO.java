package com.ezen.boilerplate.mes.user.service.DTO;

import org.springframework.security.core.userdetails.User;

public class SecurityUserDTO extends User{

  public SecurityUserDTO(LoginDTO user) {
    super(user.getUserId(), user.getPassword(), user.getAuthorities());
  }
  
}
