package com.ezen.boilerplate.setData.menu;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class G_Quality {

    @Autowired
    MenuRequestService menuRequestService;

    private final int MASTER_MENU_NO = 500;
    private final String ROOT_URL = "mes/quality/";
    private final int TOTAL_MENU_COUNT = 13;

    private final String[] MENU_NM_LIST = { //
            "자재입고검사등록", //
            "자재입고검사조회", //
            "고객사불량조치등록", //
            "업체별자재불량조회", //
            "자재별자재불량조회", //
            "LOT생산이력조회", //
            "LOT생산불량조회", //
            "자재LOT생산이력조회", //
            "작업자 불량 조회", //
            "설비별 불량 조회", //
            "제품생산불량 조회", //
            "제품불량유형조회", //
            "공정불량조회", //
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
            "", //
            "", //
            "",//
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
