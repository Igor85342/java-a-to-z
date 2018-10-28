<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action ="${pageContext.servletContext.contextPath}/create" method="post">
    Login : <input type="text" name="login"/>
    Password : <input type="text" name="password"/>
    Role: <select name="role">
            <c:forEach items ="${roles}" var="role">
                <option value="${role.name}"><c:out value = "${role.name}"></c:out></option>
            </c:forEach>
    </select>
    <input type="submit">
</form>
</body>
</html>