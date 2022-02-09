package com.ezen.boilerplate.mes.stdrMng.commonCode.service.DTO.response;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.DetailCode;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DetailCode 조회 DTO
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
