package com.ezen.boilerplate.mes.menu.service.DTO;

import com.ezen.boilerplate.mes.menu.domain.Menu;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SaveMenuDTO {
    private String menuNo;
    private String menuNm;
    private int menuOrder;
    private String menuDesc;
    private String redirectUrl;
    private Menu parentMenu;
}
