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
        for (int i = 10; i < 30; i++) {
            dto.setCodeId("MES0" + i);
            dto.setCodeNm("test" + i);
            dto.setParentCode("MES");
            codeRequest.saveMaster(dto);
        }
    }
}
