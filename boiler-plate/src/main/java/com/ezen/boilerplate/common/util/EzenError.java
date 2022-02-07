package com.ezen.boilerplate.common.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum EzenError {
  USER_NOT_FOUND(EzenErrorType.LOGIN_ERROR.toString(), 1, "존재하지 않는 사용자입니다."),
  WRONG_PASSWORD(EzenErrorType.LOGIN_ERROR.toString(), 2, "비밀번호를 잘못 입력하였습니다.");

  private String type;
  private int code;
  private String message;
}
