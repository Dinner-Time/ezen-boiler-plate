package com.ezen.boilerplate.setData.menu;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class D_Business {

    @Autowired
    MenuRequestService menuRequestService;

    private final int MASTER_MENU_NO = 200;
    private final String ROOT_URL = "mes/business/";
    private final int TOTAL_MENU_COUNT = 10;

    private final String[] MENU_NM_LIST = { //
            "주문등록참조", //
            "미생산의뢰조회", //
            "출고등록", //
            "반품등록", //
            "파렛트이동등록", //
            "제품재고조정등록", //
            "제품재고조정조회", //
            "제품재고조회", //
            "제품 LOT 재고조회", //
            "파렛트별재고조회", //
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
