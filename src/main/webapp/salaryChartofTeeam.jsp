<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/3/2021
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <title>Title</title>
<style>
    .chart-layout{
        margin :36px auto 0 auto;
        padding : 32px 0;
        height: 320px;
        background-color: #fff;
        display: flex;
        align-items: flex-end;
    }
    .chart_layout_item{
        width: 60px;
        color: #fff;
        text-align: center;
        background-color: green;
        height: var(--percent);

    }
    .clounm{
        margin-left: 50px;
    }

</style>
</head>
<body>
<div class ="chart-layout">
    <c:forEach var="chartList" items="${chartList}">
        <div class="clounm">
            <div class="chart_layout_item" style="--percent: ${chartList.percent}% "> ${chartList.salaryofWeek}</div>
            <label> Tuần ${chartList.week}</label>
            <label> pHẦN TRĂM ${chartList.percent}</label>
        </div>

    </c:forEach>
</div>

</script>

</body>
</html>
