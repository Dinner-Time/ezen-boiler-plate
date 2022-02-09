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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Code Controller
 * 
 * @author 박태훈
 * @since 2022-02-09
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-02-09  박태훈      최초 생성
 *
 *      </pre>
 */
@RestController
@RequestMapping("/mes/commonCode")
@RequiredArgsConstructor
public class CommonCodeController {

    // 조회 service
    private final CommonCodeResponse commonCodeResponse;
    // 저장, 수정, 삭제 service
    private final CommonCodeRequest commonCodeRequest;

    /**
     * 
     * CodeGroup 조회
     */
    @GetMapping("/codeGroup")
    public List<CodeGroupListDTO> codeGroup() {

        return commonCodeResponse.codeGroupList();
    }

    /**
     * 
     * MasterCode 조회
     */
    @GetMapping("/masterCode")
    public List<MasterCodeListDTO> masterCode(//
            @RequestParam("codeGroup") String codeGroup) {

        return commonCodeResponse.masterCodeListByGroup(codeGroup);
    }

    /**
     * 
     * DetailCode 조회
     */
    @GetMapping("/childCode")
    public List<DetailCodeListDTO> childCode(//
            @RequestParam("codeId") String masterCodeId) {

        return commonCodeResponse.detailCodeListByMasterCode(masterCodeId);
    }

    /**
     * 
     * MasterCode 저장
     */
    @PostMapping("/save/master")
    public int save(@RequestBody SaveCodeDTO dto) {

        int result = commonCodeRequest.saveMaster(dto);

        return result;
    }

    /**
     * 
     * DetailCode 저장
     */
    @PostMapping("/save/children")
    public int save(@RequestBody List<SaveCodeDTO> dtoList) {

        int result = commonCodeRequest.saveDetail(dtoList);

        return result;
    }
}
