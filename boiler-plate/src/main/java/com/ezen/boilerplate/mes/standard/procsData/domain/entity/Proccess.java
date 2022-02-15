package com.ezen.boilerplate.mes.standard.procsData.domain.entity;

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

@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "PROCS_DATA" // 테이블 이름
)
public class Proccess extends BaseTimeEntity {

    // 공정코드
    @Id
    @Column(name = "PROCS_CD")
    private String code;

    // 공정이름
    @Column(name = "PROCS_NM")
    private String name;

    // 공정 이후 검사 유무
    @Column(name = "INSP_YN")
    private int isInspected;

    // 비고
    @Column(name = "REMARK")
    private String remark;
}
