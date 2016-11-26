<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit</title>
</head>
<body>
	<h1 align="center">Deposit</h1>
	<form action=DepositCheck method="post">
		<table border="1" align="center">
			<tr>
				<td width="300" align="center"><p>Amount to be Deposited</p></td>
				<td align="center"><input type="text" name="amount" /></td>
			</tr>
		</table>
		<br />
		<center>
			<input type="submit" value="Deposit" />
		</center>
	</form>
</body>
</html>