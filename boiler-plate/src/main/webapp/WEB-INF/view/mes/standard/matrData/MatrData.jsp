<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- script -->
<script type="module" src="/resources/js/ezen/mes/standard/matrData/app.js" defer></script>

<!-- navigation -->
<menu-navigation parent="${sessionScope.menu.parentMenu}" child="${sessionScope.menu.childMenu}"></menu-navigation>
