<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>
<body>
<form action="/findVacancy" method="post">
    <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Find Vacancy" aria-label="Recipient's username" aria-describedby="button-addon2" name="name" id="name">
        <div class="input-group-append">
            <input class="btn btn-outline-secondary" type="submit" id="button-addon2" value="search">
        </div>
    </div>
</form>
    <#if vacancies??>
        <#list vacancies as vacancy>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">${vacancy.name}</h5>
            <p class="card-text">${vacancy.description}</p>
            <p class="card-text">Company: ${vacancy.company.getName()}</p>
        </div>
    </div>
        </#list>
    </#if>
<a href="/" class="btn btn-primary">Back</a>
</body>
</html>