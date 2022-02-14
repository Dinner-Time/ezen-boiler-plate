package com.ezen.boilerplate.setData;

import com.ezen.boilerplate.mes.manage.user.service.UserRequestService;
import com.ezen.boilerplate.mes.manage.user.service.DTO.request.SignUpDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class User {

    @Autowired
    UserRequestService userRequestService;

    @Test
    public void test() {

        SignUpDTO dto = new SignUpDTO();
        dto.setUserId("admin");
        dto.setPassword("1");

        userRequestService.save(dto);
    }
}
