<form method="POST" action="${pageContext.request.contextPath}/adminlogin">
    <table border="0">
        <tr>
            <td>Admin login</td>
            <td><input type="text" name="adminLogin" value= "${admin.adminLogin}" /> </td>
        </tr>
        <tr>
            <td> Admin password</td>
            <td><input type="text" name="password" value= "${admin.adminPassword}" /> </td>
        </tr>
        <tr>

        <tr>
        <tr>
            <td>Remember me</td>
            <td><input type="checkbox" name="rememberMe" value= "Y" /> </td>
        </tr>
        <tr>
            <td colspan ="3">
                <input type="submit" value= "Submit" />
                <a href="${pageContext.request.contextPath}/login">Cancel</a>
            </td>
        </tr>
    </table>
</form>