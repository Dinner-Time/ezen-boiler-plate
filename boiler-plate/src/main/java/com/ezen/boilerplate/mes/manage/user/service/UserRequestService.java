package com.ezen.boilerplate.mes.manage.user.service;

import com.ezen.boilerplate.mes.manage.user.domain.entity.User;
import com.ezen.boilerplate.mes.manage.user.domain.repository.UserRepository;
import com.ezen.boilerplate.mes.manage.user.service.DTO.request.SignUpDTO;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserRequestService {

    private final UserRepository userRepository;

    public int save(SignUpDTO dto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        int result = 0;

        userRepository.save(User.builder()//
                .userId(dto.getUserId())//
                .password(encoder.encode(dto.getPassword()))//
                .build());

        return ++result;
    }
}
