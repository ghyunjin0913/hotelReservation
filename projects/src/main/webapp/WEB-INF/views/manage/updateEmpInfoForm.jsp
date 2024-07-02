<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		alert("사원 정보 수정 완료");
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
            background-color: #333;
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
            background-color: #333;
            color: white;
            border: none;
            cursor: pointer;
  
        }
    </style>
</head>
<body>
	<h2>사원 수정</h2>
	<form name="form4" method="POST">
		<table class="info-table">
        <thead>
            <tr>
                <th colspan="2"><h1>사원 수정</h1></th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>이메일</td>
				<td><input name="email" value="${empInfo.email}" readonly="readonly"></td>
            </tr>
            <tr>
                <td class="required">부서번호 <span style="color: red;">*</span></td>
				<td><input name="dno" value="${empInfo.dno}"></td>
            </tr>
            <tr>
                <td class="required">직급 <span style="color: red;">*</span></td>
            	<td><input name="position" value="${empInfo.position}"></td>
            </tr>
            <tr>
                <td class="required">재직상태 <span style="color: red;">*</span></td>
			<td><input name="status" value="${empInfo.status}"></td>
            </tr>
            <tr>
                <td>입사일</td>
			<td><input name="joinDate" value="${empInfo.joinDate}" readonly="readonly"></td>
            </tr>
            <tr>
                <td class="required">퇴사일 <span style="color: red;">*</span></td>
			<td><input name="retireDate" value="${empInfo.retireDate}"></td>
            </tr>
        </tbody>
    </table>
    <div class="button">
    			<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="확인" onclick="location.href='/projects/empList'">
	</div>
	</form>
</body>
</html>