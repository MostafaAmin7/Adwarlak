import java.util.ArrayList;

public class shopOwner extends User{

	private boolean premium;
	ArrayList<Store> stores;
	private String startDate,endDate;
	private shopOwnerGUI gui;
	
	
	
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
	public ArrayList<Store> getStores() {
		return stores;
	}
	
	
	public void addStore(Store store)
	{
		stores.add(store);
	}
	public void removeStore(Store store)
	{
		for(int i=0;i<stores.size();i++)
		{
			if(stores.get(i)==store)
			{
				stores.remove(i);
			}
		}
	}
	public void addProduct(Product product,Store store)
	{
		for(int i=0;i<stores.size();i++)
		{
			if(stores.get(i)==store)
			{
				stores.get(i).setToSell(product);
				break;
			}
		}
	}
	public void removeProduct(Product product,Store store)
	{
		for(int i=0;i<stores.size();i++)
		{
			if(stores.get(i)==store)
			{
				stores.get(i).removeProduct(product);
				break;
			}
		}
	}
	public void showStatistics()
	{
		
	}
	public void suggest(Product product)
	{
		//to do
	}
}
