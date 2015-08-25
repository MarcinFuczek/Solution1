<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Welcome to Bank</title>
    <style>
        td {
            padding-right: 20px;
        }
        a {
            line-height: 0;
        }
    </style>
</head>

<body>
	<h1>Bank</h1>
	<table>
		<tr>
			<td>
				<h3><a href="/getAccounts.html">All Accounts</a></h3>
			</td>
            <td>
                <h3><a href="/getOperations.html">All Operations</a></h3>
            </td>
		</tr>
		<tr>
			<td>
				<h3><a href="/addAccount.html">Add an Account</a></h3>
			</td>
            <td>
                <h3><a href="/addOperation.html">Manage Funds</a></h3>
            </td>
		</tr>
	</table>
</body>
</html>