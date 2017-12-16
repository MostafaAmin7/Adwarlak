import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AdminGUI extends JPanel{
	//ENTRY constructors
	public AdminGUI(Admin shopowner) {
		instance=this;
		admin=shopowner;
		setup();
	}
	//ENTRY Attributes
	private AdminGUI instance;
	private Admin admin;
	//ENTRY Functions
	public void setup() {
		setLayout(null);
		setBounds(0, 0, 525, 500);
		SearchGUI searchGUI = new SearchGUI();
		searchGUI.setBounds(10, 100, 500, 350);
		add(searchGUI);
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(223, 11, 61, 14);
		add(lblAdwarlak);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 7, 89, 23);
		add(backButton);
		
		JButton logOutButton = new JButton("Log out");
		logOutButton.setBounds(10, 66, 89, 23);
		add(logOutButton);
		
		JButton addVcardButton = new JButton("Add VCard");
		addVcardButton.setBounds(138, 66, 89, 23);
		add(addVcardButton);
		
		JButton addProductButton = new JButton("Add Product");
		addProductButton.setBounds(256, 66, 103, 23);
		add(addProductButton);
		
		JButton addBrandButton = new JButton("Add Brand");
		addBrandButton.setBounds(387, 66, 103, 23);
		add(addBrandButton);
		
		JLabel AdminName = new JLabel(admin.getName());
		AdminName.setBounds(420, 11, 46, 14);
		add(AdminName);
	}
}
