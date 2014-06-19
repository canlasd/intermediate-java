import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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

public class lesson8 {
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

	public static void main(String[] args) {
		lesson8 gui = new lesson8();
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

		frame.pack();
		frame.setVisible(true);
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
			JOptionPane.showMessageDialog(frame, "File - New menu clicked",
					"New Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class saveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "File - Save menu clicked",
					"Save Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
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
