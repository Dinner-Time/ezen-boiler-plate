package com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.DetailCode;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DetailCodeListDTO {

    private String codeId;
    private String codeNm;
    private String codeDesc;
    private int isEnabled;

    public DetailCodeListDTO(DetailCode entity) {
        this.codeId = entity.getId().getCodeId();
        this.codeNm = entity.getCodeNm();
        this.codeDesc = entity.getCodeDesc();
        this.isEnabled = entity.getIsEnabled();
    }
}
