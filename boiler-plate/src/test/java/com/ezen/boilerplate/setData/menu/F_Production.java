package com.ezen.boilerplate.setData.menu;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class F_Production {

    @Autowired
    MenuRequestService menuRequestService;

    private final int MASTER_MENU_NO = 400;
    private final String ROOT_URL = "mes/production/";
    private final int TOTAL_MENU_COUNT = 22;

    private final String[] MENU_NM_LIST = { //
            "생산계획등록", //
            "생산계획조회", //
            "생산 지시등록", //
            "생산 지시조회", //
            "원소재투입등록", //
            "원소재재고조정등록", //
            "공정작업실적등록", //
            "검사공정실적등록", //
            "포장공정실적등록", //
            "제품번호발행등록", //
            "제품번호수정등록", //
            "설비비가동등록", //
            "설비비가동조회", //
            "설비비가동유형조회", //
            "공정작업실적조회", //
            "공정자재투입조회", //
            "기간생산실적조회", //
            "공정불량자료조회", //
            "설비비가동분석조회", //
            "제품번호별이력조회", //
            "기간 투입/실적율조회", //
            "생산모니터링",//
    };

    private final String[] URL_LIST = { //
            "prdctnPlan/PrdctnPlan", //
            "report/prdctnPlan/PrdctnPlan", //
            "prdctnAssign/PrdctnAssign", //
            "report/prdctnAssign/PrdctnAssign", //
            "matrInput/MatrInput", //
            "matrInvnAdj/MatrInvnAdj", //
            "procsResult/ProcsResult", //
            "inspProcsResult/InspProcsResult", //
            "shipmntProcsResult/ShipmntProcsResult", //
            "prductSerial/PrductSerial", //
            "modPrductSerial/ModPrductSerial", //
            "eqpmntDowntime/EqpmntDowntime", //
            "report/eqpmntDowntime/EqpmntDowntime", //
            "report/eqpmntDowntime/EqpmntDowntimeType", //
            "report/procsResult/ProcsResult", //
            "report/matrInput/MatrInput", //
            "report/procsResult/ProcsResultPeriod", //
            "report/procsResult/ProcsResultBad", //
            "report/eqpmntDowntime/EqpmntDowntimeAnalyze", //
            "report/procsResult/ProcsResultSerial", //
            "report/procsResult/ProcsResultRate", //
            "monitoring/Monitoring",//
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
