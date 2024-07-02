<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
	<link href="<%= request.getContextPath() %>/css/goods/gDetails.css" rel="stylesheet" type="text/css" />
	<style type="text/css">
		body {
	    	font-family: Arial, sans-serif;
		}
		.form-container .form-buttons {
				    display: flex;
				    justify-content: center;
				    margin-top: 20px;
		}
		.find-btn {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-top: 20px;
        }
        .find-btn1 {
            margin: 0;
        }
	</style>
</head>
<body>
 <%@ include file="../main/side.jsp" %>
	<h1>리뷰조회</h1>
		<div class="review-container">
			<input type="hidden" id="rid" name="rid" value="${review.rid}">
			<p>작성자: ${review.cname}</p>
			<p>작성일: ${review.rdate}</p>
			<div class="rating">
				<c:forEach var="i" begin="1" end="5">
					<c:choose>
					    <c:when test="${i <= review.rating}">
					        <span class="star">&#9733;</span>
					    </c:when>
						<c:otherwise>
							<span class="star grey">&#9734;</span>
					 	</c:otherwise>
					</c:choose>
				</c:forEach>
			</div>
			<p>후기: ${review.rcomment}</p>
		</div>
		<div class="find-btn">
			<input type="button" value="취소" onclick="history.back();">
	        <button id="updateButton" onclick="location.href='/projects/rUpdatePage?rid=${review.rid}'" class="btn btn-navy navbar-btn find-btn1">수정</button>
		    <form action="/projects/rDelete" method="post">
	        	<input type="hidden" id="rid" name="rid" value="${review.rid}">
	            <button type="submit" id="btn_submit" name="btn_submit" class="btn btn-grey navbar-btn find-btn1" onclick="self.close(); alert('삭제되었습니다')">삭제</button>
	        </form>
		</div>
</body>
</html>