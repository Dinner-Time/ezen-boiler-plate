package com.ezen.boilerplate.mes.user.service;

import com.ezen.boilerplate.mes.user.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{ // JpaRepository<Entity, Entity 기본키(@Id)의 타입>
  public User findByUserId(String userId);
}
