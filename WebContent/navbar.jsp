<%@page import="org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="classes.User"  %>
   <%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<head>
<link rel="stylesheet" href="style.css"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/Toder">Home <span class="sr-only">(current)</span></a>
      </li>
      <%User currUser=(User)session.getAttribute("currUser");
      	if(currUser==null){
      %>
      		<li class="nav-item">
        		<a class="nav-link" href="login.jsp">Login</a>
      		</li>
      <% 
      	}
      	else{
      		%>
      			<li class="nav-item">
      				<a class="nav-link" href="addtodo.jsp">Add Todo</a>
      			</li>
      			<li class="nav-item">
      				<a class="nav-link" href="seetodo.jsp">Update/Delete Todo</a>
      			</li>
      			<li class="nav-item" >
      				<a class="nav-link" href="UserLogout">Logout</a>
      			</li>
      		
      		<% 
      	}
      %>
      
      
      <% User user=(User)session.getAttribute("currUser");
      	if(user!=null){ %>
      	
      	<li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%=user.getUsernameString() %></a>
        <div class="dropdown-menu" aria-labelledby="dropdown08">
          <a class="dropdown-item" data-toggle="modal" data-target="#user_profile" href="#">Profile</a>
          <a class="dropdown-item" data-toggle="modal" data-target="#user_update" href="#" >Update Profile</a>
          <a class="dropdown-item" data-toggle="modal" data-target="#user_delete"  href="#">Delete your Account</a>
          <a class="dropdown-item" href="UserLogout">Logout</a>
        </div>
      </li>
      
      
      
      
      

  

      
      
		      <!--  profile-->
		<div class="modal fade" id="user_profile" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Profile</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="card text-center">
		        	  <div class="card-header">
    						A Toder
  					  </div>
  					  <div class="card-body">
		        	
		        <% SimpleDateFormat formatForPrint = new SimpleDateFormat("dd-MM-yyyy");
				
		        %>
					  
					  <h5 class="card-title"><%= user.getUsernameString() %></h5>
					 
					  <p class="card-text">Email:<%= user.getEmailString() %></p>
					 	<p class="card-text">Date of Birth:<%=formatForPrint.format(user.getDate_of_birthdayDate()) %></p>
					  <p class="card-text">Phone Number:<%= user.getPhone_numberLong() %></p>
					  
					  
					</div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        
		      </div>
		    </div>
		  </div>
		</div>
		</div>
		<!--  edit profile-->
		<div class="modal fade" id="user_update" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Update Your Profile</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <div class="card bg-light">
					<article class="card-body mx-auto" style="max-width: 400px;">
						 
						
						
						
						<form method="post" action="UserUpdate">
						<div class="form-group input-group">
							<div class="input-group-prepend">
							    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
							 </div>
					        <input name="username" class="form-control" placeholder="Username" type="text" title="Enter any kind of cool username &#128512;" value="<%= user.getUsernameString() %>" required>
					        <span class="input-group-text" style="color:red">*</span>
					    </div> <!-- form-group// -->
					    <div class="form-group input-group">
					    	<div class="input-group-prepend">
							    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
							 </div>
					        <input name="email" class="form-control" placeholder="Email address" type="email" title="Email is required for your notification &#128233;" value="<%= user.getEmailString() %>"  required disabled>
					        
					    </div> <!-- form-group// -->
					    <div class="form-group input-group">
					    	<div class="input-group-prepend">
							    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
							</div>
							<select class="custom-select" style="max-width: 120px;">
							    <option selected="+91">+91</option>
							</select>
					    	<input name="phone_number" class="form-control" placeholder="Phone number" type="text" title="Don't worry we won't spam you &128222;" value="<%= user.getPhone_numberLong() %>" required>
					    	
					    	<span class="input-group-text" style="color:red">*</span>
					    </div> <!-- form-group// -->
					    <div class="form-group input-group">
					    	<div class="input-group-prepend">
							    <span class="input-group-text"> <i class="fas fa-birthday-cake"></i> </span>
							</div>
							
							<input class="form-control" type="date" name="dob" title="Enter your Birth Date, we will wish you &#127874;" value="<%= user.getDate_of_birthdayDate() %>" required>
							<span class="input-group-text" style="color:red">*</span>
						</div> <!-- form-group end.// -->
					    <div class="form-group input-group">
					    	<div class="input-group-prepend">
							    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
							</div>	
					        <input id="password"  value=<%= user.getPasswordString() %> class="form-control" name="password" placeholder="Create password" type="password" pattern="\S{6,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Must have at least 6 characters' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;" required>
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
					        <button type="submit" class="btn btn-primary btn-block"> Save Changes  </button>
					    </div> <!-- form-group// -->      
					   </form>
					</article>
				</div> <!-- card.// -->
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        
		      </div>
		    </div>
		  </div>
		  
		
		  
		</div>
		  <!--  Delete Account-->
		<div class="modal fade" id="user_delete" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Deleting Your Account</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <%= currUser.getUsernameString() %>,Deleting your account..
		      </div>
		      <div class="modal-footer">
		      	<form  method="post" action="UserDelete">
		      	<input type="hidden" value="<%= currUser.getUser_idId() %>" name="user_id">
		        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
		       <!--  <button type="button" class="btn btn-primary" type="submit">Yes</button> -->
		       <input  class="btn btn-primary" type="submit" value="delete" onclick="if (confirm('Are you sure you want to delete?')) { form.action='UserDelete'; } else { return false; }" />
		       
		        </form>
		      </div>
		    </div>
		  </div>
		</div>
		
		
      
      		
      	<% }
      %>
    </ul>
  </div>
</nav>

<div class="jumbotron jumbotron-fluid" >
  <div class="container">
    <h1 style="margin-left:110px" class="display-4">Toder <i class="fa fa-tasks" aria-hidden="true"></i></h1>
    <% user=(User)session.getAttribute("currUser");
    	if(user==null){
    %>
    <p  style="margin-left:110px" class="lead">Your todo and reminder app</p>
    <% }else {%>
    	<div id="animated_div">Welcome <%=user.getUsernameString() %></div>
    	
    <% } %>
    
  </div>
  
</div>




    

