<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Registration Page</title>
</head>
<body>
	<form:form method="POST" action="register" commandName="UserDetails">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Contact :</td>
				<td><form:input path="contact" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="mail" /></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td>Confirm Password :</td>
				<td><form:input type="password" path="confirmpassword" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="Reset"></td>
			</tr>
		</table>
		<hr>
		<p>All fields marked with Asterisk(*)are required</p>
		<br>
	</form:form>
</body>
</html>