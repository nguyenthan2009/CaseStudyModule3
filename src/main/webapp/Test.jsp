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
    h4{
        text-align: center;
    }
   .btn {
       margin-right: 30px;
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
    }
    .body{
        margin-top: 46px;
    }
    .head{
        position: fixed;
        top:0;
        left: 0;
        right: 0;
        background-color: chocolate;
        height: 50px;
        z-index: 1;
    }
    li{
        float: left;
        display: inline-block;
        padding-left: 30px;
        text-decoration: none;
    }
   ul li a{
       text-decoration: none;
        color: white;
        display: inline-block;
        line-height: 50px;
    }
   li:hover a{
       color: black;
   }


    a{
        color:#f9398c;
        text-decoration:none
    }

    a:hover,a:focus{
        color:#f9398c;
        text-decoration:underline
    }

    a:focus,
    .btn:focus {
        outline: none;
    }

    .img-responsive {
        border: 1px solid #ddd;
    }

    /*-----------------------
    ----- Typo Styles ------
    -------------------------*/
    h1,h2,h3,h4,h5,h6,.h1,.h2,.h3,.h4,.h5,.h6{
        font-weight:300;
    }

    .big-text{
        font-size:58px;
        font-weight:300;
        line-height:62px;
        letter-spacing:0.01em;
        word-spacing: 0.15em;
        text-transform:uppercase;
    }

    .section-title{
        margin-top:-20px;
        margin-bottom: 80px;
        text-align:center;
    }

    /*-----------------------
    ----- Layout Styles -----
    -------------------------*/

    .add-padding {
        padding-top:50px;
        padding-bottom:50px;
    }

    /*-----------------------
    ----- Color Styles ------
    -------------------------*/

    .bg-color1{
        color:#fff;
        background:#509B9E;
    }

    .bg-color2{
        color:#fff;
        background:#f9398c;
    }

    .bg-color3{
        color:#fff;
        background:#334959;
    }

    .border-bottom-color2{
        border-bottom:7px solid #f9398c;
    }

    .border-top-color2{
        border-top:7px solid #f9398c;
    }

    .color1 .service-icon,
    .color1.service-item ul li:nth-child(2):before{
        background:#509B9E;
    }

    .color1 .service-icon:after{
        border:3px solid #509B9E;
    }

    .color2 .service-icon,
    .color2.service-item ul li:nth-child(2):before{
        background:#f9398c;
    }

    .color2 .service-icon:after{
        border:3px solid #f9398c;
    }

    .color3 .service-icon,
    .color3.service-item ul li:nth-child(2):before{
        background:#334959;
    }

    .color3 .service-icon:after{
        border:3px solid #334959;
    }

    /*------------------
    ----- Buttons ------
    --------------------*/

    .btn-color1,
    .btn-color2{
        padding: 10px 30px;
        color:#fff;
        font-size: 21px;
        font-weight: 300;
        background:#f9398c;
        outline: none !important;
        border-radius: 0;
        transition: opacity .2s ease-out;
    }

    .btn-color1{
        background:#509B9E;
    }

    .btn-color1:hover,
    .btn-color2:hover{
        color:#fff;
        opacity: 0.9;
    }

    .btn-color1:focus,
    .btn-color1:active,
    .btn-color2:focus,
    .btn-color2:active{
        color:#fff;
    }

    .btn-color1 .fa,
    .btn-color2 .fa{
        margin-right: 15px;
    }

    /*----------------------
    ----- Contact Styles ----
    ------------------------*/

    #contact{
        background-repeat:no-repeat;
        background-position:0 100%;
        background-color: #fff;
    }

    #contact-form .form-group label{
        display:none;
        font-size:18px;
        line-height:24px;
        font-weight:100;
        text-transform:uppercase;
    }

    #contact-form.no-placeholder .form-group label{
        display:block;
    }

    #contact-form .controls {
        padding:0;
        margin-bottom:30px;
        border:1px solid #ddd;
        border-radius:2px;
    }

    #contact-form .form-control {
        background:transparent !important;
        border:none;
        border-bottom:3px solid transparent;
        border-radius:0;
        outline:none;
        box-shadow:none;
        height:56px;
        font-size:21px;
        line-height:32px;
        font-weight:100;
        padding-left:64px;
        -webkit-transition:border-color .3s ease-out;
        transition:border-color .3s ease-out;
        border-radius:2px;
    }

    #contact-form .form-group{
        position:relative;
    }

    #contact-form .form-group [class*=fa] {
        display:block;
        width:64px;
        position:absolute;
        top:0;
        left:5px;
        color:#e5e5e5;
        font-size:24px;
        line-height:53px;
        text-align:center;
        font-weight:300;
        opacity:0.5;
        transition:opacity .2s ease-out;
    }

    #contact-form.no-placeholder .form-group [class*=fa]{
        top:30px;
    }

    #contact-form .form-control:focus + [class*=fa]{
        opacity:1;
    }

    #contact-form textarea.form-control {
        height:auto;
        max-width:100%;
        min-width:100%;
        font-size:21px;
        line-height:32px;
        padding-top:10px;
    }

    #contact-form .form-control:focus {
        background:#fff;
        border-bottom:3px solid #f9398c;
        outline:none;
        box-shadow:none;
        -webkit-transition:border-color .3s ease-in;
        transition:border-color .3s ease-in;
    }

    #contact-form .error-message {
        padding:5px 0;
        position:absolute;
        top:-30px;
        right:0;
        font-size:14px;
        font-weight:300;
        color:#ff0000;
        z-index:10;
    }

    #contact-form .error-message:before {
        content:"\00d7";
        font-size: 21px;
        line-height: 21px;
        margin-right: 5px;
    }

    /*----------------------
    ----- Footer Styles ----
    ------------------------*/

    #main-footer {
        background: #fff;
    }

    #main-footer p a {
        padding-bottom: 40px;
        font-size: 25px;
        text-decoration: none;
    }

    #main-footer p {
        text-align: center;
    }

    .social-links {
        list-style:none;
        margin:0;
        padding:0;
        margin-bottom:30px;
    }

    .social-links li{
        display:inline-block;
        margin:0 5px;
        border-radius:3px;
        box-shadow:0 4px 0 transparent;
        -webkit-transition:all .3s ease-out;
        transition:all .3s ease-out;
    }

    .social-links li a {
        display:block;
        color:#fff;
        font-size:21px;
        width:50px;
        height:50px;
        line-height:50px;
        text-align:center;
        background:#509B9E;
        border-radius:50%;
        -webkit-transition:all .3s ease-out;
        transition:all .3s ease-out;
    }

    .social-links li a:hover {
        color:#fff;
        background:#f9398c;
    }
    #nav3 li:hover .nav {
        display: block;
    }
    .nav{
        position: absolute;
        background-color: #cccccc;
        display: none;
    }
    .nav li {
        display:block;
        width: 100%;
        text-align: center;
        padding-right: 20px;
    }
    #nav3  li{
        position: relative;

    }
    #nav3 .nav li:hover{
        color: black;
        background-color: #ccc;
    }

    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.11.1.min.js"></script>

