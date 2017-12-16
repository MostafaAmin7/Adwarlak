import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuestGUI extends JPanel{
	//ENTRY constructor
	public GuestGUI() {
		instance=this;
		setup();
	}
	private GuestGUI instance;
	
	//ENTRY Functions
	public void setup() {
		//ENTRY Button Actions
		JButton backButton = new JButton("Back");
		backButton.setBounds(20, 11, 74, 23);
		backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().goPanelBack(instance);
			}
		});
		JButton logInButton = new JButton("Log in");
		logInButton.setBounds(629, 79, 61, 23);
		logInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanel(instance, new LogIn());
			}
		});
		JButton signUpButton = new JButton("Sign Up Customer");
		signUpButton.setBounds(563, 11, 127, 23);
		signUpButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanel(instance, new SignUp(1));
			}
		});
		JButton btnSignUpShopowner = new JButton("Sign Up ShopOwner");
		btnSignUpShopowner.setBounds(563, 45, 127, 23);
		btnSignUpShopowner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanel(instance, new SignUp(2));
			}
		});
		
		JLabel titleLabel = new JLabel("Adwarlak");
		titleLabel.setBounds(198, 15, 44, 14);
		setLayout(null);
		add(backButton);
		add(titleLabel);
		add(logInButton);
		add(signUpButton);
		add(btnSignUpShopowner);
		
		SearchGUI searchGUI = new SearchGUI();
		searchGUI.setBounds(20, 45, 533, 377);
		add(searchGUI);
	}
}