<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <table class="table table-striped">
        <c:set var="role" value="${sessionScope.get('role')}" />
        <c:out value="${role}"/>
        <thead>
        <tr>
            <th>Id</th>
            <th>Login</th>
            <th>Password</th>
            <th>Role</th>
            <th>Create Date</th>
            <th>Country</th>
            <th>City</th>
            <th>Buttons</th>
        </tr>
        </thead>

        <tbody>
        <c:if test = "${sessionScope.get('user').role == 'User'}">
            <tr>
                <td>
                    <c:out value = "${sessionScope.get('user').id}"></c:out>
                </td>
                <td>
                    <c:out value = "${sessionScope.get('user').login}"></c:out>
                </td>
                <td>
                    <c:out value = "${sessionScope.get('user').password}"></c:out>
                </td>
                <td>
                    <c:out value = "${sessionScope.get('user').role}"></c:out>
                </td>
                <td>
                    <c:out value = "${sessionScope.get('user').createDate}"></c:out>
                </td>
                <td>
                    <c:out value = "${sessionScope.get('user').country}"></c:out>
                </td>
                <td>
                    <c:out value = "${sessionScope.get('user').city}"></c:out>
                </td>
                <td>
                    <form action ="${pageContext.servletContext.contextPath}/update" method="get">
                        <button type="submit" class="btn btn-success" name="button" value ="Update">Update</button>
                        <input type="hidden" name="id" value="${user.id}">
                    </form>
                </td>
            </tr>
        </c:if>

        <c:if test = "${sessionScope.get('user').role == 'Admin'}">
            <c:forEach items ="${users}" var="user">
                <tr>
                    <td>
                        <c:out value = "${user.id}"></c:out>
                    </td>
                    <td>
                        <c:out value = "${user.login}"></c:out>
                    </td>
                    <td>
                        <c:out value = "${user.password}"></c:out>
                    </td>
                    <td>
                        <c:out value = "${user.role}"></c:out>
                    </td>
                    <td>
                        <c:out value = "${user.createDate}"></c:out>
                    </td>
                    <td>
                        <c:out value = "${user.country}"></c:out>
                    </td>
                    <td>
                        <c:out value = "${user.city}"></c:out>
                    </td>
                    <td>
                        <form action ="${pageContext.servletContext.contextPath}/update" method="get">
                            <button type="submit" class="btn btn-success" name="button" value ="Update">Update</button>
                            <input type="hidden" name="id" value="${user.id}">
                        </form>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <form action ="${pageContext.servletContext.contextPath}/delete" method="post">
                            <button type="submit" class="btn btn-danger" value = "Delete">Delete</button>
                            <input type="hidden" name="id" value="${user.id}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            <tr></tr>
            <tr>
                <td>
                    <form action ="${pageContext.servletContext.contextPath}/create" method="get">
                        <button type="submit" class="btn btn-success" name="button" value ="Create">Create</button>
                    </form>
                </td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>
</body>
</html>