package com.ezen.boilerplate.mes.manage.user.domain.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ezen.boilerplate.common.domain.BaseTimeEntity;
import com.ezen.boilerplate.mes.manage.user.domain.entity.compositeKey.AccessMenuId;

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
@Table(name = "MENU_ACCESS_MNG" // 테이블 이름
)
public class AccessMenu extends BaseTimeEntity {

	@EmbeddedId
	private AccessMenuId accessMenu;
}
