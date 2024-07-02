<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>객실정보</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/goods/gDetails.css" /> 
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" >
    <script type="text/javascript" src="js/goods/gDetails.js"></script>
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/goods/Images.css" /> 
</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
 	<%@ include file="../main/header.jsp" %>
	<div class="header">
	    <button onclick="history.back();">이전</button>
	    <h1>객실정보</h1>
	</div>	
	<div class="content">
		<!-- Slider main container -->
		<div class="swiper">
		  <!-- Additional required wrapper -->
		  <div class="swiper-wrapper">
		    <!-- Slides -->
		  	<div class="swiper-slide"><img src="<%= request.getContextPath() %>/images/hotel/milton/single1.PNG"  alt="이미지1"></div>
		    <div class="swiper-slide"><img src="<%= request.getContextPath() %>/images/hotel/milton/single2.PNG" ></div>
		  </div>
		  <!-- 네비게이션 지정 -->
	      <div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		  <div class="swiper-button-prev"></div><!-- 이전 버튼 -->
		  <!-- 페이징 필요시 추가 -->
		  <div class="swiper-pagination"></div>
		</div>	
		<script src="<%= request.getContextPath() %>/js/goods/Images.js"></script>
	    <div class="room-details">
	    	<form action="/projects/reserveButton" method="POST">
		        <div class="room-details-left">
		            <h2><span id="room-name">${room.tname}</span></h2>
		            <span id="room-capacity">${room.max}인실</span>
		        </div>
		        <div class="room-details-right">
		            <b class="large_text">가격: <fmt:formatNumber value="${room.tprice}" pattern="#,###" />KWR</b>
		            <div class="buttons">
		                <button id="reserveBtn" name="reserveBtn">예약</button>
		            </div>
		        </div>
			</form>	
		   	<form action="/projects/gDibs"  method="POST">        
		   		<% if(request.getAttribute("confirm")!=null) {%>
		   		<c:choose>
	            	<c:when test="${confirm eq 'C'}">
	     				<script type="text/javascript">
							alert('찜이 취소되었습니다.');
						</script>
	       			</c:when>		 
	       			<c:when test="${confirm eq 'D'}">
	     				<script type="text/javascript">
							alert('찜 목록에 가서 확인해보세요.');
						</script>
	       			</c:when>
	       			<c:when test="${confirm eq 'NP'}">
	     				<script type="text/javascript">
							alert('찜 목록이 다 찼습니다. 목록을 비워주세요.');
						</script>
	       			</c:when>
		    	</c:choose> 
		    	<%} %>
		        <%	if(session.getAttribute("cid") != null){%>
		        	<c:choose>
		            	<c:when test="${dibs eq 'Y'}">
		            	<div class="room-details-right">
							<button class="dibs-button" name="dibs" value="${room.tcode}Y">
							<img src="images/dibs/redheart.png">${wishNo}</button>
							</div>
						</c:when>
						<c:when test="${dibs eq 'N'}">
						<div class="room-details-right">
							<span><button class="dibs-button" name="dibs" value="${room.tcode}N">
							<img src="images/dibs/whiteheart.png">${wishNo}</button></span>
							</div>
						</c:when>
					</c:choose>	
				<%} %>
		    </form>      
		</div>
	</div>	
<div class="room-tabs">
    <div class="tab">
        <button class="tablinks" onclick="openTab(event, 'details')"><b>상세 정보</b></button>
          <button class="tablinks" onclick="openTab(event, 'reviews')" ><b>리뷰</b></button>
    </div>
    <div id="details" class="tabcontent">
        <div class="room-description">
            <h3>기본 정보</h3>
            ${details.exp}
        </div>
        <div class="room-description">
            <h3>서비스</h3>
            <pre>
베드구성: ${details.bedtype} ${details.bedno}개
객실전망: ${details.tview} View
흡연여부: ${details.smoke}
객실크기: ${details.tsize}㎡
욕실종류: ${details.bathtype}
조식여부: ${details.breakfast}
            </pre>
        </div>
    </div>
    <div id="reviews" class="tabcontent">   
	    <c:choose>
	    	<c:when test="${not empty reviewList}">
		    	<%@ include file="../review/gReview.jsp" %>
	        </c:when>
	        <c:otherwise>
	        	<div class="room-description">
	        		해당 상품의 리뷰가 존재하지 않습니다.
	        	</div>
	    	</c:otherwise>
	    </c:choose>
    </div>
</div>
