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
		.container {
		            display: flex;
		            min-height: 100vh;
		}
		.side-panel {
		            width: 250px; /* Adjust the width as needed */
		            background-color: #f4f4f4; /* Background color for visibility */
		}
		.main-content {
		            flex: 1;
		            padding: 20px;
		}
		.form-container .form-buttons {
				    display: flex;
				    justify-content: center;
				    margin-top: 20px;
		}
		.form-container input[type="submit"],
		.form-container input[type="button"] {
					margin-right: 10px;
				    padding: 10px;
				    width: 50px;
		}
		 .report-btn, .report-done-btn {
           	background-color: transparent;
  			border: 2px solid #fff;
  			color: black;
       		height: 40px;
        	width:  75px;       
        }
        .report-btn:hover, .report-done-btn:hover {
  	 		background-color: #fff;
 	 		color: #000;
        }
        .report-btn > img, .report-done-btn > img {
        	width: 40px;
        	height: 40px;
        }
	</style>
</head>
<body>
<%@ include file="../main/side.jsp" %>
	<div class="main-content">
     <div class="form-container">
		<h1>리뷰조회</h1>
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
			<p>후기: ${review.rcomment}</p>
		</div>
		<form action="/projects/answerRegister" method="POST">
			<div class="review-container">
				<label for="hname">호텔명:</label>
				<input id="hname" name="hname" value="${hReview.hname}" readonly>
				<div class="full-width">
		        	<label for="answer">답변:</label>
		            <textarea class="star_box" placeholder="답변을 작성해주세요."
		                   id="answer" name="answer" required></textarea>
		        </div>
		        <input type="hidden" id="rid" name="rid" value="${review.rid}">
			</div>
			<div class="form-buttons">
                <input type="button" value="취소" onclick="history.back();">
       
                <input type="submit" value="등록">
                   </div>
           </form>
           <form action="/projects/hReport" method="post">
	           <c:if test="${check eq 'Y'}">   
					<button class="report-btn" type="submit" name="rid" value="${review.rid}">
					<img src="images/review/siren.png" >신고</button>
	             </c:if>
	             <c:if test="${check eq 'N'}">
					 <button class='report-done-btn' disabled>
					 <img src="images/review/siren.png" >신고완료</button>
				</c:if>
			</form>
		</div>
	</div>
</body>
</html>