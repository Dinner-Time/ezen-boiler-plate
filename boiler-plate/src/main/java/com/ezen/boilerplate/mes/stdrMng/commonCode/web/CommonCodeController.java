package com.ezen.boilerplate.mes.stdrMng.commonCode.web;

import java.util.List;

import com.ezen.boilerplate.mes.stdrMng.commonCode.service.CommonCodeResponse;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.CodeGroupListDTO;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.DetailCodeListDTO;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.MasterCodeListDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommonCodeController {

    private final CommonCodeResponse commonCodeResponse;

    @GetMapping("/mes/commonCode/codeGroup")
    public List<CodeGroupListDTO> codeCategory() {

        return commonCodeResponse.codeGroupList();
    }

    @GetMapping("/mes/commonCode/commonCode")
    public List<MasterCodeListDTO> masterCode(//
            @RequestParam("codeGroup") String codeGroup) {

        return commonCodeResponse.masterCodeListByGroup(codeGroup);
    }

    @GetMapping("/mes/commonCode/childCode")
    public List<DetailCodeListDTO> childCode(//
            @RequestParam("codeId") String masterCodeId) {

        return commonCodeResponse.detailCodeListByMasterCode(masterCodeId);
    }
}