</head>
<body>
<div class="head">
   <ul id="nav3">
       <li><a href="admin?action=listPlayer">Danh sách cầu thủ</a></li>
       <li><a href="admin?action=listCoach">Danh sách huấn luận viên</a> </li>
       <li><a href="admin?action=salaryWeekofPlayer">Lương cầu thủ theo tuần</a>
           <ul class="nav">
               <li><a href="admin?action=salaryWeekofPlayer&week=1">  Tuần 1</a></li>
               <li><a href="admin?action=salaryWeekofPlayer&week=2">  Tuần 2</a></li>
               <li><a href="admin?action=salaryWeekofPlayer&week=3">  Tuần 3</a></li>
           </ul>
       </li>
       <li><a href="admin?action=salaryWeekofCoach">Lương huấn luận viên theo tuần</a>
            <ul class="nav">
                <li><a href="admin?action=salaryWeekofCoach&week=1"> Lương tuần 1</a></li>
                <li><a href="admin?action=salaryWeekofCoach&week=2"> Lương tuần 2</a></li>
                <li><a href="admin?action=salaryWeekofCoach&week=3"> Lương tuần 3</a></li>
            </ul>
       </li>
       <li><a href="admin?action=newPlayer">Thêm cầu thủ</a> </li>
       <li><a href="admin?action=newCoach">Thêm huấn luận viên</a> </li>
       <li><a href="admin?action=login">Đăng xuất</a> </li>
   </ul>
