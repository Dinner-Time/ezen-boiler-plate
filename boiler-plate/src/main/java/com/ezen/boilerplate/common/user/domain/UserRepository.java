package com.ezen.boilerplate.common.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { // JpaRepository<Entity, Entity 기본키(@Id)의 타입>
  public User findByUserId(String userId);
}
