<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Accounts</title>
    <style>
        .align_center {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>All Accounts</h1>
<table>
    <tr>
        <th width="15%">Account No</th>
        <th width="20%">Name</th>
        <th width="15%">Balance</th>
    </tr>
    <c:forEach items="${accounts}" var="account">
        <tr>
            <td class="align_center">${account.number}</td>
            <td>${account.name}</td>
            <td class="align_center">${account.balance}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3" style="padding-top: 30px">
            <a href="/main.html">-Back to main menu-</a>
        </td>
    </tr>
</table>
</body>
</html>