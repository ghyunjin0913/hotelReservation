<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사이트명</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/goods/Images.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css" >
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .hotel-info {
            text-align: left;
            margin-bottom: 20px;
        }
        .hotel-info .hotel-details {
            display: flex;
            justify-content: left;
            align-items: center;
        }
        .hotel-info h1 {
            margin: 10px 10px 10px 0;
        }
        .hotel-info p {
            margin: 10px 0;
        }
        .room-list {
            width: 80%;
            margin: 0 auto;
            border: 1px solid #000;
        }
        .room-item {
            display: flex;
            align-items: center;
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        .room-item:last-child {
            border-bottom: none;
        }
        .room-item img {
            width: 100px;
            height: 100px;
            margin-right: 20px;
        }
        .room-details {
            display: flex;
            flex-direction: column;
            flex-grow: 1;
        }
        .room-details h3 {
            margin: 0;
        }
        .room-details p {
            margin: 5px 0;
        }
        .room-price {
            display: flex;
            flex-direction: column;
            align-items: flex-end;
        }
        .room-price p {
            margin: 0;
        }
        .dibs-button {
           	background-color: transparent;
  			border: 2px solid #fff;
       		height: 30px;
        	width: 30px;
        }
         .dibs-button:hover {
  	 		background-color: #fff;
 	 		color: #000;
        }
         .dibs-button img {
        	width: 30px;
        	height: 30px;
        }
    </style>
</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
    <%@ include file="../main/header.jsp" %>
    <div class="swiper">
		  <!-- Additional required wrapper -->
		  <div class="swiper-wrapper">
		    <!-- Slides -->
		  	<div class="swiper-slide"><img src="<%= request.getContextPath() %>/images/hotel/milton/main1.PNG" ></div>
		    <div class="swiper-slide"><img src="<%= request.getContextPath() %>/images/hotel/milton/main2.PNG" ></div>
		    <div class="swiper-slide"><img src="<%= request.getContextPath() %>/images/hotel/milton/main3.PNG" ></div>
		  </div>
		  <!-- 네비게이션 지정 -->
	      <div class="swiper-button-next"></div><!-- 다음 버튼 (오른쪽에 있는 버튼) -->
		  <div class="swiper-button-prev"></div><!-- 이전 버튼 -->
		  <!-- 페이징 필요시 추가 -->
		  <div class="swiper-pagination"></div>
	</div>	
    <script src="<%= request.getContextPath() %>/js/goods/Images.js"></script>

    <div class="hotel-info">
        <div class="hotel-details">
            <h1>${hotel.hname}</h1>
            <p>${hotel.location} | ${hotel.grade}성급 | ${hotel.hphone}</p>
        </div>
    </div>

    <div class="room-list">
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
	    <c:forEach var="room" items="${rooms}">
	        <div class="room-item">
	        <%-- <img src="${room.photo}" alt="객실 사진"> --%>
	        	<div class="room-details">
	            	<h3><a href="/projects/gDetails?tcode=${room.tcode}">${room.tname}</a></h3>
	                <p>인원: ${room.max}인</p>
	                <p>재고수량: ${room.amounts}개 남음</p>
	            </div>
	            <div class="room-price">
		        	<b class="large_text">가격: <fmt:formatNumber value="${room.tprice}" pattern="#,###" />KWR</b>
		        </div>                    
			    <div class="dibs">
				    <form action="/projects/hDibs" method="POST">
			        <%--세션아이디값이 있을 때만 찜할 수 있는 버튼 띄움 --%>     
				    <%	if(session.getAttribute("cid") != null){%>
				         <c:forEach var="dibs" items="${dibs}">
				           	<c:if test="${room.tcode eq dibs.key}">
				               	<c:choose>
				                	<c:when test="${dibs.value eq 'Y'}">
				                		<span><button class="dibs-button" name="dibs" value="${dibs.key}Y">
										<img src="<%= request.getContextPath() %>/images/dibs/redheart.png"></button></span>
									</c:when>
									<c:when test="${dibs.value eq 'N'}">
										<span><button class="dibs-button" name="dibs" value="${dibs.key}N">
										<img src="<%= request.getContextPath() %>/images/dibs/whiteheart.png"></button></span>
									</c:when>	
								</c:choose>
							</c:if>	
						</c:forEach>
					<%} %>
			        </form>
			    </div>
			</div>
		</c:forEach>
	</div>
</body>
</html>
