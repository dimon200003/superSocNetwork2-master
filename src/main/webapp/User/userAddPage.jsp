<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VDistancii</title>
</head>
<body>
<h2>Here u can create u personal web page on the best platform)))</h2>
<form action="/useradd" method="post">
    <input type="text" name="userIdInput" value=""/>
    <input type="text" name="userNameInput" value=""/>
    <input type="number" name="userAgeInput" value=""/>
    <input type="number" name="userPhoneNumberInput" value=""/>
    <input type="text" name="userAddressInput" value=""/>
    <input type="text" name="userPasswordInput" value=""/>
    <button type="submit">Save</button>
</form>
<form action="userlist" method="get">
    <button type="submit">Cancel</button>
</form>

</body>
</html>