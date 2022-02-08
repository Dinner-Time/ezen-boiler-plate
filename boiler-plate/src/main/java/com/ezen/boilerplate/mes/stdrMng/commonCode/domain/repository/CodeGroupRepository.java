package com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository;

import java.util.List;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.CodeGroup;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeGroupRepository extends JpaRepository<CodeGroup, String> {
    List<CodeGroup> findByIsEnabledOrderByCreatedTime(int isEnabled);
}
