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
	<%@ include file="../main/header.jsp" %>
    <div class="form-container">
        <h2>객실 변경</h2>
        <form action="/projects/roomsupdate" method="post" >
            <fieldset>
                <legend>객실정보</legend>
                <div class="form-grid">
                  	<input type="hidden" id="tcode" name="tcode" value="${type.tcode}" >
                    <div>
                        <label for="roomName">객실명:</label>
                        <input type="text" id="tname" name="tname" value="${type.tname}" required>
                    </div>
                    <div>
                        <label for="capacity">인원:</label>
                        <select id="max" name="max" required>
                            <option value=""<c:if test="${type.max == ''}">selected</c:if>>선택하세요</option>
                            <option value="1"<c:if test="${type.max == '1'}">selected</c:if>>1</option>
                            <option value="2"<c:if test="${type.max == '2'}">selected</c:if>>2</option>
                            <option value="3"<c:if test="${type.max == '3'}">selected</c:if>>3</option>
                            <option value="4"<c:if test="${type.max == '4'}">selected</c:if>>4</option>
                            <option value="5"<c:if test="${type.max == '5'}">selected</c:if>>5</option>
                        </select>
                    </div>
                    <div>
                        <label for="price">가격:</label>
                        <input type="text" id="tprice" name="tprice" value="${type.tprice}"  required>
                    </div>
                    <div>
                        <label for="roomCount">객실 수:</label>
                        <input type="text" id="amounts" name="amounts" value="${type.amounts}"  required>
                    </div>
                     <div class="full-width">
                        <label for="exp">소개:</label>
                        <textarea cols="50" rows="10"
                        id="exp" name="exp" required>${tdetails.exp}</textarea>
                    </div>
                    <div>
                        <label for="bedtype">침대종류:</label>
                        <select id="bedtype" name="bedtype" required>
                            <option value=""<c:if test="${tdetails.bedtype == ''}">selected</c:if>>선택하세요</option>
                            <option value="King_Twin"<c:if test="${tdetails.bedtype == 'King_Twin'}">selected</c:if>>King_Twin</option>
                            <option value="King"<c:if test="${tdetails.bedtype == 'King'}">selected</c:if>>King</option>
                            <option value="Queen"<c:if test="${tdetails.bedtype == 'Queen'}">selected</c:if>>Queen</option>
                            <option value="Double"<c:if test="${tdetails.bedtype == 'Double'}">selected</c:if>>Double</option>
                            <option value="Single"<c:if test="${tdetails.bedtype == 'Single'}">selected</c:if>>Single</option>
                        </select>
                    </div>
                    <div>
                        <label for="bedno">침대수:</label>
                        <select id="bedno" name="bedno" required>
                            <option value=""<c:if test="${tdetails.bedno == ''}">selected</c:if>>선택하세요</option>
                            <option value="1"<c:if test="${tdetails.bedno == '1'}">selected</c:if>>1</option>
                            <option value="2"<c:if test="${tdetails.bedno == '2'}">selected</c:if>>2</option>
                            <option value="3"<c:if test="${tdetails.bedno == '3'}">selected</c:if>>3</option>
                        </select>
                    </div>
                    <div>
                        <label for="tview">전망:</label>
                       	<select id="tview" name="tview" required>
                            <option value=""<c:if test="${tdetails.tview == ''}">selected</c:if>>선택하세요</option>
                            <option value="Cty"<c:if test="${tdetails.tview == 'Cty'}">selected</c:if>>city</option>
                            <option value="Street"<c:if test="${tdetails.tview == 'Street'}">selected</c:if>>street</option>
                            <option value="Garden"<c:if test="${tdetails.tview == 'Garden'}">selected</c:if>>garden</option>
                            <option value="Ocean"<c:if test="${tdetails.tview == 'Ocean'}">selected</c:if>>ocean</option>
                            <option value="River"<c:if test="${tdetails.tview == 'River'}">selected</c:if>>river</option>                           
                            <option value="Mountain"<c:if test="${tdetails.tview == 'Mountain'}">selected</c:if>>mountain</option>
                            <option value="Park"<c:if test="${tdetails.tview == 'Park'}">selected</c:if>>park</option>
                        </select>
                    </div>
                    <div>
                        <label for="smoke">흡연여부:</label>
                        <input type="radio" id="smoke" name="smoke" value="Y" <c:if test="${tdetails.smoke == 'Y'}">checked</c:if>>Y
                        <input type="radio" id="smoke" name="smoke" value="N" <c:if test="${tdetails.smoke == 'N'}">checked</c:if>>N
                    </div>
                    <div>
                        <label for="tsize">객실크기:</label>
                        <input type="text" id="tsize" name="tsize" value="${tdetails.tsize}" required>
                    </div>
                    <div>
                        <label for="bathtype">욕실종류:</label>
                        <select id="bathtype" name="bathtype" required>
                            <option value=""<c:if test="${tdetails.bathtype == ''}">selected</c:if>>선택하세요</option>
                            <option value="Shower"<c:if test="${tdetails.bathtype == 'Shower'}">selected</c:if>>Shower</option>
                            <option value="Shower_Bathtub"<c:if test="${tdetails.bathtype == 'Shower_Bathtub'}">selected</c:if>>Shower &amp; Bathtub</option>
                            <option value="Bathtub"<c:if test="${tdetails.bathtype == 'Bathtub'}">selected</c:if>>Bathtub</option>
                        </select>
                    </div>
                    <div>
                        <label for="breakfast">조식여부:</label>
                        <input type="radio" id="breakfast" name="breakfast" value="Y" <c:if test="${tdetails.breakfast == 'Y'}">checked</c:if>>Y
                        <input type="radio" id="breakfast" name="breakfast" value="N" <c:if test="${tdetails.breakfast == 'N'}">checked</c:if>>N
                    </div>
                </div>
            </fieldset>
              
            <div class="form-buttons">
                <input type="button" value="취소" onclick="history.back();">
                <input type="submit" value="수정">
            </div>
        </form>
    </div>
</body>
</html>
