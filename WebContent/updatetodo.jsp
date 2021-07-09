<%@page import="classes.TodoDBFunctions"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.DBConnector" %>
<%@ page import="classes.Todo" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<%-- <% System.out.print(request.getParameter("note_id")); %> --%>
<% if(currUser==null) response.sendRedirect("index.jsp"); %>

<% 
   Integer id=Integer.parseInt(request.getParameter("todo_id"));
	
   DBConnector dbConnector=new DBConnector();
   Connection connection=dbConnector.makeConnection();
   TodoDBFunctions todoDBFunctions=new TodoDBFunctions(connection);
   Todo currTodo=todoDBFunctions.getTodoById(id);
%>

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
	<h4 class="card-title mt-3 text-center">Update Todo</h4>
	<p class="text-center">We will remind you to do your task</p>
	<form action="TodoUpdate" method="post">
	<input type="hidden" name="todo_id" value="<%=id%>">
	
	<%
    	 if(user==null){
    		 response.sendRedirect("login.jsp");
    	 }
    	 else{
    		 System.out.println(user.getUser_idId());
    %>
		<input type="hidden" name="user_id" value="<%= user.getUser_idId() %>">
		<%} %>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-heading"></i> </span>
		 </div>
        <input name="heading" class="form-control" title="Enter heading for your todo &#128512;" placeholder="Enter Heading" type="text" value="<%= currTodo.getHeadingString() %>"required>
        <span class="input-group-text" style="color:red">*</span>
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-closed-captioning"></i> </span>
		 </div>
        <input name="subheading" class="form-control" title="Enter Subheading &#128512;" placeholder="Enter Sub Heading" type="text" value="<%= currTodo.getSubheadingString() %>" >
    </div> <!-- form-group// -->
        <%-- <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="far fa-clock"></i> </span>
		</div>
		<input class="form-control" type="datetime-local" name="datetime" value="<%= currTodo.getDatetimeTimestamp() %>" required>
		
		<span class="input-group-text" style="color:red">*</span>
	</div> <!-- form-group end.// --> --%>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fas fa-info-circle"></i> </span>
		 </div>
        <textarea name="details" class="form-control" title="Enter details of your todo &#128512;" placeholder="Enter Details"><%= currTodo.getDetailsString() %></textarea>
    </div> <!-- form-group// -->
    
    <% short active=currTodo.getActiveShort(); %>
    
    <div class="form-group form-check form-check-inline">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i style="color:red" class="fas fa-calendar-times"></i> </span>
		 </div>
		 <div class="display-6 ml-3">Active:</div>
		 <%if(active==1){%>
		 
			<input name="active" class="form-check-input ml-3" id="yes" placeholder="Enter active" title="Active??" type="radio" value="1" required checked><label class="form-check-label" for="yes">Yes</label>
        	<input name="active" class="form-check-input ml-3" id="no" placeholder="Enter active" title="Active??" type="radio" value="0" required><label class="form-check-label" for="no">No</label>
		 	 
		 <%}else{%>
			<input name="active" class="form-check-input ml-3" id="yes" placeholder="Enter active" title="Active??" type="radio" value="1" required ><label class="form-check-label" for="yes">Yes</label>
        	<input name="active" class="form-check-input ml-3" id="no" placeholder="Enter active" title="Active??" type="radio" value="0" required checked><label class="form-check-label" for="no">No</label> 
		 <%} %>
		
        
        
    </div> <!-- form-group// -->
    
    <% short done=currTodo.getDoneShort(); %>
    <div class="form-group form-check form-check-inline">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i style="color:green" class="fas fa-check-circle"></i> </span>
		 </div>
		 <div class="display-6 ml-3">Done:</div>
		<% if(done==1){%>
			<input name="done" class="form-check-input ml-3" id="yes" placeholder="Enter Done" title="Done??" type="radio" value="1" required checked><label class="form-check-label" for="yes">Yes</label>
        	<input name="done" class="form-check-input ml-3" id="no" placeholder="Enter Done" title="Done??" type="radio" value="0" required><label class="form-check-label" for="no">No</label>
 		<%}else{%>
			<input name="done" class="form-check-input ml-3" id="yes" placeholder="Enter Done" title="Done??" type="radio" value="1" required ><label class="form-check-label" for="yes">Yes</label>
        	<input name="done" class="form-check-input ml-3" id="no" placeholder="Enter Done" title="Done??" type="radio" value="0" required checked><label class="form-check-label" for="no">No</label>
        
 		<%}%>
      
		 
    </div> <!-- form-group// -->

                                     
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Update Todo  </button>
    </div> <!-- form-group// -->      
                                                                    
</form>
</article>
</div> <!-- card.// -->
</body>
</html>