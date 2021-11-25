<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.10.2021
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Here us can create admin account</h2>
<form action="/superSocNetwork/adminadd" method="post">
    <input type="text" name="adminIdInput" value=""/>
    <input type="text" name="adminLoginInput" value=""/>
    <input type="text" name="adminPasswordInput" value=""/>
    <button type="submit">Save</button>
</form>
<form action="adminlist" method="get">
    <button type="submit">Cancel</button>
</form>

</body>
</html>
