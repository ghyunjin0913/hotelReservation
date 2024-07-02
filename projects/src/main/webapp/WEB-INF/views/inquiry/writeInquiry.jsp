<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#sub").on("click", function(){
			if($("#title").val()==""){
				alert("제목을 입력해주세요");
				$("#title").focus();
				return false;
			}
			if($("#contents").val()==""){
				alert("문의 내용을 입력해주세요");
				$("#contents").focus();
				return false;
			}
		});
	})
</script>
<style type="text/css">
 /* 게시판 폼 스타일 */
    .board-form {
        border: 1px solid #ccc;
        padding: 20px;
        width: 400px;
        margin: 0 auto;
    }
    .board-form label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
    }
    .board-form input[type="text"],
    .board-form select {
        width: calc(100% - 20px); /* 너비 조정 */
        padding: 5px;
        margin-bottom: 10px;
    }
    .board-form textarea {
        width: calc(100% - 20px); /* 너비 조정 */
        height: 150px; /* 높이 조정 */
        padding: 5px;
        margin-bottom: 10px;
    }
    .board-form .button {
        background-color: #007bff;
        color: #fff;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
    }
</style>
</head>
<body>
  <%@ include file="../main/side.jsp" %>
	<form action="/projects/writeBoardCtrl" method="post" class="board-form">
    <label for="title">제목</label>
    <input type="text" class="form-control" id="title" name="title">
    <label for="id">작성자</label>
    <input type="text" class="form-control" id="id" name="id" value="${id}" readonly="readonly">
    <label for="category">구분</label>
    <select id="category" name="idtype">
        <option value="고객" selected="selected">고객</option>
        <option value="업체">업체</option>
    </select>
    <label for="contents">문의내용</label>
    <textarea class="form-control" id="contents" name="contents"></textarea>
    <input type="submit" value="등록하기" class="button" id="sub">
    <input type="button" class="button" value="취소" onclick="location.href='/projects/requestInquiry'">
</form>
</body>
</html>