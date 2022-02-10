package com.ezen.boilerplate.mes.manage.menu.service.DTO.response;

import com.ezen.boilerplate.mes.manage.menu.domain.Menu;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DetailMenuDTO {

    private String menuNm;
    private int menuOrder;
    private String redirectUrl;
    private String menuDesc;

    public DetailMenuDTO(Menu entity) {
        this.menuNm = entity.getMenuNm();
        this.menuOrder = entity.getMenuOrder();
        this.redirectUrl = entity.getRedirectUrl();
        this.menuDesc = entity.getMenuDesc();
    }
}
