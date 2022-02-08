package com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveCodeDTO {

    private String codeId;
    private String codeNm;
    private String codeDesc;
    private int isEnabled = 1;

    private String parentCode;
}
