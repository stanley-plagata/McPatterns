/**
 * @author Stanley Plagata
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.text.DecimalFormat;

class McPatternsGUI extends JFrame {
	McPatternsPresenter presenter;
	
	public McPatternsGUI(McPatternsPresenter presenter) throws FileNotFoundException {
		this.presenter = presenter;
		presenter.attachView(this);
		showGUI();
	}
	
	private void showGUI() throws FileNotFoundException {
		ArrayList<MenuModel> menuItems = presenter.loadMenuItems();

		JFrame theFrame = new JFrame("Swing Example");
		theFrame.setResizable(true);
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setLayout(new BorderLayout());
		
		JPanel title = new JPanel(new FlowLayout());
		title.add(new JLabel("Welcome to McPatterns"));

		JPanel orderPane = new JPanel();
		orderPane.setLayout(new BoxLayout(orderPane, BoxLayout.PAGE_AXIS));
		JTextArea orderDetails = new JTextArea("Order:" + "\r\n");
		orderPane.setBorder(BorderFactory.createRaisedBevelBorder());
		orderPane.add(orderDetails);
		
		JLabel orderTotal = new JLabel("0.00");
		JTextField ccEntry = new JTextField("Enter CC #");

		JButton confirm = new JButton("Place Order");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((orderDetails.getText().equals("Order:" + "\r\n") || orderDetails.getText().equals("Order cancelled") || orderDetails.getText().substring(0, 15).equals("Order confirmed"))) {
					JOptionPane.showMessageDialog(theFrame, "No new order placed", "Error", JOptionPane.WARNING_MESSAGE);
				} else if (!CardValidator.validate(ccEntry.getText())) {
					JOptionPane.showMessageDialog(theFrame, "Invalid credit card number", "Error", JOptionPane.WARNING_MESSAGE);
				} else {
					CreditCard card = CardValidator.getCard();
					JOptionPane.showMessageDialog(theFrame, "Order has been placed with " + card.getCardType() + " - Total is " + orderTotal.getText(), "Order Placed", JOptionPane.INFORMATION_MESSAGE);
					String[] orderDetailsSplit = orderDetails.getText().replace("|", " - ").split(" - ");
					System.out.println(orderDetailsSplit[0]);
					orderDetails.setText("Order confirmed for " + ccEntry.getText());
					orderTotal.setText("0.00")
					ccEntry.setText("Enter CC #");
				}
			}
		});
		JButton cancel = new JButton("Cancel Order");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderDetails.setText("Order cancelled");
				orderTotal.setText("0.00");
			}
		});
		
		orderPane.add(orderTotal);
		orderPane.add(ccEntry);
		orderPane.add(confirm);
		orderPane.add(cancel);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 4));
		for (MenuModel item : menuItems) {
			JButton button = new JButton(item.getName() + " | " + item.getPrice());
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (orderDetails.getText().substring(0, 6).equals("Order ")) { // checks if it is an empty order
						orderDetails.setText("Order:" + "\r\n");
					}
					orderDetails.append(item.getName() + " | " + item.getPrice() + "\r\n");
					
					double oldTotal = (Double.parseDouble(orderTotal.getText()) * 100);
					double newTotal = (oldTotal + (item.getPrice() * 100)) / 100;
					DecimalFormat df = new DecimalFormat("#.00");
					orderTotal.setText("" + df.format(newTotal));
				}
			});
			buttonPanel.add(button);
		}
		
		theFrame.add(title,BorderLayout.NORTH);
		theFrame.add(buttonPanel, BorderLayout.CENTER);
		theFrame.add(orderPane, BorderLayout.EAST);
		
		theFrame.pack();
		theFrame.setSize(1300, 700);
		theFrame.setVisible(true);
	}
}
