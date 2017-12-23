import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AdminGUI extends JPanel{
	//ENTRY constructors
	public AdminGUI(Admin shopowner) {
		admin=shopowner;
		setup();
	}
	//ENTRY Attributes
	private Admin admin;
	private JTextField brandNameValue;
	//ENTRY Functions
	public void setup() {
		setLayout(null);
		setBounds(0, 0, 640, 460);
		SearchGUI searchGUI = new SearchGUI(admin);
		searchGUI.setBounds(0, 100, 640, 350);
		add(searchGUI);
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(293, 11, 61, 14);
		add(lblAdwarlak);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().goPanelBack();
				}
			});
		backButton.setBounds(10, 7, 89, 23);
		add(backButton);
		
		JButton logOutButton = new JButton("Log out");
		logOutButton.setBounds(10, 66, 89, 23);
		add(logOutButton);
		logOutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().swapPanelWith(new GuestGUI());
				}
			});
		
		JButton addProductButton = new JButton("Add Product");
		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanelWith(new NewProductGUI(admin));
			}
		});
		addProductButton.setBounds(168, 66, 103, 23);
		add(addProductButton);
		
		JLabel errorLabel = new JLabel();
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
		errorLabel.setVisible(false);
		errorLabel.setBounds(402, 56, 86, 14);
		add(errorLabel);
		
		JButton addBrandButton = new JButton("Add Brand");
		addBrandButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String brandName=brandNameValue.getText().trim();
				if(brandName.equals("")) {
					errorLabel.setText("Empty!");
					errorLabel.setVisible(true);
				}
				else {
					errorLabel.setVisible(false);
				}
				if(!DatabaseController.getInstance().addBrand(brandName)) {
					errorLabel.setText("Brand Exists");
					errorLabel.setVisible(true);
				}
				else {
					errorLabel.setVisible(false);
				}
			}
		});
		addBrandButton.setBounds(527, 66, 103, 23);
		add(addBrandButton);
		
		JLabel AdminName = new JLabel(admin.getName());
		AdminName.setHorizontalAlignment(SwingConstants.CENTER);
		AdminName.setBounds(527, 23, 103, 32);
		add(AdminName);
		
		brandNameValue = new JTextField();
		brandNameValue.setBounds(402, 69, 86, 20);
		add(brandNameValue);
		brandNameValue.setColumns(10);
	}
}
