<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.10.2021
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Hello: ${user.name}</h3>
${user.id}

User Name: <b>${user.name}</b>

<form action="messageadd" method="get">
    <button type="submit">Write new message</button>
</form>

<form action="readmessages" method="get">
    <input hidden type="text" name="toIdInput" value="${user.id}" readonly>
    <button type="submit">Check my post</button>
</form>

<form action="userlist" method="get">
    <button type="submit">See all users to find friends</button>
</form>




</body>
</html>
