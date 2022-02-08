package com.ezen.boilerplate.mes.stdrMng.commonCode.web;

import java.util.List;

import com.ezen.boilerplate.mes.stdrMng.commonCode.service.CommonCodeRequest;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.CommonCodeResponse;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.request.SaveCodeDTO;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.CodeGroupListDTO;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.DetailCodeListDTO;
import com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response.MasterCodeListDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CommonCodeController {

    private final CommonCodeResponse commonCodeResponse;
    private final CommonCodeRequest commonCodeRequest;

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

    @PostMapping("/mes/commonCode/save/master")
    public int save(@RequestBody SaveCodeDTO dto){

        String save = commonCodeRequest.saveMaster(dto);
        
        int result;
        result = save == null ? 0 : 1;

        return result;
    }
}
