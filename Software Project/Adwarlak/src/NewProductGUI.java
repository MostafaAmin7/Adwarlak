import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class NewProductGUI extends JPanel{
	//ENTRY Constructor
	public NewProductGUI(User x) {
				setup(x);
	}
	
	public void setup(User x) {
		setLayout(null);
		JTextField productNameValue;
		JTextField brandNameValue;
		JTextField colorValue;
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 11, 89, 23);
		add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().goPanelBack();
				}
			});
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(195, 15, 62, 14);
		add(lblAdwarlak);
		
		JLabel productNameLabel = new JLabel("Product Name");
		productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productNameLabel.setBounds(61, 57, 81, 14);
		add(productNameLabel);
		
		productNameValue = new JTextField();
		productNameValue.setBounds(61, 82, 86, 20);
		add(productNameValue);
		productNameValue.setColumns(10);
		
		brandNameValue = new JTextField();
		brandNameValue.setBounds(195, 82, 86, 20);
		add(brandNameValue);
		brandNameValue.setColumns(10);
		
		colorValue = new JTextField();
		colorValue.setBounds(321, 82, 86, 20);
		add(colorValue);
		colorValue.setColumns(10);
		
		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setHorizontalAlignment(SwingConstants.CENTER);
		brandLabel.setBounds(211, 57, 46, 14);
		add(brandLabel);
		
		JLabel colorLabel = new JLabel("Color");
		colorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		colorLabel.setBounds(341, 57, 46, 14);
		add(colorLabel);
		
		JLabel categoriesLabel = new JLabel("Category/ies  (seperate each category with / )");
		categoriesLabel.setBounds(61, 113, 346, 14);
		add(categoriesLabel);
		
		JTextArea CategoriesArea = new JTextArea();
		CategoriesArea.setBounds(61, 138, 346, 40);
		add(CategoriesArea);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descriptionLabel.setBounds(61, 189, 86, 14);
		add(descriptionLabel);
		
		JTextArea descriptionArea = new JTextArea();
		descriptionArea.setBounds(61, 214, 346, 40);
		add(descriptionArea);
		
		JLabel nameErrorLabel = new JLabel("");
		nameErrorLabel.setBounds(61, 102, 81, 14);
		add(nameErrorLabel);
		
		JLabel brandErrorLabel = new JLabel("");
		brandErrorLabel.setBounds(195, 102, 86, 14);
		add(brandErrorLabel);
		
		JLabel colorErrorLabel = new JLabel("");
		colorErrorLabel.setBounds(321, 102, 46, 14);
		add(colorErrorLabel);
		
		JLabel categoryErrorLabel = new JLabel("");
		categoryErrorLabel.setBounds(61, 176, 346, 14);
		add(categoryErrorLabel);
		
		JLabel descriptionErrorLabel = new JLabel("");
		descriptionErrorLabel.setBounds(61, 253, 346, 14);
		add(descriptionErrorLabel);
		
		if(x instanceof Admin) {
			JButton btnNewButton = new JButton("Add Product");
			btnNewButton.setBounds(192, 266, 100, 25);
			add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						String name=productNameValue.getText().trim();
						String categoryValue=CategoriesArea.getText().trim();
						ArrayList<String> categories=new ArrayList<String>();
						String brand=brandNameValue.getText().trim();
						String description=descriptionArea.getText().trim();
						GUIController.getInstance().clearPreviousPanels();
						GUIController.getInstance().goPanelBack();
						String temp="";
						for(int i=0;i<categoryValue.length();i++) {
							if(categoryValue.charAt(i)=='/') {
								categories.add(temp);
								temp="";
							}
							else {
								temp+=categoryValue.charAt(i);
							}
						}
						if(name.equals("")) {
							nameErrorLabel.setText("Empty product name!");
							nameErrorLabel.setVisible(true);
							return;
						}
						else {
							nameErrorLabel.setVisible(false);
						}
						if(brand.equals("")) {
							brandErrorLabel.setText("Empty brand name!");
							brandErrorLabel.setVisible(true);
							return;
						}
						else {
							brandErrorLabel.setVisible(false);
						}
						if(categories.size()==0) {
							categoryErrorLabel.setText("Empty categories");
							categoryErrorLabel.setVisible(true);
							return;
						}
						else {
							categoryErrorLabel.setVisible(false);
						}
						if(description.equals("")) {
							descriptionErrorLabel.setText("Empty Description!");
							descriptionErrorLabel.setVisible(true);
							return;
						}
						else {
							descriptionErrorLabel.setVisible(false);
						}
						Product x=new Product();
						x.setName(name);
						x.setBrand(brand);
						x.setCategory(categories);
						x.setColor(colorValue.getText().trim());
						x.setDescription(description);
						Product resultX=DatabaseController.getInstance().addProductToSystem(x);
						if(resultX.getName().equals("")) {
							nameErrorLabel.setText("Already Exists");
							nameErrorLabel.setVisible(true);
							return;
						}
						else {
							nameErrorLabel.setVisible(false);
						}
						if(resultX.getBrand().equals("")) {
							brandErrorLabel.setText("Already Exists");
							brandErrorLabel.setVisible(true);
							return;
						}
						else {
							brandErrorLabel.setVisible(false);
						}
						if(resultX.getCategory().size()!=x.getCategory().size()) {
							String error="";
							for(int i=0;i<x.getCategory().size();i++) {
								if(!resultX.getCategory().contains(x.getCategory().get(i))) {
									error+=x.getCategory().get(i)+" , ";
								}
							}
							categoryErrorLabel.setText(error+" not found!");
							categoryErrorLabel.setVisible(true);
							return;
						}
						else {
							nameErrorLabel.setVisible(false);
						}
					}
				});
		}
		else {
			JButton btnNewButton = new JButton("Suggest Product");
			btnNewButton.setBounds(192, 266, 100, 25);
			add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						String name=productNameValue.getText().trim();
						String categoryValue=CategoriesArea.getText().trim();
						ArrayList<String> categories=new ArrayList<String>();
						String brand=brandNameValue.getText().trim();
						String description=descriptionArea.getText().trim();
						GUIController.getInstance().clearPreviousPanels();
						GUIController.getInstance().goPanelBack();
						String temp="";
						for(int i=0;i<categoryValue.length();i++) {
							if(categoryValue.charAt(i)=='/') {
								categories.add(temp);
								temp="";
							}
							else {
								temp+=categoryValue.charAt(i);
							}
						}
						if(name.equals("")) {
							nameErrorLabel.setText("Empty product name!");
							nameErrorLabel.setVisible(true);
							return;
						}
						else {
							nameErrorLabel.setVisible(false);
						}
						if(brand.equals("")) {
							brandErrorLabel.setText("Empty brand name!");
							brandErrorLabel.setVisible(true);
							return;
						}
						else {
							brandErrorLabel.setVisible(false);
						}
						if(categories.size()==0) {
							categoryErrorLabel.setText("Empty categories");
							categoryErrorLabel.setVisible(true);
							return;
						}
						else {
							categoryErrorLabel.setVisible(false);
						}
						if(description.equals("")) {
							descriptionErrorLabel.setText("Empty Description!");
							descriptionErrorLabel.setVisible(true);
							return;
						}
						else {
							descriptionErrorLabel.setVisible(false);
						}
						Product x=new Product();
						x.setName(name);
						x.setBrand(brand);
						x.setCategory(categories);
						x.setColor(colorValue.getText().trim());
						x.setDescription(description);
						Product resultX=DatabaseController.getInstance().addProductToSuggested(x);
						if(resultX.getName().equals("")) {
							nameErrorLabel.setText("Already Exists");
							nameErrorLabel.setVisible(true);
							return;
						}
						else {
							nameErrorLabel.setVisible(false);
						}
						if(resultX.getBrand().equals("")) {
							brandErrorLabel.setText("Already Exists");
							brandErrorLabel.setVisible(true);
							return;
						}
						else {
							brandErrorLabel.setVisible(false);
						}
						if(resultX.getCategory().size()!=x.getCategory().size()) {
							String error="";
							for(int i=0;i<x.getCategory().size();i++) {
								if(!resultX.getCategory().contains(x.getCategory().get(i))) {
									error+=x.getCategory().get(i)+" , ";
								}
							}
							categoryErrorLabel.setText(error+" not found!");
							categoryErrorLabel.setVisible(true);
							return;
						}
						else {
							nameErrorLabel.setVisible(false);
						}
					}
				});
		}

	}
}
