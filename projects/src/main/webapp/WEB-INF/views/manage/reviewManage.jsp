<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
 	<%@ include file="../manage/adminMain.jsp" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
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
 		.search-bar {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #000; /* Adds a border around the search bar */
            border-radius: 5px; /* Optional: rounds the corners */
            background-color: #f9f9f9; /* Optional: adds a background color */
        }
        .search-bar > div, .search-bar input[type="submit"] {
            margin-right: 10px;
        }
        .search-keyword {
            display: flex;
            align-items: center;
        }
        .search-keyword label {
            margin-right: 5px;
        }
        .status-complete {
            background-color: #f2f2f2;
        }
        .cancel-button {
            background-color: #888;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
    </style>
  <script type="text/javascript">
        function setAnswerValue() {
            var checkbox = document.getElementById("confirmAnswer");
            var hiddenInput = document.getElementById("answer");
            
            if (checkbox.checked) {
                hiddenInput.value = "N";
            } else {
                hiddenInput.value = "Y";
            }
        }
        
        function toggleSelectBox() {
            var selectBox = document.getElementById("memberTypeSelect");
            var radioButton = document.querySelector('input[name="search"]:checked');
            
            if (radioButton && radioButton.value === "1") {
                selectBox.style.display = "block";
                selectBox.querySelector('select').setAttribute('required', 'required');
            } else {
                selectBox.style.display = "none";
                selectBox.querySelector('select').removeAttribute('required');
            }
        }
    </script>
</head>
<body>
    <div class="main-content">
        <h1>신고 댓글 내역</h1>
        <form action="/projects/mSearchReview" method="POST">
            <div class="search-bar">
                <div>
                    <input type="radio" name="search" value="1" onclick="toggleSelectBox()"> 
                    <label for="customerId">고객 아이디</label>
                    <input type="text" name="id">
                </div>
                <div id="memberTypeSelect" style="display:none;">
                    <select name="type">
                        <option value="">회원 분류</option>
                        <option value="C">고객</option>
                        <option value="H">업체</option>
                    </select>
                </div>
                <div>
                    <input type="radio" name="search" value="2" onclick="toggleSelectBox()">
                    <label for="reportNumber">신고번호</label>
                    <input type="text" name="rpno">
                </div>
                <div>
                    <input type="checkbox" id="confirmAnswer" name="ConfirmAnswer" onclick="setAnswerValue()">미답변
                    <input type="hidden" id="answer" name="answer" value="Y">
                </div>
                <input type="submit" value="검색">
            </div>
		    </form>
		    <form action="/projects/reviewManage" method="post">
		    <table>
		 	<thead>
		            <tr>
		                <th>신고댓글번호</th>
		                <th>고객분류</th>
		                <th>신고아이디</th>
		                <th>답변내역</th>
		                <th>신고 날짜</th>
		               	<th>신고 사유</th>
		               	<th>답변 상태</th>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach var="report" items="${reports}">
						<tr>
							<td>${report.rpno}</td>
		               		<td>${report.type}</td>
		               	 	<td>${report.id}</td>
					 		<td>${report.status}</td>
					 		<td>${report.rpdate}</td>
					 		<td>${report.reason}</td>
					 		<td>${report.answer}</td>
					
					 		<td>
					 			<c:if test="${report.answer eq 'N'}">
					 				 <input type="hidden" name="rid" value="${report.rid}">
					 				 <input type="hidden" name="status" value="${report.status}">
					 				 <input type="hidden" name="type" value="${report.type}">
					 				 <input type="hidden" name="id" value="${report.id}">
					 				      
					 				<button type="submit">댓글 관리</button>
					 			</c:if>
					 			<c:if test="${report.answer eq 'Y'}">
					 				<button  disabled>처리완료</button>
					 			</c:if>
					 		</td>
						</tr>
					</c:forEach>		
		        </tbody>    
		    </table>
		    </form>
	     </div>
</body>
</html>