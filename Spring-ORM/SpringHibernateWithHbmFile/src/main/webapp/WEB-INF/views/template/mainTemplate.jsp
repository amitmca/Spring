<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>  
  <head>  
    <title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
</head>
<body>

<div class="wrap">
	<div id="header">
		<div id="top">
			 <tiles:insertAttribute name="header"></tiles:insertAttribute>
		</div>
		
		<div id="nav"><br>
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
		</div>
	</div>
	
	<div id="content1">
		<div id="sidebar1">
			<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>
		</div>
		<div id="main1">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
		</div>
	</div>
		<div class="clear"></div>
</div>

<div id="footer">
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>
</div>
</body>  
</html>