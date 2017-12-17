import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

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
		
		JButton showButton = new JButton("Show Statistics");
		showButton.setBounds(520, 27, 120, 23);
		add(showButton);
		showButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//TODO
				}
			});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 61, 500, 300);
		add(scrollPane_1);
		
		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(520, 61, 120, 300);
		add(scrollPane);
		
		JList storeList = new JList();
		scrollPane.setViewportView(storeList);
	}
}
