package com.ezen.boilerplate.mes.manage.user.domain.entity.compositeKey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccessMenuId implements Serializable {
	@Column(name = "MENU_NO")
	private String no;

	@Column(name = "USER_ROLE")
	private String role;
}
