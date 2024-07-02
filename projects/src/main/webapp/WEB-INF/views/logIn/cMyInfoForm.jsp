<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>나의 정보</title>
    <script type="text/javascript">
		$(document).ready(function(){
			$("#btnUpdate").click(function(){
				document.form1.action = "${path}/projects/updateCmyInfoCtrl";
				document.form1.submit();
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
	<form name="form1" method="POST">
    <table class="info-table">
        <thead>
            <tr>
                <th colspan="2"><h1>나의 정보</h1></th>
            </tr>
        </thead>
        <tbody>
        	<tr>
                <td>아이디</td>
				<td><input name="cid" value="${cMyInfo.cid}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>이름</td>
				<td><input name="cname" value="${cMyInfo.cname}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>영문 이름</td>
				<td><input name="firstname" value="${cMyInfo.firstname}" readonly="readonly"></td>
            </tr>
            <tr>
                <td>영문 성</td>
				<td><input name="lastname" value="${cMyInfo.lastname}" readonly="readonly"></td>
            </tr>
            <tr>
                <td class="required">이메일 <span style="color: red;">*</span></td>
            	<td><input name="cmail" id="cmail" value="${cMyInfo.cmail}"></td>
            </tr>
            <tr>
                <td class="required">전화번호 <span style="color: red;">*</span></td>
			<td><input name="cphone" id="cphone" value="${cMyInfo.cphone}"></td>
            </tr>
        </tbody>
    </table>
    <div class="button">
    			<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="확인" onclick="location.href='/projects/success'">
				<input type="button" value="회원 탈퇴" onclick="location.href='/projects/customerWithdraw'">
	</div>
	</form>
</body>
</html>
