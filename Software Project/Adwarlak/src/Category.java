import java.util.ArrayList;

public class Category {
	//Attributes
	private String name;
	private ArrayList<String> products;
	
	
	// Constructors
	public Category() {
		
	}
	
	public Category(String name, ArrayList<String> products) {
		this.name = name;
		this.products = products;
	}
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}	
}
