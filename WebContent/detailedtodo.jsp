<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.DBConnector" %>
<%@ page import="classes.Todo" %>
<%@page import="classes.TodoDBFunctions"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Page of a todo</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<% 
   Integer id=Integer.parseInt(request.getParameter("todo_id"));
	
   DBConnector dbConnector=new DBConnector();
   Connection connection=dbConnector.makeConnection();
   TodoDBFunctions todoDBFunctions=new TodoDBFunctions(connection);
   Todo currTodo=todoDBFunctions.getTodoById(id);
%>

			<div class="container">
			
			  <h1 class="my-4"><%=currTodo.getHeadingString() %>
			    <small><%= currTodo.getSubheadingString() %></small>
			  </h1>
			
			  
			  <div class="row">
			
			    <div class="col-md-6">
			      <img src="todo2.png" alt="SAfd">
			    </div>
			
			    <div class="col-md-6">
			      <h3 class="my-3">Todo Description</h3>
			      <p><%=currTodo.getDetailsString() %>.</p>
			      <h3 class="my-3">Todo Details</h3>
			      <ul>
			        <li>Time: <%= currTodo.getDatetimeTimestamp() %></li>
			        <%if(currTodo.getDatetimeTimestamp().before(Calendar.getInstance().getTime())){ %>
			        	<li>The reminder has been sent to you.</li>
			        <% }else{%>
			        	<li>This todo is yet to come in your mail.</li>
			        <% }%>
			        
			        
			        <%if(currTodo.getDoneShort()==1){ %>
			        	<li>You have completed the task.</li>
			        <% }else{%>
			        	<li>You have not done the task.</li>
			        <% }%>
			        
			        
			        <%if(currTodo.getActiveShort()==1){ %>
			        	<li>This is an active task.</li>
			        <% }else{%>
			        	<li>This is not an active task.</li>
			        <% }%>
			        <a href="updatetodo.jsp?todo_id=<%= currTodo.getTodo_idInt() %>" class="badge-primary badge-pill">Update</a>
			        <a href="TodoDelete?todo_id=<%= currTodo.getTodo_idInt() %>" class="badge-primary badge-pill">Delete</a>
  		
			      </ul>
			    </div>
			
			  </div>
			  
		</div>
	

</body>
</html>