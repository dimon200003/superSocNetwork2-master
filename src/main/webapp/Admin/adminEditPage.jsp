<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 01.10.2021
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>This is page for edit admin</h2>
<form action="adminedit" method="post">
    <input type="hidden" name="adminUpdatedId" value="${adminOldId}" readonly/>
    <input type="text" name="adminUpdatedLogin" value="${adminOldLogin}"/>
    <input type="text" name="adminUpdatedPassword" value="${adminOldPassword}"/>
    <button type="submit">Save</button>
</form>


<form action="adminList" method="get">
    <button type="submit">Cancel</button>
</form>

</body>
</html>
