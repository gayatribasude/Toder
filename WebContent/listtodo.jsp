<%@page import="classes.DBConnector"%>
<%@page import="classes.TodoDBFunctions"%>
<%@page import="java.util.*" %>
<%@page import="classes.Todo" %>
<%@page import="org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.User" %>
 <%User user1=(User)session.getAttribute("currUser");%>

<div class="container">
<hr>

<%
	if(user1!=null){
		DBConnector dbConnector=new DBConnector();
		TodoDBFunctions todoDBFunctions=new TodoDBFunctions(dbConnector.makeConnection());
		List<Todo> listTodos=todoDBFunctions.getUserTodo(user1.getUser_idId()); %>
		<div class="card bg-light">
		<article class="card-body mx-auto" style="max-width: 2000px;">
		
		
		<% String success_msg=(String)session.getAttribute("success-msg-todo-update");
		if(success_msg!=null){ %>
			<div class="alert alert-success" role="alert">
  				<%=success_msg%>
			</div>
	<% 	
		session.removeAttribute("success-msg-todo-update");
		}
	%>
	
	
	<% String failed_msg=(String)session.getAttribute("failed-msg-todo-update");
		if(failed_msg!=null){ %>
			<div class="alert alert-danger" role="alert">
  				<%=failed_msg%>	
			</div>
	<%
	session.removeAttribute("failed-msg-todo-update");
		}
	%>
	
	<% String success_msg_delete=(String)session.getAttribute("success-msg-todo-delete");
		if(success_msg_delete!=null){ %>
			<div class="alert alert-success" role="alert">
  				<%=success_msg_delete%>
			</div>
	<% 	
		session.removeAttribute("success-msg-todo-delete");
		}
	%>
	
	
	<% String failed_msg_delete=(String)session.getAttribute("failed-msg-todo-delete");
		if(failed_msg_delete!=null){ %>
			<div class="alert alert-danger" role="alert">
  				<%=failed_msg_delete%>
			</div>
	<%
	session.removeAttribute("failed-msg-todo-delete");
		}
	%>
	<% if(listTodos.size()==0){%>
		You haven't registered any todo. Kindly register from here <a href="addtodo.jsp">Add Todo</a>
		
	<%}
	%>
	
	
    	<ul class="list-group">
    	<% for(Todo todo:listTodos){ %>
    	<% if(todo.getActiveShort()==0) {%>
    		<strike>
    			<li class="list-group-item d-flex container-fluid">
	    	<a data-toggle="modal" data-target="todo_profile" href="#"><%= todo.getHeadingString() %> </a><br>
	    	<span class="badge-pill"><%= todo.getSubheadingString() %></span><hr>
	    	<a class=" badge-pill"> <%= todo.getDatetimeTimestamp() %></a>
	    	
	    	<% if(todo.getDoneShort()==0) {%>
	    	<i class="fas fa-clipboard-list" style="color:black"></i>&nbsp;&nbsp;
	    	<%}else{%>
	    		<i class="fas fa-check" style="color:green"></i>&nbsp;
	    	<%} %>
	    	<!--  <button class="badge-primary badge-pill" id="feed_id" data-id="<%= todo.getTodo_idInt() %>" data-toggle="modal" data-target="#todo_update">Update</button>-->
	    	<a href="updatetodo.jsp?todo_id=<%= todo.getTodo_idInt() %>" class="badge-primary badge-pill">Update</a>
	    	<a href="TodoDelete?todo_id=<%= todo.getTodo_idInt() %>" class="badge-primary badge-pill">Delete</a>
  		
  		</li>
    		</strike>
    	<%}else{ %>
    		<li class="list-group-item d-flex">
	    	<a href="detailedtodo.jsp?todo_id=<%= todo.getTodo_idInt() %>"><%= todo.getHeadingString() %> </a><br>
	    	<span class="badge-pill"><%= todo.getSubheadingString() %></span><hr>
	    	<a class=" badge-pill"> <%= todo.getDatetimeTimestamp() %></a>
	    	
	    	<% if(todo.getDoneShort()==0) {%>
	    	<i class="fas fa-clipboard-list" style="color:black"></i>&nbsp;&nbsp;
	    	<%}else{%>
	    		<i class="fas fa-check" style="color:green"></i>&nbsp;
	    	<%} %>
	    	<!--  <button class="badge-primary badge-pill" id="feed_id" data-id="<%= todo.getTodo_idInt() %>" data-toggle="modal" data-target="#todo_update">Update</button>-->
	    	<a href="updatetodo.jsp?todo_id=<%= todo.getTodo_idInt() %>" class="badge-primary badge-pill">Update</a>
  			<a href="TodoDelete?todo_id=<%= todo.getTodo_idInt() %>" class="badge-primary badge-pill">Delete</a>
  		
	    </li>
    		
    	<%} %>
    	
		<% }
		}else{
			System.out.println("didnt get the todo of user, user is null");
		
		
	 	}%>
   
		</ul>
		</article>
		</div> <!-- card.// -->




</div>
<!--  profile-->
<div class="modal fade" id="todo_profile" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Profile</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="card">
			  <h6>adsfds</h6>
			  <h1>afddasdgssgd</h1>
			  <p class="title">fsd</p>
			  <p>asfd</p>
			  <div style="margin: 24px 0;">
			    
			  </div>
			  
		</div>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        
      </div>
    </div>
  </div>
</div>

