package classes;

import java.io.IOException;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String emailString=request.getParameter("email");
		String passwordString=request.getParameter("password");
		
		User user=new User();
		user.setEmailString(emailString);
		user.setPasswordString(passwordString);
		
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.makeConnection();
		
		UserDBFunctions userDBFunctions=new UserDBFunctions(connection);
		User currUser=userDBFunctions.getUser(user);
		HttpSession httpSession=request.getSession();
		if(currUser!=null) {
			response.sendRedirect("index.jsp");
			httpSession.setAttribute("currUser",currUser);
		}
		else {
			
			httpSession.setAttribute("failed_login", "Please Enter Valid Username and Password");
			response.sendRedirect("login.jsp");
		}
		
	}

}
