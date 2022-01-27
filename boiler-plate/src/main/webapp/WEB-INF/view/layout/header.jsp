<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<header class="ezen-header">
  <button class="btn ezen-toggle-menu" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasScrolling">
    <img src="/resources/images/icon/ico_toggle.png" alt="" />
  </button>
  <div class="ezen-user">
    <span class="btn ezen-user-info">
      <img src="/resources/images/icon/ico_user.png" alt="" />
      <b>(${sessionScope.user.userId})${sessionScope.user.userId}</b>
    </span>
    <span>|</span>
    <span class="btn ezen-user-info">
      <img src="/resources/images/icon/ico_logout.png" alt="" />
      <a href="/logout">로그아웃</a>
    </span>
  </div>
</header>
