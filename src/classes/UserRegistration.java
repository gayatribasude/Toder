package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;









@WebServlet("/UserRegistration")
public class UserRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UserRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String usernameString=request.getParameter("username");
		String emailString=request.getParameter("email");
		String passwordString=request.getParameter("password");


		String dobString=request.getParameter("dob");
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");//YYYY-MM-DD hh:mm:ss
		java.util.Date date_of_birthDate =null; 
		java.sql.Date date_of_birthDateSql=null;
		try {
			date_of_birthDate=format.parse(dobString);
			Long date_of_birthDateLong=date_of_birthDate.getTime();
			
			date_of_birthDateSql=new java.sql.Date(date_of_birthDateLong);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		long phone_numberLong =Long.parseLong(request.getParameter("phone_number"));  
		
		
		User user=new User(usernameString,emailString,passwordString,date_of_birthDateSql,phone_numberLong);
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.makeConnection();
		UserDBFunctions userDBFunctions=new UserDBFunctions(connection);
		boolean flag=userDBFunctions.addUser(user);
		HttpSession httpSession=request.getSession();
		if(flag==true) {
			response.sendRedirect("login.jsp");
			httpSession.setAttribute("success-msg", "Registration Successful");
		}
		else {
			httpSession.setAttribute("failed-msg", "Something Went Wrong: Account with this email address alreay exits");
			response.sendRedirect("registration.jsp");
		}
		
	}

}
