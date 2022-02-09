package com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.compositeKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DetailCode Entity의 복합 키 class
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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DetailCodeId implements Serializable {
    @Column(name = "CODE_ID", length = 6)
    private String codeId;

    private String masterCodeId;
}
