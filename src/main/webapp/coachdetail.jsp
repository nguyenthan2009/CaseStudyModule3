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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <style>
        h2{
            text-align: center;
            color: chocolate;
        }
        .container{
            padding-top: 70px;
        }
    </style>
</head>
<body>

<div class="container">
    <caption><h2>Coach detail</h2></caption>
   <table class="table table-dark table-striped">
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
<div class="container">
    <caption><h2>SalaryWeekofCoach</h2></caption>
    <table class="table table-dark table-striped">
        <tr>
            <th>NameCoach</th>
            <th>Week</th>
            <th>SalaryofWeek</th>
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







</body>
</html>
