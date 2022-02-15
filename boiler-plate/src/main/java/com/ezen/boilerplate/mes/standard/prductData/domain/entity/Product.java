package com.ezen.boilerplate.mes.standard.prductData.domain.entity;

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
@Table(name = "PRDUCT_DATA" // 테이블 이름
)
public class Product extends BaseTimeEntity {

    // 제품 코드
    @Id
    @Column(name = "PRDUCT_CD")
    private String code;

    // 포장시 파렛트에 담길 기준 박스 갯수
    @Column(name = "STNDRD_EA")
    private int standardEA;

    // 포장시 박스에 담길 기준 케이블 길이(M)
    @Column(name = "STNDRD_LENGTH")
    private int standardLength;
}
