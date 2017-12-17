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
//		if(type==1) {
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
			mailField.setBounds(122, 101, 86, 20);
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
			phoneField.setBounds(268, 101, 86, 20);
			phoneField.setText("Phone");
			phoneField.setColumns(10);
			
			JPasswordField passwordField = new JPasswordField();
			passwordField.setBounds(190, 139, 69, 20);
			passwordField.setText("Password");
			
			//ENTRY
			JButton signUpButton = new JButton("Sign Up");
			JLabel userNameErrorLabel = new JLabel("");
			userNameErrorLabel.setBounds(122, 81, 86, 14);
			add(userNameErrorLabel);
			
			JLabel ageErrorLabel = new JLabel("");
			ageErrorLabel.setBounds(268, 81, 86, 14);
			add(ageErrorLabel);
			
			JLabel mailErrorLabel = new JLabel("");
			mailErrorLabel.setBounds(122, 118, 86, 14);
			add(mailErrorLabel);
			
			JLabel phoneErrorLabel = new JLabel("");
			phoneErrorLabel.setBounds(268, 118, 86, 14);
			add(phoneErrorLabel);
			signUpButton.setBounds(190, 189, 69, 23);
			backButton.addActionListener(new ActionListener() {
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
//							userNameErrorLabel.setText("Empty user name!");
//							userNameErrorLabel.setVisible(true);
							return;
						}
						else {
//							userNameErrorLabel.setVisible(false);
						}
						if(phone.equals("")) {
//							passwordErrorLabel.setText("Empty password!");
//							passwordErrorLabel.setVisible(true);
							return;
						}
						else {
							int phoneValue;
							try {
								phoneValue=Integer.parseInt(phoneField.getText());	
							} catch (Exception e) {
//								this is not a number
								return;
							}
//							passwordErrorLabel.setVisible(false);
						}
						if(age.equals("")) {
//							userNameErrorLabel.setText("Empty user name!");
//							userNameErrorLabel.setVisible(true);
							return;
						}
						else {
							int ageValue;
							try {
								ageValue=Integer.parseInt(age);	
							} catch (Exception e) {
//								this is not a number
								return;
							}
//							clear age error
//							userNameErrorLabel.setVisible(false);
						}
						Customer x=new Customer();
						x.setName(name);
						x.setPhone(phone);
						x.setMail(mail);
						x.setAge(Integer.parseInt(age));
						if(DatabaseController.getInstance().signUp(x, password) == null) {
//							show error
							return;
						}
						else {
//							clear error
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
			
			JLabel label = new JLabel("");
			label.setBounds(167, 164, 111, 14);
			add(label);
			
			
			
			
//		}
//		else {
//			JTextField userNameField = new JTextField();
//			userNameField.setBounds(92, 45, 121, 20);
//			userNameField.setText("UserName");
//			userNameField.setColumns(10);
//			
//			JTextField ageField = new JTextField();
//			ageField.setBounds(269, 45, 86, 20);
//			ageField.setText("Age");
//			ageField.setColumns(10);
//			
//			JTextField phoneField = new JTextField();
//			phoneField.setBounds(92, 76, 121, 20);
//			phoneField.setText("Mail");
//			phoneField.setColumns(10);
//			
//			JTextField mailField = new JTextField();
//			mailField.setBounds(240, 76, 115, 20);
//			mailField.setText("Phone");
//			mailField.setColumns(10);
//			
//			JTextField shopNameField = new JTextField();
//			shopNameField.setBounds(92, 132, 121, 20);
//			shopNameField.setText("StoreName");
//			shopNameField.setColumns(10);
//			
//			JTextField storeAddressField = new JTextField();
//			storeAddressField.setBounds(240, 130, 115, 20);
//			storeAddressField.setText("StoreAddress");
//			storeAddressField.setColumns(10);
//			
//			JPasswordField passwordField = new JPasswordField();
//			passwordField.setBounds(186, 107, 86, 20);
//			passwordField.setText("Password");
//			
//			JLabel lblAdwarlak = new JLabel("Adwarlak");
//			lblAdwarlak.setBounds(203, 15, 44, 14);
//		
//			JButton backButton = new JButton("Back");
//			backButton.setBounds(10, 11, 55, 23);
//			backButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//						GUIController.getInstance().goPanelBack();
//					}
//				});
//			JCheckBox chckbxTrypremium = new JCheckBox("TryPremium");
//			chckbxTrypremium.setBounds(186, 155, 99, 23);
//			
//
//			//ENTRY
//			JButton signUpButton = new JButton("Sign Up");
//			signUpButton.setBounds(203, 185, 69, 23);
//			backButton.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//						//StoreOwner GUI side validation
//						String name=userNameField.getText().trim();
//						String password=passwordField.getPassword().toString().trim();
//						String mail=mailField.getText().trim();
//						String phone=phoneField.getText().trim();
//						String age=ageField.getText().trim();
//						String shopName=shopNameField.getText().trim();
//						String shopAddress=storeAddressField.getText().trim();
//						if(name.equals("")) {
////							userNameErrorLabel.setText("Empty user name!");
////							userNameErrorLabel.setVisible(true);
//							return;
//						}
//						else {
////							userNameErrorLabel.setVisible(false);
//						}
//						if(password.equals("")) {
////							passwordErrorLabel.setText("Empty password!");
////							passwordErrorLabel.setVisible(true);
//							return;
//						}
//						else {
////							passwordErrorLabel.setVisible(false);
//						}
//						if(mail.equals("")) {
////							userNameErrorLabel.setText("Empty user name!");
////							userNameErrorLabel.setVisible(true);
//							return;
//						}
//						else {
////							userNameErrorLabel.setVisible(false);
//						}
//						if(phone.equals("")) {
////							passwordErrorLabel.setText("Empty password!");
////							passwordErrorLabel.setVisible(true);
//							return;
//						}
//						else {
//							int phoneValue;
//							try {
//								phoneValue=Integer.parseInt(phoneField.getText());	
//							} catch (Exception e) {
////								this is not a number
//								return;
//							}
////							passwordErrorLabel.setVisible(false);
//						}
//						if(age.equals("")) {
////							userNameErrorLabel.setText("Empty user name!");
////							userNameErrorLabel.setVisible(true);
//							return;
//						}
//						else {
//							int ageValue;
//							try {
//								ageValue=Integer.parseInt(age);	
//							} catch (Exception e) {
////								this is not a number
//								return;
//							}
////							clear age error
////							userNameErrorLabel.setVisible(false);
//						}
//						if(shopName.equals("")) {
////							userNameErrorLabel.setText("Empty user name!");
////							userNameErrorLabel.setVisible(true);
//							return;
//						}
//						else {
////							userNameErrorLabel.setVisible(false);
//						}
//						ShopOwner x=new ShopOwner();
//						x.setName(name);
//						x.setPhone(phone);
//						x.setMail(mail);
//						x.setAge(Integer.parseInt(age));
//						x.setPremium(chckbxTrypremium.isSelected());
//						Store xStore = new Store();
//						xStore.setName(shopName);
//						xStore.setAddress(shopAddress);
//						xStore.setOwner(x);
//						x.addStore(xStore);
//						if(DatabaseController.getInstance().signUp(x, password) == null) {
////							show error
//							return;
//						}
//						else {
////							clear error
//							GUIController.getInstance().swapPanelWith(new ShopOwnerGUI(x));
//						}
//					}
//				});
//			setLayout(null);
//			
//			add(chckbxTrypremium);
//			add(backButton);
//			add(lblAdwarlak);
//			add(phoneField);
//			add(userNameField);
//			add(passwordField);
//			add(signUpButton);
//			add(shopNameField);
//			add(storeAddressField);
//			add(mailField);
//			add(ageField);
//		}
	}
}