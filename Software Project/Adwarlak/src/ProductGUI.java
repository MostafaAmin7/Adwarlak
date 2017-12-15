import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.JButton;

public class ProductGUI extends JPanel{
	//ENTRY constructor
	public ProductGUI(Product productToShow) {
		//TODO real
//		toShow=productToShow;
		//for the test
		toShow = new Product();
		Brand tempB= new Brand();
		tempB.setName("7amada");
		toShow.setBrand(tempB);
		toShow.setDescription("GoodGoodGoodGoodGoodGood\nGoodGoodGoodGoodGoodGood\nGoodGoodGoodGoodGoodGood\nGoodGoodGoodGoodGoodGood\n");
		toShow.setName("7AMADA");
		toShow.setPrice(22);
		setup();
	}
	
	//ENTRY Attributes
	private Product toShow;
	
	//ENTRY Functions
	public void setup(){
		setLayout(new MigLayout("", "[][][][][][][][][][][][]", "[][][][][][][][][][]"));
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		add(lblAdwarlak, "cell 5 0");
		
		JButton backButton = new JButton("Back");
		add(backButton, "cell 1 1 2 1");
		
		JLabel productNameLabel = new JLabel("ProductName");
		productNameLabel.setMaximumSize(new Dimension(4654849, 8484614));
		productNameLabel.setFocusable(false);
		add(productNameLabel, "cell 1 3");
		
		JLabel productNameValueLabel = new JLabel("");
		add(productNameValueLabel, "cell 3 3");
		
		JLabel brandLabel = new JLabel("Brand");
		add(brandLabel, "cell 1 4");
		
		JLabel brandValueLabel = new JLabel("");
		add(brandValueLabel, "cell 3 4");
		
		JLabel categoriesLabel = new JLabel("Categories");
		add(categoriesLabel, "cell 1 5");
		
		JLabel categoriesValueLabel = new JLabel("");
		add(categoriesValueLabel, "cell 3 5,alignx right,aligny top");
		
		JLabel descriptionLabel = new JLabel("Description");
		add(descriptionLabel, "cell 1 6");
		
		JLabel descriptionValueLabel = new JLabel("");
		add(descriptionValueLabel, "cell 3 6");
		
		JLabel priceLabel = new JLabel("Price");
		add(priceLabel, "cell 1 9");
		
		JLabel priceValueLabel = new JLabel("");
		add(priceValueLabel, "cell 3 9");
	}
}
