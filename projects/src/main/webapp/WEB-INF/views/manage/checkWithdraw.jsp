<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

th {
  background-color: #f2f2f2;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

input[type="button"] {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

input[type="button"]:hover {
  background-color: #45a049;
}

</style>
</head>
<body>
<%@ include file="../manage/adminMain.jsp" %>
	<table>
		<thead>
		<tr>
			<th>id</th>
			<th>탈퇴 예정 일자</th>
			<th>탈퇴 사유</th>
			<th>상태</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="wList" items="${wList}">
			<td>${wList.cid}</td>
			<td>${wList.expDate}</td>
			<td>${wList.reason}</td>
			<td>${wList.status}</td>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" value="업데이트" onclick="location.href='/projects/updateWithdraw'">
	<input type="button" value="확인" onclick="location.href='/projects/admin'">
</body>
</html>