<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사이드바</title>
      <link rel="stylesheet" href="css/main/side.css" /> 
</head>
<body>
	<%@ include file="../main/header.jsp" %>
    <div id="sidebar-wrapper" style="position: fixed; z-index: 10;">
        <ul class="sidebar-nav">
            <li class="sidebar-brand border-bottom">
                <a href="${pageContext.request.contextPath}/myInfoCtrl" style="font-size: 25px; font-weight: 900 !important;">MENU</a>
            </li>
            <c:choose>
                <c:when test="${not empty sessionScope.id}">
                    <li class="nav-menu">
                        <a href="${pageContext.request.contextPath}/myInfoCtrl">내정보조회</a>
                    </li>
                    <c:if test="${not empty sessionScope.cid}">
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/myBook">나의 예약</a>
                        </li>
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/myWishPage">찜 목록</a>
                        </li>
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/reviewListPage">리뷰작성</a>
                        </li>
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/myReport?type=C">리뷰신고내역</a>
                        </li>
                          <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/requestInquiry">문의</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.hid}">
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/hotelBook">고객예약</a>
                        </li>
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/gRegisterPage">객실 등록</a>
                        </li>
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/rooms">객실 관리</a>
                        </li>
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/hotelBook">예약내역조회</a>
                        </li>
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/hReviewList">리뷰내역조회</a>
                        </li>
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/myReport?type=H">리뷰신고내역</a>
                        </li>
                    </c:if>
                    <c:if test="${not empty sessionScope.eid}">
                        <li class="nav-menu">
                            <a href="${pageContext.request.contextPath}/admin">관리자모드</a>
                        </li>
                    </c:if>
                </c:when>
            </c:choose>
        </ul>
    </div>
    <div class="sidebar-toggle" onclick="toggleSidebar()"></div>

    <script>
        function toggleSidebar() {
            const sidebar = document.getElementById('sidebar-wrapper');
            const adminBox = document.querySelector('.admin-box');
            if (sidebar.style.marginRight === '-250px') {
                sidebar.style.marginRight = '0';
                if (adminBox) adminBox.style.marginRight = '250px';
            } else {
                sidebar.style.marginRight = '-250px';
                if (adminBox) adminBox.style.marginRight = '0';
            }
        }
    </script>
</body>
</html>

