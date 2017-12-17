import java.util.ArrayList;

public class ShopOwner extends User{

	private boolean premium;
	ArrayList<String> stores;
	private String startDate,endDate;
	private ShopOwnerGUI gui;
	
	
	
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public ArrayList<String> getStores() {
		return stores;
	}
	
	
	public void addStore(String store)
	{
		stores.add(store);
	}
	public void removeStore(String store)
	{
		for(int i=0;i<stores.size();i++)
		{
			if(stores.get(i)==store)
			{
				stores.remove(i);
			}
		}
	}
//	public void removeProduct(Product product,Store store)
//	{
//		for(int i=0;i<stores.size();i++)
//		{
//			if(stores.get(i).equals(store))
//			{
//				stores.get(i).removeProduct(product);
//				break;
//			}
//		}
//	}
	public void showStatistics()
	{
		
	}
	public void suggest(Product product)
	{
		//to do
	}
}
