<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnUpdate").click(function(){
			document.form4.action = "${path}/projects/updateEmpInfoCtrl";
			document.form4.submit();
			alert("사원 정보 변경 완료");
		});
	});
</script>
<style type="text/css">
table {
  border-collapse: collapse;
  width: 100%;
  overflow-x: auto;
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

/* Responsive layout - make the table scroll horizontally on small screens */
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
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화번호</th>
			<th>부서번호</th>
			<th>직급</th>
			<th>상태</th>
			<th>입사일</th>
			<th>퇴사일</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="eList" items="${eList}">
			<tr>
				<td><a href="/projects/updateEmpInfo?eid=${eList.eid}">${eList.eid}</a></td>
				<td>${eList.ename}</td>
				<td>${eList.email}</td>
				<td>${eList.ephone}</td>
				<td>${eList.dno}</td>
				<td>${eList.position}</td>
				<td>${eList.status}</td>
				<td>${eList.joinDate}</td>
				<td>${eList.retireDate}"</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<input type="button" value="확인" onclick="location.href='/projects/admin'">
</body>
</html>