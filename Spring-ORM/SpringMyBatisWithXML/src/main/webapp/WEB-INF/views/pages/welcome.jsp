<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute></title>
<script type="text/javascript" src="<c:url value='/resources/js/customalert.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/customalert.css'/>" />


    <script type="text/javascript">

		function setColor(el, bg) 
		{
		  if (el.style) el.style.backgroundColor = bg;
		}

		function checkUserName(form) 
		{
		  var bgBad = "yellow";
		  var bgGood = "lightyellow";
		  var valid = true;
		  var errmsg="";

		  if (form.username.value == "" || form.username.value.trim().length==0) {
			    valid = false;
			    setColor(form.username, bgBad);
			  
			  } else {
			    setColor(form.username, bgGood);
			  }		

		  errmsg=errmsg+"\n\nPlease enter the Username ";
			
			if (!valid) 
				createCustomAlert(errmsg,"","Errors");
				
			return valid;
		  
		} 
		
		function checkInput(form) 
		{
		  var bgBad = "yellow";
		  var bgGood = "lightyellow";
		  var valid = true;
		  var errmsg="";
		  
		 if (form.firstName.value == "" || form.firstName.value.trim().length==0) {
		    valid = false;
		    setColor(form.firstName, bgBad);
		  
		  } else {
		    setColor(form.firstName, bgGood);
		  }

		 if (form.lastName.value == "" || form.lastName.value.trim().length==0) {
		    valid = false;
		    setColor(form.lastName, bgBad);
		  
		  } else {
		    setColor(form.lastName, bgGood);
		  }
			              
		  
		  if (form.username.value == "" || form.username.value.trim().length==0) {
		    valid = false;
		    setColor(form.username, bgBad);
		  
		  } else {
		    setColor(form.username, bgGood);
		  }

		  if (form.password.value == "" || form.password.value.trim().length==0) {
		    valid = false;
		    setColor(form.password, bgBad);
		  
		  } else {
		    setColor(form.password, bgGood);
		  }
		  
		  
		   if (form.phone.value == "" || form.phone.value.trim().length==0) {
		    valid = false;
		    setColor(form.phone, bgBad);
		  
		    } else {
		    setColor(form.phone, bgGood);
		   }

           if (form.phone.value.trim().length < 10) 
	            {
		    valid = false;
		    setColor(form.phone, bgBad);
		    createCustomAlert("Please Enter a valid Contact Number","","Errors"); 
		    form.phone.value="";
		   } 
           else
           {
    		setColor(form.phone, bgGood);
    		}

           if(document.addForm.emailId.value=="")
			{
				createCustomAlert("Please Enter a valid E-mail Address","","Errors");
				document.addForm.emailId.focus();
				return false;
			}
			//E-mail field should accept valid characters only.
			if (document.addForm.emailId.value != " ")
			{
				var checkOK="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-@._";
				var checkStr = document.addForm.emailId.value;
				var allValid = 'true';
				for (i = 0;  i < checkStr.length+1;  i++)
				{
		
				ch = checkStr.charAt(i);
					for (j = 0;  j < checkOK.length+1;  j++)
					{
						if (ch == checkOK.charAt(j))
						break;
						if (j == checkOK.length)
						{
							allValid = 'false';
							break;
						}
					}
				}
			}
			//E-mail id must have '@'
			if(document.addForm.emailId.value != "")
			{
				var val=document.addForm.emailId.value ;
				var pass1=val.indexOf('@',0);
				if(pass1==-1)
				{
					//alert("Not a valid E-Mail Address");
					createCustomAlert("Not a valid E-Mail Address","","Errors");
		
					document.addForm.emailId.value="";
					document.addForm.emailId.focus();
					return false;
				}
			}
			//E-mail id must have '.'
			if(document.addForm.emailId.value != "")
			{
				var val=document.addForm.emailId.value ;
				var pass2=val.indexOf('.',0);
				if(pass2==-1)
				{
					//alert("Not a valid E-Mail Address");
					createCustomAlert("Not a valid E-Mail Address","","Errors");
					document.addForm.emailId.value="";
					document.addForm.emailId.focus();
					return false;
				}
				if((pass2 - pass1)== 1)
				{
					//alert("Not a valid E-Mail Address");
					createCustomAlert("Not a valid E-Mail Address","","Errors");
					document.addForm.emailId.value="";
					document.addForm.emailId.focus();
					return false;
				}
			}
			//E-mail id should have only @,.,_ and - with the letters and digits
			if (!allValid)
			{
				createCustomAlert("Please enter only letters, digits,and \"@\"  \"_\"  \".\"  \"-\"  characters in the \"EMail\" field.","Errors");
				document.addForm.emailId.focus();
				return false;
			}
		 
		  
		errmsg=errmsg+"\n\nPlease enter the fields marked with * ";
		
		if (!valid) 
			createCustomAlert(errmsg,"","Errors");
			
		return valid;
		}
		
		function isNumberKey(evt)
		       {
		          var chCode = (evt.which) ? evt.which : event.keyCode
		          if (chCode != 46 && chCode > 31 
		            && (chCode < 48 || chCode > 57))
		             return false;
		          else
		          return true;
		       }
		       
		       function isAlpha(keyCode)
		        {
		            return ((keyCode >= 65 && keyCode <= 90) || keyCode == 8 || keyCode == 32 || keyCode == 9 || keyCode == 46)
		        }
	</script>
	

</head>
<body>
<div class="full_w">
	<div class="h_title"><img src="<c:url value='/resources/images/b_usradd.png'/>"/>&nbsp;&nbsp;Add New User</div>
	 <form:form action="/SpringMyBatisWithXML/add" name="addForm" modelAttribute="usr" method="post" onSubmit="return checkInput(this)">
		<div class="element">
			<label for="name"><span class="red">*</span>First Name</label>
			<form:input path="firstName" cssClass="text" onkeydown= "return isAlpha(event.keyCode);"/>
		</div>
		
		<div class="element">
			<label for="name"><span class="red">*</span>Last Name</label>
			<form:input path="lastName" cssClass="text" onkeydown= "return isAlpha(event.keyCode);"/>
		</div>
			
		<div class="element">
			<label for="name"><span class="red">*</span>Username</label>
			<form:input path="username" cssClass="text" />
		</div>
		
		<div class="element">
			<label for="name"><span class="red">*</span>Password</label>
			<form:password path="password" cssClass="text"/>
		</div>
		
		<div class="element">
			<label for="name"><span class="red">*</span>Phone</label>
			<form:input path="phone" cssClass="text" onkeypress="return isNumberKey(event)" maxlength="10"/>
		</div>
		
		<div class="element">
			<label for="name"><span class="red">*</span>Email Id</label>
			<form:input path="emailId" cssClass="text"/>
		</div>
	
		<div class="entry">
			<input type="submit" value="Save" name="save" class="add">
		</div>
	</form:form>
</div>
</body>
</html>