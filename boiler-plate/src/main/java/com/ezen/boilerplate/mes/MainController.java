package com.ezen.boilerplate.mes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ezen.boilerplate.common.menu.service.response.MenuResponseService;
import com.ezen.boilerplate.common.menu.service.response.DTO.LeveledMenuDTO;
import com.ezen.boilerplate.common.menu.service.response.DTO.SelectedMenuDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
 *  2022.02.08  박태훈      메뉴 기능 DB 연동 완료, template 페이지 method 추가
 *
 *      </pre>
 */
@Controller
@RequiredArgsConstructor
public class MainController {

  /**
   * 의존성 주입
   * 1. @Autowired
   * => 선언문 마다 annotation을 사용해야한다.
   * 
   * 2. 생성자
   * => class에 @RequiredArgsConstructor 추가하고 private final로 선언만 해주면 된다.
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

    // 메인 페이지로 최초 접속 시에만 메뉴 정보를 조회하도록 if문 사용
    if (session.getAttribute("menuList") == null) {

      // 메뉴 정보 조회
      Map<String, List<LeveledMenuDTO>> menuList = menuService.leveledMenuList();
      // 조회한 정보 세션에 저장
      session.setAttribute("menuList", menuList);
    }

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
  public String page(Model model, HttpSession session,
      @RequestParam("pageLink") String pageLink,
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
   * -- template.jsp에는 controller에서 보내는 responsePage에 따라 동적으로 페이지를 import하도록
   * -- 아래와 같은 코드가 구현되어 있다.
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

  @ResponseBody
  @GetMapping("/mes/commonCode/codeGroup")
  public List<Map<String, String>> codeCategory() {
    List<Map<String, String>> result = new ArrayList<Map<String, String>>();
    for (int i = 0; i < 2; i++) {
      Map<String, String> codes = new HashMap<String, String>();
      codes.put("codeId", i == 0 ? "MES" : "LET");
      codes.put("codeIdNm", i == 0 ? "공통코드" : "LET코드");
      result.add(codes);
    }
    return result;
  }

  @ResponseBody
  @GetMapping("/mes/commonCode/commonCode")
  public List<Map<String, String>> commonCode(String codeGroup) {
    List<Map<String, String>> result = new ArrayList<Map<String, String>>();

    Map<String, String> code = new HashMap<String, String>();

    switch (codeGroup) {
      case "MES":
        code.put("codeId", "MES001");
        code.put("codeIdNm", "MES공통");
        code.put("codeDesc", "MES에서 공통으로 사용되는 코드입니다.");
        code.put("useYn", "1");
        result.add(code);
        break;
      case "LET":
        code.put("codeId", "LET001");
        code.put("codeIdNm", "일반공통");
        code.put("codeDesc", "전체에서 공통으로 사용되는 코드입니다.");
        code.put("useYn", "0");
        result.add(code);
        break;
    }

    return result;
  }

  @ResponseBody
  @GetMapping("/mes/commonCode/childCode")
  public List<Map<String, String>> childCode(String codeId) {
    List<Map<String, String>> result = new ArrayList<Map<String, String>>();

    Map<String, String> code = new HashMap<String, String>();

    switch (codeId) {
      case "MES001":
        code.put("codeNo", "1");
        code.put("codeId", "PROCS_NO");
        code.put("codeIdNm", "공정번호");
        result.add(code);
        break;
      case "LET001":
        code.put("codeNo", "1");
        code.put("codeId", "EMPL_NO");
        code.put("codeIdNm", "사원번호");
        result.add(code);
        break;
    }

    return result;
  }
}
