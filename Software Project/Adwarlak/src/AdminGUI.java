import javax.swing.JPanel;

public class AdminGUI extends JPanel{
	//ENTRY constructors
	public AdminGUI(Admin shopowner) {
		instance=this;
		owner=shopowner;
		setup();
	}
	//ENTRY Attributes
	private AdminGUI instance;
	private Admin owner;
	//ENTRY Functions
	public void setup() {
		
	}
}
