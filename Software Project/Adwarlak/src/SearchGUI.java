import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JSpinner;

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
		setLayout(null);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(10, 11, 83, 23);
		add(searchButton);
		
		searchBar = new JTextField();
		searchBar.setBounds(99, 12, 268, 20);
		add(searchBar);
		searchBar.setColumns(10);
		
		Panel searchOptionPanel = new Panel();
		searchOptionPanel.setBounds(373, 11, 109, 330);
		add(searchOptionPanel);
		searchOptionPanel.setLayout(null);
		
		JScrollPane brandListScrollPane = new JScrollPane();
		brandListScrollPane.setBounds(0, 29, 110, 80);
		searchOptionPanel.add(brandListScrollPane);
		
		JList brandList = new JList();
		brandListScrollPane.setViewportView(brandList);
		
		JScrollPane categoryListScrollPane = new JScrollPane();
		categoryListScrollPane.setBounds(0, 148, 110, 97);
		searchOptionPanel.add(categoryListScrollPane);
		
		JList categoryList = new JList();
		categoryListScrollPane.setViewportView(categoryList);
		
		JTextArea txtrSelectBrands = new JTextArea();
		txtrSelectBrands.setEditable(false);
		txtrSelectBrands.setFont(UIManager.getFont("Label.font"));
		txtrSelectBrands.setText("Select Brand/s");
		txtrSelectBrands.setBounds(0, 0, 109, 18);
		searchOptionPanel.add(txtrSelectBrands);
		
		JTextArea txtrSelectCategoryies = new JTextArea();
		txtrSelectCategoryies.setEditable(false);
		txtrSelectCategoryies.setFont(UIManager.getFont("Label.font"));
		txtrSelectCategoryies.setText("     Select\r\nCategory/ies");
		txtrSelectCategoryies.setBounds(0, 114, 109, 32);
		searchOptionPanel.add(txtrSelectCategoryies);
		
		JTextArea txtrSelectPriceRange = new JTextArea();
		txtrSelectPriceRange.setEditable(false);
		txtrSelectPriceRange.setFont(UIManager.getFont("Label.font"));
		txtrSelectPriceRange.setText("    Select Price\r\n         Range");
		txtrSelectPriceRange.setBounds(0, 256, 109, 32);
		searchOptionPanel.add(txtrSelectPriceRange);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(0, 299, 55, 20);
		searchOptionPanel.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(54, 299, 55, 20);
		searchOptionPanel.add(spinner_1);
		
		JLabel lblLow = new JLabel("Low");
		lblLow.setHorizontalAlignment(SwingConstants.CENTER);
		lblLow.setBounds(0, 285, 55, 14);
		searchOptionPanel.add(lblLow);
		
		JLabel lblHigh = new JLabel("High");
		lblHigh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHigh.setBounds(54, 285, 55, 14);
		searchOptionPanel.add(lblHigh);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 357, 301);
		add(scrollPane);
		
		Panel ResultPanel = new Panel();
		scrollPane.setViewportView(ResultPanel);
		ResultPanel.setLayout(null);
	}
}
