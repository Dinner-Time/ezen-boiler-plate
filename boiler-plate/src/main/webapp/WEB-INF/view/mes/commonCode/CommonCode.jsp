<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- script -->
<script type="module" src="/resources/js/ezen/mes/commonCode/app.js" defer></script>

<!-- navigation -->
<menu-navigation parent="${sessionScope.menu.parentMenu}" child="${sessionScope.menu.childMenu}"></menu-navigation>

<!-- 검색 조건 area -->
<div class="ezen-search-condition-wrap mb-2">
  <!-- row -->
  <div class="row py-1">
    <!-- col -->
    <div class="col-6 d-flex align-items-center">
      <label for="codeGroup">그룹코드</label>
      <ezen-select id="codeGroup" name="codeGroup"></ezen-select>
    </div>
    <!-- col -->

    <!-- col -->
    <div class="col-6 d-flex justify-content-end">
      <button type="button" id="newBtn" class="btn btn-outline-primary ezen-btn ezen-btn-new">신규</button>
      <button type="button" id="saveBtn" class="btn btn-outline-primary ezen-btn ezen-btn-save">저장</button>
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
          <div class="col-3">
            <span class="ezen-title">코드목록</span>
          </div>
          <!-- title -->

          <!-- form control input -->
          <div class="col-9 d-flex align-items-center justify-content-end">
            <div class="d-flex align-items-center">
              <label for="">코드명</label>
              <input id="searchCodeNmKeyword" class="form-control ezen-input-text w-150" type="text" />
              <button id="searchCodeNmBtn" class="btn btn-outline-primary ezen-btn w-80">검색</button>
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
            하위코드
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
        <!-- 하위코드 리스트 -->
        <div class="tab-pane fade show active" id="detail-code" role="tabpanel" aria-labelledby="detail-code-tab">
          <button id="addDetailCode" class="btn btn-outline-primary ezen-btn my-2" style="float: right">코드 추가</button>
          <div id="detailGrid"></div>
        </div>
        <!-- 하위코드 리스트 -->

        <!-- 코드 상세 정보 -->
        <div class="tab-pane fade" id="code-info" role="tabpanel" aria-labelledby="code-info-tab">
          <form id="codeDataForm">
            <table class="table mt-3">
              <colgroup>
                <col width="100px" />
                <col />
              </colgroup>
              <thead></thead>
              <!-- 코드 상세 설명 -->
              <tbody>
                <tr>
                  <th scope="row"><label for="codeId">코드 ID</label></th>
                  <td><input type="text" id="codeId" name="codeId" class="form-control ezen-input-text w-150" data-vaildate-for="saveBtn" /></td>
                </tr>

                <tr>
                  <th scope="row"><label for="codeNm">코드명</label></th>
                  <td><input type="text" id="codeNm" name="codeNm" class="form-control ezen-input-text w-250" data-vaildate-for="saveBtn" /></td>
                </tr>

                <tr>
                  <th scope="row"><label for="codeDesc">코드설명</label></th>
                  <td>
                    <div class="form-floating">
                      <textarea class="form-control ezen-input-text" id="codeDesc" name="codeDesc" rows="2" style="resize: none"></textarea>
                    </div>
                  </td>
                </tr>

                <tr>
                  <th scope="row">
                    <label for="isEnabled">사용여부</label>
                  </th>
                  <td>
                    <ezen-select name="isEnabled" id="isEnabled">
                      <option value="1">사용</option>
                      <option value="0">미사용</option>
                    </ezen-select>
                  </td>
                </tr>
              </tbody>
              <!-- 코드 상세 설명 -->
            </table>
          </form>
        </div>
        <!-- 코드 상세 정보 -->
      </div>
      <!--  -->
    </div>
  </div>
</div>
