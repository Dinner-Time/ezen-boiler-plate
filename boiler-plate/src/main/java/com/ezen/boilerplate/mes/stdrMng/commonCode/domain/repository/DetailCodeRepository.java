package com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository;

import java.util.List;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.DetailCode;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.MasterCode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailCodeRepository extends JpaRepository<DetailCode, String> {
    List<DetailCode> findByMasterCode(MasterCode masterCode);
}
