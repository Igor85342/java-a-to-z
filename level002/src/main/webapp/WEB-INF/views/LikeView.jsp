<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <title></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="counter" value="${counter}"/>
<h1>${counter}</h1>
<div class="container">
    <form action="${pageContext.servletContext.contextPath}/like" method="post">
        <button type="submit" class="btn btn-default">Like</button>
        <input type="hidden" name="counter" value="${counter}">
    </form>
</div>
</body>
</html>