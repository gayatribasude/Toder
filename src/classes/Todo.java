package classes;



public class Todo {
	private int user_idInt;
	private int todo_idInt;
	private String headingString;
	private String subheadingString;
	private String detailsString;
	private java.sql.Timestamp datetimeTimestamp;
	private Short activeShort;
	private Short doneShort;
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo(int user_idInt,String headingString, String subheadingString, String detailsString,
			java.sql.Timestamp datetimeTimestamp, Short activeShort, Short doneShort) {
		super();
		this.user_idInt=user_idInt;
		this.headingString = headingString;
		this.subheadingString = subheadingString;
		this.detailsString = detailsString;
		this.datetimeTimestamp = datetimeTimestamp;
		this.activeShort = activeShort;
		this.doneShort = doneShort;
	}
	public int getUser_idInt() {
		return user_idInt;
	}
	public void setUser_idInt(int user_idInt) {
		this.user_idInt = user_idInt;
	}
	public int getTodo_idInt() {
		return todo_idInt;
	}
	public void setTodo_idInt(int todo_idInt) {
		this.todo_idInt = todo_idInt;
	}
	public String getHeadingString() {
		return headingString;
	}
	public void setHeadingString(String headingString) {
		this.headingString = headingString;
	}
	public String getSubheadingString() {
		return subheadingString;
	}
	public void setSubheadingString(String subheadingString) {
		this.subheadingString = subheadingString;
	}
	public String getDetailsString() {
		return detailsString;
	}
	public void setDetailsString(String detailsString) {
		this.detailsString = detailsString;
	}
	public java.sql.Timestamp getDatetimeTimestamp() {
		return datetimeTimestamp;
	}
	public void setDatetimeTimestamp(java.sql.Timestamp datetimeTimestamp) {
		this.datetimeTimestamp = datetimeTimestamp;
	}
	public Short getActiveShort() {
		return activeShort;
	}
	public void setActiveShort(Short activeShort) {
		this.activeShort = activeShort;
	}
	public Short getDoneShort() {
		return doneShort;
	}
	public void setDoneShort(Short doneShort) {
		this.doneShort = doneShort;
	}

}
