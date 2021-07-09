<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container">
<hr>





<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
<% if(currUser!=null) response.sendRedirect("index.jsp"); %>
	<% String success_msg=(String)session.getAttribute("success-msg-forgot");
		if(success_msg!=null){ %>
			<div class="alert alert-success" role="alert">
  				<%=success_msg%>
			</div>
	<% 	
		session.removeAttribute("success-msg-forgot");
		}
	%>
	
	
	<% String failed_msg=(String)session.getAttribute("failed-msg-forgot");
		if(failed_msg!=null){ %>
			<div class="alert alert-danger" role="alert">
  				<%=failed_msg%>,<a href="registration.jsp">Register from Here</a>
			</div>
	<%
	session.removeAttribute("failed-msg-forgot");
		}
	%>
	<h4 class="card-title mt-3 text-center">Forgot your Password?</h4>
	<p class="text-center">Change your password easily by submitting your valid email address </p>
	
	<form method="post" action="ForgotPassword">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="email" class="form-control" placeholder="Email address" type="email" title="Email is required for your notification &#128233;" required>
        <span class="input-group-text" style="color:red">*</span>
    </div> <!-- form-group// -->                               
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Submit  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">Want to login? <a href="login.jsp">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div> 

</body>
</html>