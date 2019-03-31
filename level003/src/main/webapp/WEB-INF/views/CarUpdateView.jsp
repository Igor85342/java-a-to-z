<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <title>Create user</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h2>Редактировать объявление.</h2>
    <form action="${pageContext.servletContext.contextPath}/updatecar" method="post">
    <div class="form-group">
        <label name = "sold">Продано</label>
        <select class="form-control" name="sold">
                <option value="true"><c:out value = "Продано"></c:out></option>
                <option value="false}"><c:out value = "Не продано"></c:out></option>
        </select>
    </div>
    <button type="submit" class="btn btn-default">Изменить</button>
    <input type="hidden" name="id" value="${car.id}">
    </form>
</div>
</body>
</html>