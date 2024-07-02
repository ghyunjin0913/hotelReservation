<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>리뷰 페이지</title>
</head>
<body>
    <% if (request.getAttribute("check") != null) { %>
        <c:if test="${check eq 'N'}">
            <script>
                alert('이미 신고한 댓글입니다.');
            </script>
        </c:if>
    <% } %>
    <c:forEach var="review" items="${reviewList}">
        <div class="review-container">
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
            <p>${review.rcomment}</p>        
	        <form action="/projects/cReportCheck" method="POST">
	        	<input type="hidden" name="tcode" value="${tcode}">
	        	<div>
	          	  	<button class="report-btn" type="submit" name="rid" value="${review.rid}">
	            	    <img src="images/review/siren.png"> 신고
	            	</button>
	        	</div>
	        </form>
        </div>
    </c:forEach>  
</body>
</html>
