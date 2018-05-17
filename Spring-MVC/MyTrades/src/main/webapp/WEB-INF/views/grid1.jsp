<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.programmingfree.salesreport.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GridView</title>
<link href="<c:url value='/resources/css/demo_page.css'/>" rel="stylesheet" type="text/css" />
<link href="<c:url value='/resources/css/demo_table.css'/>" rel="stylesheet" type="text/css" />       
<link href="<c:url value='/resources/css/demo_table_jui.css'/>" rel="stylesheet" type="text/css" />

<link href="<c:url value='/resources/css/jquery-ui-1.8.24.custom.css'/>" rel="stylesheet" type="text/css" media="all" />
<script src="<c:url value='/resources/js/jquery.min.js'/>" type="text/javascript"></script>
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
<div id="container">
<div id="demo_jui">
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
								<td align='center'><a href="/MyTrades/edit?id=${user.userId}"><img src="<c:url value='/resources/images/b_edit.png'/>"/></a>&nbsp;&nbsp;<a href="/MyTrades/delete?id=${user.userId}"><img src="<c:url value='/resources/images/b_drop.png'/>"/></a></td>
							</tr>
						</c:forEach>
		            </tbody>
		        </table>
		        </div>
 </div>
</body>
</html>