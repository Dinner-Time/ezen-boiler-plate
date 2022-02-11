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
    <div class="col-12 d-flex align-items-center justify-content-end">
      <button type="button" id="newBtn" class="btn btn-outline-primary ezen-btn ezen-btn-new">신규</button>
      <button type="button" id="saveBtn" class="btn btn-outline-primary ezen-btn ezen-btn-save">저장</button>
    </div>
    <!-- col -->
  </div>
  <!-- row -->
</div>

<div class="ezen-content-wrap mt-3">
  <div class="row" style="height: 75vh">
    <div class="col-3" style="max-height: 100%; overflow-x: hidden; overflow-y: scroll">
      <div class="accordion accordion-flush" id="menuManageAccordion">
        <c:forEach var="parent" items="${menuList.parent}">
          <div class="accordion-item">
            <h2 class="accordion-header" id="menu-manage-header-${parent.menuNo}">
              <button
                class="accordion-button collapsed"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#menu-manage-${parent.menuNo}"
                aria-expanded="false"
                aria-controls="menu-manage-${parent.menuNo}"
              >
                ${parent.menuNm}
              </button>
            </h2>
            <div
              id="menu-manage-${parent.menuNo}"
              class="accordion-collapse collapse"
              aria-labelledby="menu-manage-header-${parent.menuNo}"
              data-bs-parent="#menuManageAccordion"
              data-master-menu="${parent.menuNo}"
            >
              <div class="accordion-body px-0">
                <div class="list-group list-group-flush" style="border-radius: 0.25rem"></div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
    <div class="col-1"></div>
    <div class="col-8">
      <!-- tab 구현 -->
      <nav>
        <div class="nav nav-tabs ezen-tabs" id="nav-tab" role="tablist">
          <button
            class="nav-link active"
            id="menuManageTab"
            data-bs-toggle="tab"
            data-bs-target="#menuManageTabBody"
            type="button"
            role="tab"
            aria-controls="menuManageTabBody"
            aria-selected="true"
            style="flex: 0.2"
          >
            <span class="ezen-title">정보수정</span>
          </button>
          <!--  -->
          <button class="nav-link" type="button" disabled style="border-top: none; border-right: none; background: none"></button>
        </div>
      </nav>

      <!-- tab content -->
      <div class="tab-content ezen-tab-content py-4 px-2" id="nav-tabContent">
        <div class="tab-pane fade show active" id="menuManageTabBody" role="tabpanel" aria-labelledby="menuManageTab">
          <form id="menuManageForm" class="row">
            <div class="col-12 mb-4">
              <div class="d-flex align-items-center">
                <label for="masterMenu">상위 메뉴</label>
                <input
                  type="text"
                  id="masterMenu"
                  name="masterMenu"
                  class="form-control w-150 ezen-input-text"
                  readonly
                  data-vaildate-for="saveMenu"
                />
              </div>
            </div>

            <div class="col-4 mb-4">
              <label for="menuNo">메뉴 번호</label>
              <input type="text" id="menuNo" name="menuNo" class="form-control ezen-input-text mt-2" readonly data-vaildate-for="saveMenu" />
            </div>
            <div class="col-4">
              <label for="menuNm">메뉴 이름</label>
              <input type="text" id="menuNm" name="menuNm" class="form-control ezen-input-text mt-2" data-vaildate-for="saveMenu" />
            </div>
            <div class="col-2">
              <label for="menuOrder">메뉴 순서</label>
              <input type="number" id="menuOrder" name="menuOrder" class="form-control ezen-input-text mt-2" data-vaildate-for="saveMenu" />
            </div>
            <div class="col-2 d-flex align-items-center justify-content-start">
              <button type="button" id="deleteBtn" class="btn btn-danger" style="display: none">삭제</button>
            </div>

            <div class="col-12 mb-4">
              <label for="redirectUrl">페이지 경로</label>
              <input type="text" id="redirectUrl" name="redirectUrl" class="form-control ezen-input-text mt-2" data-vaildate-for="saveMenu" />
            </div>
            <div class="col-12">
              <span>메뉴 설명</span>
              <limited-textarea id="menuDesc" name="menuDesc" height="100px" limit="255"></limited-textarea>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
