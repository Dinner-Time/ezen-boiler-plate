<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- javascript -->
<script type="module" src="/resources/js/ezen/mes/manage/menu/app.js" defer></script>

<!-- navigation -->
<menu-navigation parent="${sessionScope.menu.parentMenu}" child="${sessionScope.menu.childMenu}"></menu-navigation>

<!-- 검색 조건 area -->
<div class="ezen-search-condition-wrap mb-2">
  <!-- row -->
  <div class="row py-1">
    <!-- col -->
    <div class="col-6 d-flex align-items-center">
      <label for="menuNm">메뉴 검색</label>
      <input id="menuNm" class="form-control ezen-input-text w-150" type="text" />
      <button type="button" id="searchBtn" class="ezen-btn-search"></button>
    </div>
    <!-- col -->

    <!-- col -->
    <div class="col-6 d-flex align-items-center justify-content-end">
      <button type="button" id="searchBtn" class="btn btn-outline-primary">신규</button>
    </div>
    <!-- col -->
  </div>
  <!-- row -->
</div>

<div class="ezen-content-wrap mt-3">
  <div class="row">
    <div class="col-2">
      <ul class="list-group list-group-flush">
        <c:forEach var="parent" items="${menuList.parent}">
          <li class="list-group-item">
            <button
              class="btn form-control btn-primary mb-1"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#menu-manage-${parent.menuNo}"
              aria-expanded="false"
              aria-controls="menu-manage-${parent.menuNo}"
            >
              ${parent.menuNm}
            </button>
          </li>
        </c:forEach>
      </ul>
    </div>
    <div class="col-2">
      <c:forEach var="parent" items="${menuList.parent}">
        <div class="collapse collapse-horizontal" id="menu-manage-${parent.menuNo}">
          <ul class="list-group list-group-flush" style="width: 200px">
            <c:forEach var="child" items="${menuList.children}">
              <c:if test="${child.parentMenu.menuNo == parent.menuNo}">
                <li class="list-group-item">${child.menuNm}</li>
              </c:if>
            </c:forEach>
          </ul>
        </div>
      </c:forEach>
    </div>
    <div class="col-8">
      <div class="ezen-title">정보 수정</div>
      <!-- col -->
      <div class="col-12 d-flex align-items-center justify-content-end">
        <button type="button" id="searchBtn" class="btn btn-outline-primary">저장</button>
      </div>
      <!-- col -->
    </div>
  </div>
</div>
