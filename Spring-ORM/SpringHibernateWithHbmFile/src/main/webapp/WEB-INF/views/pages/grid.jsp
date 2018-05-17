<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>

<link href="<c:url value='/resources/css/demo_table.css'/>" rel="stylesheet" type="text/css" />       
<link href="<c:url value='/resources/css/demo_table_jui.css'/>" rel="stylesheet" type="text/css" />

<link href="<c:url value='/resources/css/jquery-ui-1.8.24.custom.css'/>" rel="stylesheet" type="text/css" media="all" />
<script src="<c:url value='/resources/js/jquery.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/js/jquery.dataTables.js'/>" type="text/javascript"></script>
 <script type="text/javascript">
        $(document).ready(function () {
            $("#companies").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true               
            });
        });
 </script>
</head>
<body id="dt_example">
<div class="full_w">
	<div class="h_title"><img src="<c:url value='/resources/images/b_usrlist.png'/>"/>&nbsp;&nbsp;List Of Users</div>
	 <br><br><br>
<table id="companies" class="display">
    <thead>
        <tr>
        	<th>Username</th>
            <th><u>First Name</u></th>
            <th><u>Last Name</u></th>
            <th><u>Phone</u></th>
            <th><u>Email Id</u></th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
  		<c:forEach items="${users}" var="user">
<tr>
<td align='center'><c:out value="${user.username}"/></td>
<td align='center'><c:out value="${user.firstName}"/></td>
<td align='center'><c:out value="${user.lastName}"/></td>
<td align='center'><c:out value="${user.phone}"/></td>
<td align='center'><c:out value="${user.emailId}"/></td>
<td align='center'><a href="/SpringHibernateWithHbmFile/edit/${user.user_id}"><img src="<c:url value='/resources/images/b_edit.png'/>"/></a>&nbsp;&nbsp;<a href="/SpringHibernateWithHbmFile/delete/${user.user_id}"><img src="<c:url value='/resources/images/b_drop.png'/>"/></a></td>
</tr>
</c:forEach>
    </tbody>
</table>
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</div>

</body>
</html>