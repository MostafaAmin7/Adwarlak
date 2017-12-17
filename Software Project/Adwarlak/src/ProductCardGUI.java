import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ProductCardGUI extends JPanel{
	//ENTRY Constructor
	public ProductCardGUI(Product p,boolean isStatistic) {
		toShow=p;
		setup(isStatistic);
	}
	
	private Product toShow;
	private JTextField productNameValue;
	private JTextField brandNameValue;
	private JTextField categoriesValue;
	private JTextField storeNameValue;
	private JTextField priceValue;
	
	public void setup(boolean isStatistic) {
		setLayout(null);
		
		JLabel productNameLabel = new JLabel("Product Name");
		productNameLabel.setBounds(10, 11, 92, 14);
		add(productNameLabel);
		
		JLabel brandNameLabel = new JLabel("Brand Name");
		brandNameLabel.setBounds(10, 36, 92, 14);
		add(brandNameLabel);
		
		JLabel categoriesLabel = new JLabel("Categories");
		categoriesLabel.setBounds(10, 61, 92, 14);
		add(categoriesLabel);
		
		JLabel storeLabel = new JLabel("Store");
		storeLabel.setBounds(236, 11, 46, 14);
		add(storeLabel);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(236, 36, 46, 14);
		add(priceLabel);
		
		productNameValue = new JTextField(toShow.getName());
		productNameValue.setEditable(false);
		productNameValue.setBounds(94, 8, 86, 20);
		add(productNameValue);
		productNameValue.setColumns(10);
		
		brandNameValue = new JTextField(toShow.getBrand());
		brandNameValue.setEditable(false);
		brandNameValue.setBounds(94, 36, 86, 20);
		add(brandNameValue);
		brandNameValue.setColumns(10);
		
		String categories = "";
		for(int i=0;i<toShow.getCategory().size();i++) {
			categories+= toShow.getCategory().get(i)+", ";
		}
		categoriesValue = new JTextField(categories);
		categoriesValue.setEditable(false);
		categoriesValue.setBounds(94, 61, 86, 20);
		add(categoriesValue);
		categoriesValue.setColumns(10);
		
		storeNameValue = new JTextField(toShow.getStore());
		storeNameValue.setEditable(false);
		storeNameValue.setBounds(272, 8, 86, 20);
		add(storeNameValue);
		storeNameValue.setColumns(10);
		
		priceValue = new JTextField(toShow.getPrice().toString());
		priceValue.setEditable(false);
		priceValue.setBounds(272, 33, 86, 20);
		add(priceValue);
		priceValue.setColumns(10);
		if(!isStatistic) {
			JButton showProductButton = new JButton("ShowProduct");
			showProductButton.setBounds(365, 66, 125, 23);
			add(showProductButton);
			showProductButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						GUIController.getInstance().swapPanelWith(new ProductGUI(toShow));
					}
				});
		}
		else {
			JLabel lblOfViews = new JLabel("# of Views");
			lblOfViews.setBounds(236, 61, 63, 14);
			add(lblOfViews);
			
			JLabel lblOfViewsValue = new JLabel(toShow.getNumberOfViews().toString());
			lblOfViewsValue.setBounds(309, 61, 46, 14);
			add(lblOfViewsValue);
		}
	}
}
