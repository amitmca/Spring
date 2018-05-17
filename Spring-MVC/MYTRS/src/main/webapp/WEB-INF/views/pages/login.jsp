<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<title>Login :: MyTrades</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<link href="<c:url value='/resources/css/login.css'/>" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="<c:url value='/resources/js/customalert.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/customalert.css'/>" />
<script type="text/javascript">

	function setColor(el, bg) 
	{
	  	if (el.style) el.style.backgroundColor = bg;
	}

	function validate(form) 
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

		  if (form.password.value == "" || form.password.value.trim().length==0) {
		    valid = false;
		    setColor(form.password, bgBad);
		  
		  } else {
		    setColor(form.password, bgGood);
		  }		  

	      errmsg=errmsg+"\n\nPlease enter the Username and password";
		
		  if (!valid) 
			createCustomAlert(errmsg,"","Errors");
			
    	 return valid;
	} 
</script>		
</head>
<body>
<div class="wrap">
	<div id="content">
		<div id="main">
			<c:if test="${not empty invalidLogin}">
			   <div class="n_error">
			   <font color="red" size="4px">Invalid Username / Password !!!</font>
			   </div> 
			</c:if>
			<img src="<c:url value='/resources/images/llogo.png'/>"/>
			<div class="full_w">
				 <form:form action="/MYTRS/login" name="loginForm" modelAttribute="usr" onSubmit="return validate(this)">
					<label for="login">Username:</label>
					<form:input path="username" class="text" />
					<label for="pass">Password:</label>
					<form:password path="password" class="text" />
					<div class="sep"></div>
					<input type="submit" name="login" value="Login" class="ok"/>
				</form:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
