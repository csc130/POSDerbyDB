
public class User {
private String username, password;
private boolean admin;
public User(String username, String password, boolean admin)
{
	setUsername(username);
	setPassword(password);
	setAdmin(admin);
}
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
public boolean isAdmin() {
	return admin;
}
public void setAdmin(boolean admin) {
	this.admin = admin;
}

}
