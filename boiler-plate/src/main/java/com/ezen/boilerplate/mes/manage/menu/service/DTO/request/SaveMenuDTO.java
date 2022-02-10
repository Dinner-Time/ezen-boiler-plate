package com.ezen.boilerplate.mes.manage.menu.service.DTO.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 메뉴 정보 저장 객체
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
@Setter
@ToString
public class SaveMenuDTO {

    // 메뉴 번호(pk)
    private String menuNo;
    // 메뉴 이름
    private String menuNm;
    // 메뉴 순서
    private int menuOrder;
    // 메뉴 설명
    private String menuDesc;
    // 연결된 페이지
    private String redirectUrl;
    // 상위 메뉴
    private String masterMenu;
}
