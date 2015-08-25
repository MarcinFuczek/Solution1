<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add an Account</title>
</head>

<body>
<h1>Add an Account</h1>
    <form:form commandName="account">
        <table>
            <tr>
                <td>Account number:</td>
                <td><form:input path="number" /></td>
            </tr>
            <tr>
                <td>Account holder name:</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Opening balance:</td>
                <td><form:input path="balance" /></td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="/main.html">-Back to main menu-</a>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>