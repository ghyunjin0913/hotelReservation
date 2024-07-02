<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	호텔명: ${msg}
	<button type="button" onclick="location.href='/projects/logOut'">로그아웃</button>
	<button type="button" onclick="location.href='/projects/hMyInfoCtrl'">내 정보 조회</button>
</body>
</html>