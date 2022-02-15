package com.ezen.boilerplate.mes.standard.employeeData.domain.entity;

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
@Table(name = "EMPLY_DATA" // 테이블 이름
)
public class Employee extends BaseTimeEntity {

	// 사번(PK)(규칙에 맞춰 자동 생성)(yyyy + 00000)
	@Id
	@Column(name = "EMPLY_ID")
	private String emloyeeId;

	// 로그인 Id(규칙에 맞춰 자동 생성)
	@Column(name = "USER_ID", nullable = false)
	private String loginId;

	// 사원이름
	@Column(name = "EMPLY_NM", nullable = false)
	private String name;

	// 이메일
	@Column(name = "EMAIL")
	private String email;

	// 휴대전화
	@Column(name = "MOB_PHON")
	private String mobileNumber;

	// 집전화
	@Column(name = "HOME_TEL")
	private String homeNumber;

	// 주소
	@Column(name = "HOME_ADDR")
	private String homeAddress;

	// 상세주소
	@Column(name = "HOME_DETAIL_ADDR")
	private String detailAddress;

	// 우편번호
	@Column(name = "HOME_ZIP")
	private String addressNumber;

	// 직책(공통코드)
	@Column(name = "JOB_POSIT", nullable = false)
	private String position;

	// 부서(공통코드)
	@Column(name = "JOB_DEPT", nullable = false)
	private String department;

	// 입사일
	@Column(name = "START_DATE", nullable = false)
	private String startDate;

	// 퇴사일
	@Column(name = "RESIGN_DATE", nullable = false)
	private String resignDate;

	// 작업공정(공통코드)
	@Column(name = "WORK_PROCS", nullable = false)
	private String workingProccess;

	// 사원구분(공통코드)
	@Column(name = "EMPLY_DIV", nullable = false)
	private String div;

	// 외주업체
	@Column(name = "ENTRPS")
	private String entrps;

	// 연봉
	@Column(name = "ANN_SAL")
	private int annualSal;

	// 월급
	@Column(name = "MON_SAL")
	private int monthlySal;

	// 생년월일
	@Column(name = "BIRTH")
	private int birthDate;

	// 비고
	@Column(name = "REMARK")
	private String remark;
}
