<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 신고 처리</title>
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            box-sizing: border-box;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 20px;
            background-color: #f9f9f9;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: inline-block;
            width: 100px;
        }
        .form-group input, .form-group textarea {
            width: calc(100% - 120px);
            padding: 5px;
        }
        .form-actions {
            text-align: right;
            margin-top: 20px;
        }
        .form-actions button {
            padding: 10px 20px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <script type="text/javascript">
        function confirmSubmission() {
            return confirm("처리를 완료하시겠습니까?");
        }
    </script>

 <form action="/projects/reviewDelete" method="POST">
    <div class="container">
        <h2>리뷰 신고 처리</h2>
        <div class="form-group">
            <label for="commentNumber">댓글번호</label>
            <input type="text" id="commentNumber" name="rid" value="${rp.rid}" readonly>
        </div>
        <div class="form-group">
            <label for="author">작성자</label>
            <input type="text" id="author" name="author" value="${rp.cid}" readonly>
        </div>
        <div class="form-group">
            <label for="content">댓글내역</label>
            <input type="text" id="content" name="rcomment" value="${rp.rcomment}" readonly>
        </div>
        <div class="form-actions">
	        <c:if test="${rp.display eq 'N'}">
	      	<% if (request.getAttribute("deleteBtn") != null) { %>
	    		<c:choose>
	        		<c:when test="${deleteBtn eq 'S'}">
	        		    <button type="submit" disabled>처리완료</button>
	        		</c:when>
	        		<c:otherwise>
	            		<button type="submit">댓글삭제</button>
	        		</c:otherwise>
	    		</c:choose>
			<% } else { %>
	    			<button type="submit">댓글삭제</button>
			<% } %>
			</c:if>
			<c:if test="${rp.display eq 'Y'}">
				    <button type="submit" disabled>처리완료</button>
			</c:if>
        </div>
    </div>
</form>

<form action="/projects/reviewAnswer" method="POST" onsubmit="return confirmSubmission()">
    <div class="container2">
        <div class="form-group">
            <label for="reporterType">신고자분류</label>
            <input type="hidden" name="rid" value="${rm.rid}" />
            <input type="text" id="reporterType" name="type" value="${rm.type}" readonly>
        </div>
        <div class="form-group">
            <label for="reporter">신고자</label>
            <input type="text" id="reporter" name="id" value="${rm.id}" readonly>
        </div>
        <div class="form-group">
            <label for="response">처리 답변</label>
            <textarea id="response" name="status"  rows="3" required>${rm.status}</textarea>
        </div>
        <div class="form-actions">
            <button type="submit">답변처리</button>
            <button type="button" onclick="history.back()">창닫기</button>
        </div>
    </div>
</form>
</body>
</html>