import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.crypto.Data;
import javax.swing.ListSelectionModel;

public class StatisticsGUI extends JPanel{
	//ENTRY
	public StatisticsGUI() {
		setup();
	}
	private ArrayList<Product> toShow;
	
	//ENTRY
	public void setup() {
		setLayout(null);
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(274, 11, 62, 14);
		add(lblAdwarlak);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(10, 27, 89, 23);
		add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().goPanelBack();
			}
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 61, 500, 300);
		add(scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(520, 86, 120, 275);
		add(scrollPane);
		
		DefaultListModel<String> list = new DefaultListModel<>();
		ArrayList<String> stores=DatabaseController.getInstance().getStores();
		for(int i=0;i<stores.size();i++) {
			list.addElement(stores.get(i));
		}
		
		JList<String> storeList = new JList<>(list);
		storeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(storeList);
		
		String selected= "";
		storeList.addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e)
		    {
		        if(!e.getValueIsAdjusting()) {
		            selected = storeList.getSelectedValue();
		        }
		    }
		});    
		
		JLabel lblSelectStore = new JLabel("Select Store");
		lblSelectStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectStore.setBounds(520, 61, 120, 14);
		add(lblSelectStore);
		

		JButton showButton = new JButton("Show Statistics");
		showButton.setBounds(520, 27, 120, 23);
		add(showButton);
		showButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Store x = DatabaseController.getInstance().getStore(selected);
					ArrayList<ProductCardGUI> productCards = new ArrayList<ProductCardGUI>();
					for(int i=0;i<x.getToSell().size();i++) {
						ProductCardGUI temp=new ProductCardGUI(x.getToSell().get(i), true);
						productCards.add(temp);
						panel.add(productCards.get(i));
					}
				}
			});
	}
}
