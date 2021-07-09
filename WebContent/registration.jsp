<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>

</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container">
<hr>





<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	

	<% if(currUser!=null) response.sendRedirect("index.jsp"); %>
	
	<% String failed_msg=(String)session.getAttribute("failed-msg");
		if(failed_msg!=null){ %>
			<div class="alert alert-danger" role="alert">
  				<%=failed_msg%>	
			</div>
	<%
	session.removeAttribute("failed-msg");
		}
	%>
	<h4 class="card-title mt-3 text-center">Registration</h4>
	<p class="text-center">Get started with your own account</p>
	
	<form method="post" action="UserRegistration">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="username" class="form-control" placeholder="Username" type="text" title="Enter any kind of cool username &#128512;" required>
        <span class="input-group-text" style="color:red">*</span>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="email" class="form-control" placeholder="Email address" type="email" title="Email is required for your notification &#128233;" required>
        <span class="input-group-text" style="color:red">*</span>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="+91">+91</option>
		</select>
    	<input name="phone_number" class="form-control" placeholder="Phone number" type="number" title="Don't worry we won't spam you &128222;" pattern="\d{10}" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 10 digits' : '');" required>
    	<span class="input-group-text" style="color:red">*</span>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-birthday-cake"></i> </span>
		</div>
		<input class="form-control" type="date" name="dob" title="Enter your Birth Date, we will wish you &#127874;" required>
		<span class="input-group-text" style="color:red">*</span>
	</div> <!-- form-group end.// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input id="password" class="form-control" name="password" placeholder="Create password" type="password" pattern="\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;" required>
        <span class="input-group-text" style="color:red">*</span>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input class="form-control" id="password_two" name="password_two" type="password" pattern="^\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Please enter the same Password as above' : '');" placeholder="Verify Password" required>
    	<span class="input-group-text" style="color:red">*</span>
    </div> <!-- form-group// -->                                      
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Create Account  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">Have an account? <a href="login.jsp">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div> 
</body>
</html>