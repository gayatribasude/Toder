<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container">
<hr>

<% if(currUser!=null) response.sendRedirect("index.jsp"); %>


<div class="card bg-light shadow">
<article class="card-body mx-auto" style="max-width: 400px;">
	<% String failed_msg=(String)session.getAttribute("failed_login");
		if(failed_msg!=null){ %>
			<div class="alert alert-danger" role="alert">
  				<%=failed_msg%>	
			</div>
	<%
	session.removeAttribute("failed_login");
		}
	%>
	<% String success_msg=(String)session.getAttribute("success-msg");
		if(success_msg!=null){ %>
			<div class="alert alert-success" role="alert">
  				<%=success_msg%>	
			</div>
	<%
	session.removeAttribute("success-msg");
		}
	%>
	<% String success_msg_logged_out=(String)session.getAttribute("success-msg-logout");
		if(success_msg_logged_out!=null){ %>
			<div class="alert alert-success" role="alert">
  				<%=success_msg_logged_out%>	
			</div>
	<%
	session.removeAttribute("success-msg-logout");
		}
	%>
	<h4 class="card-title mt-3 text-center">Login</h4>
	<p class="text-center">Get started with your own account</p>
	<form action="UserLogin" method="post">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="email" class="form-control shadow" placeholder="Email address" title="Enter enter email address &#128512;" type="text" required>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control shadow" name="password" placeholder="Enter password" title="Enter enter password &#128512;" type="password" required>
    </div> <!-- form-group// -->                                   
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Login  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">Want to have an account? <a href="registration.jsp">Register from here</a> </p>                      
    <p class="text-center">Forgot Password? <a href="forgotpassword.jsp">Go Here</a> </p>                                                               
</form>
</article>
</div> <!-- card.// -->

</div> 
</body>
</html>