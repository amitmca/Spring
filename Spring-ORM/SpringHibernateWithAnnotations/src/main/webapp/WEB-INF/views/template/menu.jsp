<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
  
<ul>
	<li class="upp"><a href="#"><b>Create</b></a>
		<ul>
			<li>&#8250; <a href="#"><b>Spot/Forward</b></a></li>
			<li>&#8250; <a href="#"><b>Swap</b></a></li>
			<li>&#8250; <a href="#"><b>NDF</b></a></li>
		</ul>
	</li>
	<li class="upp"><a href="#"><b>Requests</b></a></li>
	
	<li class="upp"><a href="#"><b>Approvals</b></a></li>
	
	<li class="upp"><a href="#"><b>Trades</b></a></li>
	
	<li class="upp"><a href="#"><b>Orders</b></a></li>
	
	<li class="upp active"><a href="#"><b>Users</b></a>
		<ul>
			<li>&#8250; <a href="/SpringHibernateWithAnnotations/welcome">Add New User</a></li>
			<li>&#8250; <a href="/SpringHibernateWithAnnotations/userList">List of Users</a></li>
			<li>&#8250; <a href="/SpringHibernateWithAnnotations/grid">List of Users-Grid</a></li>
		</ul>
	</li>
	 
</ul>    