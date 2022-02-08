package com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.MasterCode;

import lombok.Getter;
import lombok.NoArgsConstructor;

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
