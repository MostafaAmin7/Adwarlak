import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;

public class CustomerGUI extends JPanel{
	//ENTRY 
	/*
	 * Other Classes that this Class use
	 * 			Pages only for this 
	 * 					user
	 * 	-SignUP  -LogIn
	 * */
	public CustomerGUI() {
		instance=this;
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);
		productsToShow = new ArrayList<Product>();
		brands = new ArrayList<Brand>();
		categories = new ArrayList<Category>();
		setup();
	}
	//ENTRY Attributes
	private ArrayList<Product> productsToShow;
	private ArrayList<Brand> brands;
	private ArrayList<Category> categories;
	private CustomerGUI instance;
	
	//ENTRY Functions
	public void setup() {
		
	}
}
