package com.ezen.boilerplate.common.menu.service.response.DTO;

import com.ezen.boilerplate.common.menu.domain.Menu;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class LeveledMenuDTO {
    // 메뉴번호
    private String menuNo;
    // 메뉴이름
    private String menuNm;
    // 상위메뉴
    private Menu parentMenu;
    // 이동할 url
    private String redirectUrl;

    public LeveledMenuDTO(Menu entity) {
        this.menuNo = entity.getMenuNo();
        this.menuNm = entity.getMenuNm();
        this.parentMenu = entity.getParentMenu();
        this.redirectUrl = entity.getRedirectUrl();
    }
}
