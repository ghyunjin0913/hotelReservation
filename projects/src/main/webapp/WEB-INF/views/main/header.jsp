<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>HEADER</title>
    <style type="text/css">
        body {
            margin: 0;
            background: white;
            font: 600 16px/18px 'Open Sans', sans-serif;
        }
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: /* #f1f3f5; */#dcedc8;
      
            padding: 10px 20px;
        }
        .navbar .nav-left {
            display: flex;
            align-items: center;
        }
        .navbar .nav-left a {
            margin: 0 20px 0 0;
            font-size: 22px;
            display: flex;
            align-items: center;
        }
        .navbar .nav-right {
            display: flex;
            align-items: center;
            
        }
        .navbar .nav-right a {
            margin: 0 10px;
            font-size: 22px;
            display: flex;
            align-items: center;
        }
        .navbar a {
            text-decoration: none;
               color: #424242;
        }
        .navbar a:hover {
            text-decoration: underline;
        }
        .nav-left img, .nav-right img {
            width: 40px;
            height: 40px;
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <div class="navbar">
        <div class="nav-left">
            <a href="/projects/homePage">
                <img src="images/mainicon/home.png">&nbsp;홈으로</a>
            <a href="/projects/searchHotelPage">
                <img src="images/mainicon/hotel.png">&nbsp;&nbsp;호텔</a>
        </div>
        <div class="nav-right">
            <c:choose>
                <c:when test="${not empty sessionScope.id}">
                    <a href="/projects/myPage">
                        <img src="images/mainicon/my.png">&nbsp;마이페이지</a>
                    <a href="<c:url value='/logOut' />" class="logout-link">
                        <img src="images/mainicon/logout.png">&nbsp;로그아웃</a>
                </c:when>
                <c:otherwise>
                    <a href="/projects/logIn"><img src="images/mainicon/login.png">&nbsp;&nbsp;로그인</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</body>
</html>
