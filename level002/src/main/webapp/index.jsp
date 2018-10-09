<%@ page import="ru.moskalets.chapter004.httpprotocol.User" %>
<%@ page import="ru.moskalets.chapter004.httpprotocol.ValidateService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border='1'>
<%
    PrintWriter writer = response.getWriter();
    if (ValidateService.getInstance().findAll().isEmpty()) {
        writer.append("Users not found.");
    } else {
        for (User user : ValidateService.getInstance().findAll().values()) {%>
            <tr>
                <td>
                    <%=user.printUserInfo()%>
                </td>
                <td>
                    <form action ="<%=request.getContextPath()%>/update" method="post">
                        <input type="submit" name="button" value="Update">
                        <input type="hidden" name="id" value="<%=user.getId()%>">
                    </form>
                </td>
            </tr>
            <tr>
                <td>
                </td>
                <td>
                    <form action ="<%=request.getContextPath()%>/update" method="post">
                        <input type="submit" name="button" value="Delete">
                        <input type="hidden" name="id" value="<%=user.getId()%>">
                    </form>
                </td>
            </tr>
        <%}
    }%>
</table>
</body>
</html>