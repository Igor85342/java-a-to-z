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
    <script>
        function validate() {
            var result = true;
            if ($('#login').val() == "") {
                result = false
                alert($('#login').attr('title'));
            }
            if ($('#password').val() == "") {
                result = false
                alert($('#password').attr('title'));
            }
            if ($('#country').val() == "") {
                result = false
                alert($('#country').attr('title'));
            }
            return result;
        }

        $(
            $.ajax('./update', {
                method: 'put',
                complete: function(data) {
                    console.log(JSON.parse(data.responseText));
                    var result = "";
                    var cities = JSON.parse(data.responseText);

                    for(i = 0; i != cities.length; i++) {
                        result += "<option value=" + cities[i].name + ">"+ cities[i].name+"</option>"
                    }
                    var select = document.getElementById("city");
                    select.innerHTML = result;
                }
            })
        );

        function addCity() {
            if (document.getElementById("newcity").value == "") {
                alert("Fill in the city name!");
            } else {
                $.ajax({
                    type: "post",
                    url: './create',
                    data: {
                        namecity: document.getElementById("newcity").value,
                    },
                });
                alert("New city add");
            }
            return false
        }

    </script>
</head>
<body>
<div class="container">
    <h2>Update user.</h2>
    <form action="${pageContext.servletContext.contextPath}/update" method="post">
        <div class="form-group">
            <label for="login">Login:</label>
            <input type="text" class="form-control" id="login" placeholder="Enter login" name="login" value="${user.login}" title = "Enter login!">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="text" class="form-control" id="password" placeholder="Enter password" name="password" value="${user.password}" title = "Enter password!">
        </div>
        <c:if test = "${sessionScope.get('user').role == 'Admin'}">
            <div class="form-group">
                <label name = "role">Role:</label>
                <select class="form-control" name="role">
                    <c:forEach items ="${roles}" var="role">
                        <option value="${role.name}"><c:out value = "${role.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
        </c:if>
        <c:if test = "${sessionScope.get('user').role == 'User'}">
            <input type="hidden" name="role" value="${user.role}">
        </c:if>
        <div class="form-group">
            <label for="country">Country:</label>
            <input type="text" class="form-control" id="country" placeholder="Enter country" name="country" title = "Enter country!">
        </div>
        <div class="form-group">
            <label name = "city">City:</label>
            <select class="form-control" name="city" id ="city">
            </select>
        </div>
        <button type="submit" class="btn btn-default" onclick="return validate();">Update</button>
        <input type="hidden" name="id" value="${user.id}">
    </form>
</div>
<div class="container">
    <h2>Add new city</h2>
    <form action="/action_page.php" method="post">
        <div class="form-group">
            <label for="newcity">City:</label>
            <input type="text" class="form-control" title="Enter user name." id="newcity" placeholder="Enter new city" name="newcity" >
        </div>
        <button type="button" class="btn btn-default" value = "Ajax" onclick="return addCity();">Add new city</button>
    </form>
</div>
</body>
</html>