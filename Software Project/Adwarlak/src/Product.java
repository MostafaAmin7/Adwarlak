import java.util.ArrayList;

public class Product {
	// Attributes
	private String name, id, description, color, brand, store;
	private ArrayList<String> category;
<<<<<<< HEAD
	private double price, sale;
	int avilable, sold, views;

	public Product() {
		
	}
	
	public Product(Product x) {
		this.name=x.name;
		this.id = x.id;
		this.description = x.description;
		this.color = x.color;
		this.category=new ArrayList<String>();
		for (String string : x.category) {
			this.category.add(""+string);
		}
		this.brand = x.brand;
		this.price = x.price;
		this.sale = x.sale;
	}
		
		
	
	public Product(String name, String id, String description, String color, ArrayList<String> category, String brand,
			double price, double sale) {
		this.name = name;
		this.id = id;
		this.description = description;
		this.color = color;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.sale = sale;
	}
=======
	private Double price, sale;
	private Integer numberOfViews, available, sold;

>>>>>>> Mostafa-Amin
	
	//Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public ArrayList<String> getCategory() {
		return category;
	}
	public void setCategory(ArrayList<String> category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public double getSale() {
		return sale;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public void setSale(Double sale) {
		this.sale = sale;
	}
<<<<<<< HEAD
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public int getAvilable() {
		return avilable;
	}
	public void setAvilable(int avilable) {
		this.avilable = avilable;
	}
	public int getSold() {
		return sold;
	}
	public void setSold(int sold) {
		this.sold = sold;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
=======
	public Integer getNumberOfViews() {
		return numberOfViews;
	}
	public void setNumberOfViews(Integer numberOfViews) {
		this.numberOfViews = numberOfViews;
	}
	public Integer getAvailable() {
		return available;
	}
	public void setAvailable(Integer available) {
		this.available = available;
	}
	public Integer getSold() {
		return sold;
	}
	public void setSold(Integer sold) {
		this.sold = sold;
	}
>>>>>>> Mostafa-Amin

}