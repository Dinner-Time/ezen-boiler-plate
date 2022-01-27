package com.ezen.boilerplate.mes.user.service;

import com.ezen.boilerplate.mes.user.domain.User;
import com.ezen.boilerplate.mes.user.domain.UserRepository;
import com.ezen.boilerplate.mes.user.service.DTO.LoginDTO;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService{

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    User user = userRepository.findByUserId(userId);
    LoginDTO loginUser = new LoginDTO(user);

    // 여기서 role 저장
    return loginUser;
  }

  // @Override
  // public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
  //   User user = userRepository.findByUserId(userId);

  //   if(user == null){
  //     throw new UsernameNotFoundException(userId + "는 존재하지 않는 아이디 입니다.");
  //   }
  //   return user;
  // }

  
}
