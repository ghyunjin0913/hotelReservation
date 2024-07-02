<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>객실 등록</title>
	<style type="text/css">
		body {
	    	font-family: Arial, sans-serif;
		}
		.form-container {
		    width: 800px;
		    margin: 0 auto;
		}
		.form-container fieldset {
		    border: 1px solid #ccc;
		    padding: 20px;
		    margin-bottom: 20px;
		}
		.form-container legend {
		    font-weight: bold;
		}
		.form-container .form-grid {
		    display: grid;
		    grid-template-columns: 1fr 1fr;
		    gap: 10px 20px;
		}
		.form-container label {
		    margin-top: 10px;
		}
		.form-container input[type="text"],
		.form-container select,
		.form-container input[type="file"] {
		    width: 100%;
		    padding: 5px;
		    margin-top: 5px;
		    box-sizing: border-box;
		}
		.form-container .full-width {
		    grid-column: span 2;
		}
		.form-container .form-buttons {
		    display: flex;
		    justify-content: space-between;
		    margin-top: 20px;
		}
		.form-container input[type="submit"],
		.form-container input[type="button"] {
		    padding: 10px;
		    width: 45%;
		};
	</style>
</head>
<body>
 	  <%@ include file="../main/side.jsp" %>
    <div class="form-container">
        <h2>객실 등록</h2>
        <form action="/projects/gRegister" method="post" >
            <fieldset>
                <legend>업체정보</legend>
                <div class="form-grid">
                    <div>
                        <label for="hotelname">업체명:</label>
                        <input type="text" id="hname" name="hname" value="${hotel.hname}" readonly required>
                    </div>
                    <div>
                        <label for="location">지역:</label>
                        <select id="location" name="location"  required>
                            <option value=""<c:if test="${hotel.location == ''}">selected</c:if>>선택하세요</option>
                            <option value="seoul_gangnam"<c:if test="${hotel.location == 'seoul_gangnam'}">selected</c:if>>서울시 강남구</option>
                            <option value="seoul_jongno"<c:if test="${hotel.location == 'seoul_jongno'}">selected</c:if>>서울시 종로구</option>
                            <option value="seoul_mapo"<c:if test="${hotel.location == 'seoul_mapo'}">selected</c:if>>서울시 마포구</option>
                            <option value="seoul_seocho"<c:if test="${hotel.location == 'seoul_seocho'}">selected</c:if>>서울시 서초구</option>
                            <option value="seoul_songpa"<c:if test="${hotel.location == 'seoul_songpa'}">selected</c:if>>서울시 송파구</option>
                        </select>
                    </div>
                    <div>
                        <label for="phoneNumber">전화번호:</label>
                        <input type="text" id="hphone" name="hphone" value="${hotel.hphone}" readonly required>
                    </div>
                    <div>
                        <label for="grade">등급:</label>
                        <select id="grade" name="grade" required>
                            <option value=""<c:if test="${hotel.grade == ''}">selected</c:if>>선택하세요</option>
                            <option value="5"<c:if test="${hotel.grade == '5'}">selected</c:if>>5성급</option>
                            <option value="4"<c:if test="${hotel.grade == '4'}">selected</c:if>>4성급</option>
                            <option value="3"<c:if test="${hotel.grade == '3'}">selected</c:if>>3성급</option>
                            <option value="2"<c:if test="${hotel.grade == '2'}">selected</c:if>>2성급</option>
                            <option value="1"<c:if test="${hotel.grade == '1'}">selected</c:if>>1성급</option>
                        </select>
                   </div>
                </div>
            </fieldset>

            <fieldset>
                <legend>객실정보</legend>
                <div class="form-grid">
                    <div>
                        <label for="roomName">객실명:</label>
                        <input type="text" id="tname" name="tname" required>
                    </div>
                    <div>
                        <label for="capacity">인원:</label>
                        <select id="max" name="max" required>
                            <option value="">선택하세요</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>
                    <div>
                        <label for="price">가격:</label>
                        <input type="text" id="tprice" name="tprice" required>
                    </div>
                    <div>
                        <label for="roomCount">객실 수:</label>
                        <input type="text" id="amounts" name="amounts"  required>
                    </div>
                </div>
            </fieldset>
            <div class="full-width">
                <label for="roomImage">객실사진:</label>
                <input type="file" id="tpicture" name="tpicture">
            </div>
            
            <div class="form-buttons">
                <input type="button" value="취소" onclick="history.back();">
                <input type="submit" value="다음" >
            </div>
        </form>
    </div>
</body>
</html>
