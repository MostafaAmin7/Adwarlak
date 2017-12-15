import java.util.ArrayList;

public class Search {

	private Database db = new Database();
	
	public User getUser(String name, String password) {
		return db.getUser(name, password);
	}
	
	public ArrayList<Product> getProducts(String []info){ // al array da shayl ally hndowr byh "0 name - 1 brand - 2 category "
		return db.getProducts(info);
//		
//		String query;
//		boolean freeSearch = true;
//		query = "SELECT * FROM Products, Brands, Belong to_C, Categories";
//		
//		for(int i=0; i<3; ++i) {
//			if(!info[i].equals("")) {
//				freeSearch = false;
//				query+= "WHERE ";
//				break;
//			}
//		}
//		if(!freeSearch) {
//			if(!info[0].equals("")) {                                     // name
//				query += "p_name = " + info[0] + " ";
//			}
//			if(!info[1].equals("")) {                                     // brand
//				query += "Products.b_id = Brands.b_id and Brands.name = " + info[1] + " ";
//			}
//			if(!info[2].equals("")) {                                     // category
//				query += "Products.p_id [Belong to_C].p_id Categories.c_id = [Belong to_C].c_id and Categories.name = " + info[2] + " ";
//			}
//		}
	}
}