package classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MarkTodoAsDone
 */
@WebServlet("/MarkTodoAsDone")
public class MarkTodoAsDone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MarkTodoAsDone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int todo_id=Integer.parseInt(request.getParameter("todo_id"));
		//int user_id=Integer.parseInt(request.getParameter("user_id"));
		DBConnector dbConnector=new DBConnector();
		TodoDBFunctions todoDBFunctions=new TodoDBFunctions(dbConnector.makeConnection());
		Todo todo=todoDBFunctions.getTodoById(todo_id);
		todo.setDoneShort((short)1);
		boolean flag=todoDBFunctions.updateTodo(todo);
		HttpSession httpSession=request.getSession();
		String msgString;
		
		if(flag==true) {
			msgString="Wohh, Congratulations on completing the task";
		}
		else {
			msgString="Opps, Something went wrong";
		}
		httpSession.setAttribute(msgString, msgString);
		response.sendRedirect("DoneTodo.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int todo_id=Integer.parseInt(request.getParameter("todo_id"));
		//int user_id=Integer.parseInt(request.getParameter("user_id"));
		DBConnector dbConnector=new DBConnector();
		TodoDBFunctions todoDBFunctions=new TodoDBFunctions(dbConnector.makeConnection());
		Todo todo=todoDBFunctions.getTodoById(todo_id);
		todo.setDoneShort((short)1);
		boolean flag=todoDBFunctions.updateTodo(todo);
		HttpSession httpSession=request.getSession();
		String msgString;
		
		if(flag==true) {
			msgString="Wohh, Congratulations on completing the task";
		}
		else {
			msgString="Opps, Something went wrong";
		}
		httpSession.setAttribute("msgString", msgString);;
		response.sendRedirect("DoneTodo.jsp");
		
		
		
		
	}

}
