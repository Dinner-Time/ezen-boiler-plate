package com.ezen.boilerplate.setData.menu;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class A_MasterMenu {

    @Autowired
    MenuRequestService menuRequestService;

    private final int TOTAL_MENU_COUNT = 7;
    private final String LAST_MENU_NO = "100000";
    private final int LAST_MENU_ORDER = 65535;

    private final String[] MENU_NM_LIST = { //
            "기준정보관리", //
            "영업관리", //
            "자재관리", //
            "생산관리", //
            "품질관리", //
            "설비관리", //
            "시스템관리", //
    };

    @Test
    public void test() {
        for (int i = 0; i < TOTAL_MENU_COUNT; i++) {
            int menuNo = 100 * (i + 1);
            String menuNm = MENU_NM_LIST[i];

            SaveMenuDTO dto = new SaveMenuDTO();
            dto.setMenuNo(i + 1 == TOTAL_MENU_COUNT ? LAST_MENU_NO : String.valueOf(menuNo));
            dto.setMenuOrder(i + 1 == TOTAL_MENU_COUNT ? LAST_MENU_ORDER : i + 1);
            dto.setRedirectUrl("/");
            dto.setMenuNm(menuNm);

            menuRequestService.save(dto);
        }

    }
}
