<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Todo</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<% if(currUser==null) response.sendRedirect("index.jsp"); %>
	
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<% String success_msg=(String)session.getAttribute("success-msg-todo");
		if(success_msg!=null){ %>
			<div class="alert alert-success" role="alert">
  				<%=success_msg%>
			</div>
	<% 	
		session.removeAttribute("success-msg-todo");
		}
	%>
	
	
	<% String failed_msg=(String)session.getAttribute("failed-msg-todo");
		if(failed_msg!=null){ %>
			<div class="alert alert-danger" role="alert">
  				<%=failed_msg%>	
			</div>
	<%
	session.removeAttribute("failed-msg-todo");
		}
	%>
	<h4 class="card-title mt-3 text-center">Add Todo</h4>
	<p class="text-center">We will remind you to do your task</p>
	<form action="TodoInsert" method="post">
	
	<%
    	 if(user!=null){
    		 System.out.println(user.getUser_idId());
    %>
		<input type="hidden" name="user_id" value="<%= user.getUser_idId() %>">
		<%} %>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-heading"></i> </span>
		 </div>
        <input name="heading" class="form-control" placeholder="Enter Heading" type="text" required>
        <span class="input-group-text" style="color:red">*</span>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-closed-captioning"></i> </span>
		 </div>
        <input name="subheading" class="form-control" placeholder="Enter Sub Heading" type="text" >
    </div> <!-- form-group// -->
        <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="far fa-clock"></i> </span>
		</div>
		<input class="form-control" type="datetime-local" name="datetime" required>
		<span class="input-group-text" style="color:red">*</span>
	</div> <!-- form-group end.// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-info-circle"></i> </span>
		 </div>
        <textarea name="details" class="form-control" placeholder="Enter Details"></textarea>
    </div> <!-- form-group// -->

                                     
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Add Todo  </button>
    </div> <!-- form-group// -->      
                                                                    
</form>
</article>
</div> <!-- card.// -->
</body>
</html>