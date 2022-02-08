package com.ezen.boilerplate.common.menu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ezen.boilerplate.common.domain.BaseTimeEntity;
import com.ezen.boilerplate.common.menu.service.DTO.request.SaveMenuDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "MENU_INFO" // 테이블 이름
)
public class Menu extends BaseTimeEntity {

  @Id
  @Column(name = "MENU_NO", length = 10)
  private String menuNo;

  @Column(name = "MENU_NM", length = 150, nullable = false)
  private String menuNm;

  @Column(name = "MENU_ORDR", length = 2, nullable = false)
  private int menuOrder;

  @Column(name = "MENU_DESC")
  private String menuDesc;

  @Column(name = "REDIRECT_URL", nullable = false)
  private String redirectUrl;

  // 연관관계 매핑(** 메뉴 테이블은 자기 자신을 참조하는 테이블이다.)
  // @ManyToOne : 다대일 관계 매핑
  // => 객체 관점에서 부모 class
  @ManyToOne
  @JoinColumn(name = "PAR_MENU_NO")
  private Menu parentMenu; // 부모 entity 타입으로 변수를 생성한다.

  // @OneToMany : 일대다 관계 매핑
  // => 객체 관점에서 자식 class
  @OneToMany(mappedBy = "parentMenu")
  private List<Menu> childMenu; // 자기 자신 entity타입을 담는 collection 변수를 생성한다.

  /**
   * 메뉴 정보 insert, update시 사용하는 생성자
   * => DTO와 Entity의 사용법은 MenuSaveTest.java참고
   * 
   * @param dto
   */
  public Menu(SaveMenuDTO dto) {
    this.menuNo = dto.getMenuNo();
    this.menuNm = dto.getMenuNm();
    this.menuOrder = dto.getMenuOrder();
    this.menuDesc = dto.getMenuDesc();
    this.redirectUrl = dto.getRedirectUrl();
    this.parentMenu = dto.getParentMenu();
  }
}
