<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Registration Form</title>
</head>
<body>
<h2 align="center">Student Registration Form</h2>
<hr />
<table align="center" cellpadding="5" cellspacing="5">
	<form:form commandName="registration" method="POST" action="add-update">
		<tr>
			<td>Roll No</td>
			<td><form:input readonly="true" path="rollNo" /></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Course</td>
			<td><form:select path="course">
				<form:option value="" label="Select Course" />
				<form:options items="${courses}" itemLabel="title" itemValue="title" />
			</form:select></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><form:textarea cols="30" rows="4" path="address" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Register" /></td>
		</tr>
	</form:form>
</table>
</body>
</html>