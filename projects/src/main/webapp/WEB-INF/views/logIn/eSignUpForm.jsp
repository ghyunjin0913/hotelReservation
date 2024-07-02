<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
		<!-- 합쳐지고 최소화된 최신 CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
		<!-- 부가적인 테마 -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	 	
	 	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
	<title>회원가입</title>
		<script type="text/javascript">
		$(document).ready(function(){
			
			// 취소
			$(".cencle").on("click", function(){
				location.href = "/projects/logIn";
			})
			
			$("#submit").on("click", function(){
				if($("#eid").val()==""){
					alert("아이디를 입력해주세요.");
					$("eid").focus();
					return false;
				}
				if($("#epw").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#epw").focus();
					return false;
				}
				if($("#ename").val()==""){
					alert("성명을 입력해주세요.");
					$("#ename").focus();
					return false;
				}
				if($("#email").val()==""){
					alert("이메일을 입력해주세요.");
					$("#email").focus();
					return false;
				}
				if($("#ephone").val()==""){
					alert("전화번호를 입력해주세요.");
					$("#ephone").focus();
					return false;
				}
				var idChkVal = $("#eidCheck").val();
				if(idChkVal == "N"){
					alert("중복확인 버튼을 눌러주세요.");
				}else if(idChkVal == "Y"){
					$("#regForm").submit();
				}
			});
		})
		
		function fn_eidCheck() {
    // 입력된 아이디 가져오기
    var eid = document.getElementById('eid').value;

    // AJAX를 이용한 요청 보내기
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/projects/eidCheck', true); // 중복 체크를 처리하는 컨트롤러 엔드포인트로 설정
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                // 요청 성공시 처리할 작업
                var response = xhr.responseText;
                if (response === 'duplicate') {
                    // 중복된 아이디인 경우
                    
                    alert('이미 사용 중인 아이디입니다.');
                } else {
                    // 중복되지 않은 아이디인 경우
                    $('#eidCheck').attr("value", "Y");
                    alert('사용 가능한 아이디입니다.');
                }
            } else {
                // 요청 실패시 처리할 작업
                alert('요청에 실패했습니다.');
            }
        }
    };
    xhr.send('eid=' + encodeURIComponent(eid));
}
		function autoHyphen(input) {
		    // 숫자만 남기고 모든 문자 제거
		    var phoneNumber = input.value.replace(/[^\d]/g, "");

		    // 전화번호 형식에 맞게 하이푼 추가
		    if (phoneNumber.length >= 4 && phoneNumber.length <= 7) {
		        input.value = phoneNumber.slice(0, 3) + "-" + phoneNumber.slice(3);
		    } else if (phoneNumber.length >= 8) {
		        input.value = phoneNumber.slice(0, 3) + "-" + phoneNumber.slice(3, 7) + "-" + phoneNumber.slice(7);
		    }
		}
	</script>
</head>
<body>
 <%@ include file="../main/header.jsp" %>
	<section id="container">
		<form action="/projects/eSignUpCtrl" method="POST" id="regForm">
			<div class="form-group has-feedback">
				<label class="control-label" for="eid">사원번호</label>
				<input class="form-control" type="text" id="eid" name="eid"/>
				<button class="eidCheck" type="button" id="eidCheck" onclick="fn_eidCheck();" value="N">중복확인</button>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="epw">비밀번호</label>
				<input class="form-control" type="password" id="epw" name="epw"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="ename">이름</label>
				<input class="form-control" type="text" id="ename" name="ename"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="email">이메일</label>
				<input class="form-control" type="text" id="email" name="email"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="ephone">전화번호</label>
				<input class="form-control" type="text" id="ephone" name="ephone" oninput="autoHyphen(this)"/>
			</div>
		</form>
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="button" id="submit">회원가입</button>
				<button class="cencle btn btn-danger" type="button" id="submit">취소</button>
			</div>
	</section>
</body>
</html>