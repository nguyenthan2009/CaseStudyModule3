<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/1/2021
  Time: 2:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Coach</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Coach</h2></caption>
        <tr>
            <th>ID</th>
            <th>NameCoach</th>
            <th>BornYear</th>
            <th>Address</th>
            <th>Salary</th>
        </tr>
        <c:forEach var="coach" items="${listCoach}">
            <tr>
                <td>${coach.id}</td>
                <td>${coach.nameCoach}</td>
                <td>${coach.bornYear}</td>
                <td>${coach.address}</td>
                <td>${coach.salary}</td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>
