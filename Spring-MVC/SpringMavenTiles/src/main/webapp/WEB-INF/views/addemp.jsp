<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<html>  
 <head>  
     <title>Spring MVC Form Handling</title>  
 </head>  
 <body>  
  <h2>Add Employee</h2>  
<form:form method="POST" modelAttribute="usr">
<table class="form">
    <tr>
        <td class="col1">
            <label>*First Name</label>
        </td>
        <td class="col2">
            <form:input path="firstName"/>
        </td>
    </tr>
    <tr>
        <td class="col1">
            <label>*Last Name</label>
        </td>
        <td class="col2">
            <form:input path="lastName"/>
        </td>
    </tr>
    <tr>
        <td class="col1">
            <label>*User Name</label>
        </td>
        <td class="col2">
            <form:input path="username" />
        </td>
    </tr>
    <tr>
        <td class="col1">
            <label>*Password</label>
        </td>
        <td class="col2">
            <form:password path="password"/>
        </td>
    </tr>
    <tr>
        <td class="col1">
            <label>*Phone</label>
        </td>
        <td class="col2">
            <form:input path="phone" maxlength="10"/>
        </td>
    </tr>
    <tr>
        <td class="col1">
            <label>*Email Id</label>
        </td>
        <td class="col2">
            <form:input path="emailId"/>
        </td>
    </tr>
    <tr>
        <td>
         <input type="submit" value="Save" name="save"/> 
		</td>	
    </tr>
    </table>       
 </form:form>    
 </body>  
</html>  