<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .form-control{
            width: 400px;
            box-shadow: 0px 8px 9px 0px rgba(69, 69, 69, 0.25);
        }
        .container{
            padding-left: 300px;
            padding-top: 100px;
        }
        h2{
            padding-left: 70px;
            color: chocolate;
        }
        .btn{
            margin-left: 150px;
            background-color: green;
        }
        .form-group{
            color: chocolate;
        }
        .checkbox{
            color: chocolate;
        }
    </style>
</head>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript"
        src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
<body>

<div class="container">
    <h2>SearchPlayerByName</h2>
    <form method="post" id="loginForm">
        <div class="form-group">
            <label for="email">NamePlayer</label>
            <input type="text" class="form-control" id="email" placeholder="Enter email" name="namePlayer">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>
