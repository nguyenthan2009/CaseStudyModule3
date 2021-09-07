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
        width: 90px;
        color: #fff;
        text-align: center;
        background-color: green;
        height: var(--percent);

    }
    .chart_layout_item1{
        width: 90px;
        color: #fff;
        text-align: center;
        background-color: green;
        height: var(--percent);
        margin-left: 32px;
    }
    .clounm{
        margin-left: 50px;
    }
    h1{
        padding-left: 200px;
        color: chocolate;
    }

</style>
</head>
<body>
<h1>Chart SalaryOfTeam</h1>
<div class ="chart-layout">
    <c:forEach var="chartList" items="${chartList}">
        <div class="clounm">
            <div class="chart_layout_item" style="--percent: ${chartList.percent}% "> ${chartList.salaryofWeek}</div>
            <label> Tuần ${chartList.week}(${chartList.percent}%)</label>
        </div>
    </c:forEach>
    <div class="chart_layout_item1" style="--percent: 100% "> ${total}</div>
    <label>Total(100%)</label>
</div>

</script>

</body>
</html>
