<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action ="${pageContext.servletContext.contextPath}/update" method='post'>
    Name : <input type="text" name="name" value="${user.name}"/>
    Login : <input type="text" name="login" value="${user.login}"/>
    Email : <input type="text" name="email" value="${user.email}"/>
    <input type="submit" name="button" value="Update">
    <input type="hidden" name="id" value="${user.id}">
</form>
</body>
</html>