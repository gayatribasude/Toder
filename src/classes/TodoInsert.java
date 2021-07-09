package classes;


import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class TodoInsert
 */
@WebServlet("/TodoInsert")
public class TodoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoInsert() {
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
		int user_idInt=Integer.parseInt(request.getParameter("user_id"));
		String headingString=request.getParameter("heading");
		String subheadingString=request.getParameter("subheading");
		String datetimeString=request.getParameter("datetime");
		String detailString=request.getParameter("details");
		Short activeShort=1;
		Short doneShort=0;

		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.US);//YYYY-MM-DD hh:mm:ss //E MMM dd HH:mm:ss z yyyy
		java.util.Date datetimeStringDate =null; 
		java.sql.Timestamp datetimeTimestamp=null;
		try {
			
			datetimeStringDate=format.parse(datetimeString);
			Long date_of_birthDateLong=datetimeStringDate.getTime();
			
			datetimeTimestamp=new java.sql.Timestamp(date_of_birthDateLong);
			System.out.println(datetimeTimestamp);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		HttpSession httpSession=request.getSession();
		
		
		//todo should be of after curr time
		Calendar calendar=Calendar.getInstance();
		if(calendar.getTime().before(datetimeStringDate)) {
			
		
		
		
		
		Todo todo=new Todo(user_idInt,headingString,subheadingString,detailString,datetimeTimestamp,activeShort,doneShort);
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.makeConnection();
		TodoDBFunctions userDBFunctions=new TodoDBFunctions(connection);
		UserDBFunctions userDBFunctions2=new UserDBFunctions(connection);
		//boolean flag=userDBFunctions.addTodo(todo);
		Todo createdTodo=userDBFunctions.addTodoAndGetIt(todo);
		
		if(createdTodo!=null) {
			
			// creates a new calendar instance
			calendar.setTime(datetimeStringDate);   // assigns calendar to given date 
			calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
			calendar.get(Calendar.HOUR);        // gets hour in 12h format
			calendar.get(Calendar.MONTH);   
			System.out.println(calendar.getTime());

			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
			    @Override
			    public void run() {
			        //Call your method here
			        //setEmail(emailContent, subject);
			    	User user=userDBFunctions2.getUserById(user_idInt);
			    	String recepientString=user.getEmailString();
			    	//MailFunctions.sendMail(recepientString,headingString,subheadingString,calendar.getTime(),detailString);
			    	MailFunctions.sendMailTodo(recepientString,createdTodo);
			    }
			}, calendar.getTime(), 86400000);

			
			httpSession.setAttribute("success-msg-todo", "Your Todo Added Successfully");
		}
		}
		else {
			httpSession.setAttribute("failed-msg-todo", "Please enter valid time");
		}
		response.sendRedirect("addtodo.jsp");
	}

	
}


