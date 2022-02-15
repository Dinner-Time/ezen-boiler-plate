package com.ezen.boilerplate.mes.standard.commonCode.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ezen.boilerplate.common.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CodeGroup Entity
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
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "COMMON_CODE_GROUP" // 테이블 이름
)
public class CodeGroup extends BaseTimeEntity {

    // 코드 ID
    @Id
    @Column(name = "CODE_ID")
    private String codeId;

    // 코드 이름
    @Column(name = "CODE_NM", nullable = false)
    private String codeNm;

    // 코드 설명
    @Column(name = "CODE_DESC", nullable = true)
    private String codeDesc;

    // 사용 여부
    // 0: not use, 1: use
    @Column(name = "USE_YN", nullable = false)
    private int useYn;
}
