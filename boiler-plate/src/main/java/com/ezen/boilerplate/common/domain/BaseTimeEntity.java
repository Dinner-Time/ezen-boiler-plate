package com.ezen.boilerplate.common.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * JPA auditing으로 다른 entity들이 상속 받아 사용할 수 있는 생성시간, 수정시간 Entity
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
@MappedSuperclass // 다른 entity들이 상속받을 수 있게 한다.
@EntityListeners(AuditingEntityListener.class) // JPA auditing 적용
public abstract class BaseTimeEntity {

    /**
     * 해당 entity를 상속하는 entity들은 insert, update시 시간이 자동으로 update된다.
     */

    // 생성시간
    @CreatedDate
    @Column(name = "CREATED_TIME")
    private LocalDateTime createdTime = LocalDateTime.now(); // 현재시간으로 기본값 부여

    // 수정시간
    @LastModifiedDate
    @Column(name = "UPDATED_TIME")
    private LocalDateTime updatedTime = LocalDateTime.now(); // 현재시간으로 기본값 부여
}
