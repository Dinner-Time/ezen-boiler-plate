package com.ezen.boilerplate.mes.manage.user.domain.entity;

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
 * 사용자 Entity
 *
 * @author 박태훈
 * @since 2022-01-25
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일	수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-01-25  박태훈      최초 생성
 *  2022-02-08  박태훈      회원가입 DTO 적용
 *
 *
 *      </pre>
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "USER_INFO" // 테이블 이름
)
public class User extends BaseTimeEntity {

        // 사용자 로그인 ID
        @Id
        @Column(name = "USER_ID")
        private String userId;

        // 사용자 비밀번호(초기비밀번호 0000)
        @Column(name = "PASSWORD", nullable = false)
        private String password;

        // 사용자 권한
        @Column(name = "ROLE", nullable = false)
        private String role;

        // 사용자 그룹(그룹 별 권한 변경 가능)
        @Column(name = "USER_GROUP")
        private String group;
}
