public class DatabaseController {
	
	private Database database;
	
	public DatabaseController() {
		database = new Database();
	}
	
	public User signIn(String name, String password) {
		String query = "SELECT * FROM user WHERE u_name = " + name + " and password = " + password;
		return database.signIn(query);
	}
	
}
