package com.ezen.boilerplate.mes.manage.menu.service;

import java.util.Optional;

import com.ezen.boilerplate.mes.manage.menu.domain.Menu;
import com.ezen.boilerplate.mes.manage.menu.domain.MenuRepository;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuRequestService {

    private final MenuRepository menuRepository;

    public int save(SaveMenuDTO dto) {
        int result = 0;

        Optional<Menu> masterMenu = getMasterMenu(dto.getMasterMenu());

        if (masterMenu != null && !masterMenu.isPresent()) {
            return result;
        }

        menuRepository.save(Menu.builder()//
                .menuNo(dto.getMenuNo()) //
                .menuNm(dto.getMenuNm()) //
                .menuOrder(dto.getMenuOrder()) //
                .menuDesc(dto.getMenuDesc()) //
                .redirectUrl(dto.getRedirectUrl()) //
                .parentMenu(masterMenu == null ? null : masterMenu.get()) //
                .build());

        return ++result;
    }

    private Optional<Menu> getMasterMenu(String masterMenuNo) {
        if (masterMenuNo == null) {
            return null;
        }

        return menuRepository.findById(masterMenuNo);
    }

    public int deleteOne(String menuNo) {
        int result = 0;

        try {
            menuRepository.deleteById(menuNo);
        }
        catch (Exception e) {
            e.printStackTrace();
            return result;
        }

        return ++result;
    }
}
