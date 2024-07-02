<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
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
		.star_rating {
		  width: 100%; 
		  box-sizing: border-box; 
		  display: inline-flex; 
		  float: left;
		  flex-direction: row; 
		  justify-content: flex-start;
		}
		.star_rating .star {
		  width: 25px; 
		  height: 25px; 
		  margin-right: 10px;
		  display: inline-block; 
		  background: url('https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FE2bww%2FbtsviSSBz4Q%2F5UYnwSWgTlFt6CEFZ1L3Q0%2Fimg.png') no-repeat; 
		  background-size: 100%; 
		  box-sizing: border-box; 
		}
		.star_rating .star.on {
		  width: 25px; 
		  height: 25px;
		  margin-right: 10px;
		  display: inline-block; 
		  background: url('https://blog.kakaocdn.net/dn/b2d6gV/btsvbDoal87/XH5b17uLeEJcBP3RV3FyDk/img.png') no-repeat;
		  background-size: 100%; 
		  box-sizing: border-box; 
		}
		
		.star_box {
		  width: 400px;
		  box-sizing: border-box;
		  display: inline-block;
		  margin: 15px 0;
		  background: #F3F4F8;
		  border: 0;
		  border-radius: 10px;
		  height: 100px;
		  resize: none;
		  padding: 15px;
		  font-size: 13px;
		  font-family: sans-serif;
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
		}
		 #rdate {
            display: none;
        };
	</style>
</head>
<body>
    <%@ include file="../main/side.jsp" %>
    <div class="form-container">
        <h2>리뷰 작성</h2>
        <form action="/projects/rRegister" method="post" >
            <fieldset>
                <div class="form-grid">
                	
                    <div>
                        <label for="tname">상품명:</label>
                        <input type="text" id="tname" name="tname" value="${data.tname}" readonly required>
                    </div>
					<div>
                        <label for="usedate">이용날짜:</label>
                        <input type="text" id="usedate" name="usedate" value="${data.usedate}" readonly required>
                    </div>
                    <input type="hidden" id="rid" name="rid" value="${data.rid}">
                    <input type="hidden" id="cid" name="cid" value="${data.cid}">
                	<input type="hidden" id="tcode" name="tcode" value="${data.tcode}">
                	<input type="date" id="rdate" name="rdate" >
                    <div>
                       <label for="ratingValue">평점:</label>
	                   <div class ="star_rating">
						  <span class="star on" data-value="1"> </span>
						  <span class="star" data-value="2"> </span>
						  <span class="star" data-value="3"> </span>
						  <span class="star" data-value="4"> </span>
						  <span class="star" data-value="5"> </span>
						</div>
                    </div>
                     <input type="hidden" id="rating" name="rating">
                    <div class="full-width">
                        <label for="rcomment">후기:</label>
                      	<textarea class="star_box" placeholder="리뷰 내용을 작성해주세요."
                      		 id="rcomment" name="rcomment"></textarea>
                    </div>
                </div>
            </fieldset>
                 
            <div class="form-buttons">
                <input type="button" value="취소" onclick="history.back();">
                <input type="submit" value="등록">
            </div>
        </form>
    </div>
    <script>
	    document.addEventListener('DOMContentLoaded', function() {
	        const rdateInput = document.getElementById('rdate');
	        const currentDate = new Date();
	
	        // 현재 날짜를 YYYY-MM-DD 형식으로 포맷팅
	        const formattedDate = currentDate.toISOString().slice(0,10);
	
	        // input 요소의 값 설정
	        rdateInput.value = formattedDate;
	        console.log('Formatted Date:', formattedDate); // 확인용 로그
	    });
	    $(document).ready(function() {
	        $('.star_rating > .star').click(function() {
	            $(this).siblings().removeClass('on');
	            $(this).addClass('on').prevAll('.star').addClass('on');
	            
	            // 클릭된 별점의 값을 가져와 정수로 변환
	            const ratingValue = parseInt($(this).data('value'));
	            console.log('Selected Rating:', ratingValue);
	            
	            // 별점 값을 hidden input field에 설정
	            $('#rating').val(ratingValue);
	        });
	    });
	</script>
</body>
</html>
