package com.ezen.boilerplate.mes.manage.menu.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ezen.boilerplate.common.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 메뉴 Entity
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
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "MENU_INFO" // 테이블 이름
)
public class Menu extends BaseTimeEntity {

    @Id
    @Column(name = "MENU_NO")
    private String menuNo;

    @Column(name = "MENU_NM", nullable = false)
    private String menuNm;

    @Column(name = "MENU_ORDR", nullable = false)
    private int menuOrder;

    @Column(name = "MENU_DESC")
    private String menuDesc;

    @Column(name = "REDIRECT_URL", nullable = false)
    private String redirectUrl;

    @Column(name = "MASTER_MENU")
    private String masterMenu;
}
