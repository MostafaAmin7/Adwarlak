import java.util.ArrayList;

import javax.swing.JFrame;

public class DatabaseController {
	// Instance
	private static DatabaseController instance;
	public static DatabaseController getInstance() {
		if(instance==null) {
			instance = new DatabaseController();
		}
		return instance;
	}
	// Constructor
	private DatabaseController() {
		instance=this;
		instance.database = new Database();
	}
	//Attributes
	private Database database;
	
	
	public User signIn(String name, String password) {
		String query = "SELECT * FROM `user` WHERE `u_name`=\"" + name + "\" and `password`=\"" + password + "\"";
		int type = database.signIn(query);
		if(type == 0) {
			return null;
		}
		else if(type == 1) {
			query = "SELECT * FROM `admin` WHERE `u_name` = \"" + name + "\" and `password` = \"" + password + "\"";
			return database.getAdmin(query);
		}
		else if(type==2) {
			query = "SELECT * FROM `shop owner` WHERE `u_name` = \"" + name + "\" and `password` = \"" + password + "\"";
			return database.getShopOwner(query);
		}
		else if(type == 3) {
			query = "SELECT * FROM `customer` WHERE `u_name` = \"" + name + "\" and `password` = \"" + password + "\"";
			return database.getCustomer(query);
		}
		else {
			return null;
		}
	}

