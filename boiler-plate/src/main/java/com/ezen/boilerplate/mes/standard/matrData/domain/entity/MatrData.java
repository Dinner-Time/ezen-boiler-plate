package com.ezen.boilerplate.mes.standard.matrData.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "MATR_DTA" // 테이블 이름
)
public class MatrData {

    @Id
    @Column(name = "MATR_CD")
    private String matrCd;

    @Column(name = "ICUBE_MATR_CD", nullable = false)
    private String icubeMatrCd;

    @Column(name = "MATR_NM", nullable = false)
    private String matrNm;

    @Column(name = "MANAGE_UNIT", nullable = false)
    private String manageUnit;

    @Column(name = "LOT_TRGET_YN", nullable = false)
    private int hasLot;

    @Column(name = "NOT_USE_YN", nullable = false)
    private int isNotDeprecated;

}
