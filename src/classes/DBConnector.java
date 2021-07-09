package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	
	String jdbcURL= "jdbc:mysql://localhost:3306/toder?autoReconnect=true&useSSL=false";
	String username="root";
	String password="root";
	Connection connection;
	public Connection makeConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			connection = DriverManager.getConnection(jdbcURL, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connection!=null) {
			System.out.println("Connected");
		}
		return connection;
	}
	void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
