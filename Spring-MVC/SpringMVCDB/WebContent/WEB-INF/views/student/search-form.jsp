<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Registration Form</title>
</head>
<body>
<h2 align="center">Student Registration Form</h2>
<hr />
<table align="center" cellpadding="5" cellspacing="5">
	<form:form commandName="registration" method="POST" action="search">
		<tr>
			<td>Roll No</td>
			<td><form:input path="rollNo" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Search" /></td>
		</tr>
	</form:form>
</table>
<c:if test="${student != null}">
	<table align="center" cellpadding="5" cellspacing="5">
		<thead>
			<tr>
				<td>Roll No</td>
				<td>Name</td>
				<td>Course</td>
				<td>Address</td>
				<td>Age</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${student.rollNo}</td>
				<td>${student.name}</td>
				<td>${student.course}</td>
				<td>${student.address}</td>
				<td>${student.age}</td>
				<td><a href="load-form?roll=${student.rollNo}">Edit</a></td>
				<td><a href="delete?roll=${student.rollNo}">Edit</a></td>
			</tr>
		</tbody>
	</table>
</c:if>
</body>
</html>