import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SearchGUI extends JPanel{
	//ENTRY 
	/*
	 * Other Classes that this Class use
	 * 			Pages only for this 
	 * 					user
	 * 	-SignUP  -LogIn
	 * */
	public SearchGUI(User x) {
		productsToShow = new ArrayList<Product>();
		customers=new ArrayList<Customer>();
		setup(x);
	}
	//ENTRY Attributes
	private ArrayList<Product> productsToShow;
	private ArrayList<String> brands;
	private ArrayList<String> categories;
	private ArrayList<Customer> customers;
	private JTextField searchBar;
	private JTextField minValue;
	private JTextField maxValue;
	
	//ENTRY Functions
	public void setup(User x) {
		setLayout(null);
		brands=DatabaseController.getInstance().getBrands();
		categories=DatabaseController.getInstance().getCategories();
		productsToShow=DatabaseController.getInstance().search("",new ArrayList<String>(),new ArrayList<String>(),-1,-1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("For customers");
		chckbxNewCheckBox.setSelected(false);
		
		if(x instanceof Admin) {
			chckbxNewCheckBox.setBounds(373, 11, 109, 23);
			add(chckbxNewCheckBox);
		}
		
		Panel searchOptionPanel = new Panel();
		searchOptionPanel.setBounds(516, 40, 109, 299);
		add(searchOptionPanel);
		searchOptionPanel.setLayout(null);
		
		chckbxNewCheckBox.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        JCheckBox cb = (JCheckBox) event.getSource();
		        if (cb.isSelected()) {
		            remove(searchOptionPanel);
		        } else {
		            add(searchOptionPanel);
		        }
		    }
		});
		
		searchBar = new JTextField();
		searchBar.setBounds(99, 12, 268, 20);
		add(searchBar);
		searchBar.setColumns(10);
		
		JScrollPane brandListScrollPane = new JScrollPane();
		brandListScrollPane.setBounds(0, 20, 110, 70);
		searchOptionPanel.add(brandListScrollPane);
		
		DefaultListModel<String> listBrands = new DefaultListModel<>();
		for(int i=0;i<brands.size();i++) {
			listBrands.addElement(brands.get(i));
		}
		
		JList<String> brandList = new JList<>(listBrands);
		brandListScrollPane.setViewportView(brandList);
		
		ArrayList<String> selectedBrands=new ArrayList<String>();
		
		brandList.addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e)
		    {
		        if(!e.getValueIsAdjusting()) {
		            java.util.List<String> selected = brandList.getSelectedValuesList();
		            for(int i=0;i<selected.size();i++) {
		            	selectedBrands.add(selected.get(i));
		            }
		        }
		    }
		});
		
		DefaultListModel<String> listCategories = new DefaultListModel<>();
		for(int i=0;i<categories.size();i++) {
			listCategories.addElement(categories.get(i));
		}
		
		JScrollPane categoryListScrollPane = new JScrollPane();
		categoryListScrollPane.setBounds(0, 130, 110, 97);
		searchOptionPanel.add(categoryListScrollPane);
		
		JList<String> categoryList = new JList<>(listCategories);
		categoryListScrollPane.setViewportView(categoryList);
		
		ArrayList<String> selectedCategories=new ArrayList<String>();
		
		categoryList.addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e)
		    {
		        if(!e.getValueIsAdjusting()) {
		            java.util.List<String> selected = categoryList.getSelectedValuesList();
		            for(int i=0;i<selected.size();i++) {
		            	selectedCategories.add(selected.get(i));
		            }
		        }
		    }
		});
		
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
		txtrSelectCategoryies.setBounds(0, 95, 109, 32);
		searchOptionPanel.add(txtrSelectCategoryies);
		
		JTextArea txtrSelectPriceRange = new JTextArea();
		txtrSelectPriceRange.setEditable(false);
		txtrSelectPriceRange.setFont(UIManager.getFont("Label.font"));
		txtrSelectPriceRange.setText("    Select Price\r\n         Range");
		txtrSelectPriceRange.setBounds(0, 230, 109, 32);
		searchOptionPanel.add(txtrSelectPriceRange);
		
		JLabel lblLow = new JLabel("Low");
		lblLow.setHorizontalAlignment(SwingConstants.CENTER);
		lblLow.setBounds(0, 265, 55, 14);
		searchOptionPanel.add(lblLow);
		
		JLabel lblHigh = new JLabel("High");
		lblHigh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHigh.setBounds(54, 265, 55, 14);
		searchOptionPanel.add(lblHigh);
		
		minValue = new JTextField();
		minValue.setBounds(0, 279, 55, 20);
		searchOptionPanel.add(minValue);
		minValue.setColumns(10);
		
		maxValue = new JTextField();
		maxValue.setBounds(54, 279, 56, 20);
		searchOptionPanel.add(maxValue);
		maxValue.setColumns(10);
		

		JPanel resultPanel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(resultPanel);
		GroupLayout gl_resultPanel = new GroupLayout(resultPanel);
		gl_resultPanel.setHorizontalGroup(
			gl_resultPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 498, Short.MAX_VALUE)
		);
		gl_resultPanel.setVerticalGroup(
			gl_resultPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 278, Short.MAX_VALUE)
		);
		resultPanel.setLayout(gl_resultPanel);
		scrollPane.setBounds(10, 40, 500, 300);
		add(scrollPane);
		
		ArrayList<ProductCardGUI> productCardGUIs = new ArrayList<ProductCardGUI>();
		ArrayList<CustomerCardGUI> customerCardGUIs= new ArrayList<CustomerCardGUI>();
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultPanel.removeAll();
				resultPanel.repaint();
				if(chckbxNewCheckBox.isSelected()) {
//					System.out.println("AA");
					customers=DatabaseController.getInstance().getCustomers(searchBar.getText());
					
					for(int i=0;i<customers.size();i++) {
						CustomerCardGUI card=new CustomerCardGUI(customers.get(i));
						card.setPreferredSize(new Dimension(500, 100));
						customerCardGUIs.add(card);
						resultPanel.add(card);
					}

//					JLabel dummy=new JLabel("");
//					dummy.setBounds(0, customers.size()*100, 10, 10);
//					resultPanel.add(dummy);
				}
				else {
					Double minVal=0D,maxVal=0D;
					String mini=minValue.getText().trim();
					String max=maxValue.getText().trim();
					if(mini.equals("")) {
						mini="-1";
					}
					if(max.equals("")) {
						max="-1";
					}
					try {
						minVal=Double.parseDouble(mini);
						maxVal=Double.parseDouble(max);
					} catch (Exception e2) {
						minValue.setText("");
						maxValue.setText("");
					}
					if(maxVal<0) {
						minVal=-1D;
						maxVal=-1D;
					}
					productsToShow=DatabaseController.getInstance().search(searchBar.getText(),selectedBrands,selectedCategories,minVal.intValue(),maxVal.intValue());
					
					for(int i=0;i<productsToShow.size();i++) {
						ProductCardGUI card=new ProductCardGUI(productsToShow.get(i),x,false);
						card.setBounds(0, i*100, 500, 100);
//						card.setPreferredSize(new Dimension(500, 100));
						productCardGUIs.add(card);
						resultPanel.add(card);
//						resultPanel..add(arg0)
					}
//					JLabel dummy=new JLabel("");
//					dummy.setBounds(0, productsToShow.size()*100, 10, 10);
//					resultPanel.add(dummy);
					resultPanel.setPreferredSize(new Dimension(500, productsToShow.size()*100));
					
				}
			}
		});
		searchButton.setBounds(10, 11, 83, 23);
		add(searchButton);
		
		
//		scrollPane.setViewportView(resultPanel);
		
		
		
		
//		Product z=new Product();
//		z.setName("nn");
//		z.setBrand("MM");
//		z.setCategory(new ArrayList<String>());
//		z.setStore("SSSS");
//		z.setPrice(15D);
//		ProductCardGUI ca=new ProductCardGUI(z,new Guest(),false);
//		ca.setBounds(0, 0, 500, 100);
//		Product z1=new Product();
//		z1.setName("nn");
//		z1.setBrand("MM");
//		z1.setCategory(new ArrayList<String>());
//		z1.setStore("SSSS");
//		z1.setPrice(15D);
//		ProductCardGUI ca1=new ProductCardGUI(z,new Guest(),false);
//		ca1.setBounds(0, 100, 500, 100);
//		ResultPanel.add(ca);
//		ResultPanel.add(ca1);
		
	}
}
