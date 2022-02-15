package com.ezen.boilerplate.mes.standard.commonCode.domain.repository;

import java.util.List;

import com.ezen.boilerplate.mes.standard.commonCode.domain.entity.CodeGroup;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CodeGroup Repository
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
public interface CodeGroupRepository extends JpaRepository<CodeGroup, String> {
    List<CodeGroup> findByUseYnOrderByCreatedTime(int useYn);
}
