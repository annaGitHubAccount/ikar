<!DOCTYPE html>
<html>
<head>

    <title>Login</title>

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script
            src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"
            integrity="sha256-T0Vest3yCU7pafRw9r+settMBX6JkKN06dqBnpQ8d30="
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.js"></script>


</head>

<body>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="position: center">
<form:form method="POST" action="login" id="loginForm">

    <tr><td><label for="username">Username: </label></td></tr>
    <tr><td><div class="ui input"><input type="text" class="ui input" name="username" id="username" /></div></td></tr>

    <tr><td><label for="password">Password: </label></td></tr>
    <tr><td><div class="ui input"><input type="password" class="ui input" name="password" id="password" /></div></td></tr>

    <tr><td colspan="2"><input class="ui button" type="submit" value="Login"/></td></tr>

</form:form>
</table>
</body>
</html>