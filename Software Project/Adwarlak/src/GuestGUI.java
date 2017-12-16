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
		backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().goPanelBack(instance);
			}
		});
		JButton logInButton = new JButton("Log in");
		logInButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanel(instance, new LogIn());
			}
		});
		JButton signUpButton = new JButton("Sign Up Customer");
		signUpButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanel(instance, new SignUp(1));
			}
		});
		JButton btnSignUpShopowner = new JButton("Sign Up ShopOwner");
		btnSignUpShopowner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanel(instance, new SignUp(2));
			}
		});
		
		JLabel titleLabel = new JLabel("Adwarlak");
		
		JButton btnShowProduct = new JButton("Show Product");
		btnShowProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanel(instance, new ProductGUI(null));
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(backButton)
									.addGap(133)
									.addComponent(titleLabel)
									.addPreferredGap(ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
									.addComponent(logInButton))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGap(55)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(signUpButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnSignUpShopowner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(121)
							.addComponent(btnShowProduct)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(backButton)
						.addComponent(logInButton)
						.addComponent(titleLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(signUpButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSignUpShopowner)
					.addGap(38)
					.addComponent(btnShowProduct)
					.addContainerGap(137, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}