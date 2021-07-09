<%@page import="classes.UserDBFunctions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="classes.DBConnector" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="classes.TodoDBFunctions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Toder</title>
<style type="text/css">
.center_text{
	display: flex;
	justify-content: center;
	align-items: center;
	
}
</style>
</head>
<body>

<%@ include file="navbar.jsp" %>
<%
	DBConnector connector= new DBConnector();
	Connection connection=connector.makeConnection();
	UserDBFunctions userDBFunctions=new UserDBFunctions(connection);
	TodoDBFunctions todoDBFunctions1=new TodoDBFunctions(connection);
%>
<div class="container">
	<div class="row">
		<div class="col">
			<!-- <div class="display-6" ><h3 align="center">Todos</h3></div> -->
		</div>
		
	</div>
	<div class="row">
	<% String success_msg_update=(String)session.getAttribute("success_update");
							if(success_msg_update!=null){ %>
								<div class="alert alert-success" role="alert">
					  				<%=success_msg_update%>
								</div>
						<% 	
							session.removeAttribute("success_update");
							}
						%>
						
						
						<% String failed_msg_update=(String)session.getAttribute("failed_update");
							if(failed_msg_update!=null){ %>
								<div class="alert alert-danger" role="alert">
					  				<%=failed_msg_update%>	
								</div>
						<%
						session.removeAttribute("failed_update");
							}
						%>
		<div class="col-3">
			<div  class="display-6 center_text" ><%= userDBFunctions.getTotalActiveUserCount() %>: Active Users</div>
			<i style="font-size:70px;display: flex;justify-content: center;align-items: center;" class="text-muted fas fa-users"></i>
		</div>
		
		<div class="col-3">
			<div class="display-6 center_text" ><%= userDBFunctions.getTotalUserCount() %>: Registered Users</div>
			<i style="font-size:70px;display: flex;justify-content: center;align-items: center;" class="text-muted fas fa-user-plus"></i>
		</div>
		<div class="col-3">
			<div class="display-6 center_text" ><%= todoDBFunctions1.getTotalToderCount() %> :Total Todos registered</div>
			<i style="font-size:70px;display: flex;justify-content: center;align-items: center;" class="text-muted fas fa-list"></i>
		</div>
		<div class="col-3">
			<div class="display-6 center_text" ><%= todoDBFunctions1.getTotalCompletedTaskCount() %> : Total Completed task</div>
			<i style="font-size:70px;display: flex;justify-content: center;align-items: center;" class="text-muted fas fa-clipboard-check"></i>
		</div>
	</div>
	<div class="container px-4 py-5" id="icon-grid">
    <h2 class="pb-2 border-bottom">About Toder</h2>
	
  <ul>
    <li>User can add todo and remainder mail will get send to the user's email address at the time of reminder as alert</li> 
    <a href="addtodo.jsp"> Add Todo</a> |<a href="seetodo.jsp"> See your todos</a> | |<a href="seetodo.jsp"> Update todos</a>
    <li>User can mark done in the mail itself</li>
    <li>User can deactivate or can delete the todo</li>
    <li>User can change the password or other information related to profile in profile section</li>
    <li>User can deactivate the account, it permanently deletes the account</li>
  </ul>
    
  </div>
</div>
<hr/>
<hr/>


</body>

</html>