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
				document.form3.action = "${path}/projects/updateHmyInfoCtrl";
				document.form3.submit();
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
	<form name="form3" method="POST">
    <table class="info-table">
        <thead>
            <tr>
                <th colspan="2"><h1>업체 정보 조회 정보</h1></th>
            </tr>
        </thead>
        <tbody>
        	<tr>
				<td>아이디</td>
				<td><input name="hid" value="${hMyInfo.hid}" readonly="readonly"></td>
            </tr>
            <tr>
				<td>업체명</td>
				<td><input name="hname" value="${hMyInfo.hname}" readonly="readonly"></td>
            </tr>
            <tr>
				<td>등급</td>
				<td><input name="grade" value="${hMyInfo.grade}" readonly="readonly"></td>
            </tr>
            <tr>
 				<td class="required">위치 <span style="color: red;">*</span></td>
				<td><input name="hotellocation" value="${hMyInfo.location}"></td>
            </tr>
            <tr>
      			<td class="required">이메일 <span style="color: red;">*</span></td>
				<td><input name="hmail" value="${hMyInfo.hmail}"></td>
            </tr>
            <tr>
				<td class="required">전화번호 <span style="color: red;">*</span></td>
				<td><input name="hphone" value="${hMyInfo.hphone}"></td>
            </tr>
        </tbody>
    </table>
    	<div class="button">
    			<input type="button" value="수정" id="btnUpdate">
				<input type="button" value="확인" onclick="location.href='/projects/success'">
				<input type="button" value="회원 탈퇴" onclick="location.href='/projects/#'">
		</div>
	</form>
</body>
</html>