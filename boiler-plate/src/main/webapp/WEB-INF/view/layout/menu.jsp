<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- menu css -->
<link rel="stylesheet" href="/resources/css/ezen/layout/menu.css" />
<!-- menu css -->

<!-- menu content -->
<!-- offcanvas의 class에 show를 붙이면 보인다. -->
<div
  class="offcanvas offcanvas-start ezen-menu-wrap"
  data-bs-scroll="true"
  data-bs-backdrop="false"
  tabindex="-1"
  id="offcanvasScrolling"
  aria-labelledby="offcanvasScrollingLabel"
>
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasScrollingLabel"></h5>
    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
  </div>
  <div class="offcanvas-body">
    <ul class="list-unstyled ps-0">
      <!-- 여기서 부터 db의 메뉴를 읽어와서 반복문 실행 -->
      <li class="mb-1">
        <button
          type="button"
          class="btn btn-toggle align-items-center justify-content-between rounded collapsed fw-normal"
          data-bs-toggle="collapse"
          data-bs-target="#home-collapse"
        >
          기준정보관리
        </button>
        <!-- 소메뉴 -->
        <div class="collapse" id="home-collapse">
          <ul class="btn-toggle-nav list-unstyled pb-1 move-page-link-wrap">
            <li data-page-link="mes/commonCode/CommonCode" data-page-no="1">
              <a href="#" class="link-dark"><span>공통관리</span></a>
            </li>
            <li data-page-link="">
              <a href="#" class="link-dark"><span>자재정보</span></a>
            </li>
            <li data-page-link="">
              <a href="#" class="link-dark"><span>공정정보</span></a>
            </li>
          </ul>
        </div>
        <!-- 소메뉴 -->
      </li>
      <!-- 여기까지 db의 메뉴를 읽어와서 반복문 실행 -->
    </ul>
  </div>
</div>
<!-- menu content -->

<!-- menu js -->
<script src="/resources/js/ezen/layout/menu.js" defer></script>
<!-- menu js -->
