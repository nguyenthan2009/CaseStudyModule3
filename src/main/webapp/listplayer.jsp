<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 9/2/2021
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Player</title>
</head>
<body>
<center>
    <h1>List Players</h1>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Born Year</th>
            <th>Address</th>
            <th>Position</th>
            <th>Salary</th>
            <th>Status</th>
            <th>Image</th>
            <th>details</th>
        </tr>
        <c:forEach var="user" items="${listPlayers}">
            <tr>
                <td>${user.id}</td>
                <td>${user.namePlayer}</td>
                <td>${user.bornYear}</td>
                <td>${user.address}</td>
                <td>${user.playPossition}</td>
                <td>${user.salary}</td>
                <td>${user.status}</td>
                <td><img src ="${user.image}" alt="Không thể load ảnh" style="width: 50px;height: 60px"></td>
                    <%--                <td>--%>
                    <%--                    <a href="/users?Homepage=edit&id=${user.id}">Edit</a>--%>
                    <%--                    <a href="/users?Homepage=delete&id=${user.id}">Delete</a>--%>
                    <%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>