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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <style>
        h2{
            text-align: center;
        }
        .test{
            background-color: #428bca;
            height: 100%;
        }
        .test2{
            padding-top: 40px;
            width: 100%;
            text-align: center;
            text-decoration: none;
            margin-right: 25px;
        }
        a{
            color: black;
            position: absolute;
            z-index: 0;
        }



    </style>


</head>
<body>
<div class="test">
<div class="container">
    <caption><h2>List of Coach</h2></caption>
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>NameCoach</th>
            <th>BornYear</th>
            <th>Address</th>
            <th>Salary</th>
        </tr>
        </thead>
        <c:forEach var="coach" items="${listCoach}">
            <tbody>
            <tr>
                <td>${coach.id}</td>
                <td>${coach.nameCoach}</td>
                <td>${coach.bornYear}</td>
                <td>${coach.address}</td>
                <td>${coach.salary}</td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
</div>
    <div class="test2" style="z-index: 1"><a href="admin">Quay lại trang chủ</a></div>
</div>


</body>
</html>
