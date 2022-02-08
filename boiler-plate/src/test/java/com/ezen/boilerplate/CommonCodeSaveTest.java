package com.ezen.boilerplate;

import com.ezen.boilerplate.mes.stdrMng.commonCode.service.CommonCodeRequest;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.request.SaveCodeDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CommonCodeSaveTest {

    @Autowired
    CommonCodeRequest codeRequest;

    @Test
    public void test() {
        SaveCodeDTO dto = new SaveCodeDTO();
        dto.setCodeId("01");
        dto.setCodeNm("합판");
        dto.setParentCode("MES002");
        codeRequest.saveDetail(dto);
    }
}
