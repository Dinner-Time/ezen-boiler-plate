package com.ezen.boilerplate;

import java.util.Optional;

import com.ezen.boilerplate.common.menu.domain.Menu;
import com.ezen.boilerplate.common.menu.domain.MenuRepository;
import com.ezen.boilerplate.common.menu.service.DTO.request.SaveMenuDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MenuSaveTest {

    @Autowired
    MenuRepository menuRepository;

    @Test
    public void insert() {
        Optional<Menu> parentMenu = menuRepository.findById("110");

        SaveMenuDTO dto = SaveMenuDTO.builder()
                .menuNo("105")
                .menuNm("다시수정test5")
                .menuOrder(1)
                .redirectUrl("mes/common")
                .parentMenu(parentMenu.isPresent() ? parentMenu.get() : null)
                .build();

        menuRepository.save(new Menu(dto));
    }
}
