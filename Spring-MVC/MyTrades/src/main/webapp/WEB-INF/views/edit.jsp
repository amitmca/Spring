<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Mytrades :: Add New User</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/table.css'/>" media="screen" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/reset.css'/>" media="screen" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/text.css'/>" media="screen" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/grid.css'/>" media="screen" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/layout.css'/>" media="screen" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/nav.css'/>" media="screen" />
    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="css/ie6.css" media="screen" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie.css" media="screen" /><![endif]-->
    <link href="<c:url value='/resources/css/fancy-button/fancy-button.css'/>" rel="stylesheet" type="text/css" />
    <!--Jquery UI CSS-->
    <link href="<c:url value='/resources/css/themes/base/jquery.ui.all.css'/>" rel="stylesheet" type="text/css" />
    <!-- BEGIN: load jquery -->
    <script src="<c:url value='/resources/js/jquery-1.6.4.min.js'/>" type="text/javascript"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/jquery-ui/jquery.ui.core.min.js'/>"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.widget.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.accordion.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.effects.core.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.effects.slide.min.js'/>" type="text/javascript"></script>
    <!-- END: load jquery -->
    <!--jQuery Date Picker-->
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.widget.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.datepicker.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.progressbar.min.js'/>" type="text/javascript"></script>
    <!-- jQuery dialog related-->
    <script src="<c:url value='/resources/js/jquery-ui/external/jquery.bgiframe-2.1.2.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.mouse.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.draggable.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.position.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.resizable.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.dialog.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.effects.core.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.effects.blind.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery-ui/jquery.effects.explode.min.js'/>" type="text/javascript"></script>
    <!-- jQuery dialog end here-->
    <script src="<c:url value='/resources/js/jquery-ui/jquery.ui.accordion.min.js'/>" type="text/javascript"></script>
    <!--Fancy Button-->
    <script src="<c:url value='/resources/js/fancy-button/fancy-button.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/setup.js'/>" type="text/javascript"></script>
    <!-- Load TinyMCE -->
    <script src="<c:url value='/resources/js/tiny-mce/jquery.tinymce.js'/>" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            setupTinyMCE();
            setupProgressbar('progress-bar');
            setDatePicker('date-picker');
            setupDialogBox('dialog', 'opener');
            $('input[type="checkbox"]').fancybutton();
            $('input[type="radio"]').fancybutton();
        });
    </script>
    <script type="text/javascript" src="<c:url value='/resources/js/customalert.js'/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/customalert.css'/>" />
    <link href="<c:url value='/resources/css/popupstyle.css'/>" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="<c:url value='/resources/js/script.js'/>"></script>
    
    
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
    <div class="container_12">
        <div class="grid_12 header-repeat">
            <div id="branding">
                <div class="floatleft">
                    <img src="<c:url value='/resources/img/logo.png'/>" alt="Logo" /></div>
                <div class="floatright">
                    <div class="floatleft">
                    <div class="floatleft marginleft10">
                        <ul class="inline-ul floatleft">
                           <li><a href="<spring:url value="/logOut" htmlEscape="true"/>">Logout</a></li>
                        </ul>
                    </div>
                </div>
                <div class="clear">
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
            <ul class="nav main">
                   <li class="ic-form-style"> <a href="javascript:"><span>Users</span></a>
                    <ul>
                        <li><a href="welcome"><img src="<c:url value='/resources/images/b_usradd.png'/>"/>&nbsp;&nbsp;Add New User</a> </li>
                        <li><a href="#"  class="topopup"><img src="<c:url value='/resources/images/b_view.png'/>"/>&nbsp;&nbsp;Search user</a></li>
                        <li><a href="userList"><img src="<c:url value='/resources/images/b_usrlist.png'/>"/>&nbsp;&nbsp;List Of Users</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
            <div class="box round first fullpage">
                <h2><img src="<c:url value='/resources/images/b_usradd.png'/>"/>&nbsp;&nbsp;Add New User</h2>
                <div class="block ">
                <fieldset>
                <c:if test="${!empty userToEdit}">
                <c:forEach items="${userToEdit}" var="user">
                  <form:form action="/MyTrades/update" name="addForm" modelAttribute="usr" method="post" onSubmit="return checkInput(this)">
                    <table class="form">
                    	
                        <tr>
                            <td class="col1">
                                <label>*First Name</label>
                            </td>
                            <td class="col2">
                             <form:hidden path="userId" cssClass="form_input" value="${user.userId}"/>
                                <form:input path="firstName" cssClass="form_input" value="${user.firstName}" onkeydown= "return isAlpha(event.keyCode);"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="col1">
                                <label>*Last Name</label>
                            </td>
                            <td class="col2">
                                <form:input path="lastName" class="form_input" value="${user.lastName}" onkeydown= "return isAlpha(event.keyCode);"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="col1">
                                <label>*User Name</label>
                            </td>
                            <td class="col2">
                                <form:input path="username" class="form_input" value="${user.username}"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="col1">
                                <label>*Password</label>
                            </td>
                            <td class="col2">
                                <form:password path="password" class="form_input" value="${user.password}"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="col1">
                                <label>*Phone</label>
                            </td>
                            <td class="col2">
                                <form:input path="phone" class="form_input" value="${user.phone}" onkeypress="return isNumberKey(event)" maxlength="10"/>
                            </td>
                        </tr>
                         <tr>
                            <td class="col1">
                                <label>*Email Id</label>
                            </td>
                            <td class="col2">
                                <form:input path="emailId" class="form_input" value="${user.emailId}"/>
                            </td>
                        </tr>
                        <tr>
                        	<td>
                        	 <input type="submit" value="Update" name="update" class="btn btn-orange"/> 
						   	</td>
                        </tr>
                    </table>
                   </form:form>
                   </c:forEach>
                   </c:if>
                   </fieldset>
                </div>
            </div>
          
            </div>
            
        </div>
        <div class="clear">
      </div>
    <div class="clear">
    </div>
    

    <div id="toPopup"> 
	 <div class="close"></div>
     	<span class="ecs_tooltip">Press Esc to close <span class="arrow"></span></span>
		<div id="popup_content"> <!--your content start-->
			<form:form action="/MyTrades/search" name="searchForm" modelAttribute="usr" method="post" onSubmit="return checkUserName(this)">
             <br><br>
             <label>User Name : </label> <form:input path="username"/>
             <br><br>
             <p align="center"><input type="submit" value="Search" name="search" class="btn btn-red"/></p>
             </form:form>
       </div> <!--your content end-->
    </div> <!--toPopup end-->
   	<div class="loader"></div>
  	<div id="backgroundPopup"></div>
   
    <div id="site_info">
        <p>
            Copyright @ 2014. All Rights Reserved.
        </p>
    </div>
</body>
</html>
    