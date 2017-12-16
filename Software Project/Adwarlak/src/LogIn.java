
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
		instance=this;
		setup();
	}
	//ENTRY Attributes
	private LogIn instance;
	private JTextField userNameField;
	private JPasswordField passwordField;
	
	//ENTRY Functions
	public void setup() {
		//ENTRY Button Actions
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().goPanelBack(instance);
				}
			});
		JLabel userNameErrorLabel = new JLabel();
		JLabel passwordErrorLabel = new JLabel();
		userNameErrorLabel.setForeground(Color.RED);
		passwordErrorLabel.setForeground(Color.RED);
		userNameErrorLabel.setVisible(false);
		passwordErrorLabel.setVisible(false);
		
		JButton logInButton = new JButton("Log in");
		logInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			// empty Validation
				String name=userNameField.getText().trim();
				String password=passwordField.getPassword().toString().trim();
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
				if(DatabaseController.getInstance().signIn(name, password) instanceof Customer) {
					GUIController.getInstance().swapPanel(instance, new CustomerGUI((Customer)DatabaseController.getInstance().signIn(name, password)));
				}
				else if(DatabaseController.getInstance().signIn(name, password) instanceof Admin) {
					
				}
				else if(DatabaseController.getInstance().signIn(name, password) instanceof ShopOwner) {
					
				}
				else {
					passwordErrorLabel.setText("Wrong user name or password!");
				}
			}
		});
		JLabel titleLabel = new JLabel("Adwarlak");
		
		userNameField = new JTextField();
		userNameField.setColumns(20);
		userNameField.setText("UserName");
		userNameField.setForeground(Color.GRAY);
		userNameField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (userNameField.getText().equals("UserName")) {
		            userNameField.setText("");
		            userNameField.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (userNameField.getText().isEmpty()) {
		            userNameField.setForeground(Color.GRAY);
		            userNameField.setText("UserName");
		        }
		    }
		    });
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		passwordField.setText("Password");
		passwordField.setForeground(Color.GRAY);
		passwordField.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (passwordField.getText().equals("Password")) {
		            passwordField.setText("");
		            passwordField.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (passwordField.getText().isEmpty()) {
		            passwordField.setForeground(Color.GRAY);
		            passwordField.setText("Password");
		        }
		    }
		    });
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(backButton)
							.addGap(133)
							.addComponent(titleLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(189)
							.addComponent(logInButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(173)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(userNameErrorLabel)
								.addComponent(passwordErrorLabel))))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(backButton)
						.addComponent(titleLabel))
					.addGap(77)
					.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(userNameErrorLabel)
					.addGap(10)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordErrorLabel)
					.addGap(11)
					.addComponent(logInButton)
					.addGap(60))
		);
		setLayout(groupLayout);
	}
}