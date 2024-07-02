<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>객실조회</title>
	<!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- jQuery UI -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <!-- jqGrid -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/css/ui.jqgrid.min.css">
    <script src="https://cdn.jsdelivr.net/npm/free-jqgrid@4.15.5/js/jquery.jqgrid.min.js"></script>
    <style>
        .ui-jqgrid {
            width: auto;
        }
        .table {
        	width : 100px;
			height : 100px;
			margin: auto;
        }
        
    </style>
	<script>
	    var data = [
	        <c:forEach var="hotel" items="${hotels}" varStatus="status">
	        {
	        	hid: '${hotel.hid}',
	        	hpw: '${hotel.hpw}',
	        	hname: '${hotel.hname}',
	        	grade: '${hotel.grade}',
	        	location: '${hotel.location}',
	        	hmail: '${hotel.hmail}',
	        	hphone: '${hotel.hphone}',
	        	hdate: '${hotel.hdate}'
	        }<c:if test="${!status.last}">,</c:if>
	        </c:forEach>
	    ];
	
	    jQuery(document).ready(function($) {
	        $("#grid").jqGrid({
	            datatype: 'local',
	            data: data,
	            colModel: [
	                { label: '업체코드', name: 'hid', align: "center" },
	                { label: '비밀번호', name: 'hpw', align: "right" },
	                { label: '호텔명', name: 'hname', align: "right" },
	                { label: '등급', name: 'grade', align: "right" },
	                { label: '위치', name: 'location', align: "center" },
	                { label: '이메일', name: 'hmail', align: "left" },
	                { label: '연락처', name: 'hphone', align: "right" },
	                { label: '등록일자', name: 'hdate', align: "right", formatter: 'date', formatoptions: { newformat: 'Y-m-d' }  }
	            ],
	            viewrecords: true,
	            pagerpos: 'center',
	            autowidth: true,
	            shrinkToFit: false,
	            height: "auto",
	            rowNum: 10,
	            rownumbers: true,
	            pager: "#pager",
	            caption: "업체조회"
	        });
	    });
	
	</script>
</head>
<body>
	<%@ include file="../manage/adminMain.jsp" %>
	<form action="/projects/hotelSearch" method="post">
		<div class="search-bar">
			<select id="type" name="type" required>
			    <option value="hid" <c:if test="${param.type == 'hid'}">selected</c:if>>업체코드</option>
			    <option value="hname" <c:if test="${param.type == 'hname'}">selected</c:if>>업체명</option>
			</select>
			<input type="text" id="keyword" name="keyword" value="${param.keyword}" required>
			<input type="submit" value="검색" >
		</div>
	</form>
    <div class="table">
        <table id="grid"></table>
        <div id="pager"></div>
    </div>
</body>
</html>
