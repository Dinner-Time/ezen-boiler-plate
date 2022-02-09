package com.ezen.boilerplate.common.menu.service.DTO.response;

import com.ezen.boilerplate.common.menu.domain.Menu;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 선택한 메뉴 조회 객체
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
@Getter
@NoArgsConstructor
public class SelectedMenuDTO {

    // 상위 메뉴
    private String parentMenu;
    // 하위 메뉴
    private String childMenu;

    // 생성자
    public SelectedMenuDTO(Menu entity) {
        this.parentMenu = entity.getParentMenu().getMenuNm();
        this.childMenu = entity.getMenuNm();
    }
}
