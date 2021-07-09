package classes;



public class User {
	private int user_idId;
	private String usernameString;
	private String emailString;
	private String passwordString;
	private java.sql.Date date_of_birthdayDate;
	private long phone_numberLong;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String usernameString, String emailString, String passwordString, java.sql.Date date_of_birthDateSql,
			long phone_numberLong) {
		super();
		this.usernameString = usernameString;
		this.emailString = emailString;
		this.passwordString = passwordString;
		this.date_of_birthdayDate = date_of_birthDateSql;
		this.phone_numberLong = phone_numberLong;
	}
	public String getUsernameString() {
		return usernameString;
	}
	public void setUsernameString(String usernameString) {
		this.usernameString = usernameString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	public String getPasswordString() {
		return passwordString;
	}
	public void setPasswordString(String passwordString) {
		this.passwordString = passwordString;
	}
	public java.sql.Date getDate_of_birthdayDate() {
		return date_of_birthdayDate;
	}
	public void setDate_of_birthdayDate(java.sql.Date date_of_birthdayDate) {
		this.date_of_birthdayDate = date_of_birthdayDate;
	}
	public long getPhone_numberLong() {
		return phone_numberLong;
	}
	public void setPhone_numberLong(long phone_numberLong) {
		this.phone_numberLong = phone_numberLong;
	}
	public int getUser_idId() {
		return user_idId;
	}
	public void setUser_idId(int user_idId) {
		this.user_idId=user_idId;
	}
	
	
	
	
}
