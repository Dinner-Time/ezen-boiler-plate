package com.ezen.boilerplate.mes.standard.commonCode.service.DTO.response;

import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.CodeGroup;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CodeGroup 조회 DTO
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
public class CodeGroupListDTO {
    private String codeId;
    private String codeNm;

    public CodeGroupListDTO(CodeGroup dto) {
        this.codeId = dto.getCodeId();
        this.codeNm = dto.getCodeNm();
    }
}
