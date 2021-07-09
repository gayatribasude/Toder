package classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class UserDBFunctions {
	Connection connection;
	
	public UserDBFunctions(Connection connection) {
		super();
		this.connection=connection;
	}
	boolean addUser(User user) {
		String sql="insert into user(username,email,password,date_of_birth,phone_number)"+" values(?,?,?,?,?)";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1,user.getUsernameString());
			statement.setString(2,user.getEmailString());
			statement.setString(3,user.getPasswordString());
			statement.setDate(4,user.getDate_of_birthdayDate());
			statement.setLong(5,user.getPhone_numberLong());
			int rows=statement.executeUpdate();
			if(rows>0) {
				System.out.println("Successfully inserted:"+user.getUsernameString());
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
	
	User getUser(User user) {
		String sql="select * from user where email=? and password=? limit 1";
		User currUser=null;
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1,user.getEmailString());
			statement.setString(2, user.getPasswordString());
	
			ResultSet rows=statement.executeQuery();
			if(rows.next()) {
				System.out.println("Data aayaaa");
				currUser=new User();
				currUser.setUser_idId(rows.getInt("user_id"));
				currUser.setUsernameString(rows.getString("username"));
				currUser.setEmailString(rows.getString("email"));
				currUser.setPhone_numberLong(rows.getLong("phone_number"));
				java.sql.Date dobDate=rows.getDate("date_of_birth");
				currUser.setDate_of_birthdayDate(dobDate);
				currUser.setPasswordString(rows.getString("password"));

			}
			else {
				System.out.println("data nahi aayaaa");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currUser;
	}
	
	boolean updateUser(User user) {
		String sql="update user set username=?, password=?, email=?, phone_number=?,date_of_birth=? where user_id=?";
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1,user.getUsernameString());
			statement.setString(2, user.getPasswordString());
			statement.setString(3, user.getEmailString());
			statement.setLong(4,user.getPhone_numberLong() );
			statement.setDate(5, user.getDate_of_birthdayDate());
			statement.setInt(6, user.getUser_idId());
			
			int rows=statement.executeUpdate();
			if(rows==0) return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	public boolean deleteUserById(int user_id) {
		String sql="delete from user where user_id=?";
		
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1,user_id);
			int rows=statement.executeUpdate();
			if(rows==1) {
				System.out.println("user delete huaa");
				return true;
			}
			else {
				System.out.println("user delete nahi huaa");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public User getUserById(int user_id) {
		String sql="select * from user where user_id=?";
		User user=null;
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, user_id);
			ResultSet resultSet=statement.executeQuery();
			//User(String usernameString, String emailString, String passwordString, java.sql.Date date_of_birthDateSql, long phone_numberLong) {
			if(resultSet.next()) {
				user=new User(resultSet.getString("username"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getDate("date_of_birth"),resultSet.getLong("phone_number"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
		
	}
	public User getUserByEmail(String emailString) {
		String sql="select * from user where email=?";
		User user=null;
		try {
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, emailString);
			ResultSet resultSet=statement.executeQuery();
			//User(String usernameString, String emailString, String passwordString, java.sql.Date date_of_birthDateSql, long phone_numberLong) {
			if(resultSet.next()) {
				user=new User(resultSet.getString("username"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getDate("date_of_birth"),resultSet.getLong("phone_number"));
				user.setUser_idId(resultSet.getInt("user_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	public int getTotalActiveUserCount() {
		String sqlString="select count(*) from user";
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
	public int getTotalUserCount() {
		String sqlString="select max(user_id) from user";
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
