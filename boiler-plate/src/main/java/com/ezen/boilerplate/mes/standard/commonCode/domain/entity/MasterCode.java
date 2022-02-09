package com.ezen.boilerplate.mes.standard.commonCode.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ezen.boilerplate.common.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * MasterCode Entity
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
@Table(name = "COMMON_CODE_MASTER" // 테이블 이름
)
public class MasterCode extends BaseTimeEntity {

    @Id
    @Column(name = "CODE_ID", length = 6)
    private String codeId;

    @ManyToOne
    @JoinColumn(name = "CODE_CATEGORY")
    private CodeGroup codeGroup;

    // 코드 이름
    @Column(name = "CODE_NM", length = 20, nullable = false)
    private String codeNm;

    // 코드 설명
    @Column(name = "CODE_DESC", length = 255, nullable = true)
    private String codeDesc;

    // 0: not use, 1: use
    @Column(name = "IS_ENABLED", nullable = false)
    private int isEnabled;

    // 자식 객체에 저장되어 있는 @ManyToOne 변수
    @OneToMany(mappedBy = "masterCode")
    private List<DetailCode> codes;
}
