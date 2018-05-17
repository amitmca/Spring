<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Users</title>

        <link rel="stylesheet" href="<c:url value='/resources/css/jsgrid.min.css' />" />
        <link rel="stylesheet" href="<c:url value='/resources/css/jsgrid-theme.min.css' />" />
  
        <script type="text/javascript" src="<c:url value='/resources/js/jquery-1.11.2.min.js' />"></script>    
        <script type="text/javascript" src="<c:url value='/resources/js/jsgrid.min.js' />"></script>
    	<script type="text/javascript" src="<c:url value='/resources/js/jsgrid-script.js' />"></script>
    </head>
    <body>
     <div class="row">
       <div>
         <p>Basic Scenario</p>
       </div>
       <div>
           <div id="jsGrid-basic"></div>
       </div>
     </div>
  </body>
</html>
