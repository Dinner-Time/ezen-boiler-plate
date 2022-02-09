package com.ezen.boilerplate.mes.standard.commonCode.service.DTO.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Code 저장 DTO
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
@Setter
public class SaveCodeDTO {

    private String codeId;
    private String codeNm;
    private String codeDesc;
    private int isEnabled = 1;

    private String parentCode;
}
