package classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	super.doGet(request, response);
		
		
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DBConnector dbConnector=new DBConnector();
		int id=Integer.parseInt(request.getParameter("user_id"));
		UserDBFunctions userDBFunctions=new UserDBFunctions(dbConnector.makeConnection());
		boolean flag=userDBFunctions.deleteUserById(id);
		HttpSession httpSession=request.getSession();
		if(flag==true) {
			httpSession.setAttribute("success-msg-user-delete", "User Deleted successfully");
			httpSession.removeAttribute("currUser");
		}
		else {
			httpSession.setAttribute("failed-msg-todo-user-delete", "Something Went Wrong");
		}
		response.sendRedirect("login.jsp");
	}

}
