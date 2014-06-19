import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class lesson9 {
	private JFrame frame;
	private JPanel contentPane;
	// radio buttons and button group
	private JRadioButton regularCrustButton;
	private JRadioButton thinCrustButton;
	private JRadioButton handCrustButton;
	private JRadioButton deepCrustButton;
	private ButtonGroup crustButtonGroup;

	// checkboxes

	private JCheckBox pepperoniBox;
	private JCheckBox sausageBox;
	private JCheckBox cheeseBox;
	private JCheckBox pepperBox;
	private JCheckBox onionBox;
	private JCheckBox mushroomBox;
	private JCheckBox oliveBox;
	private JCheckBox anchovyBox;

	// text fields

	private JTextField breadSticksText;
	private JTextField buffaloWingsText;
	private JTextField nameText;
	private JTextField addressText;
	private JTextField cityText;

	public static void main(String[] args) {
		lesson9 gui = new lesson9();
		gui.start();
	}

	public void start() {
		frame = new JFrame("GUI Pizza");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeContent();
		makeNorthRegion();
		makeWestRegion();
		makeCenterRegion();
		makeEastRegion();
		makeMenus();
		makeSouthRegion();

		frame.pack();
		frame.setVisible(true);
	}

	private void makeSouthRegion() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Deliver To:  "));

		// create subpanels

		JPanel smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));

		// put labels on sub panels

		smallPanel.add(new JLabel("Name:  "));
		smallPanel.add(new JLabel("Address:  "));
		smallPanel.add(new JLabel("City, Street, Zip:  "));
		smallPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

		// add subpanel to main panel

		panel.add(smallPanel);

		// add main panel to container and position it south

		contentPane.add(panel, BorderLayout.SOUTH);

		// add second subpanel

		smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.Y_AXIS));
		nameText = new JTextField();
		addressText = new JTextField();
		cityText = new JTextField();
		smallPanel.add(nameText);
		smallPanel.add(addressText);
		smallPanel.add(cityText);

		panel.add(smallPanel);

		// add border to textfields
		smallPanel.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));

	}

	private void makeEastRegion() {
		// set up side orders with quantities in EAST

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory
				.createTitledBorder("Sides (Enter Quantity)"));
		panel.setPreferredSize(new Dimension(150, 0));

		// create another panel with its own layout

		JPanel smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));

		// create new text field

		breadSticksText = new JTextField("", 2);
		breadSticksText.setMaximumSize(new Dimension(20, 24));
		smallPanel.add(breadSticksText);
		smallPanel.add(new JLabel("Bread Sticks"));
		smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(smallPanel);

		smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));
		buffaloWingsText = new JTextField("", 2);
		buffaloWingsText.setMaximumSize(new Dimension(20, 24));
		smallPanel.add(buffaloWingsText);
		smallPanel.add(new JLabel("Buffalo Wings"));
		smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(smallPanel);

		contentPane.add(panel, BorderLayout.EAST);

	}

	private void makeCenterRegion() {

		// create panel with borders
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Select Toppings"));

		// create buttons

		pepperoniBox = new JCheckBox("Pepperoni", false);
		panel.add(pepperoniBox);
		sausageBox = new JCheckBox("Sausage", false);
		panel.add(sausageBox);
		cheeseBox = new JCheckBox("Cheese", false);
		panel.add(cheeseBox);
		pepperBox = new JCheckBox("Pepper", false);
		panel.add(pepperBox);
		onionBox = new JCheckBox("Onion", false);
		panel.add(onionBox);
		mushroomBox = new JCheckBox("Mushroom", false);
		panel.add(mushroomBox);
		oliveBox = new JCheckBox("Olives", false);
		panel.add(oliveBox);
		anchovyBox = new JCheckBox("Anchovies", false);
		panel.add(anchovyBox);

		contentPane.add(panel, BorderLayout.CENTER);

	}

	private void makeWestRegion() {

		// create panel with borders
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Choose a Crust"));

		// create button groups
		crustButtonGroup = new ButtonGroup();

		// add buttons
		regularCrustButton = new JRadioButton("Regular Crust", true);
		crustButtonGroup.add(regularCrustButton);
		panel.add(regularCrustButton);

		thinCrustButton = new JRadioButton("Thin Crust", true);
		crustButtonGroup.add(thinCrustButton);
		panel.add(thinCrustButton);

		handCrustButton = new JRadioButton("Hand Tossed Crust", true);
		crustButtonGroup.add(handCrustButton);
		panel.add(handCrustButton);

		deepCrustButton = new JRadioButton("Deep-Dish Crust", true);
		crustButtonGroup.add(deepCrustButton);
		panel.add(deepCrustButton);

		contentPane.add(panel, BorderLayout.WEST);

	}

	private void makeNorthRegion() {

		// make sure to put the filename path when adding the icon
		JLabel imgLabel = new JLabel(new ImageIcon(
				"C:/Users/canlasd/Pictures/L08-06.jpg"), JLabel.CENTER);
		contentPane.add(imgLabel, BorderLayout.NORTH);
	}

	private void makeContent() {
		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(6, 6));

	}

	private void makeMenus() {
		JMenuBar menuBar;
		JMenu menu;
		JMenuItem menuItem;
		// add menu bar
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// setup file menu

		menu = new JMenu("File");
		menuBar.add(menu);
		menu.setMnemonic(KeyEvent.VK_F);

		// add items to file menu
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(new newListener());
		menuItem.setDisplayedMnemonicIndex(0);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				Event.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new saveListener());
		menuItem.setDisplayedMnemonicIndex(0);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				Event.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new exitListener());
		menuItem.setDisplayedMnemonicIndex(1);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				Event.CTRL_MASK));
		menu.add(menuItem);

		// setup help menu
		menu = new JMenu("Help");
		menuBar.add(menu);
		menu.setMnemonic(KeyEvent.VK_H);

		// add items to help menu
		menuItem = new JMenuItem("About");
		menuItem.addActionListener(new aboutListener());
		menuItem.setDisplayedMnemonicIndex(1);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,
				Event.CTRL_MASK));
		menu.add(menuItem);

	}

	private class newListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			regularCrustButton.setSelected(true);

			pepperoniBox.setSelected(false);
			sausageBox.setSelected(false);
			cheeseBox.setSelected(false);
			pepperBox.setSelected(false);
			onionBox.setSelected(false);
			mushroomBox.setSelected(false);
			oliveBox.setSelected(false);
			anchovyBox.setSelected(false);

			breadSticksText.setText("");
			buffaloWingsText.setText("");
			nameText.setText("");
			addressText.setText("");
			cityText.setText("");

		}

	}

	private class saveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String order = "Pizza Order\n" + "================\n" + "Crust: \n";

			if (regularCrustButton.isSelected()) {
				order += "         Regular\n";
			} else if (thinCrustButton.isSelected()) {
				order += "         Thin\n";
			} else if (deepCrustButton.isSelected()) {
				order += "         Deep-dish\n";
			} else if (handCrustButton.isSelected()) {
				order += "         Hand-Tossed\n";
			} else {
				JOptionPane.showMessageDialog(frame,
						"You must select a crust type!", "Crust Type Error",
						JOptionPane.ERROR_MESSAGE);
			}
			order += "Toppings:\n";
			if (pepperoniBox.isSelected()) {
				order += "     Pepperoni\n";
			}
			if (sausageBox.isSelected()) {
				order += "     Sausage\n";
			}
			if (cheeseBox.isSelected()) {
				order += "     Extra Cheese\n";
			}
			if (pepperBox.isSelected()) {
				order += "     Peppers\n";
			}
			if (onionBox.isSelected()) {
				order += "     Onions\n";
			}
			if (mushroomBox.isSelected()) {
				order += "     Mushrooms\n";
			}
			if (oliveBox.isSelected()) {
				order += "     Olives\n";
			}
			if (anchovyBox.isSelected()) {
				order += "     Anchovies\n";
			}

			int bs = 0;
			int bw = 0;
			try {
				if (!breadSticksText.getText().isEmpty()) {
					bs = Integer.parseInt(breadSticksText.getText());
				}
				if (!buffaloWingsText.getText().isEmpty()) {
					bw = Integer.parseInt(buffaloWingsText.getText());
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(frame,
						"Side order entries must be numeric,\n"
								+ "and must be whole numbers",
						"Side Order Error", JOptionPane.ERROR_MESSAGE);
			}
			if (bs > 0 || bw > 0) {
				order += "Sides:\n";
				if (bs > 0) {
					order += "     " + bs + " Bread Sticks\n";
				}
				if (bw > 0) {
					order += "     " + bw + " Buffalo Wings\n";
				}
			}

			if (nameText.getText().isEmpty() || addressText.getText().isEmpty()
					|| cityText.getText().isEmpty()) {
				JOptionPane.showMessageDialog(frame,
						"Address fields may not be empty.", "Address Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				order += "Deliver To:\n";
				order += "     " + nameText.getText() + "\n";
				order += "     " + addressText.getText() + "\n";
				order += "     " + cityText.getText() + "\n";
			}
			order += "\n***END OF ORDER ***\n";

			try {
				PrintStream oFile = new PrintStream("PizzaOrder.txt");
				oFile.print(order);
				oFile.close();
			} catch (IOException ioe) {
				System.out.println("\n*** I/O Error ***\n" + ioe);
			}
		}

	}

	private class aboutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane
					.showMessageDialog(
							frame,
							"GUI Pizza \n\n Version 1.0  \n Build B20080226-1746\n\n "
									+ "(c) Copyright Merril Hall 2008 \n\n All rights reserved\n\n "
									+ "Visit www.ed2go.com/"
									+ "  \nEducation To Go  \nIntermediate Java Course",
							"About GUI Pizza", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}
	}

}
