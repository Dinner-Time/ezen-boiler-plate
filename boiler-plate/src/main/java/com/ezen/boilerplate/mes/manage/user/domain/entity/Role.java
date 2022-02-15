package com.ezen.boilerplate.mes.manage.user.domain.entity;

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
@Table(name = "ROLE" // 테이블 이름
)
public class Role extends BaseTimeEntity {

	@Id
	@Column(name = "ROLE_CODE")
	private String code;

	@Column(name = "ROLE_NAME", nullable = false)
	private String name;

	@Column(name = "ROLE_DESC")
	private String desc;
}
