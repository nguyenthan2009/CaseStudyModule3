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
            padding-left: 180px;
            color: chocolate;
        }
        .btn{
            margin-left: 320px;
            background-color: green;
        }
        .form-group{
            color: chocolate;
        }
       .form{
           float:left;
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
    <h2>Add Player&&userPlayer</h2>
    <form method="post" id="loginForm">
        <div class="form">
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-group">
            <label for="fullname">FullName:</label>
            <input type="text" class="form-control" id="fullname" placeholder="Enter fullname" name="fullname">
        </div>
        <div class="form-group">
            <label for="bornYear">BornYear</label>
            <input type="text" class="form-control" id="bornYear" placeholder="Enter bornyear" name="bornYear">
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input type="text" class="form-control" id="address" placeholder="Enter address" name="address">
        </div>
        <div class="form-group">
            <label for="salary">Salary</label>
            <input type="text" class="form-control" id="salary" placeholder="Enter salary" name="salary">
        </div>
          <div class="form-group">
              <label for="role">Role</label>
            <select id="role" name="role">
                <option value="player">Player</option>
                <option value="coach">Coach</option>
            </select>
          </div>
        </div>
        <div class="form">
            <div class="form-group">
                <label for="status">Status</label>
                <input type="text" class="form-control" id="status" placeholder="Enter status" name="status">
            </div>
            <div class="form-group">
                <label for="image">Image</label>
                <input type="text" class="form-control" id="image" placeholder="Enter image" name="image">
            </div>
            <div class="form-group">
                <label for="height">Height</label>
                <input type="text" class="form-control" id="height" placeholder="Enter height" name="height">
            </div>
            <div class="form-group">
                <label for="weight">Weight</label>
                <input type="text" class="form-control" id="weight" placeholder="Enter weight" name="weight">
            </div>
            <div class="form-group">
                <label for="bmiIndex">bmiIndex</label>
                <input type="text" class="form-control" id="bmiIndex" placeholder="Enter bmiIndex" name="bmiIndex">
            </div>
            <div class="form-group">
                <label for="formIndex">formIndex</label>
                <input type="text" class="form-control" id="formIndex" placeholder="Enter formIndex" name="formIndex">
            </div>
            <div class="form-group">
                <label for="position">Position</label>
                <select id="position" name="position">
                    <option value="Tien dao">Tien dao</option>
                    <option value="Tien ve">Tien ve</option>
                    <option value="Trung ve">Trung ve</option>
                    <option value="Hau ve">Hau ve</option>
                    <option value="Thu mon">Thu mon</option>
                </select>
            </div>
        </div>
        <button type="Add" class="btn btn-default">Submit</button>
    </form>
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true
                },
                password: {
                    required: true,
                    minlength: 6
                }
            },
            messages: {
                email: {
                    required: "The email is required!",
                },
                password: {
                    required: "Please provide a password",
                    minlength: "Your password must be at least 6 characters long"
                },
            }
        });
    });

</script>



</body>
</html>