<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
<style type="text/css">
body{
  margin:0;
  color:#6a6f8c;
  background:#c8c8c8;
  font:600 16px/18px 'Open Sans',sans-serif;
}
*,:after,:before{box-sizing:border-box}
.clearfix:after,.clearfix:before{content:'';display:table}
.clearfix:after{clear:both;display:block}
a{color:inherit;text-decoration:none}

.payLogIn-wrapper{
  width:100%;
  margin:auto;
  max-width:525px;
  min-height:670px;
  position:relative;

  box-shadow:0 12px 15px 0 rgba(0,0,0,.24),0 17px 50px 0 rgba(0,0,0,.19);
}
.payLogIn-html{
  width:100%;
  height:100%;
  position:absolute;
  padding:90px 70px 50px 70px;
  background:rgba(40,57,101,.9);
}
.payLogIn-html .cLogIn-htm{
  top:0;
  left:0;
  right:0;
  bottom:0;
  position:absolute;
  transform:rotateY(180deg);
  backface-visibility:hidden;
  transition:all .4s linear;
}
.payLogIn-html .customer{
  display:none;
}
.payLogIn-html .tab,
.payLogIn-form .group .label,
.payLogIn-form .group .button{
  text-transform:uppercase;
}
.payLogIn-html .tab{
  font-size:22px;
  margin-right:15px;
  padding-bottom:5px;
  margin:0 15px 10px 0;
  display:inline-block;
  border-bottom:2px solid transparent;
}
.payLogIn-html .customer:checked + .tab{
  color:#fff;
  border-color:#1161ee;
}
.payLogIn-form{
  min-height:345px;
  position:relative;
  perspective:1000px;
  transform-style:preserve-3d;
}
.payLogIn-form .group{
  margin-bottom:15px;
}
.payLogIn-form .group .label,
.payLogIn-form .group .input,
.payLogIn-form .group .button{
  width:100%;
  color:#fff;
  display:block;
}
.payLogIn-form .group .input,
.payLogIn-form .group .button{
  border:none;
  padding:15px 20px;
  border-radius:25px;
  background:rgba(255,255,255,.1);
}
.payLogIn-form .group .label{
  color:#aaa;
  font-size:12px;
}
.payLogIn-form .group .button{
  background:#1161ee;
}
.payLogIn-form .group label .icon{
  width:15px;
  height:15px;
  border-radius:2px;
  position:relative;
  display:inline-block;
  background:rgba(255,255,255,.1);
}
.payLogIn-form .group label .icon:before,
.payLogIn-form .group label .icon:after{
  content:'';
  width:10px;
  height:2px;
  background:#fff;
  position:absolute;
  transition:all .2s ease-in-out 0s;
}
.payLogIn-form .group label .icon:before{
  left:3px;
  width:5px;
  bottom:6px;
  transform:scale(0) rotate(0);
}
.payLogIn-form .group label .icon:after{
  top:6px;
  right:0;
  transform:scale(0) rotate(0);
}
.payLogIn-html .customer:checked + .tab  + .payLogIn-form .cLogIn-htm{
  transform:rotate(0);
}

.hr{
  height:2px;
  margin:60px 0 50px 0;
  background:rgba(255,255,255,.2);
}
.foot-lnk{
  text-align:center;
}
</style>
</head>
<body>
 	 <%@ include file="../main/header.jsp" %>
	<div class="payLogIn-wrapper">
    <div class="payLogIn-html">
        <input id="tab-1" type="radio" name="tab" class="customer" checked>
        <label for="tab-1" class="tab">고객</label>
 
        <div class="payLogIn-form">
            <div class="cLogIn-htm">
            
                <form method="POST" action="/projects/payLogIn" id="payLogIn-form">
                	<c:choose>
                   		<c:when test="${result eq 'no_id'}">
     				   	<script type="text/javascript">
						alert('존재하지 않는 아이디입니다.');
						</script>
       					 </c:when>
       					 
       					      		<c:when test="${result eq 'wrong_pw'}">
     				   	<script type="text/javascript">
						alert('비밀번호가 일치하지 않습니다. 다시 입력해주세요.');
						</script>
       					 </c:when>
       					 
        			</c:choose>
                    <div class="group">
                        <label for="user" class="label">아이디</label>
                        <input type="text" name="cid" class="input">
                    </div>
                    <div class="group">
                        <label for="pass" class="label">비밀번호</label>
                        <input type="password" name="cpw" class="input">
                    </div>
                    <div class="group">
                        <input type="submit" class="button" value="로그인">
                    </div>
                    <div class="hr"></div>
                    <div class="foot-lnk">
                        <a href="/projects/cSignUp">회원가입</a>
                    </div>
                </form>
            </div>
          
        </div>
    </div>
</div>
</body>
</html>

