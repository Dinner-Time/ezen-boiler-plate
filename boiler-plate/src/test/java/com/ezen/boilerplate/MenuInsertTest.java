package com.ezen.boilerplate;

import java.util.Optional;

import com.ezen.boilerplate.mes.menu.domain.Menu;
import com.ezen.boilerplate.mes.menu.domain.MenuRepository;
import com.ezen.boilerplate.mes.menu.service.DTO.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuInsertTest {

    @Autowired
    MenuRepository menuRepository;

    @Test
    public void insert() {
        Optional<Menu> parentMenu = menuRepository.findById("110");

        SaveMenuDTO dto = SaveMenuDTO.builder()
                .menuNo("106")
                .menuNm("test6")
                .menuOrder(1)
                .redirectUrl("mes/common")
                .parentMenu(parentMenu.isPresent() ? parentMenu.get() : null)
                .build();

        menuRepository.save(new Menu(dto));
    }
}
