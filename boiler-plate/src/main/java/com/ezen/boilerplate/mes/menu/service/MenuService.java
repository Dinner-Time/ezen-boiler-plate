package com.ezen.boilerplate.mes.menu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ezen.boilerplate.mes.menu.domain.Menu;
import com.ezen.boilerplate.mes.menu.domain.MenuRepository;
import com.ezen.boilerplate.mes.menu.service.DTO.SelectedMenuDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public SelectedMenuDTO findSelectedMenu(String menuNo) {
        // 자동으로 join을 걸었다??? 어떻게????
        Menu menu = menuRepository.findById(menuNo).get();
        Menu parent = menuRepository.findById(menu.getParentMenu().getMenuNo()).get();

        SelectedMenuDTO selected = SelectedMenuDTO.builder()
                .parentMenu(parent.getMenuNm())
                .childMenu(menu.getMenuNm())
                .build();

        return selected;
    }

    public Map<String, List<Menu>> leveledMenuList() {
        Map<String, List<Menu>> result = new HashMap<String, List<Menu>>();
        result.put("parent", menuRepository.findByParentMenuIsNull());
        result.put("children", menuRepository.findByParentMenuIsNotNull());
        return result;
    }
}
