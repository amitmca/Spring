<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Add/Edit Record</title>
</head>
<body>
	<form:form commandName="person" action="/SpringHibernateCRUD/save" method="post">
		<table>
			<tr>
				<td><label>First Name : </label></td>
				<td><form:hidden path="id" /> <form:input path="fname" /></td>
			</tr>
			<tr>
				<td><label>Last Name : </label></td>
				<td><form:input path="lname" /></td>
			</tr>
			<tr>
				<td><label>Age: </label></td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><label>Salary: </label></td>
				<td><form:input path="salary" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save"></input></td>
			</tr>
		</table>
	</form:form>
	
</body>
</html>