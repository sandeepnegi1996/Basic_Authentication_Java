package model;
public class User {

	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String toString()
	{
		return this.getUsername()+"  "+this.getPassword();
	}
	
	@Override
	public boolean equals(Object obj)
	{
		String uname=this.username;
		String paswd=this.password;
		
		String username=( (User)obj).getUsername();
		String password=((User)obj).getPassword();
		
		return uname.equals(username) && paswd.equals(password);
		
	}
	
}
