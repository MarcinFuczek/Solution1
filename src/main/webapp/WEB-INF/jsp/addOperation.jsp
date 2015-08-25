<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Deposit or Withdraw Funds</title>
    <style>
        ul.vertical {
            list-style-type: none;
            padding: 0;
            margin: 0;
            border: 0;
        }
    </style>
</head>

<body>
<h1>Manage Funds</h1>
    <form:form commandName="operation">
        <table>
            <tr>
                <td>Type:</td>
                <td>
                    <ul class="vertical">
                        <form:radiobuttons path="type" id="operationTypeRadios" element="li"/>
                    </ul>
                </td>
            </tr>
            <tr>
                <td>Account:</td>
                <td>
                    <form:select path="accountNumber"
                                 multiple="false"
                                 items="${availableAccounts}"
                                 itemValue="number" itemLabel="formattedName"
                                 />
                </td>
                <td><label id="recipient_label">Recipient:</label></td>
                <td>
                    <form:select path="recipient" id="recipient_combobox"
                                 multiple="false"
                                 items="${availableAccounts}"
                                 itemValue="number" itemLabel="formattedName"
                                 />
                </td>
            </tr>
            <tr>
                <td>Sum:</td>
                <td><form:input path="sum" /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><form:input path="description" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="/main.html">-Back to main menu-</a>
                </td>
            </tr>
        </table>
    </form:form>

    <script src="/resources/jquery-1.11.0.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            var typeRadios = $('input:radio[name=type]');
            toggleAccountsSelection(typeRadios); // show/hide box on page load
            typeRadios.change(function() {
                toggleAccountsSelection(this);
            })
        });
        function toggleAccountsSelection(button_obj) {
            if (button_obj.value == 'TRANSFER') {
                $('#recipient_label').prop('hidden', false);
                $('#recipient_combobox').prop('hidden', false);
            } else {
                $('#recipient_label').prop('hidden', true);
                $('#recipient_combobox').prop('hidden', true);
            }
        }
    </script>
</body>
</html>