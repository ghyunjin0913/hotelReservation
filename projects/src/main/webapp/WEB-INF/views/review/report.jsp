<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>댓글 신고 화면</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
        }
        h2 {
            text-align: center;
        }
        .info {
            font-size: 14px;
            color: #666;
            margin-bottom: 20px;
        }
        .section {
            margin-bottom: 20px;
        }
        .section h3 {
            margin: 10px 0;
            font-size: 16px;
        }
        .section label {
            display: block;
            margin-bottom: 10px;
            font-size: 14px;
        }
        .section input[type="radio"] {
            margin-right: 10px;
        }
        .extra-info {
            display: none;
            margin-top: 10px;
        }
        .extra-info textarea {
            width: 100%;
            height: 60px;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        .buttons {
            text-align: center;
            margin-top: 10px;
        }
        .buttons button {
            padding: 10px 20px;
            font-size: 14px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .buttons button[type="submit"] {
            background-color: #007bff;
            color: white;
        }
        .buttons button[type="button"] {
            background-color: #6c757d;
            color: white;
            margin-left: 10px;
        }
    </style>
    <script>
        function toggleExtraInfo() {
            var otherReason = document.querySelector('input[name="reason"][value="8"]');
            var extraInfo = document.querySelector('.extra-info');
            if (otherReason.checked) {
                extraInfo.style.display = 'block';
            } else {
                extraInfo.style.display = 'none';
            }
        }

        window.onload = function() {
            var reasonRadios = document.querySelectorAll('input[name="reason"]');
            reasonRadios.forEach(function(radio) {
                radio.addEventListener('change', toggleExtraInfo);
            });
        };
    </script>
</head>
<body>
    <%@ include file="../main/header.jsp" %>
    <% if (request.getAttribute("result") != null) { %>
        <c:if test="${result eq 'S'}">
            <script>
                alert('신고가 완료됐습니다.');
            </script>
        </c:if>   
    <% } %>
    <form action="/projects/report" method="POST">
        <div class="container">
        	<input type="hidden" name="tcode" value="${tcode}">
            <input type="hidden" name="rid" value="${rid}">
            <input type="hidden" name="type" value="${type}">
            <h2>댓글 신고</h2>
            <p class="info">
                신고 접수는 자신과 반대 의견을 표현하는 기능이 아닙니다. <br>
                허위, 장난, 부분하게 신고하면 권한이 회수되니 신중히 신고하시기 바랍니다. <br>
                신고하시면 검토하여 필요하면 삭제, 이동, 회원 제재 조치 합니다.
            </p>

            <div class="section">
                <h3>신고 사유</h3>
                <label><input type="radio" name="reason" value="음란 사이트, 도박 사이트 광고 게시물" required>음란 사이트, 도박 사이트 광고 게시물 </label>
                <label><input type="radio" name="reason" value="관련없는 업체광고 또는 홍보성 게시물"> 관련없는 업체광고 또는 홍보성 게시물</label>
                <label><input type="radio" name="reason" value="선정적, 폭력적 내용의 사진이나 내용, 링크 게시물"> 선정적, 폭력적 내용의 사진이나 내용, 링크 게시물</label>
                <label><input type="radio" name="reason" value="실제 후기와 관련없는 게시물">실제 후기와 관련없는 게시물 </label>
                <label><input type="radio" name="reason" value="게시판 성격과 맞지 않거나 타 게시판 링크 제공 게시물">게시판 성격과 맞지 않거나 타 게시판 링크 제공 게시물 </label>
                <label><input type="radio" name="reason" value="타인을 비방하거나 심한 욕설을 하는 게시물"> 타인을 비방하거나 심한 욕설을 하는 게시물</label>
                <label><input type="radio" name="reason" value="종교, 정치, 지역 단체를 비방하는 게시물"> 종교, 정치, 지역 단체를 비방하는 게시물</label>
                <label><input type="radio" name="reason" value="8">기타 적합하지 않다고 판단되는 게시물</label>
                
                <div class="extra-info">
                    <textarea name="details" placeholder="추가 신고 내용을 작성하세요. 50자 이내"></textarea>
                </div>
                
                <div class="buttons">
                    <button type="submit">신고 접수</button>
                    <button type="button" onclick="window.open('','_self').close()">창닫기</button>
                </div>
            </div>
        </div>
    </form>
</body>
</html>
