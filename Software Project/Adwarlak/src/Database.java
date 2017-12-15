import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

	public Connection conn = null;
	private String dbName = null;
	private String URL = null;
	private String user = null;
	private String password = null;
	
	public Database() {
		dbName = "adwarlak";
		URL = "jdbc:mysql://localhost:3306/";
		user = "root";
		password = "123456";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(URL+dbName, user, password);//here put the new simple url.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private ResultSet runSql(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}
	
	
}
