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
import javax.swing.SwingConstants;

public class GuestGUI extends JPanel{
	//ENTRY constructor
	public GuestGUI() {
		setup();
	}
	
	//ENTRY Functions
	public void setup() {
		setBounds(0,0,494,441);
		//ENTRY Button Actions
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 33, 74, 23);
		backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().goPanelBack();
			}
		});
		JButton logInButton = new JButton("Log in");
		logInButton.setBounds(389, 67, 95, 23);
		logInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanelWith(new LogIn());
			}
		});
		JButton signUpButton = new JButton("Sign Up Customer");
		signUpButton.setBounds(10, 67, 139, 23);
		signUpButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanelWith(new SignUp(1));
			}
		});
		JButton btnSignUpShopowner = new JButton("Sign Up ShopOwner");
		btnSignUpShopowner.setBounds(186, 67, 139, 23);
		btnSignUpShopowner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanelWith(new SignUp(2));
			}
		});
		
		JLabel titleLabel = new JLabel("Adwarlak");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(186, 15, 139, 14);
		setLayout(null);
		add(backButton);
		add(titleLabel);
		add(logInButton);
		add(signUpButton);
		add(btnSignUpShopowner);
		
		SearchGUI searchGUI = new SearchGUI(new Guest());
		searchGUI.setBounds(0, 90, 494, 349);
		add(searchGUI);
	}
}