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
<c:forEach items ="${carsFilter}" var="car">
    <div class="container">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Объявление <c:out value = "${car.id}"></c:out></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><b>Категория</b></td>
                <td><c:out value = "${car.category.name}"></c:out></td>

            </tr>
            <tr>
                <td><b>Марка</b></td>
                <td><c:out value = "${car.brand.name}"></c:out></td>
            </tr>
            <tr>
                <td><b>Кузов</b></td>
                <td><c:out value = "${car.carbody.name}"></c:out></td>
            </tr>
            <tr>
                <td><b>Мотор</b></td>
                <td><c:out value = "${car.motor.name}"></c:out></td>
            </tr>
            <tr>
                <td><b>Привод</b></td>
                <td><c:out value = "${car.transmission.name}"></c:out></td>
            </tr>
            <tr>
                <td><b>Пользователь</b></td>
                <td><c:out value = "${car.user.login}"></c:out></td>
            </tr>
            <tr>
                <td><b>Продано</b></td>
                <td>
                    <c:if test = "${car.sold == false}">
                        <b>Нет</b>
                    </c:if>
                    <c:if test = "${car.sold == true}">
                        <b>Да</b>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td><b>Дата создания</b></td>
                <td>
                    <jsp:useBean id="myDate" class="java.util.Date"/>
                    <c:set target="${myDate}" property="time" value="${car.date}"/>
                    <c:out value = "${myDate}"></c:out>
                </td>
            </tr>
            <tr>
                <td>
                    <c:if test = "${car.imageBase64 != ''}">
                        <img src="data:image/jpg;base64,${car.imageBase64}" width="320" height="240" >
                    </c:if>
                    <c:if test = "${car.imageBase64 == ''}">
                        <b>Изображение отсутствует!</b>
                    </c:if>
                </td>
            </tr>
            </tbody>
        </table>
    </div>
</c:forEach>
        <form action ="${pageContext.servletContext.contextPath}/cars" method="get">
            <button type="submit" class="btn btn-success" name="button" value ="cars">Все авто</button>
        </form>
</body>
</html>