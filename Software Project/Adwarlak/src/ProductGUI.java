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

public class ProductGUI extends JPanel{
	//ENTRY constructor
	public ProductGUI(Product productToShow) {
		instance=this;
		//TODO real
//		toShow=productToShow;
		//for the test
		toShow = new Product();
		Brand tempB= new Brand();
		tempB.setName("7amada");
		toShow.setCategory(new ArrayList<Category>());
		toShow.setBrand(tempB);
		toShow.setDescription("GoodGoodGoodGoodGoodGood\nGoodGoodGoodGoodGoodGood\nGoodGoodGoodGoodGoodGood\nGoodGoodGoodGoodGoodGood\n");
		toShow.setName("7AMADA");
		toShow.setPrice(22D);
		setup();
	}
	
	//ENTRY Attributes
	private ProductGUI instance;
	private Product toShow;
	
	//ENTRY Functions
	public void setup(){
		setLayout(new MigLayout("", "[][][][grow][][][][][][][][]", "[][][][][][][grow][][][]"));
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		add(lblAdwarlak, "cell 5 0");
		
		JButton backButton = new JButton("Back");
		add(backButton, "cell 1 1 2 1");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					GUIController.getInstance().goPanelBack(instance);
				}
			});
		
		JLabel productNameLabel = new JLabel("ProductName");
		productNameLabel.setMaximumSize(new Dimension(4654849, 8484614));
		productNameLabel.setFocusable(false);
		add(productNameLabel, "cell 1 3");
		
		JLabel productNameValueLabel = new JLabel(toShow.getName());
		add(productNameValueLabel, "cell 3 3");
		
		JLabel brandLabel = new JLabel("Brand");
		add(brandLabel, "cell 1 4");
		
		JLabel brandValueLabel = new JLabel(toShow.getBrand().getName());
		add(brandValueLabel, "cell 3 4");
		
		JLabel categoriesLabel = new JLabel("Categories");
		add(categoriesLabel, "cell 1 5");
		
		String categories="";
		for(int i=0;i<toShow.getCategory().size();i++) {
			categories += toShow.getCategory().get(i).getName()+", ";
		}
		JLabel categoriesValueLabel = new JLabel(categories);
		add(categoriesValueLabel, "cell 3 5,alignx right,aligny top");
		
		JLabel descriptionLabel = new JLabel("Description");
		add(descriptionLabel, "cell 1 6");
		
		JTextPane descriptionValue = new JTextPane();
		descriptionValue.setText(toShow.getDescription());
		add(descriptionValue, "cell 3 6,growy");
		
		JLabel priceLabel = new JLabel("Price");
		add(priceLabel, "cell 1 9");
		
		JLabel priceValueLabel = new JLabel(toShow.getPrice().toString());
		add(priceValueLabel, "cell 3 9");
	}
}
