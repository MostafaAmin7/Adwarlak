import java.util.ArrayList;

public class ShopOwner extends User{
	private boolean premium;
	private ArrayList<User>stores;
	private String startDate;
	private String endDate;
	public boolean isPremium() {
		return premium;
	}
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	public ArrayList<User> getStores() {
		return stores;
	}
	public void setStores(ArrayList<User> stores) {
		this.stores = stores;
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
	
}
