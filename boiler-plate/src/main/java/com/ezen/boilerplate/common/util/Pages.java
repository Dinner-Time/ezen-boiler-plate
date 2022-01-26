package com.ezen.boilerplate.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 
 * Controller로 이동할 페이지
 * @author 박태훈
 * @since 2022.01.25
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022.01.25	박태훈	    최초생성
 *
 *      </pre>
 */
@AllArgsConstructor
@Getter
public enum Pages {
  TEMPLATE("layout/template"),
  MAIN("mes/main"),
  LOGIN("mes/login/login")
  ;

  private final String page;
}
