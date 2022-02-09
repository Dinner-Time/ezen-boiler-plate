package com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.MasterCode;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * MasterCode 조회 DTO
 * 
 * @author 박태훈
 * @since 2022-02-08
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-02-08  박태훈      최초 생성
 *
 *      </pre>
 */
@Getter
@NoArgsConstructor
public class MasterCodeListDTO {

    private String codeId;
    private String codeNm;
    private String codeDesc;
    private int isEnabled;

    public MasterCodeListDTO(MasterCode entity) {
        this.codeId = entity.getCodeId();
        this.codeNm = entity.getCodeNm();
        this.codeDesc = entity.getCodeDesc();
        this.isEnabled = entity.getIsEnabled();
    }
}
