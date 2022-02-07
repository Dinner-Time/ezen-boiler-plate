package com.ezen.boilerplate.mes.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ezen.boilerplate.mes.menu.service.MenuService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 *
 *      </pre>
 */
@Controller
@RequiredArgsConstructor
public class MainController {

  private final MenuService menuService;

  private final String TEMPLATE = "layout/template";

  // 메인페이지
  @GetMapping("/")
  public String main(Model model, HttpSession session) {
    // 메뉴 정보 조회
    if (session.getAttribute("menuList") == null) {
      session.setAttribute("menuList", menuService.leveledMenuList());
    }

    model.addAttribute("responsePage", "mes/main");
    return TEMPLATE;
  }

  // 메뉴 버튼 클릭 시 이동
  @GetMapping("/mes/{pageNo}")
  public String page(Model model, HttpSession session, String pageLink, @PathVariable("pageNo") String pageNo) {

    // 선택한 메뉴정보 세션에 저장
    session.setAttribute("menu", menuService.findSelectedMenu(pageNo));

    model.addAttribute("responsePage", pageLink);
    return TEMPLATE;
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
