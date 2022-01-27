package com.ezen.boilerplate.mes.user.service.DTO;

import java.util.ArrayList;
import java.util.Collection;

import com.ezen.boilerplate.mes.user.domain.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginDTO implements UserDetails{

  private String userId;
  private String password;

  @Builder
  public LoginDTO(User entity){
    this.userId = entity.getUserId();
    this.password = entity.getPassword();
  }

  // 로그인 ID
  @Override
  public String getUsername() {
    return this.userId;
  }

  // 로그인 패스워드
  @Override
  public String getPassword() {
    return this.password;
  }

  // 권한 목록
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection <GrantedAuthority> authorities = new ArrayList<>();

    // 유저 별 추가할 권한 관리
    authorities.add(new SimpleGrantedAuthority("Role"));
    return authorities;
  }

  // 계정 만료 여부(true : 만료되지 않음)
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // 계정 잠김 여부(true : 잠기지 않음)
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // 비밀번호 만료 여부(true : 만료되지 않음)
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // 계정 활성화 여부(true : 활성화)
  @Override
  public boolean isEnabled() {
    return true;
  }
  
}
