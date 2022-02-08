package com.ezen.boilerplate.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 에러 메세지 enum
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
@AllArgsConstructor
@Getter
public enum EzenError {
  USER_NOT_FOUND(EzenErrorType.LOGIN_ERROR, 1, "존재하지 않는 사용자입니다."),
  WRONG_PASSWORD(EzenErrorType.LOGIN_ERROR, 2, "비밀번호를 잘못 입력하였습니다.");

  private EzenErrorType type;
  private int code;
  private String message;
}
