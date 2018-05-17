<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
</head>
<body>
<div class="full_w">
	<div class="h_title"><img src="<c:url value='/resources/images/b_usrlist.png'/>"/>&nbsp;&nbsp;List Of Users</div>
	
     <c:if test="${not empty showDeleteMessage}">
     <div class="n_ok">
      <font color="green" size="4px">Record Deleted Successfully !!!</font>
      </div> 
	</c:if>
    
     <c:if test="${not empty showSaveMessage}">
     <div class="n_ok">
      <font color="green" size="4px">Record Saved Successfully !!!</font>
      </div> 
	</c:if>
	

     <c:if test="${not empty showUpdateMessage}">
     <div class="n_ok">
       <font color="green" size="4px">Record Updated Successfully !!!</font>
      </div> 
	</c:if>
			
	
	<c:choose>
        <c:when test="${!empty users}">
	<div class="CSSTableGenerator" style="width:600px;height:150px;">
		<table>
			<tr>
				<th>Username</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Email Id</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td align='center'><c:out value="${user.username}"/></td>
					<td align='center'><c:out value="${user.firstName}"/></td>
					<td align='center'><c:out value="${user.lastName}"/></td>
					<td align='center'><c:out value="${user.phone}"/></td>
					<td align='center'><c:out value="${user.emailId}"/></td>
					<td align='center'><a href="/MYTRS/edit?id=${user.userId}"><img src="<c:url value='/resources/images/b_edit.png'/>"/></a>&nbsp;&nbsp;<a href="/MYTRS/delete?id=${user.userId}"><img src="<c:url value='/resources/images/b_drop.png'/>"/></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</c:when>
<c:otherwise>
    	<font color="red"><h3>No Records Found.</h3></font>
   </c:otherwise>
</c:choose>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

</div>	
</body>
</html>