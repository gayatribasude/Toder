package classes;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		User user_from_session=(User)httpSession.getAttribute("currUser");
		
		
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.makeConnection();
		UserDBFunctions userDBFunctions=new UserDBFunctions(connection);
		
		String usernameString=request.getParameter("username");
		String emailString=user_from_session.getEmailString();
		int user_idInt=user_from_session.getUser_idId();
		long phone_numberLong=Long.parseLong(request.getParameter("phone_number"));
		String dobString=request.getParameter("dob");
		
		
		java.util.Date date_of_birthDate =null; //new java.sql.Date( date_of_birth.getTime() );
		java.sql.Date date_of_birthDateSql=null;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			date_of_birthDate=format.parse(dobString);
			Long date_of_birthDateLong=date_of_birthDate.getTime();
			
			date_of_birthDateSql=new java.sql.Date(date_of_birthDateLong);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		String passwordString=request.getParameter("password");
		
		User user=new User();
		user.setUsernameString(usernameString);
		user.setDate_of_birthdayDate(date_of_birthDateSql);
		user.setEmailString(emailString);
		user.setUser_idId(user_idInt);
		user.setPasswordString(passwordString);
		user.setPhone_numberLong(phone_numberLong);
		boolean flag=userDBFunctions.updateUser(user);
		if(flag==true) {
			httpSession.removeAttribute("currUser");
			httpSession.setAttribute("currUser", user);
			httpSession.setAttribute("success_update", "Successfully Updated");
		}
		
		else {
			httpSession.setAttribute("failed_update", "Something Went Wrong");
		}
		response.sendRedirect("index.jsp");
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(request, response);
		
	}

}
