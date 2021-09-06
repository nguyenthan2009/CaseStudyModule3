<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/6/2021
  Time: 3:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .b{
            float: left;
            margin-left: 40px;
        }
    </style>
</head>
<body>
<div class="a">
    <div class="b">
   <table border="1" cellpadding="5">
     <caption><h2>Coach detail</h2></caption>
    <tr>
        <th>ID</th>
        <th>NameCoach</th>
        <th>BornYear</th>
        <th>Address</th>
        <th>Salary</th>
    </tr>
        <tr>
            <td>${coachdetail.id}</td>
            <td>${coachdetail.nameCoach}</td>
            <td>${coachdetail.bornYear}</td>
            <td>${coachdetail.address}</td>
            <td>${coachdetail.salary}</td>
        </tr>
   </table>
    </div>
    <div class="b">
    <table border="1" cellpadding="5">
        <caption><h2>SalaryWeekofCoach</h2></caption>
        <tr>
            <th>NameCoach</th>
            <th>Week</th>
            <th>Salary</th>
        </tr>

     <c:forEach var="salaryofWeek" items="${salaryofWeek}">
        <tr>
            <td>${salaryofWeek.nameCoach}</td>
            <td>${salaryofWeek.week}</td>
            <td>${salaryofWeek.weekSalary}</td>

        </tr>
     </c:forEach>
    </table>
    </div>
</div>






</body>
</html>
