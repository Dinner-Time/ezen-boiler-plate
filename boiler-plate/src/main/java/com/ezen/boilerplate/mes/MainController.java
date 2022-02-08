package com.ezen.boilerplate.mes;

import javax.servlet.http.HttpSession;

import com.ezen.boilerplate.common.menu.service.MenuResponseService;
import com.ezen.boilerplate.common.menu.service.DTO.response.SelectedMenuDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

/**
 * 
 * Main Controller
 * 
 * @author 박태훈
 * @since 2022.01.25
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일		   수정자	    수정내용
 *  -------     --------  ---------------------------
 *  2022.01.25	박태훈	    최초생성
 *  2022.02.08  박태훈      메뉴 기능 DB 연동 완료 
 *                          template 페이지 method 추가
 *                          세션에 메뉴 정보 저장 기능 UserController로 이동
 *
 *      </pre>
 */
@Controller
@RequiredArgsConstructor
public class MainController {

    /**
     * 의존성 주입 1. @Autowired => 선언문 마다 annotation을 사용해야한다.
     * 
     * 2. 생성자 => class에 @RequiredArgsConstructor 추가하고 private
     * final로 선언만 해주면 된다.
     * 
     * -- 해당 controller에선 생성자 주입 방식 활용
     */
    // 메뉴 서비스
    private final MenuResponseService menuService;

    /**
     * 메인 페이지 이동
     * 
     * @param model
     * @param session
     * @return
     */
    @GetMapping("/")
    public String main(Model model, HttpSession session) {
        // template page 활용
        return templatePage(model, "main");
    }

    /**
     * 메뉴 클릭 시 페이지 이동 controller
     * 
     * @param model
     * @param session
     * @param pageLink // 이동할 페이지
     * @param pageNo   // 메뉴 entity에 저장된 menuNo
     * @return
     */
    @GetMapping("/mes/{pageNo}")
    public String page(Model model, HttpSession session, @RequestParam("pageLink") String pageLink,
            @PathVariable("pageNo") String pageNo) {

        // 선택한 메뉴 정보 조회
        SelectedMenuDTO selectedMenu = menuService.findSelectedMenu(pageNo);
        // 조회한 정보 세션에 저장
        session.setAttribute("menu", selectedMenu);

        // template page 활용
        return templatePage(model, pageLink);
    }

    /**
     * template page
     * 
     * -- template.jsp에는 controller에서 보내는 responsePage에 따라 동적으로
     * 페이지를 import하도록 -- 아래와 같은 코드가 구현되어 있다.
     * 
     * <c:import url="/WEB-INF/view/${responsePage}.jsp"
     * charEncoding="UTF-8"></c:import>
     * 
     * @param model
     * @param returnPage // 화면에 보여줄 jsp의 경로
     * @return
     */
    private String templatePage(Model model, String returnPage) {
        model.addAttribute("responsePage", returnPage);
        return "layout/template";
    }

}
