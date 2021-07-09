package classes;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TodoDelete
 */
@WebServlet("/TodoDelete")
public class TodoDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("todo_id"));
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.makeConnection();
		TodoDBFunctions todoDBFunctions=new TodoDBFunctions(connection);
		boolean flag=todoDBFunctions.deleteTodoById(id);
		HttpSession httpSession=request.getSession();
		if(flag==true) {
			httpSession.setAttribute("success-msg-todo-delete", "Your Todo Deleted Successfully");
		}
		else {
			httpSession.setAttribute("failed-msg-todo-delete", "Todo cannot be deleted before scheduled time. Deactivate, if required");
		}
		response.sendRedirect("index.jsp");
	}

}
