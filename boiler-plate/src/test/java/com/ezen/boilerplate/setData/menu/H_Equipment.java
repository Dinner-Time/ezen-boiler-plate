package com.ezen.boilerplate.setData.menu;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class H_Equipment {

    @Autowired
    MenuRequestService menuRequestService;

    private final int MASTER_MENU_NO = 600;
    private final String ROOT_URL = "mes/equipment/";
    private final int TOTAL_MENU_COUNT = 8;

    private final String[] MENU_NM_LIST = { //
            "설비 등록", //
            "설비 제품UPH 등록", //
            "설비 수리 등록", //
            "설비 정기점검 등록", //
            "설비 조회", //
            "설비 정기점검 조회", //
            "설비생산 이력조회", //
            "설비 수리조회", //
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
