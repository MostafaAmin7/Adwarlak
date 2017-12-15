import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SignUp extends JPanel{
	//ENTRY 
	/*
	 * This Class is used only for Log in
	 * */
	public SignUp(int type) {
		instance=this;
		
		
		
		
		setup(type);
	}
	//ENTRY Attributes
	private SignUp instance;
	
	//ENTRY Functions
	public void setup(int type) {
		if(type==1) {
			//ENTRY Button Actions
			JLabel lblAdwarlak = new JLabel("Adwarlak");
			JButton backButton = new JButton("Back");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						GUIController.getInstance().goPanelBack(instance);
					}
				});
			
			JTextField mailField = new JTextField();
			mailField.setText("Mail");
			mailField.setColumns(10);
			
			JTextField userNameField = new JTextField();
			userNameField.setText("UserName");
			userNameField.setColumns(10);
			
			JTextField ageField = new JTextField();
			ageField.setText("Age");
			ageField.setColumns(10);
			JTextField phoneField;
			phoneField = new JTextField();
			phoneField.setText("Phone");
			phoneField.setColumns(10);
			
			JPasswordField passwordField = new JPasswordField();
			passwordField.setText("Password");
			
			JButton signUpButton = new JButton("Sign Up");
		
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(28)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(backButton)
										.addPreferredGap(ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
										.addComponent(lblAdwarlak, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(162)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(signUpButton, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
											.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))))
								.addGap(191))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(122)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(60)
										.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGap(0))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(22)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(backButton)
							.addComponent(lblAdwarlak))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(30)
						.addComponent(signUpButton)
						.addGap(88))
			);
			setLayout(groupLayout);
		}
		else {
			JTextField userNameField = new JTextField();
			userNameField.setText("UserName");
			userNameField.setColumns(10);
			
			JTextField ageField = new JTextField();
			ageField.setText("Age");
			ageField.setColumns(10);
			
			JTextField phoneField = new JTextField();
			phoneField.setText("Mail");
			phoneField.setColumns(10);
			
			JTextField mailField = new JTextField();
			mailField.setText("Phone");
			mailField.setColumns(10);
			
			JTextField shopNameField = new JTextField();
			shopNameField.setText("StoreName");
			shopNameField.setColumns(10);
			
			JTextField storeAddressField = new JTextField();
			storeAddressField.setText("StoreAddress");
			storeAddressField.setColumns(10);
			
			JPasswordField passwordField = new JPasswordField();
			passwordField.setText("Password");
			
			JLabel lblAdwarlak = new JLabel("Adwarlak");
		
			JButton backButton = new JButton("Back");
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						GUIController.getInstance().goPanelBack(instance);
					}
				});
			
			JButton btnSignUp = new JButton("Sign Up");
		
		
		
		
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(29)
								.addComponent(backButton)
								.addGap(137)
								.addComponent(lblAdwarlak))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(146)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(phoneField)
									.addComponent(userNameField)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(57)
										.addComponent(btnSignUp))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(shopNameField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(storeAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(85, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(23)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(backButton)
							.addComponent(lblAdwarlak))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(ageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(mailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(shopNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(storeAddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnSignUp)
						.addGap(92))
			);
			setLayout(groupLayout);
		}
	}
}