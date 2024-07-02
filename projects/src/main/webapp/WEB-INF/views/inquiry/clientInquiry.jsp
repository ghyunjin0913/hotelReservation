<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
        width: 800px;
        height: 100px;
        margin: auto;
    }
    input[type="button"] {
        background-color: #4CAF50;
        border: none;
        color: white;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
    }
    input[type="button"]:hover {
        background-color: #45a049;
    }
</style>
<script>
	    var data = [
	        <c:forEach var="iList" items="${iList}">
	        {
	        	ino: '${iList.ino}',
	        	id: '${iList.id}',
	        	title: '${iList.title}',
	        	istatus: '${iList.status}',
	        	registerDate: '${iList.registerDate}'
	        }<c:if test="${!status.last}">,</c:if>
	        </c:forEach>
	    ];
	
	    $(document).ready(function($) {
	        $("#grid").jqGrid({
	            datatype: 'local',
	            data: data,
	            colModel: [
	                { label: '문의번호', name: 'ino', align: "center" },
	                { label: '작성자', name: 'id', align: "right" },
	                { label: '제목', name: 'title', align: "right",
	                  formatter: function(cellValue, options, rowObject) {
	                      return '<a href="#" class="title-link" data-ino="' + rowObject.ino + '">' + cellValue + '</a>';
	                  }
	                },
	                { label: '문의상태', name: 'istatus', align: "right" },
	                { label: '등록일자', name: 'registerDate', align: "center" }
	            ],
	            viewrecords: true,
	            pagerpos: 'center',
	            autowidth: true,
	            shrinkToFit: false,
	            height: "auto",
	            rowNum: 10,
	            rownumbers: false,
	            pager: "#pager",
	            caption: "문의내역"
	        });

	        // '제목' 클릭 이벤트 처리
	        $("#grid").on("click", ".title-link", function(event) {
	            event.preventDefault();
	            var ino = $(this).data("ino");
	            location.href = "/projects/showInquiry?ino=" + encodeURIComponent(ino);
	        });
	    });
	
	</script>
</head>
<body>
  <%@ include file="../main/side.jsp" %>
<h2>나의 문의 내역</h2>
<div class="table">
    <table id="grid"></table>
    <div id="pager"></div>
    <input type="button" value="글쓰기" onclick="location.href='/projects/writeBoard'">
</div>


</body>
</html>