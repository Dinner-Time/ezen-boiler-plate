<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <!-- head -->
  <!-- meta 속성, title, 필수 css, js 등을 정의한다. -->
  <c:import url="/WEB-INF/view/layout/head.jsp" charEncoding="UTF-8"></c:import>

  <body>
    <!-- header  -->
    <!-- 최상단 UI를 정의한다. -->
    <c:import url="/WEB-INF/view/layout/header.jsp" charEncoding="UTF-8"></c:import>

    <!-- menu -->
    <!-- 메뉴 UI를 정의한다. -->
    <c:import url="/WEB-INF/view/layout/menu.jsp" charEncoding="UTF-8"></c:import>

    <!-- main -->
    <!-- URL에 따라 동적으로 변하는 페이지를 정의한다. -->
    <c:import url="/WEB-INF/view/${responsePage}.jsp" charEncoding="UTF-8"></c:import>
  </body>

  <!-- footer -->
  <!-- 최하단 UI를 정의한다. -->
  <c:import url="/WEB-INF/view/layout/footer.jsp" charEncoding="UTF-8"></c:import>
</html>
