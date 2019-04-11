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
<div class="container">
    <h2>Создать новое объявление</h2>
    <form action="${pageContext.servletContext.contextPath}/create" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label name = "category">Категория:</label>
                <select class="form-control" name="category">
                    <c:forEach items ="${categories}" var="category">
                        <option value="${category.id}"><c:out value = "${category.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label name = "brand">Марка:</label>
                <select class="form-control" name="brand">
                    <c:forEach items ="${brands}" var="brand">
                        <option value="${brand.id}"><c:out value = "${brand.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
        <div class="form-group">
            <label name = "carbody">Кузов:</label>
            <select class="form-control" name="carbody">
                <c:forEach items ="${carbodyes}" var="carbody">
                    <option value="${carbody.id}"><c:out value = "${carbody.name}"></c:out></option>
                </c:forEach>
            </select>
        </div>
            <div class="form-group">
                <label name = "motor">Мотор:</label>
                <select class="form-control" name="motor">
                    <c:forEach items ="${motors}" var="motor">
                        <option value="${motor.id}"><c:out value = "${motor.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label name = "transmission">Привод:</label>
                <select class="form-control" name="transmission">
                    <c:forEach items ="${transmissions}" var="transmission">
                        <option value="${transmission.id}"><c:out value = "${transmission.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
            Select file to upload: <input type="file" name="file" size="60" /><br />
        <button type="submit" class="btn btn-default" <%--onclick="return validate();"--%>  >Create</button>
        <input type="hidden" name="id_user" value="${user.id}">
    </form>
</div>
</body>
</html>