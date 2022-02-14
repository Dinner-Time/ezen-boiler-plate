package com.ezen.boilerplate.setData.menu;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class B_Manage {

    @Autowired
    MenuRequestService menuRequestService;

    private final int MASTER_MENU_NO = 100000;
    private final String ROOT_URL = "mes/manage/";
    private final int TOTAL_MENU_COUNT = 3;
    private final String[] MENU_NM_LIST = { //
            "사용자 관리", //
            "메뉴 관리", //
            "작업PC 관리", //
    };

    private final String[] URL_LIST = { //
            "user/User", //
            "menu/Menu", //
            "plc/Plc", //
    };

    @Test
    public void test() {
        for (int i = 0; i < TOTAL_MENU_COUNT; i++) {
            int menuNo = MASTER_MENU_NO + (i + 1);
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
