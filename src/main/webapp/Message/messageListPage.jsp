<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 22.09.2021
  Time: 13:04
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
        <th>MessageId</th>
        <th>FromId</th>
        <th>Content</th>
        <th>ToId</th>
    </tr>
    <c:forEach items="${messageList}" var="message">
        <tr>
            <td>${message.getMessageId()}</td>
            <td>${message.getFromId()}</td>
            <td>${message.getContent()}</td>
            <td>${message.getToId()}</td>
            <td>
                <form action="messagedelete" method="get">
                    <input type="hidden" name="MessageIdParam" value="${message.getMessageId()}"/>
                    <button type="submit">Delete</button>
                </form>
            </td>
            <td>
                <form action="messageedit" method="get">
                    <br>
                    <label>name</label>
                    <input hidden type="hidden" name="MessageIdParam" value="${message.getMessageId()}" />
                    <input type="hidden" name="MessageFromIdParam" value="${message.getFromId()}" />
                    <input type="hidden" name="MessageContentParam" value="${message.getContent()}" />
                    <input hidden type="hidden" name="MessageToIdParam" value="${message.getToId()}" />
                    <button type="submit">Edit</button>
                </form>
            </td>
            <td>
            <form action="messageresponse" method="get">

                <input type="hidden" name="MessageToIdParam" value="${message.getFromId()}" />
                <input hidden type="hidden" name="MessageFromIdParam" value="${message.getToId()}" />
                <button type="submit">Write new message</button>
            </form>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="messageadd" method="get">
    <button type="submit">Write new message</button>
</form>
</body>
</html>
