<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.programmingfree.salesreport.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>MyTrades :: List Of Users</title>
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
    
    <link href="<c:url value='/resources/css/popupstyle.css'/>" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="<c:url value='/resources/js/script.js'/>"></script>
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
	</script>
	
	
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
				
					
					<div id="demo_jui">
					<table id="companies" class="display">
				            <thead>
				                <tr>
				                    <th><u>Country</u></th>
				                    <th><u>Revenue</u></th>
				                    <th><u>Sales_Manager</u></th>
				                    <th><u>Year</u></th>
				                </tr>
				            </thead>
				            <tbody>
				          		<% for(SalesReport c: FetchDataFromDb.GetSalesData()){ %>
								  <tr>
								    <td><%=c.getCountry()%></td>
								    <td><%=c.getRevenue()%></td>
								    <td><%=c.getSalesmanager()%></td>
								    <td><%=c.getYear()%></td>
								  </tr>
								<% } %>
				            </tbody>
				        </table>
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
             <label>User Name</label> <input type="text" name="username"/>
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
    