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
	//ENTRY 
	/*
	 * Other Classes that this Class use
	 * 			Pages only for this 
	 * 					user
	 * 	-SignUP  -LogIn
	 * */
	public GuestGUI() {
		instance=this;
		productsToShow = new ArrayList<Product>();
		brands = new ArrayList<Brand>();
		categories = new ArrayList<Category>();
		setup();
	}
	//ENTRY Attributes
	private ArrayList<Product> productsToShow;
	private ArrayList<Brand> brands;
	private ArrayList<Category> categories;
	private GuestGUI instance;
	
	//ENTRY Functions
	public void setup() {
		JTextField searchBar;
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
		
		JButton searchButton = new JButton("Search");
		
		JLabel titleLabel = new JLabel("Adwarlak");
		
		searchBar = new JTextField();
		searchBar.setText("search");
		searchBar.setColumns(50);
		
		//setting the spaceholder
		searchBar.setForeground(Color.GRAY);
		searchBar.addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (searchBar.getText().equals("Search")) {
		            searchBar.setText("");
		            searchBar.setForeground(Color.BLACK);
		        }
		    }
		    @Override
		    public void focusLost(FocusEvent e) {
		        if (searchBar.getText().isEmpty()) {
		            searchBar.setForeground(Color.GRAY);
		            searchBar.setText("Search");
		        }
		    }
		    });
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(backButton)
							.addGap(133)
							.addComponent(titleLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
							.addComponent(logInButton))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(searchButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchBar, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(signUpButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSignUpShopowner, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
						.addComponent(signUpButton)
						.addComponent(searchButton)
						.addComponent(searchBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSignUpShopowner)
					.addContainerGap(198, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}