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
<link href="<c:url value='/resources/css/leftlayout.css'/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/resources/css/rightlayout.css'/>" rel="stylesheet" type="text/css" media="all" />
<link href="<c:url value='/resources/css/navi.css'/>" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.7.2.min.js'/>"></script>

<script type="text/javascript">
$(function(){
	$(".box .h_title").not(this).next("ul").hide("normal");
	$(".box .h_title").not(this).next("#home").show("normal");
	$(".box").children(".h_title").click( function() { $(this).next("ul").slideToggle(); });
});
</script>
</head>
<body>
<div class="left">
<img src="<c:url value='/resources/images/logo.jpg'/>"/>
</div>
<div class="right">
	<div class="align-right"><br>
		<p>Welcome <strong><%= session.getAttribute("firstName") %></strong><a href="<spring:url value="/logOut" htmlEscape="true"/>">&nbsp;&nbsp;&nbsp;[Logout]</a></p>
	</div>
</div>
</body>
</html>