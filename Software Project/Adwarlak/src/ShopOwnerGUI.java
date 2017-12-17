import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ShopOwnerGUI extends JPanel{
	//ENTRY constructors
	public ShopOwnerGUI(ShopOwner shopowner) {
		owner=shopowner;
		setup();
	}
	//ENTRY Attributes
	private ShopOwner owner;
	private JTextField storeName;
	private JTextField storeAddress;
	//ENTRY Functions
	public void setup() {
		setLayout(null);
		
		SearchGUI searchGUI = new SearchGUI(owner);
		searchGUI.setBounds(10, 139, 500, 350);
		add(searchGUI);
		
		DefaultListModel<String> list = new DefaultListModel<>();
		ArrayList<String> stores=DatabaseController.getInstance().getStores();
		for(int i=0;i<stores.size();i++) {
			list.addElement(stores.get(i));
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(270, 51, 140, 47);
		add(scrollPane);
		
		JList<String> storeList = new JList<>(list);
		scrollPane.setViewportView(storeList);
		String selected;
		storeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		storeList.addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e)
		    {
		        if(!e.getValueIsAdjusting()) {
		            selected = storeList.getSelectedValue();
		        }
		    }
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIController.getInstance().goPanelBack();
			}
		});
		btnBack.setBounds(10, 29, 89, 23);
		add(btnBack);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIController.getInstance().swapPanelWith(new GuestGUI());
			}
		});
		btnLogOut.setBounds(10, 71, 89, 23);
		add(btnLogOut);
		
		JButton btnSuggestProduct = new JButton("Suggest Product");
		btnSuggestProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIController.getInstance().swapPanelWith(new NewProductGUI(owner));
			}
		});
		btnSuggestProduct.setBounds(10, 105, 111, 23);
		add(btnSuggestProduct);
		

		JLabel nameError = new JLabel("");
		nameError.setForeground(Color.RED);
		nameError.setBounds(421, 51, 89, 14);
		add(nameError);
		
		JButton btnAddStore = new JButton("Add Store");
		btnAddStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=storeName.getText().trim();
				String address=storeAddress.getText().trim();
				if(name.equals("")) {
					nameError.setText("Empty");
					nameError.setVisible(true);
					return;
				}
				else {
					nameError.setVisible(false);
				}
				if(!DatabaseController.getInstance().addStore(owner.getName(),name,address)) {
					nameError.setText("Already Exists");
					nameError.setVisible(true);
					return;
				}
				nameError.setVisible(false);
			}
		});
		btnAddStore.setBounds(421, 105, 89, 23);
		add(btnAddStore);
		
		JButton btnShowStatistics = new JButton("Show Statistics");
		btnShowStatistics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIController.getInstance().swapPanelWith(new StatisticsGUI());
			}
		});
		
		btnShowStatistics.setBounds(131, 105, 129, 23);
		add(btnShowStatistics);
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(225, 15, 65, 14);
		add(lblAdwarlak);
		
		
		storeName = new JTextField();
		storeName.setBounds(421, 30, 89, 20);
		add(storeName);
		storeName.setColumns(10);
		
		storeAddress = new JTextField();
		storeAddress.setBounds(421, 75, 89, 20);
		add(storeAddress);
		storeAddress.setColumns(10);
		
		JButton addProductButton = new JButton("Add Product");
		addProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIController.getInstance().swapPanelWith(new AddingProductGUI(selected));
			}
		});
		addProductButton.setBounds(270, 105, 141, 23);
		add(addProductButton);
		
		JLabel lblSelectStore = new JLabel("Select Store");
		lblSelectStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectStore.setBounds(270, 33, 140, 14);
		add(lblSelectStore);
		
		
	}
}
