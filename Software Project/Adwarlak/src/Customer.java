import java.util.ArrayList;

public class Customer extends User{
	private float rate;
//	private Cart cart;
	private float voucherCard;
	private ArrayList<Product> prevBuy;
//	private ArrayList<Product> prevSearch;
//	CustomerGUI gui;
	
	public void addToPrevBuy(Product p) {
		if(!prevBuy.contains(p)) {
			prevBuy.add(p);
		}
		else {
			
		}
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getVoucherCard() {
		return voucherCard;
	}

	public void setVoucherCard(float voucherCard) {
		this.voucherCard = voucherCard;
	}

	public ArrayList<Product> getPrevBuy() {
		return prevBuy;
	}

	public void setPrevBuy(ArrayList<Product> prevBuy) {
		this.prevBuy = prevBuy;
	}

//	public void addToPrevSearch() {
//		
//	}
	
//	public void addToCart(Product p) {
//		cart.addToBuy();
//	}
	
//	public void openCart() {
//		if(!cart.toBuy.isEmpty()) {
//			
//		}
//	}
	
}
