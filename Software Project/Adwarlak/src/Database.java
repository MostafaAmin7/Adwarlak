import java.util.ArrayList;

public class Database {

	public ArrayList<Product> products = new ArrayList<Product>();
	public ArrayList<Brand> brands = new ArrayList<Brand>();
	public ArrayList<Category> categories = new ArrayList<Category>();
	public ArrayList<User> users = new ArrayList<User>();
	public ArrayList<Admin> admins = new ArrayList<Admin>();
	public ArrayList<ShopOwner> shopOwners = new ArrayList<ShopOwner>();
	public ArrayList<Customer> cusromers = new ArrayList<Customer>();
	public ArrayList<Store> stores = new ArrayList<Store>();
	
	
	public Database() {
		
	}
	
	public User getUser(String name, String password) {
		for (User user : users) {
			if(user.getName().equals(name) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
	
	public ArrayList<Product> getProducts(String [] info){
		ArrayList<Product> result = new ArrayList<Product>();
		for (Product product : products) {
			if(info[0].equals("") || product.getName().equals(info[0])) {
				if(info[1].equals("") || product.getBrand().getName().equals(info[1])) {
					if(info[2].equals("")) {
						result.add(product);
					}
					else {
						for (Category category : categories) {
							if(category.getName().equals(info[2])) {
								result.add(product);
								break;
							}
						}
					}
				}
			}
		}
		return result;
	}
}
