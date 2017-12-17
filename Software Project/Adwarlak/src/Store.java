import java.util.ArrayList;
import java.util.Locale.Category;

public class Store {
	
	private String name,address;
	private float rate;
	private ArrayList<Product> toSell; 
	private ArrayList<Product> history;
<<<<<<< HEAD
	private String owner;
	
	public Store() {
		toSell = new ArrayList<Product>(); 
		history = new ArrayList<Product>();
	}
=======
	private ShopOwner owner;
>>>>>>> Mostafa-Amin
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public ArrayList<Product> getToSell() {
		return toSell;
	}
	public void setToSell(ArrayList<Product> products) {
		toSell = products;
	}
	public ArrayList<Product> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<Product> history) {
		this.history = history;
	}
<<<<<<< HEAD
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
=======
	public ShopOwner getOwner() {
		return owner;
	}
	public void setOwner(ShopOwner owner) {
>>>>>>> Mostafa-Amin
		this.owner = owner;
	}
	public void removeProduct(Product product){
		for(int i=0 ; i<toSell.size() ; i++){
			if(toSell.get(i)==product){
				history.add(toSell.get(i));
				toSell.remove(i);
			}
		}
	}
	
	
}