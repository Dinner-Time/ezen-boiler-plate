package com.ezen.boilerplate.mes.menu.service.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDTO {
  private String parentMenu;
  private String childMenu;

  private String parentMenuNo;
  private String childMenuNo;
}
