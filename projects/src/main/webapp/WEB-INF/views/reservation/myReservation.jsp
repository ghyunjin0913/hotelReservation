<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약/결제 내역</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .status-complete {
            background-color: #f2f2f2;
        }
        .cancel-button {
            background-color: #888;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
 
 	   <%@ include file="../main/side.jsp" %>
	<form action="/projects/myReservation" method="POST" >
    <h1>나의 예약 내역</h1>
    	<c:if test="${check eq 'check'}">
        	<script type="text/javascript">
			alert('예약을 취소하시겠습니까?');
			</script>
        </c:if>
    
    <table>
        <thead>
            <tr>
                <th>예약번호</th>
                <th>객실 정보</th>
                <th>예약날짜</th>
                <th>예약상태</th>
                <th>결제금액</th>
            </tr>
        </thead>
        <tbody>
            	<c:forEach var="List" items="${List}">
					<tr>
						<td>${List.rid}</td>
               			<td>${List.hname} <br> ${List.exp}<br> ${List.bedtype} <br> 인원수:${List.person} </td>
               	 		<td>${List.rdate.substring(0, 10)}</td>
			 			<td class="status-complete">예약완료<br><button type="submit" id="cancel" name="cancel" value="${List.rid}">예약취소</button></td>
			  			<td>${List.price}</td>
					</tr>
				</c:forEach>
        </tbody>
    </table>
    </form>
</body>
</html>
