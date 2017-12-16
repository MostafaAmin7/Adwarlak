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
		
		this.dbName = "adwarlak";
		URL="jdbc:mysql://localhost:3306/";
		user="root";
		password="123456";
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
	public int signIn(String query ){
		
		try {
			ResultSet result = runSql(query);
			if(result.next()){
				return result.getInt("type");
			}
			else{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public Admin getAdmin(String query){
		try {
			ResultSet result = runSql(query);
			Admin admin=new Admin();
			admin.setName(result.getString("u_name"));
			admin.setMail(result.getString("mail"));
			admin.setPhone(result.getString("phone"));
			admin.setAge(result.getInt("age"));
			admin.setLevel(result.getInt("level"));
			
			return admin;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;			
		}
	}
	
	public Customer getCustomer(String query){
		try {
			ResultSet result = runSql(query);
			
			Customer customer=new Customer();
			customer.setName(result.getString("u_name"));
			customer.setMail(result.getString("mail"));
			customer.setPhone(result.getString("phone"));
			customer.setAge(result.getInt("age"));
			customer.setRate(result.getInt("rate"));
			
			
			return customer;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;	
		}
	}
	
	public ShopOwner getShopOwner(String query){
		try {
			ResultSet result = runSql(query);
			ShopOwner shopOwner=new ShopOwner();
			shopOwner.setName(result.getString("u_name"));
			shopOwner.setMail(result.getString("mail"));
			shopOwner.setPhone(result.getString("phone"));
			shopOwner.setAge(result.getInt("age"));
			shopOwner.setStartDate(result.getString("start date"));
			shopOwner.setEndDate(result.getString("end date"));
			if(result.getInt("premium")==1){
				shopOwner.setPremium(true);
			}
			else{
				shopOwner.setPremium(false);
			}
			
			
			
			
			
			
			return shopOwner;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
public void signUp(String query){
	try {
		runSql(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
}
	

}
