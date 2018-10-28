<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border='1'>
    <c:set var="role" value="${sessionScope.get('role')}" />
    <c:out value="${role}"/>
    <tr>
        <td><strong>Id</strong></td>
        <td><strong>Login</strong></td>
        <td><strong>Password</strong></td>
        <td><strong>Role</strong></td>
        <td><strong>Create Date</strong></td>
        <td><strong>Buttons</strong></td>
    </tr>
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
                <form action ="${pageContext.servletContext.contextPath}/update" method="get">
                    <input type="submit" name="button" value="Update">
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
                    <form action ="${pageContext.servletContext.contextPath}/update" method="get">
                        <input type="submit" name="button" value="Update">
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
    </c:if>
</table>
</body>
</html>