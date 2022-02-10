package com.ezen.boilerplate.mes.manage.menu.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 메뉴 repository -- JpaRepository 구현
 * 
 * @author 박태훈
 * @since 2022-02-07
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-02-07  박태훈      최초 생성
 *
 *      </pre>
 */
public interface MenuRepository extends JpaRepository<Menu, String> {
    // Menu entity의 parentMenu가 null이 아닌 행 select
    public List<Menu> findByParentMenuIsNotNullOrderByMenuOrder();

    // Menu entity의 parentMenu가 null인 행 select
    public List<Menu> findByParentMenuIsNullOrderByMenuOrder();

    // 한 건 조회
    public Menu findByMenuNo(String menuNo);
}
