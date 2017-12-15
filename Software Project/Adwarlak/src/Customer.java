import java.util.ArrayList;

public class Customer {
	private float rate;
	private Cart cart;
	private float voucherCard;
	private ArrayList<Product> prevBuy;
//	private ArrayList<Product> prevSearch;
	CustomerGUI gui;
	
	public void addToPrevBuy(Product p) {
		if(!prevBuy.contains(p)) {
			prevBuy.add(p);
		}
		else {
			
		}
	}

//	public void addToPrevSearch() {
//		
//	}
	
	public void addToCart(Product product) {
		cart.addToBuy(product);
	}
	
	
}
