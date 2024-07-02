<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>리뷰신고내역</title>
    <!-- jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- jQuery UI -->
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <!-- jqGrid -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/free-jqgrid/4.15.5/css/ui.jqgrid.min.css">
    <script src="https://cdn.jsdelivr.net/npm/free-jqgrid@4.15.5/js/jquery.jqgrid.min.js"></script>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        .table {
            width: 100%;
            height: 100%;
            display: flex;
            flex-direction: column;
        }
        .ui-jqgrid {
            flex: 1;
        }
    </style>
    <script>
        var data = [
            <c:forEach var="report" items="${reports}" varStatus="status">
            {
            	rpno: '${report.rpno}',
                gname: '${report.gname}',
                rcomment: '${report.rcomment}',
                reason: '${report.reason}',
                status: '${report.status}'
            }<c:if test="${!status.last}">,</c:if>
            </c:forEach>
        ];

        jQuery(document).ready(function($) {
            $("#grid").jqGrid({
                datatype: 'local',
                data: data,
                colModel: [
                	{ label: '신고 번호', name: 'rpno', align: "center" },
                    { label: '해당 상품', name: 'gname', align: "center" },
                    { label: '신고 댓글', name: 'rcomment', align: "left" },
                    { label: '신고 이유', name: 'reason', align: "left" },
                    { label: '처리 여부', name: 'status', align: "right" }
                ],
                viewrecords: true,
                pagerpos: 'center',
                autowidth: true,
                shrinkToFit: false,
                height: "100%",
                rowNum: 10,
                rownumbers: true,
                pager: "#pager",
                caption: "리뷰신고내역"
            });
        });
    </script>
</head>
<body>

      <%@ include file="../main/side.jsp" %>
    <div class="table">
        <table id="grid"></table>
        <div id="pager"></div>
    </div>
</body>
</html>
