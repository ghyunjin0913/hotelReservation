<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Payment Form</title>
 <style>
        body {
            font-family: Arial, sans-serif;
        }
        form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        label {
            display: block;
            margin-top: 10px;
        }
        input[type="text"],
        select,
        textarea {
            width: calc(100% - 20px);
            padding: 8px 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="text"].highlight {
            background-color: #e6f7ff;
        }
        textarea {
            height: 60px;
            resize: none;
        }
        button {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>

</head>

<body>
 	 <%@ include file="../main/header.jsp" %>
    <form action="/projects/payInfo" method="POST" >
    
       	<c:if test="${result eq 'Fail'}">
        	<script type="text/javascript">
			alert('결제에 실패하였습니다. 다시 시도해주십시오.');
			</script>
        </c:if>
    
        <p>[결제 가능] VISA Master American Express</p>

        <label for="cardco">결제 방법 선택</label><br>
        <select id="cardco" name="cardco" required>
            <option value="">카드 선택</option>
            <option value="VISA">VISA</option>
            <option value="MASTER">Master</option>
            <option value="AMEX">American Express</option>
        </select><br><br>

        <label for="cardno">카드 번호</label><br>
        <input type="text" id="cardno" name="cardno" required><br><br>

        <label for="expiredate">카드 만료일</label>
        <input type="month" id="expiredate" name="expiredate" required style="width: 100px;">
          
        <label for="cvc" style="margin-left: 1px;">CVC 번호</label><br>
     	<input type="text" id="cvcno" name="cvcno" required style="width: 50px; margin-left: 1px;"><br><br>

        <label for="tprice">결제 총 금액</label>
        <input type="text" id="tprice" name="tprice" value="${tprice}" readonly>원<br><br>

        <button type="submit" id="confirm" name="confirm" value="complete">결제완료</button>
    </form>
</body>
</html>
