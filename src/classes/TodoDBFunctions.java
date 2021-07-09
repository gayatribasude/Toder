package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TodoDBFunctions {

	private Connection connection;

	public TodoDBFunctions(Connection connection) {
		// TODO Auto-generated constructor stub
		super();
		this.connection=connection;
	}

	public boolean addTodo(Todo todo) {
		// TODO Auto-generated method stub
		String sql="insert into todo(user_id,heading,subheading,details,datetime,active,done)"+" values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1,todo.getUser_idInt());
			statement.setString(2,todo.getHeadingString());
			statement.setString(3,todo.getSubheadingString());
			statement.setString(4,todo.getDetailsString());
			statement.setTimestamp(5,todo.getDatetimeTimestamp());
			statement.setShort(6, todo.getActiveShort());
			statement.setShort(7,todo.getDoneShort());
			int rows=statement.executeUpdate();
			if(rows>0) {
				System.out.println("Successfully inserted:"+todo.getHeadingString());
				return true;
			}
			else {
				System.out.println("Not added");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Todo addTodoAndGetIt(Todo todo) {
		// TODO Auto-generated method stub
		String sql="insert into todo(user_id,heading,subheading,details,datetime,active,done)"+" values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement statement=connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1,todo.getUser_idInt());
			statement.setString(2,todo.getHeadingString());
			statement.setString(3,todo.getSubheadingString());
			statement.setString(4,todo.getDetailsString());
			statement.setTimestamp(5,todo.getDatetimeTimestamp());
			statement.setShort(6, todo.getActiveShort());
			statement.setShort(7,todo.getDoneShort());
			int rows=statement.executeUpdate();
			if(rows>0) {
				ResultSet rs = statement.getGeneratedKeys();
				if(rs.next()) {
					System.out.println("-----------");
					System.out.println("-----------");
					System.out.println(rs.getLong(1));
					System.out.println("-----------");
					System.out.println("-----------");
					Todo createdTodo=getTodoById((int)rs.getLong(1));
					createdTodo.setTodo_idInt((int)rs.getLong(1));	
					System.out.println("Successfully inserted:"+todo.getHeadingString());
					return createdTodo;
				}
			}
			else {
				System.out.println("Not added");
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	public List<Todo> getUserTodo(int id){
		 List<Todo> listTodos=new ArrayList<Todo>();
		 Todo todo=null;
		 String sql="select * from todo where user_id=? order by todo_id desc";
		 try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1,id);
	
			ResultSet rows=statement.executeQuery();
			while(rows.next()) {
				System.out.println("Data aayaaa");
				todo=new Todo();
				todo.setUser_idInt(rows.getInt("user_id"));
				todo.setTodo_idInt(rows.getInt("todo_id"));
				todo.setHeadingString(rows.getString("heading"));
				todo.setSubheadingString(rows.getString("subheading"));
				todo.setDetailsString(rows.getString("details"));
				todo.setDatetimeTimestamp(rows.getTimestamp("datetime"));
				todo.setActiveShort(rows.getShort("active"));
				todo.setDoneShort(rows.getShort("done"));
				listTodos.add(todo);

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTodos;
		
	}
	public Todo getTodoById(int todo_id) {
		String sql="select * from todo where todo_id=?";
		Todo currTodo=null;
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1,todo_id);
			ResultSet rows=statement.executeQuery();
			if(rows.next()) {
				System.out.println("Getting a todo");
				currTodo=new Todo();
				currTodo.setUser_idInt(rows.getInt("user_id"));
				currTodo.setTodo_idInt(rows.getInt("todo_id"));
				currTodo.setActiveShort(rows.getShort("active"));
				currTodo.setDatetimeTimestamp(rows.getTimestamp("datetime"));
				currTodo.setDetailsString(rows.getString("details"));
				currTodo.setDoneShort(rows.getShort("done"));
				currTodo.setHeadingString(rows.getString("heading"));
				currTodo.setSubheadingString(rows.getString("subheading"));
			}
			else {
				System.out.println("todo nahi aayaaa");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currTodo;
	}
	public boolean updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		String sql="update todo set heading=?,subheading=?,details=?,active=?,done=? where todo_id=?";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1,todo.getHeadingString());
			statement.setString(2,todo.getSubheadingString());
			statement.setString(3,todo.getDetailsString());
			statement.setShort(4,todo.getActiveShort());
			//statement.setTimestamp(5,todo.getDatetimeTimestamp());
			statement.setShort(5, todo.getDoneShort());
			statement.setInt(6,todo.getTodo_idInt());
			
			int rows=statement.executeUpdate();
			if(rows>0) {
				System.out.println("Successfully updated:"+todo.getTodo_idInt());
				return true;
			}
			else {
				System.out.println("Not updated");
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean deleteTodoById(int todo_id) {
		String sql="delete from todo where todo_id=? and datetime<NOW()";
		
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1,todo_id);
			
			int rows=statement.executeUpdate();
			if(rows==1) {
				System.out.println("todo delete huaa");
				return true;
			}
			else {
				System.out.println("todo delete nahi huaa");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public int getTotalToderCount() {
		String sqlString="select max(todo_id) from todo";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sqlString);
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	public int getTotalCompletedTaskCount() {
		String sqlString="select count(*) from todo where done=1";
		try {
			Statement statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sqlString);
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
