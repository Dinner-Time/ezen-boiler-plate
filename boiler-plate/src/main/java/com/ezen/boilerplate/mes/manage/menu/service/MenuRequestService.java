package com.ezen.boilerplate.mes.manage.menu.service;

import com.ezen.boilerplate.mes.manage.menu.domain.entity.Menu;
import com.ezen.boilerplate.mes.manage.menu.domain.repository.MenuRepository;
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

        try {
            menuRepository.save(Menu.builder()//
                    .menuNo(dto.getMenuNo()) //
                    .menuNm(dto.getMenuNm()) //
                    .menuOrder(dto.getMenuOrder()) //
                    .menuDesc(dto.getMenuDesc()) //
                    .redirectUrl(dto.getRedirectUrl()) //
                    .masterMenu(dto.getMasterMenu()) //
                    .build());
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }

        return ++result;
    }

    public int deleteOne(String menuNo) {
        int result = 0;

        try {
            menuRepository.deleteById(menuNo);
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }

        return ++result;
    }
}
