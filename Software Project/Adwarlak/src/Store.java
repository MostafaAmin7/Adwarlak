import java.util.ArrayList;
import java.util.Locale.Category;

public class Store {
	
	private String name,address;
	private float rate;
	private ArrayList<Product> toSell; 
	private ArrayList<Product> history;
	private ArrayList<User> owner;
	
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
	public void setToSell(Product product) {
		toSell.add(product);
	}
	public ArrayList<Product> getHistory() {
		return history;
	}
	public void setHistory(ArrayList<Product> history) {
		this.history = history;
	}
	public ArrayList<User> getOwner() {
		return owner;
	}
	public void setOwner(ArrayList<User> owner) {
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