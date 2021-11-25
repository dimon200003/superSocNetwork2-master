<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.09.2021
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Here u can write a message for ur friends</h2>
<form action="/messageadd" method="post">
    <input hidden type="numer" name="messageIdInput" value=""/>
    <input type="text" name="messageContentInput" value=""/>
    <input type="number" name="messageFromIdInput" value="${user.id}"/>
    <input type="number" name="messageToIdInput" value=""/>
    <button type="submit">Save</button>
</form>
<form action="messagelist" method="get">
    <button type="submit">Cancel</button>
</form>
${user.id}
</body>
</html>
