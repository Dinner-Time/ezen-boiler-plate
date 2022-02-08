package com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository;

import java.util.List;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.CodeGroup;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.MasterCode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterCodeRepository extends JpaRepository<MasterCode, String> {
    List<MasterCode> findByCodeGroup(CodeGroup codeGroup);
}
