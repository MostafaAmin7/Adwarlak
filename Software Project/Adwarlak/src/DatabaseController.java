import java.util.Calendar;
import java.util.Date;

public class DatabaseController {
	
	private Database database;
	
	public DatabaseController() {
		database = new Database();
	}
	
	
	public User signIn(String name, String password) {
		String query = "SELECT * FROM user WHERE u_name = " + name + " and password = " + password;
		int type = database.signIn(query);
		if(type == 0) {
			return null;
		}
		else if(type == 1) {
			query = "SELECT * FROM admin WHERE u_name = " + name + " and password = " + password;
			return database.getAdmin(query);
		}
		else if(type==2) {
			query = "SELECT * FROM `shop owner` WHERE u_name = " + name + " and password = " + password;
			return database.getShopOwner(query);
		}
		else if(type == 3) {
			query = "SELECT * FROM customer WHERE u_name = " + name + " and password = " + password;
			return database.getCustomer(query);
		}
		else {
			return null;
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public User signUp(User x, String password) {
		String query1 = "SELECT * FROM user WHERE u_name = " + x.getName();
		if(database.signIn(query1) != 0) {
			return null;
		}
		String query2;
		
		int type;
		if(x instanceof Customer) {
			query2 = "INSERT INTO `customer` VALUES(";
			type = 3;
		}
		else if(x instanceof ShopOwner) {
			query2 = "INSERT INTO `shop owner` VALUES(";
			type = 2;
		}
		
		query1 = "INSERT INTO `user` VALUES(";
		
		query1 += " " + x.getName();
		query2 += " " + x.getName();
		
		query1 += ", " + password;
		query2 += ", " + password;
		
		query1 += ", " + x.getMail();
		query2 += ", " + x.getMail();
		
		query1 += ", " + x.getPhone();
		query2 += ", " + x.getPhone();
		
		query1 += ", " + x.getAge();
		query2 += ", " + x.getAge();
		
		query1 += ", " + type;
		query2 += ", " + type;
		
		if(type == 3) {
			query2 += ", 0)";
		}
		else if(x instanceof ShopOwner){
			ShopOwner owner = (ShopOwner)x;
			query2 += ", " + owner.getStartDate();
			query2 += ", " + owner.getEndDate();
			query2 += ", " + owner.isPremium();
		}
		
		query1 += ");";
		query2 += ");";
		
		database.signUp(query1 + query2);
		return x;
	}
	
}
