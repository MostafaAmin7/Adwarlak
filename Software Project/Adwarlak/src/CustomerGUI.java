import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		customer=x;
		setup();		
	}

	//ENTRY Attributes
	private Customer customer;
	private JTextField textField;
	
	//ENTRY Functions
	public void setup() {
		setLayout(null);
		
		SearchGUI searchGUI_1 = new SearchGUI(customer);
		searchGUI_1.setBounds(0, 96, 634, 350);
		add(searchGUI_1);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 11, 89, 23);
		add(backButton);
		backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().goPanelBack();
				}
			});
		
		JButton logOutButton = new JButton("Log out");
		logOutButton.setBounds(10, 55, 89, 23);
		add(logOutButton);
		logOutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().swapPanelWith(new GuestGUI());
				}
			});
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(260, 15, 106, 14);
		add(lblAdwarlak);
		
		JButton suggestProductButton = new JButton("Suggest Product");
		suggestProductButton.setBounds(503, 62, 131, 23);
		add(suggestProductButton);
		suggestProductButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().swapPanelWith(new NewProductGUI(customer));
				}
			});
		
		textField = new JTextField(customer.getName());
		textField.setBounds(548, 19, 86, 20);
		add(textField);
		textField.setColumns(10);
	}
}
