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
<ul class="list-group">
    <li class="list-group-item">Name: ${user.name}</li>
    <li class="list-group-item">Email: ${user.email}</li>
    <li class="list-group-item">Education: ${user.education}</li>
    <#--<li class="list-group-item">Skills:-->
        <#--<#list skills as skill>-->
        <#--<#if counts??>-->
        <#--<#list counts as count>-->
        <#--<form action="/user/${user.id}/skill/${skill.id}/assessment" method="post">-->
            <#--<div> <h3>${skill.skill_name} </h3> <input value="assess" type="submit" ></div>-->
        <#--</form>-->
        <#--</#list>-->
        <#--</#if>-->
        <#--</#list>-->
    <#--</li>-->
</ul>
<table data-name="Skills">
<tr>
    <#list skills as skill>
        <form action="/user/${user.id}/skill/${skill.id}/assessment" method="post">
    <td style="width: 200px"><h4>${skill.skill_name}:   </h4><input value="assess" type="submit" ></td>
        </form>
</#list>
</tr>
    <tr>
        <#if counts??>
            <#list counts as count>
            <td>${count}</td>
            </#list>
        </#if>
    </tr>
</table>

<a href="/" class="btn btn-primary">Back</a>
</body>
</html>