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
import javax.xml.ws.AsyncHandler;
import javax.swing.JCheckBox;

public class SignUp extends JPanel{
	//ENTRY 
	/*
	 * This Class is used only for Log in
	 * */
	public SignUp(int type) {		
		setup(type);
	}
	//ENTRY Attributes
	
	//ENTRY Functions
	public void setup(int type) {
		if(type==1) {
			//ENTRY Button Actions
			JLabel lblAdwarlak = new JLabel("Adwarlak");
			lblAdwarlak.setBounds(207, 26, 52, 14);
			JButton backButton = new JButton("Back");
			backButton.setBounds(28, 22, 55, 23);
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						GUIController.getInstance().goPanelBack();
					}
				});
			
			JTextField mailField = new JTextField();
			mailField.setBounds(122, 116, 86, 20);
			mailField.setText("Mail");
			mailField.setColumns(10);
			
			JTextField userNameField = new JTextField();
			userNameField.setBounds(122, 63, 86, 20);
			userNameField.setText("UserName");
			userNameField.setColumns(10);
			
			JTextField ageField = new JTextField();
			ageField.setBounds(268, 63, 86, 20);
			ageField.setText("Age");
			ageField.setColumns(10);
			JTextField phoneField;
			phoneField = new JTextField();
			phoneField.setBounds(268, 116, 86, 20);
			phoneField.setText("Phone");
			phoneField.setColumns(10);
			
			JPasswordField passwordField = new JPasswordField();
			passwordField.setBounds(169, 172, 111, 20);
			passwordField.setText("Password");
			
			//ENTRY
			JButton signUpButton = new JButton("Sign Up");
			JLabel userNameErrorLabel = new JLabel("");
			userNameErrorLabel.setBounds(122, 91, 86, 14);
			add(userNameErrorLabel);
			
			JLabel ageErrorLabel = new JLabel("");
			ageErrorLabel.setBounds(268, 91, 86, 14);
			add(ageErrorLabel);
			
			JLabel mailErrorLabel = new JLabel("");
			mailErrorLabel.setBounds(122, 147, 86, 14);
			add(mailErrorLabel);
			
			JLabel phoneErrorLabel = new JLabel("");
			phoneErrorLabel.setBounds(268, 147, 86, 14);
			add(phoneErrorLabel);
			
			JLabel passwordErrorLabel = new JLabel("");
			passwordErrorLabel.setBounds(169, 191, 111, 14);
			add(passwordErrorLabel);
			
			signUpButton.setBounds(180, 216, 79, 23);
			signUpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						//customer GUI side validation
						String name=userNameField.getText().trim();
						String password=passwordField.getPassword().toString().trim();
						String mail=mailField.getText().trim();
						String phone=phoneField.getText().trim();
						String age=ageField.getText().trim();
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
						if(mail.equals("")) {
							mailErrorLabel.setText("Empty user name!");
							mailErrorLabel.setVisible(true);
							return;
						}
						else {
							phoneErrorLabel.setVisible(false);
						}
						if(phone.equals("")) {
							phoneErrorLabel.setText("Empty password!");
							phoneErrorLabel.setVisible(true);
							return;
						}
						else {
							if(phone.length() != 8) {
								phoneErrorLabel.setText("must be 8 digits");
								phoneErrorLabel.setVisible(true);
								return;
							}
							phoneErrorLabel.setVisible(false);
							int phoneValue;
							try {
								phoneValue=Integer.parseInt(phoneField.getText());	
							} catch (Exception e) {
								phoneErrorLabel.setText("NaN");
								phoneErrorLabel.setVisible(true);
								return;
							}
							phoneErrorLabel.setVisible(false);
						}
						
						if(age.equals("")) {
							ageErrorLabel.setText("Empty user name!");
							ageErrorLabel.setVisible(true);
							return;
						}
						else {
							int ageValue;
							try {
								ageValue=Integer.parseInt(age);	
							} catch (Exception e) {
								ageErrorLabel.setText("NaN");
								ageErrorLabel.setVisible(true);
								return;
							}
							if(ageValue > 150 && ageValue <= 15) {
								ageErrorLabel.setText("invalid age");
								ageErrorLabel.setVisible(true);
								return;
							}
//							clear age error
							ageErrorLabel.setVisible(false);
						}
						
						Customer x=new Customer();
						x.setName(name);
						x.setPhone(phone);
						x.setMail(mail);
						x.setAge(Integer.parseInt(age));
						if(DatabaseController.getInstance().signUp(x, password) == null) {
							userNameErrorLabel.setText("username already exists");
							userNameErrorLabel.setVisible(true);
							return;
						}
						else {
							userNameErrorLabel.setVisible(false);
							GUIController.getInstance().swapPanelWith(new CustomerGUI(x));
						}
					}
				});
			setLayout(null);
			add(backButton);
			add(lblAdwarlak);
			add(signUpButton);
			add(passwordField);
			add(mailField);
			add(phoneField);
			add(userNameField);
			add(ageField);
			
		}
		else {
			JTextField userNameField = new JTextField();
			userNameField.setBounds(92, 45, 121, 20);
			userNameField.setText("UserName");
			userNameField.setColumns(10);
			
			JTextField ageField = new JTextField();
			ageField.setBounds(240, 45, 115, 20);
			ageField.setText("Age");
			ageField.setColumns(10);
			
			JTextField phoneField = new JTextField();
			phoneField.setBounds(92, 96, 121, 20);
			phoneField.setText("Mail");
			phoneField.setColumns(10);
			
			JTextField mailField = new JTextField();
			mailField.setBounds(240, 96, 115, 20);
			mailField.setText("Phone");
			mailField.setColumns(10);
			
			JTextField shopNameField = new JTextField();
			shopNameField.setBounds(92, 203, 121, 20);
			shopNameField.setText("StoreName");
			shopNameField.setColumns(10);
			
			JTextField storeAddressField = new JTextField();
			storeAddressField.setBounds(92, 255, 263, 20);
			storeAddressField.setText("StoreAddress");
			storeAddressField.setColumns(10);
			
			JPasswordField passwordField = new JPasswordField();
			passwordField.setBounds(169, 144, 99, 20);
			passwordField.setText("Password");
			
			JLabel lblAdwarlak = new JLabel("Adwarlak");
			lblAdwarlak.setBounds(203, 15, 44, 14);
		
			JButton backButton = new JButton("Back");
			backButton.setBounds(10, 11, 55, 23);
			backButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						GUIController.getInstance().goPanelBack();
					}
				});
			JCheckBox chckbxTrypremium = new JCheckBox("Try Premium");
			chckbxTrypremium.setBounds(240, 202, 115, 23);
			

			//ENTRY
			JButton signUpButton = new JButton("Sign Up");
			
			JLabel userNameErrorLabel = new JLabel("");
			userNameErrorLabel.setBounds(92, 64, 121, 14);
			add(userNameErrorLabel);
			
			JLabel ageErrorLabel = new JLabel("");
			ageErrorLabel.setBounds(240, 64, 116, 14);
			add(ageErrorLabel);
			
			JLabel mailErrorLabel = new JLabel("");
			mailErrorLabel.setBounds(92, 116, 121, 14);
			add(mailErrorLabel);
			
			JLabel phoneErrorLabel = new JLabel("");
			phoneErrorLabel.setBounds(240, 116, 115, 14);
			add(phoneErrorLabel);
			
			JLabel passwordErrorLabel = new JLabel("");
			passwordErrorLabel.setBounds(169, 163, 99, 14);
			add(passwordErrorLabel);
			
			JLabel shopNameErrorLabel = new JLabel("");
			shopNameErrorLabel.setBounds(92, 222, 121, 14);
			add(shopNameErrorLabel);
			
			JLabel storeAddressErrorLabel = new JLabel("");
			storeAddressErrorLabel.setBounds(92, 275, 263, 14);
			add(storeAddressErrorLabel);
			
			signUpButton.setBounds(169, 309, 103, 23);
			signUpButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						//StoreOwner GUI side validation
						String name=userNameField.getText().trim();
						String password=passwordField.getPassword().toString().trim();
						String mail=mailField.getText().trim();
						String phone=phoneField.getText().trim();
						String age=ageField.getText().trim();
						String shopName=shopNameField.getText().trim();
						String shopAddress=storeAddressField.getText().trim();
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
						if(mail.equals("")) {
							mailErrorLabel.setText("Empty user name!");
							mailErrorLabel.setVisible(true);
							return;
						}
						else {
							phoneErrorLabel.setVisible(false);
						}
						if(phone.equals("")) {
							phoneErrorLabel.setText("Empty password!");
							phoneErrorLabel.setVisible(true);
							return;
						}
						else {
							if(phone.length() != 8) {
								phoneErrorLabel.setText("must be 8 digits");
								phoneErrorLabel.setVisible(true);
								return;
							}
							phoneErrorLabel.setVisible(false);
							int phoneValue;
							try {
								phoneValue=Integer.parseInt(phoneField.getText());	
							} catch (Exception e) {
								phoneErrorLabel.setText("NaN");
								phoneErrorLabel.setVisible(true);
								return;
							}
							phoneErrorLabel.setVisible(false);
						}
						
						if(age.equals("")) {
							ageErrorLabel.setText("Empty user name!");
							ageErrorLabel.setVisible(true);
							return;
						}
						else {
							int ageValue;
							try {
								ageValue=Integer.parseInt(age);	
							} catch (Exception e) {
								ageErrorLabel.setText("NaN");
								ageErrorLabel.setVisible(true);
								return;
							}
							if(ageValue > 150 && ageValue <= 15) {
								ageErrorLabel.setText("invalid age");
								ageErrorLabel.setVisible(true);
								return;
							}
//							clear age error
							ageErrorLabel.setVisible(false);
						}
						if(shopName.equals("")) {
							shopNameErrorLabel.setText("Empty user name!");
							shopNameErrorLabel.setVisible(true);
							return;
						}
						else {
							shopNameErrorLabel.setVisible(false);
						}
						ShopOwner x=new ShopOwner();
						x.setName(name);
						x.setPhone(phone);
						x.setMail(mail);
						x.setAge(Integer.parseInt(age));
						x.setPremium(chckbxTrypremium.isSelected());
						Store xStore = new Store();
						xStore.setName(shopName);
						xStore.setAddress(shopAddress);
						xStore.setOwner(x);
						x.addStore(xStore);
						if(DatabaseController.getInstance().signUp(x, password) == null) {
							userNameErrorLabel.setText("username already exists");
							userNameErrorLabel.setVisible(true);
							return;
						}
						else {
							userNameErrorLabel.setVisible(false);
							GUIController.getInstance().swapPanelWith(new ShopOwnerGUI(x));
						}
					}
				});
			setLayout(null);
			
			add(chckbxTrypremium);
			add(backButton);
			add(lblAdwarlak);
			add(phoneField);
			add(userNameField);
			add(passwordField);
			add(signUpButton);
			add(shopNameField);
			add(storeAddressField);
			add(mailField);
			add(ageField);
			
			
		}
	}
}