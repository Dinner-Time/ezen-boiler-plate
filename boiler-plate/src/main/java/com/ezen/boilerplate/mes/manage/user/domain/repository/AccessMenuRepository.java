package com.ezen.boilerplate.mes.manage.user.domain.repository;

import com.ezen.boilerplate.mes.manage.user.domain.entity.AccessMenu;
import com.ezen.boilerplate.mes.manage.user.domain.entity.compositeKey.AccessMenuId;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessMenuRepository extends JpaRepository<AccessMenu, AccessMenuId> {

}
