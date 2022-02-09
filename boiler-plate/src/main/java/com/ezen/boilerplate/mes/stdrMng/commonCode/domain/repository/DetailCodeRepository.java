package com.ezen.boilerplate.mes.stdrMng.commonCode.domain.repository;

import java.util.List;

import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.DetailCode;
import com.ezen.boilerplate.mes.stdrMng.commonCode.domain.entity.MasterCode;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DetailCode Repository
 * 
 * @author 박태훈
 * @since 2022-02-08
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-02-08  박태훈      최초 생성
 *
 *      </pre>
 */
public interface DetailCodeRepository extends JpaRepository<DetailCode, String> {
    List<DetailCode> findByMasterCode(MasterCode masterCode);
}
