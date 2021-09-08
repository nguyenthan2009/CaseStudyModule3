<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/6/2021
  Time: 4:35 PM
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
</head>
<body>
<div class="head">
<a href="players?action=detailPlayer&id=${user.id}"> Thông tin cá nhân</a>
</div>
</body>
</html>