</div>
<div class="body">
<div class="container">

    <div class="well well-sm text-right"> <strong> Thưởng </strong>
        <div class="btn-group"> <a href="admin?action=weekOfPlayer" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list"> </span>Thưởng lương cầu thủ theo tuần</a> <a href="admin?action=weekOfCoach" id="grid" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th"></span>Thưởng lương huấn luận viên theo tuần</a>
        </div>
        <strong> Hiển thị</strong>
        <div class="btn-group"> <a href="admin?action=ChartofTeam" id="list1" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list"> </span>Biểu đồ lương đội bóng</a> <a href="admin?action=ChartofCoach" id="grid1" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th"></span>Biểu đồ lương huấn luận viên</a>
        </div>
    </div>
    <h3> Cầu thủ nổi bật</h3>
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
<!-- ==============================================
    CONTACT
    =============================================== -->
<section id="contact" class="add-padding border-top-color2">

    <div class="container text-center">

        <div class="row">

            <div class="col-sm-6 col-md-5 text-right scrollimation fade-up d1">

                <h1 class="big-text">Contact Me</h1>

                <p class="lead">FootBallTeam<br>Team Manager</p>

                <p>

                <p>Please feel free to contact me with questions, comments or collaborations.</p>

                <p>For more information, <a href="http://korenlc.com" target="_blank">visit my blog.</a></p>

            </div>

            <!--=== Contact Form ===-->

            <form id="contact-form" class="col-sm-6 col-md-offset-1 scrollimation fade-left d3" action="contact.php" method="post" novalidate>

                <div class="form-group">
                    <label class="control-label" for="contact-name">Name</label>
                    <div class="controls">
                        <input id="contact-name" name="contactName" placeholder="Your name" class="form-control requiredField" data-new-placeholder="Your name" type="text" data-error-empty="Please enter your name">
                        <i class="fa fa-user"></i>
                    </div>
                </div><!-- End name input -->

                <div class="form-group">
                    <label class="control-label" for="contact-mail">Email</label>
                    <div class=" controls">
                        <input id="contact-mail" name="email" placeholder="Your email" class="form-control requiredField" data-new-placeholder="Your email" type="email" data-error-empty="Please enter your email" data-error-invalid="Invalid email address">
                        <i class="fa fa-envelope"></i>
                    </div>
                </div><!-- End email input -->

                <div class="form-group">
                    <label class="control-label" for="contact-message">Message</label>
                    <div class="controls">
                        <textarea id="contact-message" name="comments"  placeholder="Your message" class="form-control requiredField" data-new-placeholder="Your message" rows="6" data-error-empty="Please enter your message"></textarea>
                        <i class="fa fa-comment"></i>
                    </div>
                </div><!-- End textarea -->

                <p><button name="submit" type="submit" class="btn btn-color2 btn-block" data-error-message="Error!" data-sending-message="Sending..." data-ok-message="Message Sent"><i class="fa fa-paper-plane"></i>Send Message</button></p>
                <input type="hidden" name="submitted" id="submitted" value="true" />

            </form><!-- End contact-form -->

        </div>

    </div>

</section>

<!-- ==============================================
FOOTER
=============================================== -->

<footer id="main-footer" class="add-padding border-top-color2">

    <div class="container">

        <p><a href="http://korenlc.com" target="_blank">VISIT MY BLOG</a></p><br>

        <ul class="social-links text-center">
            <li><a href="https://twitter.com/korenlc" target="_blank"><i class="fa fa-twitter fa-fw"></i></a></li>
            <li><a href="https://plus.google.com/u/0/+KLCohen/posts/p/pub" target="_blank"><i class="fa fa-google-plus fa-fw"></i></a></li>
            <li><a href="https://www.linkedin.com/in/korenlesliecohen" target="_blank"><i class="fa fa-linkedin fa-fw"></i></a></li>
        </ul>

        <p class="text-center">&copy; 2014 - Koren Leslie Cohen</p>

    </div>

</footer>

<script type="text/javascript">
    $(document).ready(function() {
        $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
        $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');
            $('#products .item').addClass('grid-group-item');
        });
    });</script>

</body>
</html>
