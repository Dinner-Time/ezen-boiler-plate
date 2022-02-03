<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- navigation -->
<menu-navigation parent="${sessionScope.menu.parentMenu}" child="${sessionScope.menu.childMenu}"></menu-navigation>

<!-- 검색 조건 area -->
<div class="ezen-search-condition-wrap mb-2">
  <!-- row -->
  <div class="row py-1">
    <!-- col -->
    <div class="col-6 d-flex align-items-center">
      <label for="code">그룹코드</label>
      <ezen-select id="code" name="code">
        <option value="1">MES001</option>
        <option value="2">MES002</option>
        <option value="3">MES003</option>
        <option value="4">MES004</option>
        <option value="5">MES005</option>
      </ezen-select>
    </div>
    <!-- col -->

    <!-- col -->
    <div class="col-6 d-flex justify-content-end">
      <button type="button" class="btn btn-outline-primary ezen-btn ezen-btn-new">신규</button>
      <button type="button" class="btn btn-outline-primary ezen-btn ezen-btn-save">저장</button>
    </div>
    <!-- col -->
  </div>
  <!-- row -->
</div>

<!-- 정보 조회 화면 -->
<div class="ezen-content-wrap">
  <div class="row">
    <!-- 코드 리스트 -->
    <div class="col-4">
      <!-- 코드 검색 조건 -->
      <div class="ezen-search-condition-wrap no-border no-background p-0 my-2">
        <!-- row -->
        <div class="row">
          <!-- title -->
          <div class="col-2">
            <span class="ezen-title">코드</span>
          </div>
          <!-- title -->

          <!-- form control input -->
          <div class="col-10 d-flex align-items-center justify-content-end">
            <div class="d-flex align-items-center">
              <label for="">코드 ID명</label>
              <input class="form-control ezen-input-text w-150" type="text" />
              <button class="btn btn-outline-primary ezen-btn w-80">검색</button>
            </div>
          </div>
          <!-- form control input -->
        </div>
        <!-- row -->
      </div>
      <!-- 코드 검색 조건 -->

      <!-- grid -->
      <div id="grid"></div>
      <!-- grid -->
    </div>
    <!-- 코드 리스트 -->

    <!-- 코드 상세정보 -->
    <div class="col-8">
      <!-- tab 구현 -->
      <nav>
        <div class="nav nav-tabs ezen-tabs" id="nav-tab" role="tablist">
          <button
            class="nav-link active"
            id="detail-code-tab"
            data-bs-toggle="tab"
            data-bs-target="#detail-code"
            type="button"
            role="tab"
            aria-controls="detail-code-wrap"
            aria-selected="true"
          >
            상세코드
          </button>
          <!--  -->
          <button
            class="nav-link"
            id="code-info-tab"
            data-bs-toggle="tab"
            data-bs-target="#code-info"
            type="button"
            role="tab"
            aria-controls="code-info"
            aria-selected="false"
          >
            코드정보
          </button>
        </div>
      </nav>

      <!-- tab content -->
      <div class="tab-content ezen-tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="detail-code" role="tabpanel" aria-labelledby="detail-code-tab">
          <div class="mt-5" id="detailGrid"></div>
        </div>
        <div class="tab-pane fade" id="code-info" role="tabpanel" aria-labelledby="code-info-tab">코드정보</div>
      </div>
      <!--  -->
    </div>
  </div>
</div>
<script type="module" src="/resources/js/ezen/mes/commonCode/app.js" defer></script>
