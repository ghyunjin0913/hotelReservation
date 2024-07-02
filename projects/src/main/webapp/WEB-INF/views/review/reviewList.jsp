<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        table {
            width: 80%;
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
	    <h1>나의 리뷰 내역</h1>
	    <table>
	        <thead>
	            <tr>
	                <th>예약번호</th>
	                <th>객실정보</th>
	                <th>예약날짜</th>
	                <th>결제금액</th>
	                <th>리뷰작성</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach var="List" items="${List}">
					<tr>
						<td>${List.rid}</td>
	               		<td>${List.hname} <br> ${List.tname} <br> 인원수:${List.person} </td>
	               	 	<td>${List.checkin.substring(0, 10)} ~ ${List.checkout.substring(0, 10)}</td>
				 		<td><fmt:formatNumber value="${List.tprice}" pattern="#,###" /> KWR</td>
				 		<td><c:if test="${List.cid eq null}">
				 				<button id='target_btn_1' onclick="location.href='/projects/rRegisterPage?rid=${List.rid}'">리뷰등록</button>
				 			</c:if>
				 			<c:if test="${List.cid != null}">
					 				<button id='target_btn_2' onclick="location.href='/projects/rViewPage?rid=${List.rid}'">리뷰보기</button>
					 		</c:if>
				 		</td>
					</tr>
				</c:forEach>
	        </tbody>
	    </table>
</body>
</html>