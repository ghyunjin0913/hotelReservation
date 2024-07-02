<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
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
         #roomDialog {
            display: none;
        }
        .container {
            display: flex;
            min-height: 100vh;
        }
        .side-panel {
            width: 250px; /* Adjust the width as needed */
            background-color: #f4f4f4; /* Background color for visibility */
        }
        .main-content {
            flex: 1;
            padding: 20px;
        }
        .find-btn {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-top: 20px;
        }
        .find-btn1 {
            margin: 0;
        }
    </style>
<script>
    var data = [
        <c:forEach var="room" items="${rooms}" varStatus="status">
        {
            tcode: '${room.tcode}',
            tname: '${room.tname}',
            max: '${room.max}',
            tprice: '<fmt:formatNumber value="${room.tprice}" pattern="#,###" /> KWR',
            amounts: '${room.amounts}',
            exp: '${room.exp}',
            bedtype: '${room.bedtype}',
            bedno: '${room.bedno}',
            tview: '${room.tview}',
            smoke: '${room.smoke}',
            tsize: '${room.tsize}',
            bathtype: '${room.bathtype}',
            breakfast: '${room.breakfast}'
        }<c:if test="${!status.last}">,</c:if>
        </c:forEach>
    ];

    $(document).ready(function() {
        $("#grid").jqGrid({
            datatype: 'local',
            data: data,
            colModel: [
                { label: '객실명', name: 'tname', align: "center" },
                { label: '인원', name: 'max', align: "right" },
                { label: '가격', name: 'tprice', align: "right" },
                { label: '수량', name: 'amounts', align: "right" },
                { label: '보기', name: 'details', formatter: viewButton, align: "center" }
            ],
            viewrecords: true,
            pagerpos: 'center',
            width: 800,
            shrinkToFit: false,
            height: "auto",
            rowNum: 10,
            rownumbers: true,
            pager: "#pager",
            caption: "객실조회"
        });

        // Initialize jQuery UI Dialog
        $("#roomDialog").dialog({
            autoOpen: false,
            modal: true,
            width: 400
        });

    });

    function viewButton(cellValue, options, rowObject) {
        // Add debug information
        return '<button type="button" class="btn btn-primary" onclick=\'viewDetails(' + JSON.stringify(rowObject) + ')\'>보기</button>';
    }

    function viewDetails(rowData) {
        // Populate the popup with row data
        $('#roomName').text(rowData.tname);
        $('#roomMax').text(rowData.max);
        $('#roomPrice').text(rowData.tprice);
        $('#roomAmount').text(rowData.amounts);
        $('#roomExp').text(rowData.exp);
        $('#roomBedtype').text(rowData.bedtype);
        $('#roomBedno').text(rowData.bedno);
        $('#roomView').text(rowData.tview);
        $('#roomSmoke').text(rowData.smoke);
        $('#roomSize').text(rowData.tsize);
        $('#roomBathtype').text(rowData.bathtype);
        $('#roomBreakfast').text(rowData.breakfast);

        // delete
        $('#tcode').val(rowData.tcode);
        // update
        $('#updateButton').off('click').on('click', function() {
            window.location.href = '/projects/gUpdate?tcode=' + rowData.tcode;
        });
        // Open the popup
        $('#roomDialog').dialog("open");
    }
</script>
</head>

<body>
<%@ include file="../main/side.jsp" %>
	<div class="main-content">
		<h1>객실조회</h1>
		<div class="table">
			<table id="grid"></table>
		    <div id="pager"></div>
		</div>
	</div>
	<div id="roomDialog" title="객실 정보">
	     <div class="content">
	        <p><strong>객실명:</strong> <span id="roomName"></span></p>
	        <p><strong>인원:</strong> <span id="roomMax"></span></p>
	        <p><strong>가격:</strong> <span id="roomPrice"></span></p>
	        <p><strong>수량:</strong> <span id="roomAmount"></span></p>
		    <p><strong>소개:</strong> <span id="roomExp"></span></p>
		    <p><strong>침대종류:</strong> <span id="roomBedtype"></span></p>
		    <p><strong>침대수 :</strong> <span id="roomBedno"></span></p>
		    <p><strong>전망:</strong> <span id="roomView"></span></p>
		    <p><strong>흡연여부:</strong> <span id="roomSmoke"></span></p>
		    <p><strong>객실크기:</strong> <span id="roomSize"></span></p>
		    <p><strong>욕실종류:</strong> <span id="roomBathtype"></span></p>
		    <p><strong>조식여부:</strong> <span id="roomBreakfast"></span></p>

	    </div>
	    <div class="find-btn">
            <button id="updateButton" type="button" class="btn btn-navy navbar-btn find-btn1">수정</button>
	        <form action="/projects/roomsdelete" method="post">
                    <input type="hidden" id="tcode" name="tcode" >
                    <button type="submit" class="btn btn-grey navbar-btn find-btn1"  onClick="window.location.reload();">삭제</button>
            </form>
	    </div>
	    <a href="#none" class="close"><img src="//img.echosting.cafe24.com/skin/base/common/btn_close.png" alt="닫기" /></a>
    </div>
</body>
</html>
