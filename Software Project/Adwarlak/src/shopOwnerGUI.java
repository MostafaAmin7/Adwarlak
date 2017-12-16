import javax.swing.JPanel;

public class ShopOwnerGUI extends JPanel{
	//ENTRY constructors
	public ShopOwnerGUI(ShopOwner shopowner) {
		instance=this;
		owner=shopowner;
		setup();
	}
	//ENTRY Attributes
	private ShopOwnerGUI instance;
	private ShopOwner owner;
	//ENTRY Functions
	public void setup() {
		
	}
}
