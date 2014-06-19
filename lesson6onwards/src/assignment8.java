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

public class assignment8 {
	private JFrame frame;
	private JPanel contentPane;
	// radio buttons and button group
	private JRadioButton mallardDuck;
	private JRadioButton pekinDuck;
	private JRadioButton dutchDuck;
	private JRadioButton saxonyDuck;
	private ButtonGroup typeDuck;

	// text fields

	private JTextField longWings;
	private JTextField nofeathersText;
	private JTextField nameText;
	private JTextField addressText;

	// checkboxes

	private JCheckBox quackLoud;
	private JCheckBox hasDucklings;
	private JCheckBox laysEggs;
	private JCheckBox fliesFast;

	public static void main(String[] args) {
		assignment8 gui = new assignment8();
		gui.start();
	}

	public void start() {
		frame = new JFrame("Assignment 8");
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

	private void makeCenterRegion() {

		// create panel with borders
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Select Options"));

		// create buttons

		fliesFast = new JCheckBox("Flies Fast", false);
		panel.add(fliesFast);
		hasDucklings = new JCheckBox("Has Ducklings", false);
		panel.add(hasDucklings);
		laysEggs = new JCheckBox("Lays Eggs", false);
		panel.add(laysEggs);
		quackLoud = new JCheckBox("Quacks Loud", false);
		panel.add(quackLoud);

		contentPane.add(panel, BorderLayout.CENTER);

	}

	private void makeEastRegion() {
		// set up side orders with quantities in EAST

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Specify Quantity"));
		panel.setPreferredSize(new Dimension(150, 0));

		// create another panel with its own layout

		JPanel smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));

		// create new text field

		nofeathersText = new JTextField("", 2);
		nofeathersText.setMaximumSize(new Dimension(20, 24));
		smallPanel.add(nofeathersText);
		smallPanel.add(new JLabel("Feathers"));
		smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(smallPanel);

		smallPanel = new JPanel();
		smallPanel.setLayout(new BoxLayout(smallPanel, BoxLayout.X_AXIS));
		longWings = new JTextField("", 2);
		longWings.setMaximumSize(new Dimension(20, 24));
		smallPanel.add(longWings);
		smallPanel.add(new JLabel("Long Wings"));
		smallPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(smallPanel);

		contentPane.add(panel, BorderLayout.EAST);

	}

	private void makeWestRegion() {

		// create panel with borders
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createTitledBorder("Choose a Duck"));

		// create button groups
		typeDuck = new ButtonGroup();

		// add buttons
		mallardDuck = new JRadioButton("Mallard Duck", true);
		typeDuck.add(mallardDuck);
		panel.add(mallardDuck);

		dutchDuck = new JRadioButton("Dutch Duck", true);
		typeDuck.add(dutchDuck);
		panel.add(dutchDuck);

		pekinDuck = new JRadioButton("Pekin Duck", true);
		typeDuck.add(pekinDuck);
		panel.add(pekinDuck);

		saxonyDuck = new JRadioButton("Saxony Duck", true);
		typeDuck.add(saxonyDuck);
		panel.add(saxonyDuck);

		contentPane.add(panel, BorderLayout.WEST);

	}

	private void makeNorthRegion() {

		// make sure to put the filename path when adding the icon
		JLabel imgLabel = new JLabel(new ImageIcon(
				"C:/Users/canlasd/Pictures/duck.jpg"), JLabel.CENTER);
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
			mallardDuck.setSelected(true);

			hasDucklings.setSelected(false);
			laysEggs.setSelected(false);
			fliesFast.setSelected(false);
			quackLoud.setSelected(false);

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
							"Assignment 8 \n\n Version 1.0  \n Build B20080226-1746\n\n "
									+ "(c) David Canlas 2014 \n\n All rights reserved\n\n "
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
