<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
  <!-- head -->
  <!-- meta 속성, title, 필수 css, js 등을 정의한다. -->
  <c:import url="/WEB-INF/view/layout/head.jsp" charEncoding="UTF-8"></c:import>

  <!-- login css -->
  <link rel="stylesheet" href="/resources/css/ezen/login/login.css" />
  <!-- login js -->
  <script type="module" src="/resources/js/ezen/login/app.js" defer></script>
  <body>
    <div class="login-page">
      <div class="login-wrap">
        <div class="login-box">
          <!-- 이젠솔루션 login logo -->
          <div class="login-box-img"></div>

          <!-- login Form -->
          <div class="login-box-form">
            <form id="loginForm">
              <!-- 회사 로고 -->
              <div class="logo-img mb-5">
                <img src="/resources/images/logo/adwinner_login_logo.png" alt="" />
              </div>

              <!-- 아이디 입력칸 -->
              <div class="input-group mb-3">
                <span class="input-group-text">
                  <img src="/resources/images/icon/ic_login.png" alt="" />
                </span>
                <div class="form-floating">
                  <input type="text" name="userId" class="form-control" placeholder="아이디" data-vaildate-for="loginBtn" />
                  <label for="userId">아이디</label>
                </div>
              </div>

              <!-- 비밀번호 입력칸 -->
              <div class="input-group mb-3">
                <span class="input-group-text">
                  <img src="/resources/images/icon/ic_pw.png" alt="" />
                </span>
                <div class="form-floating">
                  <input type="password" name="password" class="form-control" placeholder="비밀번호" data-vaildate-for="loginBtn" />
                  <label for="password">비밀번호</label>
                </div>
              </div>

              <!-- 아이디 저장 체크박스 -->
              <div class="form-check mb-3">
                <input type="checkbox" class="form-check-input" id="isSaveId" />
                <label for="isSaveId" class="form-check-label">아이디 저장</label>
              </div>

              <!-- 로그인 버튼 -->
              <div class="d-grid gap-2">
                <button id="loginBtn" class="btn btn-primary btn-login" type="button">로그인</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
