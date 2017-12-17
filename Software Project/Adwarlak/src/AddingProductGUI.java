import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AddingProductGUI extends JPanel{
	public AddingProductGUI(String s) {
		setLayout(null);
		toSelectFrom=DatabaseController.getInstance().search("",new ArrayList<String>(),new ArrayList<String>(),-1,-1);
		
		
		JLabel lblAdwarlak = new JLabel("Adwarlak");
		lblAdwarlak.setBounds(179, 11, 80, 14);
		add(lblAdwarlak);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIController.getInstance().goPanelBack();
			}
		});
		btnBack.setBounds(10, 24, 89, 23);
		add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 50, 400, 200);
		add(scrollPane);
		
		DefaultListModel<String> listProducts = new DefaultListModel<>();
		for(int i=0;i<toSelectFrom.size();i++) {
			listProducts.addElement(toSelectFrom.get(i).getName());
		}
		
		JList<String> list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
		
		
		
//		list.addListSelectionListener(new ListSelectionListener() {
//		    @Override
//		    public void valueChanged(ListSelectionEvent e)
//		    {
//		        if(!e.getValueIsAdjusting()) {
//		            selected=list.getSelectedValue();
//		        }
//		    }
//		});
		
		JButton btnAddSelectedProduct = new JButton("Add Selected Product");
		btnAddSelectedProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex()!=-1) {
					DatabaseController.getInstance().addProductToStore(toSelectFrom.get(list.getSelectedIndex()));
				}
			}
		});
		btnAddSelectedProduct.setBounds(114, 266, 222, 23);
		add(btnAddSelectedProduct);
		
		store=s;
		setup();
	}
	String store;
	ArrayList<Product> toSelectFrom;
	public void setup() {
		
	}
}
