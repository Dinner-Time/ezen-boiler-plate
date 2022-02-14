package com.ezen.boilerplate.setData.menu;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class C_Standard {

    @Autowired
    MenuRequestService menuRequestService;

    private final int MASTER_MENU_NO = 100;
    private final String ROOT_URL = "mes/standard/";
    private final int TOTAL_MENU_COUNT = 8;

    private final String[] MENU_NM_LIST = { //
            "공정코드등록", //
            "공정사용자재등록", //
            "제품공정흐름등록", //
            "공정내역등록", //
            "사원정보조회", //
            "불량내역등록", //
            "비가동내역등록", //
            "작업표준서등록", //
    };

    private final String[] URL_LIST = { //
            "commonCode/CommonCode", //
            "matrData/MatrData", //
            "prductData/PrductData", //
            "procsData/ProcsData", //
            "emplyrData/EmplyData", //
            "badData/BadData", //
            "eqpmntDowntimeData/EqpmntDowntimeData", //
            "standardWorkSheet/StandardWorkSheet", //
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
