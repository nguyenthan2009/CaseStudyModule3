<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        .form-control {
            width: 400px;
            box-shadow: 0px 8px 9px 0px rgba(69, 69, 69, 0.25);
        }

        .container {
            padding-left: 300px;
            padding-top: 100px;
        }

        h2 {
            padding-left: 180px;
            color: chocolate;
        }

        .btn {
            margin-left: 320px;
            background-color: green;
        }

        .form-group {
            color: chocolate;
        }

        .form {
            float: left;
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
    <h2>EDIT PLAYER</h2>
    <form method="post" >
        <div class="form">

            <div class="form-group">
                <label for="namePlayer">FullName:</label>
                <input type="text" class="form-control" id="namePlayer" value="<c:out value='${player.namePlayer}' />" name="namePlayer">
            </div>
            <div class="form-group">
                <label for="bornYear">BornYear</label>
                <input type="text" class="form-control" id="bornYear" value="<c:out value='${player.bornYear}' />"  name="bornYear">
            </div>
            <div class="form-group">
                <label for="address">Address</label>
                <input type="text" class="form-control" id="address" value="<c:out value='${player.address}' />" name="address">
            </div>
            <div class="form-group">
                <label for="salary">Salary</label>
                <input type="text" class="form-control" id="salary" value="<c:out value='${player.salary}' />" name="salary">
            </div>
            <div class="form-group">
                <label for="status">Status</label>
                <input type="text" class="form-control" id="status"  value="<c:out value='${player.status}' />" name="status">
            </div>
            <div class="form-group">
                <label for="image">Image</label>
                <input type="text" class="form-control" id="image" value="<c:out value='${player.image}'/>" name="image">
            </div>

        </div>
        <div class="form">
            <div class="form-group">
                <label for="position">Position</label>
                <input type="text" class="form-control" id="position" value="<c:out value='${player.playPossition}'/>" name="position">
            </div>
            <div class="form-group">
                <label for="height">Height</label>
                <input type="text" class="form-control" id="height" value="<c:out value='${playerStats.height}'/>" name="height">
            </div>
            <div class="form-group">
                <label for="weight">Weight</label>
                <input type="text" class="form-control" id="weight" value="<c:out value='${playerStats.weight}'/>" name="weight">
            </div>
            <div class="form-group">
                <label for="bmiIndex">bmiIndex</label>
                <input type="text" class="form-control" id="bmiIndex" value="<c:out value='${playerStats.bmiIndex}'/>" name="bmiIndex">
            </div>
            <div class="form-group">
                <label for="formIndex">formIndex</label>
                <input type="text" class="form-control" id="formIndex" value="<c:out value='${playerStats.formIndex}'/>" name="formIndex">
            </div>
        </div>
        <button type="Add" class="btn btn-default">Submit</button>
    </form>
</div>
<script type="text/javascript">


</script>


</body>
</html>