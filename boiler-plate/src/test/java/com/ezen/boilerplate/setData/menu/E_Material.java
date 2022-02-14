package com.ezen.boilerplate.setData.menu;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class E_Material {

    @Autowired
    MenuRequestService menuRequestService;

    private final int MASTER_MENU_NO = 300;
    private final String ROOT_URL = "mes/material/";
    private final int TOTAL_MENU_COUNT = 9;

    private final String[] MENU_NM_LIST = { //
            "발주등록참조", //
            "자재입고등록", //
            "자재반품등록", //
            "자재LOT 재고조정등록", //
            "자재 재고조정등록", //
            "자재 재고조정조회", //
            "자재재고조회", //
            "자재LOT 재고조회", //
            "안전재고조회", //
    };

    private final String[] URL_LIST = { //
            "", //
            "", //
            "", //
            "", //
            "", //
            "", //
            "", //
            "", //
            "", //
    };

    @Test
    public void test() {
        for (int i = 0; i < TOTAL_MENU_COUNT; i++) {
            int menuNo = MASTER_MENU_NO + i + 1;
            String menuNm = MENU_NM_LIST[i];
            String redirectUrl = URL_LIST[i];

            SaveMenuDTO dto = new SaveMenuDTO();
            dto.setMasterMenu(String.valueOf(MASTER_MENU_NO));
            dto.setMenuNo(String.valueOf(menuNo));
            dto.setMenuOrder(i + 1);
            dto.setMenuNm(menuNm);
            dto.setRedirectUrl(ROOT_URL + redirectUrl);

            menuRequestService.save(dto);
        }

    }
}
