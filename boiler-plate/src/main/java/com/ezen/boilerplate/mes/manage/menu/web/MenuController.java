package com.ezen.boilerplate.mes.manage.menu.web;

import java.util.List;

import com.ezen.boilerplate.mes.manage.menu.service.MenuRequestService;
import com.ezen.boilerplate.mes.manage.menu.service.MenuResponseService;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.request.SaveMenuDTO;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.response.DetailMenuDTO;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.response.ListOfMenuDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/manage/menu")
@RequiredArgsConstructor
public class MenuController {

    private final MenuResponseService menuResponseService;
    private final MenuRequestService menuRequestService;

    @GetMapping("/{menuNo}")
    public DetailMenuDTO read( //
            @PathVariable("menuNo") String menuNo //
    ) {
        return menuResponseService.findByMenuNo(menuNo);
    }

    @GetMapping("/all")
    public List<ListOfMenuDTO> list() {
        return menuResponseService.findAll();
    }

    @PostMapping("/save")
    public int save( //
            @RequestBody SaveMenuDTO dto //
    ) {
        return menuRequestService.save(dto);
    }

    @DeleteMapping("/{menuNo}")
    public int deleteOne(//
            @PathVariable("menuNo") String menuNo //
    ) {
        return menuRequestService.deleteOne(menuNo);
    }
}
