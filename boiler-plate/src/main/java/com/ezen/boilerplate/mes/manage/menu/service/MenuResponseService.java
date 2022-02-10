package com.ezen.boilerplate.mes.manage.menu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ezen.boilerplate.mes.manage.menu.domain.Menu;
import com.ezen.boilerplate.mes.manage.menu.domain.MenuRepository;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.response.DetailMenuDTO;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.response.LeveledMenuDTO;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.response.ListOfMenuDTO;
import com.ezen.boilerplate.mes.manage.menu.service.DTO.response.SelectedMenuDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * 메뉴 정보 조회 service
 *
 * @author 박태훈
 * @since 2022-02-07
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022-02-07  박태훈      최초 생성
 *
 *      </pre>
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuResponseService {

    // 생성자 의존성 주입(자세한 내용은 MainController 참고)
    private final MenuRepository menuRepository;

    /**
     * 선택한 메뉴 정보 조회
     *
     * @param menuNo
     * @return
     */
    public SelectedMenuDTO findSelectedMenu(String menuNo) {
        Menu menu = menuRepository.findById(menuNo).get();
        return new SelectedMenuDTO(menu);
    }

    /**
     * 접근 가능한 전체 메뉴 조회
     *
     * @return
     */
    public Map<String, List<LeveledMenuDTO>> leveledMenuList() {
        Map<String, List<LeveledMenuDTO>> result = new HashMap<String, List<LeveledMenuDTO>>();

        List<Menu> parentsEntity = menuRepository.findByParentMenuIsNullOrderByMenuOrder();
        List<Menu> childrenEntity = menuRepository.findByParentMenuIsNotNullOrderByMenuOrder();

        List<LeveledMenuDTO> parentsDTO = new ArrayList<LeveledMenuDTO>();
        List<LeveledMenuDTO> childrenDTO = new ArrayList<LeveledMenuDTO>();

        for (Menu m : parentsEntity) {
            parentsDTO.add(new LeveledMenuDTO(m));
        }
        for (Menu m : childrenEntity) {
            childrenDTO.add(new LeveledMenuDTO(m));
        }

        result.put("parent", parentsDTO);
        result.put("children", childrenDTO);
        return result;
    }

    /**
     * 한 건 조회
     * 
     * @param menuNo
     * @return
     */
    public DetailMenuDTO findByMenuNo(String menuNo) {
        Optional<Menu> entity = menuRepository.findById(menuNo);

        DetailMenuDTO result = entity.isPresent() ? new DetailMenuDTO(entity.get()) : new DetailMenuDTO();

        return result;
    }

    /**
     * 
     * 하위메뉴 전체 조회
     */
    public List<ListOfMenuDTO> findAll() {

        List<Menu> entities = menuRepository.findByParentMenuIsNotNullOrderByMenuOrder();

        List<ListOfMenuDTO> dtos = new ArrayList<ListOfMenuDTO>();

        for (Menu m : entities) {
            dtos.add(new ListOfMenuDTO(m));
        }

        return dtos;
    }
}
