package com.ezen.boilerplate;

import com.ezen.boilerplate.mes.manage.menu.domain.Menu;
import com.ezen.boilerplate.mes.manage.menu.domain.MenuRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuSaveTest {

    @Autowired
    MenuRepository menuRepository;

    @Test
    public void insert() {
        for (int i = 0; i < 20; i++) {
            int menuNo = 301 + i;

            menuRepository.save(Menu.builder()//
                    .menuNo(String.valueOf(menuNo))//
                    .menuNm("test" + i)//
                    .parentMenu(menuRepository.findById("300").get())//
                    .build());
        }
    }
}
