<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>예약 확인서</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 300px;
            margin: 0 auto;
            border: 1px solid #ccc;
            padding: 20px;
        }
        .notification {
            background-color: #dff0d8;
            color: #3c763d;
            padding: 10px;
            margin-bottom: 20px;
        }
        .field {
            margin-bottom: 15px;
        }
        .label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        .input {
            width: 100%;
            padding: 5px;
            box-sizing: border-box;
        }
        .hotel-info {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }
        .hotel-photo {
            width: 60px;
            height: 60px;
            background-color: #eee;
            margin-right: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
            font-size: 12px;
            color: #aaa;
        }
        .hotel-details {
            flex-grow: 1;
        }
        .hotel-details .input {
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
 	 <%@ include file="../main/header.jsp" %>
    <div class="container">
        <div class="notification">
            예약 확인서가 발송되었습니다. 이메일 받은 편지함에서 확인할 수 없는 경우 스팸 메일함도 확인해 보시기 바랍니다.
        </div>
        <div class="field">
            <label class="label">예약번호</label>
            <input type="text" class="input" name="reservation_number" 
            value="${rid}" readonly>
        </div>
        <div class="field">
            <label class="label">예약일자</label>
            <input type="text" class="input" name="reservation_date"
               value="${rdate}" readonly>
        </div>
        <div class="hotel-info">
            <div class="hotel-photo">
                호텔사진
            </div>
            <div class="hotel-details">
                <div class="field">
                    <label class="label">호텔명</label>
                    <input type="text" class="input" name="hotel_name"
                        value="${hname}" readonly>
                </div>
                <div class="field">
                    <label class="label">위치</label>
                    <input type="text" class="input" name="hotel_location"
                     value="${location}" readonly>
                </div>
            </div>
        </div>
        <div class="field">
            <label class="label">결제금액</label>
            <input type="text" class="input" name="payment_amount"
                  value="${tprice}" readonly>
        </div>
    </div>
</body>
</html>
