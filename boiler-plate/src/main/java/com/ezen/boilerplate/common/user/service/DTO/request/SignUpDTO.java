package com.ezen.boilerplate.common.user.service.DTO.request;

import lombok.Getter;
import lombok.Setter;

/**
 * 회원가입 객체
 *
 * @author 박태훈
 * @since 2022-02-08
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일	    수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-02-08  박태훈      최초 생성
 *
 *
 *      </pre>
 */
@Getter
@Setter
public class SignUpDTO {

    // 사용자 Id
    private String userId;
    // 비밀번호
    private String password;
}
