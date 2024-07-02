<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
 src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- 부트스트랩 3.4.1버전을 적용하기 위한 링크태그와 스크립트 태그 -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
<!-- favicon.co를 없애는 링크태그 -->
<script
 src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- jquery를 사용하기 위해 적용해둔 스크립트 코드 -->
<link href="/resources/css/main.css" rel="stylesheet">

<style type="text/css">
#gnb{
	height: 50px;
	background-color: #b4b4b4;
}

#gnb p, .nav p{
	font-size: 3em;
	margin-left: 600px;
}
#nav1 {
  background-color: #333; /* 배경색 지정 */
  padding: 10px; /* 안쪽 여백 지정 */
}

/* 각 메뉴 항목의 스타일링 */
#nav1 ul {
  list-style-type: none; /* 리스트 마커 제거 */
  padding: 0; /* 리스트 안쪽 여백 제거 */
  margin: 0; /* 리스트 바깥 여백 제거 */
}

#nav1 li {
  display: inline; /* 항목들을 가로로 배치 */
  margin-right: 10px; /* 각 항목 사이 간격 조절 */
}

#nav1 a {
  text-decoration: none; /* 링크 밑줄 제거 */
  color: #fff; /* 링크 색상 지정 */
  padding: 5px 10px; /* 링크 안쪽 여백 지정 */
  border-radius: 5px; /* 링크 모서리를 둥글게 만듦 */
  background-color: #666; /* 링크 배경색 지정 */
}

#nav1 a:hover {
  background-color: #999; /* 호버 시 배경색 변경 */
}

</style>
</head>
<body>
  <%@ include file="../main/side.jsp" %>
	<div id="gnb">
		<div  class="text-right" >
				<c:if test="${ename != null}"> <!-- /* 로그인이 되어있으면 userid+환영합니다 / 마이페이지 / 로그아웃 버튼을 띄운다 */ -->
					<span class="glyphicon glyphicon-heart-empty" style="color: white;" aria-hidden="true"></span>
					<span id="login_log" style="border-bottom: 1px solid white;">${ename} 님, 환영합니다.</span>
					<span class="glyphicon glyphicon-heart-empty" style="color: white;" aria-hidden="true"></span>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button onclick="location.href='/projects/myInfoCtrl'">마이페이지</button>
					<button onclick="location.href='/projects/logOut'">로그아웃</button>
				</c:if>
				
		</div>
	</div>
<nav id="nav1">
    <ul>
      <li><a href="/projects/rankList">회원 등급 관리</a></li>
      <li><a href="/projects/empList">사원 정보 관리</a></li>
      <li><a href="/projects/withdrawList">탈퇴 회원 관리</a></li>
      <li><a href="/projects/hotelList">업체 정보 관리</a></li>
      <li><a href="/projects/typeList">객실 정보 관리</a></li>
      <li><a href="/projects/reviewManagePage">댓글 신고 관리</a></li>
    </ul>
  </nav>
  
</body>
</html>