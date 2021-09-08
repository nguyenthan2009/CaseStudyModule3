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
        .bubble-legend-symbol{
            margin-left: 340px;
            background-color: red;
            color: white;
        }
        .bubble-legend-symbol1{
            margin-left: 320px;
            background-color: forestgreen;
        }
        a{
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>

<div class="container">
    <caption><h2>Player detail</h2></caption>
    <table class="table table-dark table-striped">
        <tr>
            <th>NamePlayer</th>
            <th>BornYear</th>
            <th>Address</th>
            <th>Position</th>
            <th>Salary</th>
            <th>Status</th>
        </tr>
        <tr>
            <td>${player.namePlayer}</td>
            <td>${player.bornYear}</td>
            <td>${player.address}</td>
            <td>${player.playPossition}</td>
            <td>${player.salary}</td>
            <td>${player.status}</td>
        </tr>
    </table>
</div>
<div class="container">
    <caption><h2>StatsOfPlayer</h2></caption>
    <table class="table table-dark table-striped">
        <tr>
            <th>Height</th>
            <th>Weight</th>
            <th>bmiIndex</th>
            <th>formIndex</th>
        </tr>
            <tr>
                <td>${playerstats.height}</td>
                <td>${playerstats.weight}</td>
                <td>${playerstats.bmiIndex}</td>
                <td>${playerstats.formIndex}</td>
            </tr>
    </table>
</div>
<div class="container">
    <caption><h2>SalaryWeekofPlayer</h2></caption>
    <table class="table table-dark table-striped">
        <tr>
            <th>namePlayer</th>
            <th>Week</th>
            <th>SalaryofWeek</th>

        </tr>
        <tr>
            <td>${weekSaralyofPlayer.namePlayer}</td>
            <td>${weekSaralyofPlayer.week}</td>
            <td>${weekSaralyofPlayer.weekSalary}</td>

        </tr>
    </table>
</div>
<button class="bubble-legend-symbol"><a href="admin?action=deletePlayer&id=${player.id}">Xoá cầu thủ</a> </button>
<button class="bubble-legend-symbol1"><a href="admin?action=updatePlayerInfo&id=${player.id}">Sửa cầu thủ</a> </button>







</body>
</html>
