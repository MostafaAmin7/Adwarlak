import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;

public class CustomerGUI {
	//ENTRY 
	/*
	 * Other Classes that this Class use
	 * 			Pages only for this 
	 * 					user
	 * 	-SignUP  -LogIn
	 * */
	public CustomerGUI() {
		instance=this;
		
		setup();
	}
	//ENTRY Attributes
	private ArrayList<Product> productsToShow;
	private ArrayList<Brand> brands;
	private ArrayList<Category> categories;
	private CustomerGUI instance;
	private JPanel buyPanel, payPanel;
	private SearchGUI searchPanel;
	private ProductGUI productPanel;
	
	//ENTRY Functions
	public void setup() {
		
	}
}
