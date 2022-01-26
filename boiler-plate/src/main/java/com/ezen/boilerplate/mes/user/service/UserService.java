package com.ezen.boilerplate.mes.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return null;
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
