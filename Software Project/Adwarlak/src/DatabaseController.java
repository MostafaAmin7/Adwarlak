import java.util.ArrayList;

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
		else{
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
			query2 += ", 0";    //  rate
		}
		else if(x instanceof ShopOwner){
			ShopOwner owner = (ShopOwner)x;
			query2 += ", " + owner.getStartDate();
			query2 += ", " + owner.getEndDate();
			query2 += ", " + owner.isPremium();
			query2 += ", 0";    //  rate
		}
		
		query1 += ");";
		query2 += ");";
		
		database.signUp(query1 + query2);
		return x;
	}
	
	
	public ArrayList<Product> search(
								String product, 
								ArrayList<String> brands, 
								ArrayList<String> categories,
								int lower, int upper
								)
	{
		boolean brand, category, startPrice, endPrice;
		brand = !brands.isEmpty();
		category = !categories.isEmpty();
		startPrice = lower!=-1;
		endPrice = upper!=-1;
		
		String query = "SELECT * FROM products, brands, `belong to_c`, categories";
		query += " WHERE products.b_id = brands.b_id and";
		query += " products.p_id=`belong to_c`.p_id and categories.c_id=`belong to_c`.c_id";
		if(brand) {	
			query += " and brands.name REGEXP \"";
			query += brands.get(0);
			for (int i=1; i<brands.size(); ++i) {
				query += "|" + brands.get(i);
			}
			query += "\"";
		}
		if(category) {
			query += " and categories.name REGEXP \"";
			query += categories.get(0);
			for(int i=1; i<categories.size(); ++i) {
				query += "|" + categories.get(i);
			}
			query += "\"";
		}
		if(startPrice && endPrice) {
			query+= " and price between" + lower +" and 150" + upper;
		}
		else if(startPrice) {
			query+= " and price > " + lower;
		}
		else if(endPrice) {
			query+= " and price < " + upper;
		}
		query += ";";
		
		return database.getProducts(query);
		return null;
	}
}
