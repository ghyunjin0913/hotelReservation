<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnUpdate").click(function(){
			document.form2.action = "${path}/projects/updateEmyInfoCtrl";
			document.form2.submit();
			alert("회원정보 수정 완료");
		});
	});
</script>
<style>
        body {
            font-family: Arial, sans-serif;
        }
        .info-table {
            width: 350px;
            border-collapse: collapse;
            margin: 60px auto;
        }
        .info-table th, .info-table td {
            border: 1px solid #ccc;
            padding: 12px 15px;
            text-align: left;
            height: 30px;
        }
        .info-table th {
            background-color: #74D19D;
            color: white;
        }
        .info-table td {
            background-color: #f9f9f9;
        }
        .info-table td.required {
            color: black;
        }
        .info-table td:first-child {
            width: 150px;
        }
        .button {
        	text-align: center;
            margin: 0 10px;
            padding: 10px 20px;
            background-color: #74D19D;
            color: white;
            border: none;
            cursor: pointer;
  
        }
    </style>
</head>
<body>
  <%@ include file="../main/side.jsp" %>
	<h2>내 정보 조회</h2>
	<form name="form2" method="POST">
		<table class="info-table">
        <thead>
            <tr>
                <th colspan="2"><h1>나의 정보</h1></th>
            </tr>
        </thead>
        <tbody>
        	<tr>
                <td>아이디</td>
				<td><input name="eid" value="${eMyInfo.eid}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>이름</td>
				<td><input name="ename" value="${eMyInfo.ename}" readonly="readonly"></td>
            </tr>
            <tr>
                <td class="required">이메일 <span style="color: red;">*</span></td>
				<td><input name="email" value="${eMyInfo.email}"></td>
            </tr>
            <tr>
                <td class="required">전화번호 <span style="color: red;">*</span></td>
				<td><input name="ephone" value="${eMyInfo.ephone}"></td>
            </tr>
            <tr>
                <td>부서번호</td>
				<td><input name="dno" value="${eMyInfo.dno}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>직급</td>
            	<td><input name="position" value="${eMyInfo.position}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>재직상태</td>
			<td><input name="status" value="${eMyInfo.status}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>입사일</td>
			<td><input name="joinDate" value="${eMyInfo.joinDate}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>퇴사일</td>
			<td><input name="retireDate" value="${eMyInfo.retireDate}" readonly="readonly"></td>
            </tr>
        </tbody>
    </table>
    <div class="button">
    			<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="확인" onclick="location.href='/projects/success'">
	</div>
	</form>
</body>
</html>