package com.ezen.boilerplate;

import com.ezen.boilerplate.common.menu.domain.MenuRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuSaveTest {

    @Autowired
    MenuRepository menuRepository;

    @Test
    public void insert() {

    }
}
