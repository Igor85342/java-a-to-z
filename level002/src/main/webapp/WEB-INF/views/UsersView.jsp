<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border='1'>
    <tr>
        <td><strong>Id</strong></td>
        <td><strong>Name</strong></td>
        <td><strong>Login</strong></td>
        <td><strong>Email</strong></td>
        <td><strong>Create Date</strong></td>
        <td><strong>Buttons</strong></td>
    </tr>
    <c:forEach items ="${users}" var="user">
            <tr>
                <td>
                    <c:out value = "${user.id}"></c:out>
                </td>
                <td>
                    <c:out value = "${user.name}"></c:out>
                </td>
                <td>
                    <c:out value = "${user.login}"></c:out>
                </td>
                <td>
                    <c:out value = "${user.email}"></c:out>
                </td>
                <td>
                    <c:out value = "${user.createDate}"></c:out>
                </td>
                <td>
                    <form action ="${pageContext.servletContext.contextPath}/update" method="get">
                        <input type="submit" name="button" value="Update">
                        <input type="hidden" name="id" value="${user.id}">
                        <c:set var="user" value="${user}" scope="session"/>
                    </form>
                </td>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td>
                    <form action ="${pageContext.servletContext.contextPath}/delete" method="post">
                        <input type="submit" name="button" value="Delete">
                        <input type="hidden" name="id" value="${user.id}">
                    </form>
                </td>
            </tr>
    </c:forEach>
    <tr></tr>
    <tr>
    <td>
        <form action ="${pageContext.servletContext.contextPath}/create" method="get">
            <input type="submit" name="button" value="Create">
        </form>
    </td>
    </tr>
</table>
</body>
</html>