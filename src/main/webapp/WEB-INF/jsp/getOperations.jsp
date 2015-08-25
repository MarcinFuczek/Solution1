<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Operations</title>
    <style>
        .align_center {
            text-align: center;
        }
    </style>
</head>
<body>
<h1>All Operations</h1>
<table id="operations" width="100%">
    <tr>
        <th width="15%">Operation ID</th>
        <th width="15%">Date</th>
        <th width="15%">Account No</th>
        <th width="10%">Operation Type</th>
        <th width="10%">Sum</th>
        <th width="10%">Balance</th>
        <th width="20%">Description</th>
    </tr>
    <tr>
        <th width="15%"></th>
        <th width="15%"></th>
        <th width="15%">
            <input type="text" id="accountFilter" />
        </th>
        <th width="10%">
            <select id="typeFilter">
                <option value="ALL">--ALL--</option>
                <option value="DEPOSIT">DEPOSIT</option>
                <option value="WITHDRAW">WITHDRAW</option>
                <option value="TRANSFER">TRANSFER</option>
            </select>
        </th>
        <th width="10%"></th>
        <th width="10%"></th>
        <th width="20%"></th>
    </tr>
    <c:forEach items="${operations}" var="operation">
        <tr>
            <td class="align_center">${operation.id}</td>
            <td>${operation.formattedDate}</td>
            <td class="account_col">${operation.accountNumber}</td>
            <td class="type_col">${operation.type}</td>
            <td class="align_center">${operation.sum}</td>
            <td class="align_center">${operation.finalBalance}</td>
            <td>${operation.description}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6" style="padding-top: 30px">
            <a href="/main.html">-Back to main menu-</a>
        </td>
    </tr>
</table>

<script src="/resources/jquery-1.11.0.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        $('#typeFilter').change(function() {
            filterByType(this);
        });
        $('#accountFilter').change(function() {
            filterByAccount(this);
        });
    });
    function filterByType(combobox_obj) {
        var operations_table = $("#operations");
        if ($(combobox_obj).val() == 'ALL') {
            operations_table.find("td.type_col").parent().show();
        } else {
            operations_table.find("td.type_col:contains('" + $(combobox_obj).val() + "')").parent().show();
            operations_table.find("td.type_col:not(:contains('" + $(combobox_obj).val() + "'))").parent().hide();
        }
    }
    function filterByAccount(input_obj) {
        var operations_table = $("#operations");
        operations_table.find("td.account_col:contains('" + $(input_obj).val() + "')").parent().show();
        operations_table.find("td.account_col:not(:contains('" + $(input_obj).val() + "'))").parent().hide();
    }
</script>
</body>
</html>