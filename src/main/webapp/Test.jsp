<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 9/3/2021
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">body{
        font-family:Arial, Helvetica, sans-serif;
        font-size:12px;
    }
    .glyphicon {
        margin-right:5px;
    }
    .thumbnail {
        margin-bottom: 20px;
        padding: 0px;
        -webkit-border-radius: 0px;
        -moz-border-radius: 0px;
        border-radius: 0px;
    }
    .item.list-group-item {
        float: none;
        width: 100%;
        background-color: #fff;
        margin-bottom: 10px;
    }
    .item.list-group-item:nth-of-type(odd):hover, .item.list-group-item:hover {
        background: #428bca;
    }
    .item.list-group-item .list-group-image {
        margin-right: 10px;
    }
    .item.list-group-item .thumbnail {
        margin-bottom: 0px;
    }
    .item.list-group-item .caption {
        padding: 9px 9px 0px 9px;
    }
    .item.list-group-item:nth-of-type(odd) {
        background: #eeeeee;
    }
    .item.list-group-item:before, .item.list-group-item:after {
        display: table; content:"";
    }
    .item.list-group-item img {
        float: left;
    }
    .item.list-group-item:after {
        clear: both;
    }
    .list-group-item-text {
        margin: 0 0 11px;
    }</style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
<c:forEach var="listPlayer1" items="${listPlayer}">
<div class="container">
    <h3> Sản phẩm nổi bật</h3>
    <div class="well well-sm text-right"> <strong>Chọn kiểu hiển thị</strong>
        <div class="btn-group"> <a href="http://hocwebgiare.com/#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list"> </span>Dạng danh sách</a> <a href="http://hocwebgiare.com/#" id="grid" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th"></span>Dạng lưới</a>
        </div>
    </div>
    <div id="products" class="row list-group">
        <div class="item  col-xs-3 col-lg-3">
            <div class="thumbnail"> <img class="group list-group-image" src="${listPlayer1.image}" alt="Sản phẩm 1" width="300">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">${listPlayer1.namePlayer} </h4>
                    <p class="group inner list-group-item-text"> Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead"> 200.000 đ</p>
                        </div>
                        <div class="col-xs-12 col-md-6"> <a class="btn btn-success" href="http://hocwebgiare.com/">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-3 col-lg-3">
            <div class="thumbnail"> <img class="group list-group-image" src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/product/images/2.jpg" alt="Sản phẩm 2" width="300">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading"> Sản phẩm 2</h4>
                    <p class="group inner list-group-item-text"> Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead"> 200.000 đ</p>
                        </div>
                        <div class="col-xs-12 col-md-6"> <a class="btn btn-success" href="http://hocwebgiare.com/">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-3 col-lg-3">
            <div class="thumbnail"> <img class="group list-group-image" src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/product/images/3.jpg" alt="Sản phẩm 3" width="300">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading"> Sản phẩm 3</h4>
                    <p class="group inner list-group-item-text"> Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead"> 200.000 đ</p>
                        </div>
                        <div class="col-xs-12 col-md-6"> <a class="btn btn-success" href="http://hocwebgiare.com/">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-3 col-lg-3">
            <div class="thumbnail"> <img class="group list-group-image" src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/product/images/4.jpg" alt="Sản phẩm 4" width="300">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading"> Sản phẩm 4</h4>
                    <p class="group inner list-group-item-text"> Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,  sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead"> 200.000 đ</p>
                        </div>
                        <div class="col-xs-12 col-md-6"> <a class="btn btn-success" href="http://hocwebgiare.com/">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-3 col-lg-3">
            <div class="thumbnail"> <img class="group list-group-image" src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/product/images/5.jpg" alt="Sản phẩm 5" width="300">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading"> Sản phẩm 5</h4>
                    <p class="group inner list-group-item-text"> Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,  sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead"> 200.000 đ</p>
                        </div>
                        <div class="col-xs-12 col-md-6"> <a class="btn btn-success" href="http://hocwebgiare.com/">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-3 col-lg-3">
            <div class="thumbnail"> <img class="group list-group-image" src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/product/images/6.jpg" alt="Sản phẩm 6" width="300">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading"> Sản phẩm 6</h4>
                    <p class="group inner list-group-item-text"> Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">200.000 đ</p>
                        </div>
                        <div class="col-xs-12 col-md-6"> <a class="btn btn-success" href="http://hocwebgiare.com/">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-3 col-lg-3">
            <div class="thumbnail"> <img class="group list-group-image" src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/product/images/7.jpg" alt="Sản phẩm 7" width="300">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading"> Sản phẩm 7</h4>
                    <p class="group inner list-group-item-text"> Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">200.000 đ</p>
                        </div>
                        <div class="col-xs-12 col-md-6"> <a class="btn btn-success" href="http://hocwebgiare.com/">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item  col-xs-3 col-lg-3">
            <div class="thumbnail"> <img class="group list-group-image" src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/product/images/8.jpg" alt="Sản phẩm 8" width="300">
                <div class="caption">
                    <h4 class="group inner list-group-item-heading"> Sản phẩm 8</h4>
                    <p class="group inner list-group-item-text"> Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">200.000 đ</p>
                        </div>
                        <div class="col-xs-12 col-md-6"> <a class="btn btn-success" href="http://hocwebgiare.com/">Chi tiết</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</c:forEach>
<script type="text/javascript">
    $(document).ready(function() {
        $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
        $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');
            $('#products .item').addClass('grid-group-item');
        });
    });</script>

</body>
</html>
