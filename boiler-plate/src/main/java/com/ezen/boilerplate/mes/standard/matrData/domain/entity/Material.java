package com.ezen.boilerplate.mes.standard.matrData.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(name = "MATR_DTA", // 테이블 이름
                uniqueConstraints = { // unique 제약조건 설정
                                @UniqueConstraint(name = "UNIQUE_MATR_CD", // unique 제약조건 이름
                                                columnNames = { "ICUBE_MATR_CD" } // 적용할 칼럼 이름
                                ), })
public class Material extends BaseTimeEntity {

        // 자재번호
        @Id
        @Column(name = "MATR_CD")
        private String code;

        // 아이큐브에 저장된 자재번호
        @Column(name = "ICUBE_MATR_CD", nullable = false)
        private String icubeCode;

        // 자재이름
        @Column(name = "MATR_NM", nullable = false)
        private String name;

        // 관리 단위
        @Column(name = "MANAGE_UNIT", nullable = false)
        private String unit;

        // LOT 사용 여부
        @Column(name = "LOT_TRGET_YN", nullable = false)
        private int hasLot;

        // 자재 사용 여부
        @Column(name = "NOT_USE_YN", nullable = false)
        private int isUsing;

        // 비고
        @Column(name = "REMARK")
        private String remark;

}
