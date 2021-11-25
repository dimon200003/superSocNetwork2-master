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
<h2>This is page for edit messages</h2>
<form action="messageedit" method="post">
    <input type="hidden" name="messageUpdatedId" value="${messageOldId}" readonly/>
    <input type="number" name="messageUpdatedFromId" value="${messageOldFromId}"/>
    <input type="text" name="messageUpdatedContent" value="${messageOldContent}"/>
    <input type="number" name="messageUpdatedToId" value="${messageOldToId}"/>
    <button type="submit">Save</button>
</form>
<form action="messagelist" method="get">
    <button type="submit">Cancel</button>
</form>

</body>
</html>