	public User signUp(User x, String password) {
		String query1 = "SELECT * FROM user WHERE u_name = \"" + x.getName()+"\"";
		if(database.signIn(query1) != 0) {
			return null;
		}
		String query2="";
		
		int type=0;
		if(x instanceof Customer) {
			query2 = "INSERT INTO `customer` VALUES(";
			type = 3;
		}
		else{
			query2 = "INSERT INTO `shop owner` VALUES(";
			type = 2;
		}
		
		query1 = "INSERT INTO `user` VALUES(";
		
		query1 += " \"" + x.getName()+"\"";
		query2 += " \"" + x.getName()+"\"";
		
		query1 += ", "+"\"" + password+"\"";
		query2 += ", "+"\"" + password+"\"";
		
		query1 += ", "+"\"" + x.getMail()+"\"";
		query2 += ", "+"\"" + x.getMail()+"\"";
		
		query1 += ", "+"\"" + x.getPhone()+"\"";
		query2 += ", "+"\"" + x.getPhone()+"\"";
		
		query1 += ", "+"\"" + x.getAge()+"\"";
		query2 += ", "+"\"" + x.getAge()+"\"";
		
		query1 += ", "+ type;
		query2 += ", "+ type;
		
		if(type == 3) {
			query2 += " "+"," + 0 + ", " + 0;    //  rate , VCard
		}
		else if(x instanceof ShopOwner){
			ShopOwner owner = (ShopOwner)x;
			query2 += ", " +"\""+ owner.getStartDate()+"\"";
			query2 += ", " +"\""+ owner.getEndDate()+"\"";
			query2 += ", " + owner.isPremium();
			query2 += ", 0";    //  rate
		}
		
		query1 += ") ;";
		query2 += ") ;";
		database.Run(query1);
		database.Run(query2);
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
		
		String query = "SELECT products.*, brands.name as bName, categories.name as cName, stores.name as sName, `has a_p`.*";
		query += " FROM products, brands, `belong to_c`, categories, `has a_p`, stores ";
		query += " WHERE products.b_id = brands.b_id and";
		query += " products.p_id=`belong to_c`.p_id and categories.c_id=`belong to_c`.c_id and `has a_p`.p_id = products.p_id and `has a_p`.s_id = stores.s_id";
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
			query+= " and price between " + lower +" and " + upper;
		}
		else if(startPrice) {
			query+= " and price > " + lower;
		}
		else if(endPrice) {
			query+= " and price < " + upper;
		}
		query += ";";
		return database.getProducts(query);
	}

	public ArrayList<String> getBrands() {
		return database.getBrands();
	}
	
	public ArrayList<String> getCategories(){
		return database.getCategories();
	}

	public ArrayList<Customer> getCustomers(String name){
		String query = "SELECT * FROM customer WHERE REGEXP \"" + name + "\"";
		return database.getCustomers(query);
	}

	public boolean addBrand(String name) {
		String query = "SELECT * FROM brands WHERE name=\"" + name + "\"";
		if(database.findBrand(query) != -1) {
			return false;
		}
		query = "INSERT INTO brands (name) VALUES (\"" + name + "\")";
		database.Run(query);
		return true;
	}

	public boolean addStore(String ownerName, String name,  String address) {
		String query = "SELECT * FROM stores WHERE name=\"" + name + "\"";
		if(database.findStore(query)) {
			return false;
		}
		query = "INSERT INTO stores (u_name, name, address) VALUES (\"" + ownerName + "\",\"" + name + "\",\"" + address +"\");";
		database.Run(query);
		return true;
	}

	public Product addProductToSystem(Product p) {
		Product product = new Product(p);
		boolean pass = true;
		int id;
		ArrayList<Integer> c_id = new ArrayList<Integer>();
		String query = "SELECT * FROM products WHERE name=\"" + product.getName() + "\";";
		if(database.findProduct(query) != -1) {
			product.setName("");
			pass = false;
		}
		query = "SELECT * FROM brands WHERE name=\"" + product.getBrand() + "\";";
		id = database.findBrand(query);
		if(id == -1) {
			product.setBrand("");
			pass = false;
		}
		
		for (String category : product.getCategory()) {
			query = "SELECT * FROM categories WHERE name=\"" + category + "\";";
			c_id.add(database.findCategory(query));
			if(c_id.get(c_id.size()-1) == -1) {
				product.getCategory().remove(category);
				pass = false;
			}
		}
		
		if(pass) {
			query = "INSERT INTO products (name, Description, color, b_id, inSystem) ";
			query += "VALUES (\"" + product.getName() + "\", \"" + product.getDescription()+"\", \""+product.getColor() + "\"";
			query += ", " + id + ", 1);";
			database.Run(query);
			for (Integer integer : c_id) {
				query = "INSERT INTO `belong to_c` VALUSE (" + integer + ", " + id + ");";
				database.Run(query);
			}
		}
		return product;
	}

	public boolean addCategory(String name) {
		String query = "SELECT * FROM categories WHERE name=\"" + name + "\";";
		if(database.findCategory(query) != -1) {
			return false;
		}
		query = "INSERT INTO categories (name) VALUES (\"" + name + "\");";
		database.Run(query);
		return true;
	}
	
	public ArrayList<String> getStores(){
		return database.getStores();
	}
	
	public Store getStore(String name) {
		String query;
		Store store = new Store();
		query = "SELECT products.*, brands.name as bName,`has a_p`.* ";
		query += "FROM products, `has a_p`, stores,brands ";
		query += "WHERE products.b_id = brands.b_id and products.p_id = `has a_p`.p_id and `has a_p`.s_id = stores.s_id and stores.name = \"" + name + "\"";
		
		store.setName(name);		
		store.setToSell(database.getStoreProducts(query));
		return store;
	}

	public Product suggestProduct(Product p) {
		Product product = new Product(p);
		boolean pass = true;
		int id;
		ArrayList<Integer> c_id = new ArrayList<Integer>();
		String query = "SELECT * FROM products WHERE name=\"" + product.getName() + "\";";
		if(database.findProduct(query) != -1) {
			product.setName("");
			pass = false;
		}
		query = "SELECT * FROM brands WHERE name=\"" + product.getBrand() + "\";";
		id = database.findBrand(query);
		if(id != -1) {
			product.setBrand("");
		}
		else {
			pass = false;
		}
		for (String category : product.getCategory()) {
			query = "SELECT * FROM categories WHERE name=\"" + category + "\";";
			c_id.add(database.findCategory(query));
			if(c_id.get(c_id.size()-1) != -1) {
				product.getCategory().remove(category);
			}
			else {
				pass = false;
			}
		}
		
		if(pass) {
			query = "INSERT INTO products (name, Description, color, b_id, inSystem) ";
			query += "VALUES (\"" + product.getName() + "\", \"" + product.getDescription()+"\", \""+product.getColor() + "\"";
			query += ", " + id + ", 0);";
			database.Run(query);
			for (Integer integer : c_id) {
				query = "INSERT INTO `belong to_c` VALUSE (" + integer + ", " + id + ");";
				database.Run(query);
			}
		}
		return product;
	}

	public boolean addProductToStore(Product product) {
		String query = "SELECT * FROM stores where name=\"" + product.getStore() + "\";";
		int s_id = database.getStoreID(query);
		query = "SELECT * FROM `has a_p` WHERE p_id=\"" + product.getId() + "\" and s_id=" + s_id + ";";
		if(database.inStore(query)) {
			return false;
		}
		query = "INSERT INTO `has a_p` VALUES (" + s_id + ", \"" + product.getId() + "\", ";
		query += product.getAvailable() + ", 0, " + product.getPrice() + ", 0);";
		database.Run(query);
		return true;
	}

	public void updateVCard(Customer c) {
		String query = "UPDATE customers SET vCard=" + c.getVoucherCard() + "WHERE u_name=\"" + c.getName() + "\";";
		database.Run(query);
	}

	public void buy(Product product) {
		String query = "SELECT * FROM stores where name=\"" + product.getStore() + "\";";
		int s_id = database.getStoreID(query);
		query = "UPDATE `has a_p` set avail=avail-1, sold = sold + 1 ";
		query +="where s_id ="+ s_id+" and p_id =\"" +product.getId()+"\";";
		database.Run(query);
	}
	
	public void updateProduct(Product product) {
		String query = "SELECT * FROM stores where name=\"" + product.getStore() + "\";";
		int s_id = database.getStoreID(query);
		query = "UPDATE `has a_p`";
		query += " set avail = " + product.getAvailable() + ", price = " + product.getPrice();
		query += " where p_id = \"" + product.getId() + "\" and s_id = " + s_id + ";";
		database.Run(query);
	}
}