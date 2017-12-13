import java.util.ArrayList;

public class Cart {
	private ArrayList<Product> toBuy=new ArrayList<Product>();
	private String shippingState;
	private float totalPrice=0;
	
	
	public ArrayList<Product> getToBuy() {
		return toBuy;
	}
	public String getShippingState() {
		return shippingState;
	}
	public void setShippingState(String shippingState) {
		this.shippingState = shippingState;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	
	public void addToBuy(Product product)
	{
		toBuy.add(product);
		totalPrice+=product.getPrice();
	}
	public void removeFromToBuy(Product product)
	{
		for(int i=0;i<toBuy.size();i++)
		{
			if(toBuy.get(i)==product)
			{
				totalPrice-=toBuy.get(i).getPrice();
				toBuy.remove(i);
				break;
			}
		}
	}
	public float showPrice(ArrayList<Product> toBuy)
	{
		float p=0;
		for(int i=0;i<toBuy.size();i++)
		{
			p+=toBuy.get(i).getPrice();
		}
		return p;
	}
	
}
