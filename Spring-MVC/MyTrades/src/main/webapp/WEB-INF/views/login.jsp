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
<link href="<c:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/table.css'/>" media="screen" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/reset.css'/>" media="screen" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/text.css'/>" media="screen" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/grid.css'/>" media="screen" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/layout.css'/>" media="screen" />
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/nav.css'/>" media="screen" />
<script>var __links = document.querySelectorAll('a');function __linkClick(e) { parent.window.postMessage(this.href, '*');} ;for (var i = 0, l = __links.length; i < l; i++) {if ( __links[i].getAttribute('data-t') == '_blank' ) { __links[i].addEventListener('click', __linkClick, false);}}</script>
<script src="<c:url value='/resources/js/jquery.min.js'/>"></script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
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
<!-- contact-form -->	

<c:if test="${not empty invalidLogin}">
   <div class="message error">
   <h5>Invalid User/ Password !!!</h5>
   </div> 
</c:if>

<div class="message warning">
<div class="login-head"><h1>MyTrades</h1></div>
<br><br>
<div class="inset">
	
		 <form:form action="/MyTrades/login" name="loginForm" modelAttribute="usr" onSubmit="return validate(this)">
			<li>
				<a href="#" class=" icon user"></a><form:input path="username"/>
			</li>
				<div class="clear"> </div>
			<li>
				<a href="#" class="icon lock"></a><form:password path="password"/>
			</li>
			<div class="clear"> </div>
			<div class="submit">
			<input type="submit" name="login" value="Login" >
			<div class="clear">  </div>	
			</div>
				
		</form:form>
		</div>					
</div>
	<div class="clear"> </div>
</body>
</html>
