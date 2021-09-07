<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/3/2021
  Time: 3:34 PM
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
      color: #509B9E;
    }
    .container{
      padding-top: 30px;
    }
  </style>
</head>
<body>
<div class="container">
  <caption><h2>List SalaryWeekofPlayer</h2></caption>
  <table class="table table-striped table-bordered">
    <tr>
      <th>NamePlayer</th>
      <th>Week</th>
      <th>SalaryWeek</th>
    </tr>
    <c:forEach var="salaryofPlayer" items="${listSalary}">
      <tr>
        <td>${salaryofPlayer.namePlayer}</td>
        <td>${salaryofPlayer.week}</td>
        <td>${salaryofPlayer.weekSalary}</td>
      </tr>
    </c:forEach>
  </table>
</div>


</body>
</html>
