package com.ezen.boilerplate.mes.manage.menu.service.DTO.response;

import com.ezen.boilerplate.mes.manage.menu.domain.Menu;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 접근 가능한 메뉴 정보 조회 객체
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
public class LeveledMenuDTO {

    // 메뉴번호
    private String menuNo;
    // 메뉴이름
    private String menuNm;
    // 상위메뉴
    private Menu parentMenu;
    // 이동할 url
    private String redirectUrl;

    // 생성자
    public LeveledMenuDTO(Menu entity) {
        this.menuNo = entity.getMenuNo();
        this.menuNm = entity.getMenuNm();
        this.parentMenu = entity.getParentMenu();
        this.redirectUrl = entity.getRedirectUrl();
    }
}
