import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CustomerCardGUI extends JPanel{
	//ENTRY
	public CustomerCardGUI(Customer x) {
		toShow=x;
		setup();
	}
	
	private Customer toShow;
	private JTextField valueToAdd;
	private JTextField customerNameValue;
	private JTextField currentVCardValue;
	
	public void setup() {
		setLayout(null);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(244, 31, 140, 14);
		add(errorLabel);
		
		JButton addButton = new JButton("Add To VCard");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String value=valueToAdd.getText().trim();
				if(value=="") {
					errorLabel.setText("Empty!");
					errorLabel.setVisible(true);
					return;
				}
				else {
					errorLabel.setVisible(false);
				}
				int v=0;
				try {
					v=Integer.parseInt(value);
				} catch (Exception e) {
					errorLabel.setText("NaN ya 7ywan!");
					errorLabel.setVisible(true);
					return;
				}
				if(v<0) {
					errorLabel.setText("Negative?!!!");
					errorLabel.setVisible(true);
					return;
				}
				errorLabel.setVisible(false);
				toShow.setVoucherCard(toShow.getVoucherCard()+v);
				DatabaseController.getInstance().updateVCard(toShow);
			}
		});
		addButton.setBounds(244, 56, 146, 23);
		add(addButton);
		
		valueToAdd = new JTextField();
		valueToAdd.setBounds(244, 11, 146, 20);
		add(valueToAdd);
		valueToAdd.setColumns(10);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(27, 14, 89, 14);
		add(lblCustomerName);
		
		JLabel lblVoucherCardValue = new JLabel("Voucher Card Value");
		lblVoucherCardValue.setBounds(10, 60, 106, 14);
		add(lblVoucherCardValue);
		
		customerNameValue = new JTextField(toShow.getName());
		customerNameValue.setEditable(false);
		customerNameValue.setBounds(119, 11, 115, 20);
		add(customerNameValue);
		customerNameValue.setColumns(10);
		
		currentVCardValue = new JTextField(toShow.getVoucherCard().toString());
		currentVCardValue.setEditable(false);
		currentVCardValue.setBounds(119, 59, 115, 20);
		add(currentVCardValue);
		currentVCardValue.setColumns(10);
		
		
	}
}
