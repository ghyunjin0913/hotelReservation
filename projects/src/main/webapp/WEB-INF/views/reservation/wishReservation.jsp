<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8e9;
            /* display: flex; */
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            padding: 20px;
        }
        .header {
            background-color: #dff2cc;
            text-align: center;
            width: 100%;
            border-radius: 10px 10px 0 0;
        }
        .header h2 {
            margin: 0;
            color: #6baa37;
            padding: 10px 0;
        }
        .container form {
            display: flex;
            flex-direction: column;
        }
        .container form div {
            margin-bottom: 15px;
        }
        .container form label {
            font-weight: bold;
            margin-bottom: 5px;
            display: block;
        }
        .container form input,
        .container form select {
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
        }
        .container form button {
            background-color: #b3e2a3;
            border: none;
            padding: 10px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .container form button:hover {
            background-color: #a1d893;
        }
    </style>
</head>
<body>
  <%@ include file="../main/header.jsp" %>
    <form action="wishCheck" method="POST">
  		<c:if test="${check eq 'N'}">
        	<script type="text/javascript">
			alert('해당 날짜에는 예약이 불가능합니다. 날짜를 다시 선택해주십시오');
			</script>
        </c:if>
        <div class="container">
            <div class="header">
                <h2>예약 정보</h2>
            </div>
            <div>
                <label for="hotel-name">호텔명</label>
                <input type="text" name="hname" value="${info.hname}">
            </div>
            <div>
                <label for="room-type">객실타입</label>
                <input type="text" name="tcode" value="${tcode}">${info.tname}
            </div>
            <div>
                <label for="price">가격</label>
                <input type="text" name="tprice" value="${info.tprice}">
            </div> 
            <div>
                <label for="checkIn"><img src="images/reservation/calendar.png" width=15 height=15> 체크인</label>
                <input type="date" name="checkIn" required>
           	</div>
          	<div>
                <label for="checkOut"><img src="images/reservation/calendar.png" width=15 height=15> 체크아웃</label>
                <input type="date" name="checkOut" required>
            </div>
            <div>
                <label for="guests"><img src="images/reservation/person.png" width=15 height=15> 인원</label>
                <select name="max" id="guest-select" required>
                    <script>
                        const maxGuests = ${info.max};
                        const guestSelect = document.getElementById('guest-select');
                        for (let i = 1; i <= maxGuests; i++) {
                            const option = document.createElement('option');
                            option.value = i;
                            option.textContent = i + '명';
                            guestSelect.appendChild(option);
                        }
                    </script>
                </select>
            </div>
            <button type="submit">확인</button>
        </div>
    </form>
</body>
</html>
