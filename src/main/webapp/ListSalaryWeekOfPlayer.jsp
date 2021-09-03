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
</head>
<body>
<div align="center">
  <table border="1" cellpadding="5">
    <caption><h2>List SalaryWeekofPlayer</h2></caption>
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
