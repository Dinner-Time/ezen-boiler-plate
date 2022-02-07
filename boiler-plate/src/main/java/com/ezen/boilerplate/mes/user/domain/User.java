package com.ezen.boilerplate.mes.user.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
  name = "USER_INFO", // 테이블 이름
    uniqueConstraints = {  // unique 제약조건 설정
      @UniqueConstraint(
        name="UNIQUE_USER_ID", // unique 제약조건 이름
        columnNames = {"USER_ID"}  // 적용할 칼럼 이름
      )
    } 
  )
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false)
  private Long id;

  @Column(name = "USER_ID", length = 36)
  private String userId;

  @Column(name="PASSWORD", length = 128, nullable = false)
  private String password;

  @Column(name="CREATED_TIME", nullable = false)
  private LocalDateTime createdTime = LocalDateTime.now();

  @Column(name="UPDATED_TIME", nullable = false )
  private LocalDateTime updatedTime = LocalDateTime.now();

}
