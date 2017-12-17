import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;

public class ProductGUI extends JPanel{
	//ENTRY constructor
	public ProductGUI(Product productToShow,User x) {
		toUse=x;
		toShow=productToShow;
		setup();
	}
	
	//ENTRY Attributes
	private User toUse;
	private Product toShow;
	private JTextField priceValue;
	private JTextField toAddValue;
	
	//ENTRY Functions
	public void setup(){
		setLayout(null);
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(194, 11, 44, 14);
		add(lblAdwarlak);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 11, 55, 23);
		add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().goPanelBack();
				}
			});
		
		JLabel productNameLabel = new JLabel("ProductName");
		productNameLabel.setBounds(10, 56, 64, 14);
		productNameLabel.setMaximumSize(new Dimension(4654849, 8484614));
		productNameLabel.setFocusable(false);
		add(productNameLabel);
		
		JLabel productNameValueLabel = new JLabel(toShow.getName());
		productNameValueLabel.setBounds(133, 56, 55, 14);
		add(productNameValueLabel);
		
		JLabel brandLabel = new JLabel("Brand");
		brandLabel.setBounds(10, 81, 28, 14);
		add(brandLabel);
		
		JLabel brandValueLabel = new JLabel(toShow.getBrand());
		brandValueLabel.setBounds(133, 81, 55, 14);
		add(brandValueLabel);
		
		JLabel categoriesLabel = new JLabel("Categories");
		categoriesLabel.setBounds(10, 106, 52, 14);
		add(categoriesLabel);
		
		String categories="";
		for(int i=0;i<toShow.getCategory().size();i++) {
			categories += toShow.getCategory().get(i)+", ";
		}
		JTextArea categoriesArea = new JTextArea(categories);
		categoriesArea.setBounds(133, 101, 61, 60);
		add(categoriesArea);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setBounds(10, 168, 53, 14);
		add(descriptionLabel);
		
		JTextPane descriptionValue = new JTextPane();
		descriptionValue.setBounds(133, 168, 61, 82);
		descriptionValue.setText(toShow.getDescription());
		add(descriptionValue);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(10, 261, 23, 14);
		add(priceLabel);
		
		JLabel priceValueLabel = new JLabel(toShow.getPrice().toString());
		priceValueLabel.setBounds(133, 261, 55, 14);
		add(priceValueLabel);
		
		if(toUse instanceof ShopOwner) {
			JLabel lblAvailable = new JLabel("Pieces available : ");
			lblAvailable.setBounds(290, 56, 120, 14);
			add(lblAvailable);
			
			priceValue = new JTextField();
			priceValue.setBounds(290, 78, 120, 20);
			add(priceValue);
			priceValue.setColumns(10);
			
			JLabel priceError = new JLabel("");
			priceError.setForeground(Color.RED);
			priceError.setBounds(290, 101, 120, 14);
			add(priceError);
			
			JButton updatePrice = new JButton("Update Price");
				updatePrice.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String price=priceValue.getText().trim();
						if(price.equals("")) {
							priceError.setText("Empty!");
							priceError.setVisible(true);
							return;
						}
						else {
							priceError.setVisible(false);
						}
						Double p=0D;
						try {
							p=Double.parseDouble(price);
						} catch (Exception e) {
							priceError.setText("NaN");
							priceError.setVisible(true);
							return;
						}
						priceError.setVisible(false);
						toShow.setPrice(p);
						DatabaseController.getInstance().updateProduct(toShow);
					}
				});
			updatePrice.setBounds(290, 114, 120, 23);
			add(updatePrice);
			
			toAddValue = new JTextField();
			toAddValue.setBounds(290, 165, 120, 20);
			add(toAddValue);
			toAddValue.setColumns(10);
			
			JButton addToStore = new JButton("Add To Store");
			JLabel toAddError = new JLabel("");
			toAddError.setBounds(290, 185, 120, 14);
			add(toAddError);
			addToStore.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String numberOfAdd = toAddValue.getText().trim();
					if(numberOfAdd.equals("")) {
						toAddError.setText("Empty");
						toAddError.setVisible(true);
						return;
					}
					else {
						toAddError.setVisible(false);
					}
					int num = 0;
					try {
						num = Integer.parseInt(numberOfAdd);
					}
					catch(Exception ex) {
						toAddError.setText("NaN");
						toAddError.setVisible(true);
						return;
					}
					
					toAddError.setVisible(false);
					toShow.setAvailable(toShow.getAvailable()+num);
					DatabaseController.getInstance().updateProduct(toShow);
				}
			});
			addToStore.setBounds(290, 210, 120, 23);
			add(addToStore);
			
			JLabel storeName = new JLabel("store name : " + toShow.getStore());
			storeName.setBounds(290, 261, 120, 14);
			add(storeName);
			
		
		
		
		}
		if(toUse instanceof Customer) {
			Customer x=(Customer)toUse;
			JLabel lblYourVcard = new JLabel("Your VCard : "+x.getVoucherCard().toString());
			lblYourVcard.setBounds(298, 52, 94, 23);
			add(lblYourVcard);
			
			JLabel lblYouDontHave = new JLabel("you don't have enough money");
			lblYouDontHave.setForeground(Color.RED);
			lblYouDontHave.setHorizontalAlignment(SwingConstants.CENTER);
			lblYouDontHave.setBounds(254, 106, 165, 14);
			
			JButton btnBuy = new JButton("Buy");
			btnBuy.setBounds(298, 77, 89, 23);
			add(btnBuy);
			btnBuy.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						if(x.getVoucherCard()<toShow.getPrice()) {
							lblYouDontHave.setVisible(true);
							return;
						}
						else {
							lblYouDontHave.setVisible(false);
						}
						x.setVoucherCard((int)(x.getVoucherCard()-toShow.getPrice()));
						DatabaseController.getInstance().submitBuy(x,toShow);
						GUIController.getInstance().goPanelBack();
						GUIController.getInstance().clearPreviousPanels();
					}
				});
			
			add(lblYouDontHave);
		}
		
	}
}
