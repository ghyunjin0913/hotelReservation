<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
  <link rel="stylesheet" href="css/logIn/logInForm.css" /> 
    <title>로그인화면</title>
<script type="text/javascript">
$(document).ready(function(){
    $("#btncLogin").click(function(){
        document.cloginForm.action = "/projects/cLogInCtrl";
        document.cloginForm.submit();
    });
    $("#btneLogin").click(function(){
        document.eloginForm.action = "/projects/eLogInCtrl";
        document.eloginForm.submit();
    });
    $("#btnhLogin").click(function(){
        document.hloginForm.action = "/projects/hLogInCtrl";
        document.hloginForm.submit();
    });

    // 결과 확인은 로그인 폼의 제출 이벤트 후에 실행되도록 이동
    var result = "${result}";
    var type = "${type}"; // 변경된 부분
    if(result === "no_id"){
        alert("아이디가 틀렸습니다.");
    } else if(result === "wrong_pw"){
        alert("비밀번호가 틀렸습니다.");
    }

    // 로그인 실패 시 해당 폼으로 다시 로드
    if(type === "customer") {
        $("#tab-1").prop("checked", true); // 변경된 부분
    } else if(type === "employee") {
        $("#tab-2").prop("checked", true); // 변경된 부분
    } else if(type === "hotel") {
        $("#tab-3").prop("checked", true); // 변경된 부분
    }
});
</script>
</head>
<body>
 <%@ include file="../main/header.jsp" %>
    <div class="logIn-wrapper">
        <div class="logIn-html">
            <input id="tab-1" type="radio" name="tab" class="customer" checked>
            <label for="tab-1" class="tab">고객</label>
            <input id="tab-2" type="radio" name="tab" class="emp">
            <label for="tab-2" class="tab">사원</label>
            <input id="tab-3" type="radio" name="tab" class="hotel">
            <label for="tab-3" class="tab">호텔</label>
            
            <div class="logIn-form">
                <div class="cLogIn-htm">
                    <form method="POST" name="cloginForm" id="cLogIn-form">
                        <div class="group">
                            <label for="user" class="label">아이디</label>
                            <input type="text" name="cid" id="input" class="input">
                        </div>
                        <div class="group">
                            <label for="pass" class="label">비밀번호</label>
                            <input type="password" name="cpw" id="input" class="input">
                        </div>
                          <div class="group">
                            <input type="submit" class="button" id="btncLogin" value="로그인">
                        </div>
                        <div class="hr"></div>
                        <div class="foot-lnk">
                            <a href="/projects/cSignUp">회원가입</a>
                        </div>
                    </form>
                </div>
                 <div class="eLogIn-htm">
                <form method="POST" name="eloginForm"id="eLogIn-form">
                    <div class="group">
                        <label for="user" class="label">아이디</label>
                        <input type="text" name="eid" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">비밀번호</label>
                        <input type="password" name="epw" class="input">
                    </div>
                    <div class="group">
                        <input type="submit" class="button" id="btneLogin" value="로그인">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="/projects/eSignUp">회원가입</a>
                    </div>
                </form>
            </div>
            <div class="hLogIn-htm">
                <form method="POST" name="hloginForm"id="hLogIn-form">
                    <div class="group">
                        <label for="user" class="label">아이디</label>
                        <input type="text" name="hid" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">비밀번호</label>
                        <input type="password" name="hpw" class="input">
                    </div>
                     <div class="group">
                        <input type="submit" class="button" id="btnhLogin" value="로그인">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="/projects/hSignUp">회원가입</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>