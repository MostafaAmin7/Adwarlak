import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {

	public Connection conn = null;
	private String dbName = null;
<<<<<<< HEAD

	private String URL=null;
	private String user=null;
	private String password=null;
=======
	private String URL = null;
	private String user = null;
	private String password = null;
>>>>>>> Mostafa-Amin
	
	public Database() {
		
		this.dbName = "adwarlak";
		URL="jdbc:mysql://localhost:3306/";
		user="root";
		password="123456";
<<<<<<< HEAD
		
=======
>>>>>>> Mostafa-Amin
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(URL+dbName, user, password);//here put the new simple url.
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void Run(String query) {
		try {
			runSql(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private ResultSet runSql(String sql) throws SQLException {
		Statement sta = conn.createStatement();
		return sta.executeQuery(sql);
	}
	
	public int signIn(String query){
		try {
			ResultSet result = runSql(query);
			if(result.next()){
				return result.getInt("type");
			}
			else{
				return 0;
			}
		} catch (SQLException e) {
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
			customer.setVoucherCard(result.getInt("vCard"));
			
			
			return customer;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;	
		}
	}
	
	public ArrayList<Product> getProducts(String query){
		ArrayList<Product> products = new ArrayList<Product>();
		String name, store;
		boolean found;
		Product newProduct;
		try {
			ResultSet result = runSql(query);
			while(result.next()) {
				found = false;
				name = result.getString("name");
				store = result.getString("sName");
				for (Product product : products) {
					if(product.getName().equals(name) && product.getStore().equals(store)) {
						found = true;
						product.getCategory().add(result.getString("cName"));
						break;
					}
				}
				if(found) {
					continue;
				}
				newProduct = new Product();
				newProduct.setName(name);
				newProduct.setId(result.getString("p_id"));
				newProduct.setDescription(result.getString("Description"));
				newProduct.setBrand(result.getString("bName"));
				newProduct.setColor(result.getString("color"));
				newProduct.getCategory().add(result.getString("cName"));
				newProduct.setStore(result.getString("sName"));
				newProduct.setPrice(result.getFloat("price"));
				newProduct.setAvilable(result.getInt("avail"));
				newProduct.setSold(result.getInt("sold"));
				newProduct.setViews(result.getInt("veiws"));
				products.add(newProduct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
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
			
			query = "select stores.name from `shop owner`, stores ";
			query += "WHERE stores.u_name = `shop owner`.u_name and ";
			query += "`shop owner`.u_name = " + shopOwner.getName() + ";";
			result = runSql(query);
			while(result.next()) {
				shopOwner.getStores().add(result.getString("name"));
			}
			return shopOwner;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public void signUp(String query){
//		try {
//			runSql(query);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public ArrayList<Product> getAllProducts(){
		String query = "";
		query += "select products.*, brands.name as bName, categories.name as cName, `has a_p`.price,`has a_p`.avail, `has a_p`.sold, `has a_p`.veiws ";
		query += "from products, `belong to_c`, categories, brands ";
		query += "where products.p_id=`belong to_c`.p_id and categories.c_id=`belong to_c`.c_id and products.b_id=brands.b_id;";
		ArrayList<Product> products = new ArrayList<Product>();
		String name;
		boolean found;
		Product newProduct;
		try {
			ResultSet result = runSql(query);
			while(result.next()) {
				found = false;
				name = result.getString("name");
				for (Product product : products) {
					if(product.getName().equals(name)) {
						found = true;
						product.getCategory().add(result.getString("cName"));
						break;
					}
				}
				if(found) {
					continue;
				}
				newProduct = new Product();
				newProduct.setName(name);
				newProduct.setId(result.getString("p_id"));
				newProduct.setDescription(result.getString("Description"));
				newProduct.setBrand(result.getString("bName"));
				newProduct.setColor(result.getString("color"));
				newProduct.getCategory().add(result.getString("cName"));
				products.add(newProduct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return products;
	}

	public ArrayList<String> getBrands(){
		ArrayList<String> brands = new ArrayList<String>();
		String query = "SELECT name FROM brands;";
		try {
			ResultSet result = runSql(query);
			while(result.next()) {
				brands.add(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return brands;
	}

	public ArrayList<String> getCategories(){
		ArrayList<String> categories = new ArrayList<String>();
		String query = "select name FROM categories;";
		try {
			ResultSet result = runSql(query);
			while(result.next()) {
				categories.add(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categories;
	}

	public ArrayList<String> getStores() {
		String query = "SELECT name FROM stores";
		ArrayList<String> stores = new ArrayList<String>();
		try {
			ResultSet result = runSql(query);
			while(result.next()) {
				stores.add(result.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stores;
	}
	
	public ArrayList<Customer> getCustomers(String query) {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer customer;
		try {
			ResultSet result = runSql(query);
			while(result.next()) {
				customer = new Customer();
				customer.setName(result.getString("name"));
				customer.setAge(result.getInt("age"));
				customer.setMail(result.getString("mail"));
				customer.setPhone(result.getString("phone"));
				customer.setRate(result.getInt("rate"));
				customer.setVoucherCard(result.getInt("vCard"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

<<<<<<< HEAD
	public int findBrand(String query) {
		ResultSet result;
		try {
			result = runSql(query);
			if(result.next()) {
				return result.getInt("b_id");
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

//	public void addBrand(String query) {
//		try {
//			runSql(query);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public boolean findStore(String query) {
		try {
			return runSql(query).next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

//	public void addStore(String query) {
//		try {
//			runSql(query);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public int findProduct(String query) {
		try {
			ResultSet result = runSql(query);
			if(result.next()) {
				return result.getInt("p_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

//	public void addProductToSystem(String query) {
//		try {
//			runSql(query);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public int findCategory(String query) {
		try {
			ResultSet result = runSql(query);
			if(result.next()) {
				return result.getInt("c_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

//	public void addCP(String query) {
//		try {
//			runSql(query);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	public void addCategory(String query) {
//		try {
//			runSql(query);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	public ArrayList<Product> getStoreProducts(String query){
		ArrayList<Product> products = new ArrayList<Product>();
		Product product;
		try {
			ResultSet result = runSql(query);
			while(result.next()) {
				product = new Product();
				product.setName(result.getString("name"));
				product.setDescription(result.getString("Description"));
				product.setColor(result.getString("color"));
				product.setBrand(result.getString("bName"));
				product.setAvilable(result.getInt("avail"));
				product.setSold(result.getInt("sold"));
				product.setViews(result.getInt("views"));
				product.setPrice(result.getFloat("price"));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

	public int getStoreID(String query) {
		try {
			ResultSet result = runSql(query);
			if(result.next()) {
				return result.getInt("s_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean inStore(String query) {
		try {
			if(runSql(query).next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void addProducToStore(String query) {
		try {
			runSql(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateVC(String query) {
		try {
			runSql(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void buyProduct(String query) {
		try {
			runSql(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
=======
}
>>>>>>> Mostafa-Amin
