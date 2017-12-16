import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CustomerGUI extends JPanel{
	//ENTRY 
	/*
	 * Other Classes that this Class use
	 * 			Pages only for this 
	 * 					user
	 * 	-SignUP  -LogIn
	 * */
	public CustomerGUI(Customer x) {
		instance=this;
		customer=x;
		setup();		
	}

	//ENTRY Attributes
	private CustomerGUI instance;
	private Customer customer;
	private ProductGUI productPanel;
	private JTextField textField;
	
	//ENTRY Functions
	public void setup() {
		setLayout(null);
		
		SearchGUI searchGUI_1 = new SearchGUI();
		searchGUI_1.setBounds(10, 96, 500, 350);
		add(searchGUI_1);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 11, 89, 23);
		add(backButton);
		
		JButton logOutButton = new JButton("Log out");
		logOutButton.setBounds(10, 55, 89, 23);
		add(logOutButton);
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(228, 15, 106, 14);
		add(lblAdwarlak);
		
		JButton suggestProductButton = new JButton("Suggest Product");
		suggestProductButton.setBounds(376, 55, 131, 23);
		add(suggestProductButton);
		
		textField = new JTextField(customer.getName());
		textField.setBounds(401, 12, 86, 20);
		add(textField);
		textField.setColumns(10);
	}
}
