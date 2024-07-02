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
@media screen and (max-width: 600px) {
  table {
    width: 100%;
  }
  th, td {
    padding: 6px;
  }
  input[type="button"] {
    padding: 8px 16px;
    font-size: 14px;
  }
}
</style>
</head>
<body>
<%@ include file="../manage/adminMain.jsp" %>
	<table>
		<thead>
		<tr>
			<th>id</th>
			<th>이름</th>
			<th>예약건수</th>
			<th>등급</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="cList" items="${countList}">
			<tr>
				<td>${cList.cid}</td>
				<td>${cList.cname}</td>
				<td>${cList.cnt}</td>
				<td>${cList.rname}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" value="업데이트" onclick="location.href='/projects/updateRank'">
	<input type="button" value="확인" onclick="location.href='/projects/admin'">
</body>
</html>