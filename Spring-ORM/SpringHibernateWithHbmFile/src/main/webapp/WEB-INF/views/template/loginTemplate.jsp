<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>  
<html>  
  <head>  
      
    <title>
    <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>

            <tiles:insertAttribute name="body"></tiles:insertAttribute>

</body>  
</html>