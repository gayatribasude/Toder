package classes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TodoUpdate
 */
@WebServlet("/TodoUpdate")
public class TodoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int id=Integer.parseInt(request.getParameter("todo_id"));
		System.out.println("yahahhahfh "+id);
		String headingString=request.getParameter("heading");
		String subheadingString=request.getParameter("subheading");
		String datetimeString=request.getParameter("datetime");
		String detailString=request.getParameter("details");
		Short activeShort=Short.parseShort(request.getParameter("active"));
		Short doneShort=Short.parseShort(request.getParameter("done"));
		DBConnector dbConnector=new DBConnector();
		TodoDBFunctions todoDBFunctions=new TodoDBFunctions(dbConnector.makeConnection());
		Todo todo=new Todo();
		todo.setTodo_idInt(id);
		todo.setHeadingString(headingString);
		todo.setActiveShort(activeShort);
		
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);//YYYY-MM-DD hh:mm:ss //E MMM dd HH:mm:ss z yyyy
//		java.util.Date datetimeStringDate =null; 
//		java.sql.Timestamp datetimeTimestamp=null;
//		try {
//			
//			datetimeStringDate=format.parse(datetimeString);
//			Long date_of_birthDateLong=datetimeStringDate.getTime();
//			
//			datetimeTimestamp=new java.sql.Timestamp(date_of_birthDateLong);
//			System.out.println(datetimeTimestamp);
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		Todo oldTodo=todoDBFunctions.getTodoById(id);
		todo.setDetailsString(detailString);
		todo.setDatetimeTimestamp(oldTodo.getDatetimeTimestamp());
		todo.setSubheadingString(subheadingString);
		todo.setDoneShort(doneShort);
		System.out.print(todo.getTodo_idInt()+" "+todo.getDetailsString()+" "+todo.getDatetimeTimestamp()+" "+todo.getSubheadingString()+" "+todo.getActiveShort()+" "+todo.getDoneShort()+" "+todo.getTodo_idInt()+" "+todo.getHeadingString());
		Boolean flag=todoDBFunctions.updateTodo(todo);
		HttpSession httpSession=request.getSession();
		if(flag==true) {
			httpSession.setAttribute("success-msg-todo-update", "Your Todo Updated Successfully");
		}
		else {
			httpSession.setAttribute("failed-msg-todo-update", "Something Went Wrong");
		}
		response.sendRedirect("seetodo.jsp");
		
		
	}

}
