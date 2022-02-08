package com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity;

import com.ezen.boilerplate.common.domain.BaseTimeEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
@Table(name = "COMMON_CODE_CATEGORY" // 테이블 이름
)
public class CodeGroup extends BaseTimeEntity {

    // 코드 ID
    @Id
    @Column(name = "CODE_ID", length = 6)
    private String codeId;

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
    @OneToMany(mappedBy = "codeGroup")
    private List<MasterCode> codes;
}
