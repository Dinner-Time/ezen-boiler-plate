package com.ezen.boilerplate.mes.manage.menu.service.DTO.response;

import com.ezen.boilerplate.mes.manage.menu.domain.entity.Menu;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListOfMenuDTO {

    private String menuNo;
    private String menuNm;
    private String masterMenu;

    public ListOfMenuDTO(Menu entity) {
        this.menuNo = entity.getMenuNo();
        this.menuNm = entity.getMenuNm();
        this.masterMenu = entity.getMasterMenu();
    }

}
