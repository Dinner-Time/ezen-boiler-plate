package com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.CodeGroup;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CodeGroupListDTO {
    private String codeId;
    private String codeNm;

    public CodeGroupListDTO(CodeGroup dto) {
        this.codeId = dto.getCodeId();
        this.codeNm = dto.getCodeNm();
    }
}
