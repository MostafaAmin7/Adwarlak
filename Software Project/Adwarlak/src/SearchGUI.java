import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JList;

public class SearchGUI extends JPanel{
	//ENTRY 
	/*
	 * Other Classes that this Class use
	 * 			Pages only for this 
	 * 					user
	 * 	-SignUP  -LogIn
	 * */
	public SearchGUI() {
		instance=this;
		setLayout(null);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 11, 55, 23);
		add(backButton);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(10, 45, 65, 23);
		add(searchButton);
		
		searchBar = new JTextField();
		searchBar.setBounds(99, 46, 250, 20);
		add(searchBar);
		searchBar.setColumns(10);
		
		Panel panel = new Panel();
		panel.setBounds(355, 45, 85, 245);
		add(panel);
		panel.setLayout(null);
		productsToShow = new ArrayList<Product>();
		brands = new ArrayList<Brand>();
		categories = new ArrayList<Category>();
		setup();
	}
	//ENTRY Attributes
	private ArrayList<Product> productsToShow;
	private ArrayList<Brand> brands;
	private ArrayList<Category> categories;
	private SearchGUI instance;
	private JTextField searchBar;
	
	//ENTRY Functions
	public void setup() {
	
	}
}
