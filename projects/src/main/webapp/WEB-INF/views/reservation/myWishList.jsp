<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false"  pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>찜 목록</title>
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border-bottom: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
            border-bottom: 2px solid #ddd;
        }
        tr:last-child td {
            border-bottom: none;
        }
        img {
            width: 30px;
            height: 30px;
        }
        .reserve {
           width: 80%;
            border-top: 2px solid #ccc;
            border-bottom: 2px solid #ccc;
            background-color: #f9f9f9;
            text-align: right; 
            padding: 10px 0; 
        }
        .reserve-btn {
            background-color: #FFD700;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
        }
        .delete-btn {
           	background-color: transparent;
  			border: 2px solid #fff;
  			color: black;
       		height: 40px;
        	width: 30px;       
        }
        .delete-btn:hover {
  	 		background-color: #fff;
 	 		color: #000;
        }
        .delete-btn > img {
        	width: 30px;
        	height: 30px;
        }
    </style>
</head>
<body>
 	<%@ include file="../main/side.jsp" %>
	<form action="/projects/myWishList" method="POST">
	<table>
    	<tr>
    	    <th>예약 시 선택</th>
    	    <th>호텔명</th>
    	    <th>객실타입</th>
    	    <th>상품가격</th>
    	   	<th>찜 삭제</th>
   		</tr>
   		<c:forEach var="wishList" items="${wishList}">
   			<tr>
        		<td><input type="radio" name="radio" value="${wishList.tcode}" ></td>
        		<td><img src="${wishList.img}"> ${wishList.hname} </td>
        		<td>${wishList.tname}</td>
        		<td>${wishList.tprice}</td>
        		<td> 
               <span><button class="delete-btn" value="${wishList.tcode}">
                    <img src="images/dibs/delete.png"></button></span>
                </td>
            </tr>
        </c:forEach>
    </table>
        <div class="reserve">
            <button class="reserve-btn" type="submit" name="btn" value="R">예약하기</button>
        </div>
    </form>
    <script>
        // 클래스가 delete-btn인 모든 요소에 이벤트 리스너 추가
        const deleteButtons = document.querySelectorAll(".delete-btn");

        // 모든 삭제 버튼에 대해 반복하면서 클릭 이벤트 리스너 추가
        deleteButtons.forEach(button => {
            button.addEventListener("click", (event) => {
                // 버튼 클릭의 기본 동작(폼 제출 또는 링크 이동) 방지
                event.preventDefault();

                // 삭제할 아이템의 코드
                const tcode = button.value;

                // 삭제 확인 메시지 표시
                if (confirm("찜을 취소하시겠습니까?")) {
                    // AJAX를 사용하여 서버에 삭제 요청 보내기
                    const xhttp = new XMLHttpRequest();
                    xhttp.onreadystatechange = function() {
                        if (this.readyState === 4 && this.status === 200) {
                            // 요청이 성공하면 페이지 다시로드
                            window.location.reload();
                        }
                    };
                    xhttp.open("POST", "/projects/delete", true);
                    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    xhttp.send("tcode=" + tcode);
                }
            });
        });
    </script>
</body>
</html>
