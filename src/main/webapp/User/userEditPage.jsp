<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.09.2021
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>This is page for edit user</h2>

<form action="useredit" method="post">
    <input type="hidden" name="userUpdatedId" value="${userOldId}" readonly/>
    <input type="text" name="userUpdatedName" value="${userOldName}"/>
    <input type="number" name="userUpdatedAge" value="${userOldAge}"/>
    <input type="number" name="userUpdatedPhoneNumber" value="${userOldPhoneNumber}"/>
    <input type="text" name="userUpdatedPassword" value="${userOldPassword}"/>
    <input type="text" name="userUpdatedAddress" value="${userOldAddress}"/>
    <button type="submit">Save</button>
</form>


<form action="userlist" method="get">
    <button type="submit">Cancel</button>
</form>

</body>
</html>
