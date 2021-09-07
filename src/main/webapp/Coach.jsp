<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/6/2021
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .head{
            position: fixed;
            top:0;
            left: 0;
            right: 0;
            background-color: chocolate;
            height: 50px;
            z-index: 1;
            text-align: center;
        }
        a{
            text-decoration: none;
            color: white;
            display: inline-block;
            line-height: 50px;
        }
        :hover a{
            color: black;
        }
        h4{
            text-align: center;
        }
        .head a{
            display: inline-block;
            color: white;
            background-color: green;
        }

    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="head">
    <a href="coach?action=coachdetail&id=${user.id}">Thông tin Huấn luận viên</a>
</div>
<div class="body">
<div class="container">
    <div id="products" class="row list-group">
        <c:forEach var="listPlayer1" items="${listPlayer}">
            <div class="item  col-xs-3 col-lg-3">
                <div class="thumbnail"> <img class="group list-group-image" src="${listPlayer1.image}" alt="Sản phẩm 1" style="width: 200px;height: 300px">
                    <div class="caption">
                        <h4 class="group inner list-group-item-heading">${listPlayer1.namePlayer} </h4>
                        <p class="group inner list-group-item-text"> </p>
                        <div class="row">
                            <div class="col-xs-12 col-md-6" style="position: relative;left: 80px"> <a class="btn btn-success" href="admin?action=playerDetail&id=${listPlayer1.id}">Chi tiết</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</div>

</body>
</html>
