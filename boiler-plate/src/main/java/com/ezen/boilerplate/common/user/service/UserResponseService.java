package com.ezen.boilerplate.common.user.service;

import com.ezen.boilerplate.common.user.domain.User;
import com.ezen.boilerplate.common.user.domain.UserRepository;
import com.ezen.boilerplate.common.user.service.DTO.response.LoginDTO;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserResponseService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    User user = userRepository.findByUserId(userId);
    LoginDTO loginUser = new LoginDTO(user);
    return loginUser;
  }
}
