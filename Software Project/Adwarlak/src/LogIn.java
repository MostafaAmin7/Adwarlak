
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class LogIn extends JPanel{
	//ENTRY 
	/*
	 * This Class is used only for Log in
	 * */
	public LogIn() {
		setup();
	}
	//ENTRY Attributes
	private JTextField userNameField;
	private JPasswordField passwordField;
	
	//ENTRY Functions
	public void setup() {
		setBounds(0, 0, 500, 300);
		//ENTRY Button Actions
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 11, 55, 23);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().goPanelBack();
				}
			});
		JLabel userNameErrorLabel = new JLabel();
		userNameErrorLabel.setBounds(173, 125, 200, 20);
		JLabel passwordErrorLabel = new JLabel();
		passwordErrorLabel.setBounds(173, 210, 200, 20);
		userNameErrorLabel.setForeground(Color.RED);
		passwordErrorLabel.setForeground(Color.RED);
		userNameErrorLabel.setVisible(false);
		passwordErrorLabel.setVisible(false);
		
		JButton logInButton = new JButton("Log in");
		logInButton.setBounds(189, 230, 87, 23);
		logInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			// empty Validation
				String name=userNameField.getText().trim();
//				String password=passwordField.getPassword().toString().trim();
				String password=passwordField.getText().toString().trim();
				if(name.equals("")) {
					userNameErrorLabel.setText("Empty user name!");
					userNameErrorLabel.setVisible(true);
					return;
				}
				else {
					userNameErrorLabel.setVisible(false);
				}
				if(password.equals("")) {
					passwordErrorLabel.setText("Empty password!");
					passwordErrorLabel.setVisible(true);
					return;
				}
				else {
					passwordErrorLabel.setVisible(false);
				}
			//TODO Validation by database
				System.out.println(name + "   " + password);
//				password = "123";
				User x = DatabaseController.getInstance().signIn(name, password);
				if( x instanceof Customer) {
					GUIController.getInstance().swapPanelWith(new CustomerGUI((Customer)DatabaseController.getInstance().signIn(name, password)));
				}
				else if(x instanceof Admin) {
					GUIController.getInstance().swapPanelWith(new AdminGUI((Admin)DatabaseController.getInstance().signIn(name, password)));
				}
				else if(x instanceof ShopOwner) {
					GUIController.getInstance().swapPanelWith(new ShopOwnerGUI((ShopOwner)DatabaseController.getInstance().signIn(name, password)));
				}
				else {
					passwordErrorLabel.setText("Wrong user name or password!");
					passwordErrorLabel.setVisible(true);
				}
			}
		});
		JLabel titleLabel = new JLabel("Adwarlak");
		titleLabel.setBounds(198, 15, 69, 14);
		
		userNameField = new JTextField();
		userNameField.setBounds(173, 88, 166, 20);
		userNameField.setColumns(20);
		
		
		passwordField = new JPasswordField("password");
		passwordField.setBounds(173, 173, 166, 20);
		passwordField.setColumns(20);
		setLayout(null);
		add(backButton);
		add(titleLabel);
		add(logInButton);
		add(passwordField);
		add(userNameField);
		add(userNameErrorLabel);
		add(passwordErrorLabel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(173, 63, 77, 14);
		add(lblUserName);
		
		JLabel lblPasswrod = new JLabel("Password");
		lblPasswrod.setBounds(173, 148, 69, 14);
		add(lblPasswrod);
	}
}