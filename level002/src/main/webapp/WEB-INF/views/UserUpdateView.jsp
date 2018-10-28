<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action ="${pageContext.servletContext.contextPath}/update" method='post'>
    Login : <input type="text" name="login" value="${user.login}"/>
    Password : <input type="text" name="password" value="${user.password}"/>
    <c:if test = "${sessionScope.get('user').role == 'Admin'}">
        Role: <select name="role">
        <c:forEach items = "${roles}" var = "role">
            <option value="${role.name}"><c:out value = "${role.name}"></c:out></option>
        </c:forEach>
    </select>
    </c:if>
    <c:if test = "${sessionScope.get('user').role == 'User'}">
        <input type="hidden" name="role" value="${user.role}">
    </c:if>
    <input type="submit" name="button" value="Update">
    <input type="hidden" name="id" value="${user.id}">
</form>
</body>
</html>