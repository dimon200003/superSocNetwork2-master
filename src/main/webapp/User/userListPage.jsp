<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.09.2021
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="6">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Password</th>
        <th>PhoneNumber</th>
        <th>Address</th>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getAge()}</td>
            <td>${user.getPhoneNumber()}</td>
            <td>${user.getAddress()}</td>
            <td>
                <form action="userdelete" method="get">
                    <input type="hidden" name="UserIdParam" value="${user.getId()}"/>
                    <button type="submit">Delete</button>
                </form>
            </td>
            <td>

                <form action="useredit" method="get">
                    <br>
                    <label>name</label>
                    <input type="hidden" name="UserIdParam" value="${user.getId()}" />
                    <input type="hidden" name="UserNameParam" value="${user.getName()}" />
                    <input type="hidden" name="UserAgeParam" value="${user.getAge()}" />
                    <input type="hidden" name="UserPhoneNumberParam" value="${user.getPhoneNumber()}" />
                    <input type="hidden" name="UserPasswordParam" value="${user.getPassword()}" />
                    <input type="hidden" name="UserAddressParam" value="${user.getAddress()}" />
                    <button type="submit">Edit</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<form action="useradd" method="get">
    <button type="submit">Add new User</button>
</form>

</body>
</html>
