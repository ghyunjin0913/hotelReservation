<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {

		$("#drop_out_of_member").click(function(event) {
			event.preventDefault();
			
			var choice = confirm("정말로 탈퇴하시겠습니까?");
			/* 컨펌창에서 확인을 누르면 */
			if (choice) {
				
				var userpw = $("#inputPassword").val(); /* input으로 입력받은 비밀번호 값 */
				var realUserPw = $("#realUserPw").val(); /* DB에서 넘겨받은 비밀번호 값 */ 
				var isChecked = $("#checkbox").prop("checked"); /* 체크박스의 체크 여부를 가져오는 변수 */
				var reason = $("#inputReason").val();
				
				
				if (userpw == '') {
					/* 1. 비밀번호 입력란이 공란일 때 alert을 띄운 뒤 비밀번호 입력란에 focus */
					alert("비밀번호를 입력해주세요.");
					$("#inputPassword").focus();
				
				} else {
					/* 2. 비밀번호는 입력되어있는데 체크박스가 체크 안 된 경우 */
					if (!isChecked) { /* isChecked의 값이 false인 경우 */
						
						alert("탈퇴 동의란에 체크 해주세요.");
						/* alert을 띄워 동의란에 체크하도록 함 */
						
					} else {
						/* 3. 비밀번호, 체크박스 모두 입력되어있는데, DB에 저장된 비밀번호와 다른 경우 */
						if (userpw != realUserPw) {
							/* alert창을 띄워 비밀번호를 확인하게 한 뒤, 비밀번호 입력란에 focus */
							alert("잘못된 비밀번호입니다.");
							$("#inputPassword").focus();
						} else {
							/* 옳은 비밀번호 + 체크박스 체크되었는데 이유를 작성 안한 경우*/
							if (reason == ''){
								alert("이유를 작성해 주세요");
								$("#inputReason").focus();
							}
							else {
								alert("탈퇴 신청 완료. 탈퇴처리는 24시간 이내에 이뤄집니다");
								$("form").submit();
								/* from 태그를 제출한다 */
							}
						 	
						}

					}

				}

			} else { /* confirm에서 취소를 선택한 경우 : 마이페이지로 돌아간다 */
				var userid = $("#inputId").val();
				location.assign("/member/read/" + userid);
			}
		});

	});
</script>
</head>
<body>
 <%@ include file="../main/header.jsp" %>
<div class="container">

		<div class="row">
			<h1>정말로 탈퇴하시겠어요?</h1>
			<h3>탈퇴하기 버튼을 누르시면 적립된 포인트 및 모든 정보가 사라집니다.</h3>
			<h3>탈퇴처리는 24시간 이내에 이뤄집니다</h3>
		</div>
		<!-- class=row -->
		<div class="container">
			<h4>탈퇴를 원하시면 비밀번호를 입력해주세요.</h4>
			<br>
		</div>

		<div class="row deleteForm">
		<form class="form-horizontal" action="/projects/insertCustomerWithdraw" method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">ID</label>
				<div class="col-sm-10">
					<input class="form-control" id="inputId" name="cid" value="${clogIn.cid}" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputPassword" name="cpw" required>
					<input type="hidden" id="realUserPw" value="${clogIn.cpw}">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" id="checkbox" required>탈퇴시의 주의사항을 확인했습니다.</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="inputReason3" class="col-sm-2 control-label">탈퇴 이유</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputReason" name="reason">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default" id="drop_out_of_member">탈퇴하기</button>
					<input type="button" value="취소" onclick="location.href='/projects/myInfoCtrl'">
				</div>
			</div>
		</form>
		</div>
	</div><!-- class=container -->
</body>
</html>