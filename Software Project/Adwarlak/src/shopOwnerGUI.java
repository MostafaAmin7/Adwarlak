import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	private JTextField textField;
	private JTextField textField_1;
	//ENTRY Functions
	public void setup() {
setLayout(null);
		
		SearchGUI searchGUI = new SearchGUI();
		searchGUI.setBounds(10, 139, 500, 350);
		add(searchGUI);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 11, 89, 23);
		add(btnBack);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(10, 42, 89, 23);
		add(btnLogOut);
		
		JButton btnSuggestProduct = new JButton("Suggest Product");
		btnSuggestProduct.setBounds(10, 105, 111, 23);
		add(btnSuggestProduct);
		
		JButton btnAddStore = new JButton("Add Store");
		btnAddStore.setBounds(210, 105, 89, 23);
		add(btnAddStore);
		
		JButton btnShowStatistics = new JButton("Show Statistics");
		btnShowStatistics.setBounds(399, 105, 111, 23);
		add(btnShowStatistics);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(399, 49, 111, 45);
		add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(210, 15, 65, 14);
		add(lblAdwarlak);
		
		JLabel label = new JLabel("");
		label.setBounds(429, 15, 46, 14);
		add(label);
		
		JLabel lblSelectStore = new JLabel("Select Store");
		lblSelectStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectStore.setBounds(400, 35, 111, 14);
		add(lblSelectStore);
		
		textField = new JTextField();
		textField.setBounds(140, 75, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(275, 75, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
	}
}
