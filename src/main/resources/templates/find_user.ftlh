<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<div class="limiter">
    <div id="header-wrapper">
        <div id="header" class="container">
            <div id="logo">
                <h1><a href="#">LinkedIn</a></h1>
            </div>
        </div>
    </div>
    <form action="/findUser" method="post">
    <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Find Users by skill" aria-label="Recipient's username" aria-describedby="button-addon2" name="skill_name">
        <div class="input-group-append">
            <input class="btn btn-outline-secondary" type="submit" id="button-addon2" value="search">
        </div>
    </div>
    </form>
    <#if users??>
    <#list users as user>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">${user.name}</h5>
            <p class="card-text">${user.email}</p>
            <a href="/user/${user.id}" class="btn btn-primary">Go in profile</a>
        </div>
    </div>
    </#list>
    </#if>
</div>
<a href="/" class="btn btn-primary">Back</a>
</body>
</html>