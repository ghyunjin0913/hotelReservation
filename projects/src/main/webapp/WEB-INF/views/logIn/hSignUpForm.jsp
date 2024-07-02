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
				if($("#hid").val()==""){
					alert("아이디를 입력해주세요.");
					$("hid").focus();
					return false;
				}
				if($("#hpw").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#hpw").focus();
					return false;
				}
				if($("#hname").val()==""){
					alert("업체명을 입력해주세요.");
					$("#hname").focus();
					return false;
				}
				if($("#grade").val()==""){
					alert("등급을 입력해주세요.");
					$("#firstname").focus();
					return false;
				}
				if($("#location").val()==""){
					alert("위치를 입력해주세요.");
					$("#location").focus();
					return false;
				}
				if($("#hmail").val()==""){
					alert("이메일을 입력해주세요.");
					$("#hmail").focus();
					return false;
				}
				if($("#hphone").val()==""){
					alert("전화번호를 입력해주세요.");
					$("#hphone").focus();
					return false;
				}
				var idChkVal = $("#hidCheck").val();
				if(idChkVal == "N"){
					alert("중복확인 버튼을 눌러주세요.");
				}else if(idChkVal == "Y"){
					$("#regForm").submit();
				}
			});
		})
		
		function fn_hidCheck() {
    // 입력된 아이디 가져오기
    var hid = document.getElementById('hid').value;

    // AJAX를 이용한 요청 보내기
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/projects/hidCheck', true); // 중복 체크를 처리하는 컨트롤러 엔드포인트로 설정
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
                    $('#hidCheck').attr("value", "Y");
                    alert('사용 가능한 아이디입니다.');
                }
            } else {
                // 요청 실패시 처리할 작업
                alert('요청에 실패했습니다.');
            }
        }
    };
    xhr.send('hid=' + encodeURIComponent(hid));
}
		const autoHyphen = (target) => {
			 target.value = target.value
			   .replace(/[^0-9]/g, '')
			   .replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
			}
	</script>
</head>
<body>
 <%@ include file="../main/header.jsp" %>
	<section id="container">
		<form action="/projects/hSignUpCtrl" method="POST" id="regForm">
			<div class="form-group has-feedback">
				<label class="control-label" for="hid">아이디</label>
				<input class="form-control" type="text" id="hid" name="hid"/>
				<button class="hidCheck" type="button" id="hidCheck" onclick="fn_hidCheck();" value="N">중복확인</button>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="hpw">비밀번호</label>
				<input class="form-control" type="password" id="hpw" name="hpw"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="hname">업체명</label>
				<input class="form-control" type="text" id="hname" name="hname"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="grade">등급</label>
				<input class="form-control" type="text" id="grade" name="grade"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="location">위치</label>
				<input class="form-control" type="text" id="location" name="location"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="hmail">이메일</label>
				<input class="form-control" type="text" id="hmail" name="hmail"/>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label" for="hphone">전화번호</label>
				<input class="form-control" type="text" id="hphone" name="hphone" oninput="autoHyphen(this)" maxlength="13" autofocus/>
			</div>
		</form>
			<div class="form-group has-feedback">
				<button class="btn btn-success" type="button" id="submit">회원가입</button>
				<button class="cencle btn btn-danger" type="button" id="submit">취소</button>
			</div>
	</section>
</body>
</html>