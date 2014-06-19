import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

public class Lesson12 {
	// window frame
	private JFrame frame;
	private JPanel contentPane;

	// labels
	private JLabel nameLabel;
	private JLabel numLabel;
	private JLabel positionLabel;
	private JLabel avgPtsLabel;
	private JLabel avgRbndsLabel;
	private JLabel avgAssistsLabel;
	private JLabel avgMinsLabel;

	// text fields
	private JTextField playerName;
	private JTextField playerNum;
	private JTextField playerPosition;
	private JTextField playerAvgPts;
	private JTextField playerAvgRbnds;
	private JTextField playerAvgAssists;
	private JTextField playerAvgMins;

	private JTextArea textArea;
	private JScrollPane scrollArea;

	// declare map
	private TreeMap<Integer, Player> map;

	// declare iterator
	private ListIterator<Player> lit;
	public Object Player;

	public static void main(String[] args) {
		Lesson12 listGUI = new Lesson12();
		listGUI.start();
	}

	public void start() {
		frame = new JFrame("Lists");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

		makeMenus();
		makeContent();

		frame.pack();
		frame.setVisible(true);
	}

	private void makeMenus() {
		JMenuBar menuBar;

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// set up menus
		menuBar.add(makeFileMenu());
		menuBar.add(makeViewMenu());
		menuBar.add(makeHelpMenu());
	}

	private JMenu makeFileMenu() {
		JMenu menu;
		JMenuItem menuItem;

		// set up the File menu
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		// add Open menu item
		menuItem = new JMenuItem("Open...");
		menuItem.setMnemonic(KeyEvent.VK_O);
		menuItem.addActionListener(new OpenMenuItemListener());
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				Event.CTRL_MASK));
		menu.add(menuItem);

		// add Exit menu item
		menu.addSeparator();
		menuItem = new JMenuItem("Exit");
		menuItem.setMnemonic(KeyEvent.VK_X);
		menuItem.addActionListener(new ExitMenuItemListener());
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				Event.CTRL_MASK));
		menu.add(menuItem);

		return menu;
	}

	private JMenu makeViewMenu() {
		JMenu menu;
		JMenuItem menuItem;

		// set up the View menu
		menu = new JMenu("View");
		menu.setMnemonic(KeyEvent.VK_V);

		// add Next Player menu item
		menuItem = new JMenuItem("Next Player");
		menuItem.addActionListener(new NextMenuItemListener());
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,
				Event.ALT_MASK));
		menu.add(menuItem);

		// add Previous Player menu item
		menuItem = new JMenuItem("Previous Player");
		menuItem.addActionListener(new PrevMenuItemListener());
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_UP,
				Event.ALT_MASK));
		menu.add(menuItem);

		// add Team View
		menu.addSeparator();
		menuItem = new JMenuItem("Team View");
		menuItem.addActionListener(new TeamMenuItemListener());
		menu.add(menuItem);

		// add Player View
		menuItem = new JMenuItem("Player View");
		menuItem.addActionListener(new PlayMenuItemListener());
		menu.add(menuItem);

		// add Search View
		menuItem = new JMenuItem("Search By Number");
		menuItem.addActionListener(new SearchMenuItemListener());
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				Event.ALT_MASK));
		menu.add(menuItem);

		return menu;
	}

	private JMenu makeHelpMenu() {
		JMenu menu;
		JMenuItem menuItem;

		// set up the Help menu
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);

		// add About menu item
		menuItem = new JMenuItem("About Lists");
		menuItem.setMnemonic(KeyEvent.VK_A);
		menuItem.addActionListener(new AboutMenuItemListener());
		menu.add(menuItem);

		return menu;
	}

	private void makeContent() {

		// create tab object

		JTabbedPane tabby = new JTabbedPane();

		// create the panel for the tab
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

		// add contents to the panel

		nameLabel = new JLabel("Player Name:  ");
		nameLabel
				.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 14));
		panel.add(nameLabel);
		playerName = new JTextField();
		playerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel.add(playerName);

		numLabel = new JLabel("Player Number:  ");
		numLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 14));
		panel.add(numLabel);
		playerNum = new JTextField();
		playerNum.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel.add(playerNum);

		positionLabel = new JLabel("Player Position:  ");
		positionLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC,
				14));
		panel.add(positionLabel);
		playerPosition = new JTextField();
		playerPosition.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel.add(playerPosition);

		avgPtsLabel = new JLabel("Average Points:  ");
		avgPtsLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC,
				14));
		panel.add(avgPtsLabel);
		playerAvgPts = new JTextField();
		playerAvgPts.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel.add(playerAvgPts);

		avgRbndsLabel = new JLabel("Average Rebounds:  ");
		avgRbndsLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC,
				14));
		panel.add(avgRbndsLabel);
		playerAvgRbnds = new JTextField();
		playerAvgRbnds.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel.add(playerAvgRbnds);

		avgAssistsLabel = new JLabel("Average Assists:  ");
		avgAssistsLabel.setFont(new Font("Trebuchet MS", Font.BOLD
				+ Font.ITALIC, 14));
		panel.add(avgAssistsLabel);
		playerAvgAssists = new JTextField();
		playerAvgAssists.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel.add(playerAvgAssists);

		avgMinsLabel = new JLabel("Average Minutes Played:  ");
		avgMinsLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC,
				14));
		panel.add(avgMinsLabel);
		playerAvgMins = new JTextField();
		playerAvgMins.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		panel.add(playerAvgMins);

		// add tab to panel

		tabby.addTab("Player View", panel);
		tabby.setMnemonicAt(0, KeyEvent.VK_P);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

		textArea = new JTextArea(15, 25);
		scrollArea = new JScrollPane(textArea);
		scrollArea
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollArea
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollArea);

		tabby.addTab("Team View", panel);
		tabby.setMnemonicAt(1, KeyEvent.VK_T);

		contentPane.add(tabby);

	}

	private class AboutMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane
					.showMessageDialog(
							frame,
							"Lists\n\nVersion 1.0\nBuild B200803275-1720\n\n"
									+ "(c) Copyright Merrill Hall 2008\nAll rights reserved\n\n"
									+ "Visit /\nEducation To Go\n"
									+ "Intermediate Java Course",
							"About Lists", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class OpenMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {

			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(frame);
			File playerFile = fc.getSelectedFile();
			if (playerFile == null) {
				return;
			}

			// create map

			map = new TreeMap<Integer, Player>();

			try {
				Scanner scan = new Scanner(playerFile);
				while (scan.hasNext()) {

					String name = scan.next() + "" + scan.next();
					int nbr = scan.nextInt();
					char position = scan.next().charAt(0);
					double avgPoints = scan.nextDouble();
					double avgRebounds = scan.nextDouble();
					double avgAssists = scan.nextDouble();
					double avgMins = scan.nextDouble();
					map.put(new Integer(nbr), new Player(name, nbr, position,
							avgPoints, avgRebounds, avgAssists, avgMins));

				}
				scan.close();
			}

			catch (IOException e) {
				JOptionPane.showMessageDialog(frame,
						"IO Error in file \n\n    " + playerFile.getName()
								+ "\n\n This program will close", "IO Error",
						JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
			// populate the list
			for (Player p : map.values()) {
				textArea.setText(textArea.getText() + p.toString() + "\n\n");
			}
			{
				;
			}
			findPlayer();

		}
	}

	private void findPlayer() {
		boolean isGoodNumber = false;
		Integer playerNum = new Integer(0);
		while (!isGoodNumber) {
			try {
				playerNum = new Integer(Integer.parseInt(JOptionPane
						.showInputDialog(frame, "Enter a Player number:  ",
								"Player Entry", JOptionPane.QUESTION_MESSAGE)));
				isGoodNumber = true;
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(frame, "Invalid Number",
						"Player Number Error", JOptionPane.ERROR_MESSAGE);
			}
			if (isGoodNumber) {
				Player p = map.get(playerNum);
				if (p == null) {
					JOptionPane.showMessageDialog(frame, "Player number "
							+ playerNum.intValue() + "does not exist!",
							"Player Number Error", JOptionPane.ERROR_MESSAGE);
					isGoodNumber = false;
				} else {
					getPlayer(p);
				}
			}

		}

	}

	private class ExitMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	private class NextMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {

			if (map == null || map.size() == 0) {
				return;
			}

			Map.Entry<Integer, Player> entry = map.higherEntry(Integer
					.parseInt(playerNum.getText()));
			if (entry == null) {
				JOptionPane
						.showMessageDialog(
								frame,
								"There are no more players.\n You have reached the end of the list",
								"End of List", JOptionPane.WARNING_MESSAGE);
			} else {
				getPlayer(entry.getValue());
			}

		}
	}

	private class PrevMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {

			if (map == null || map.size() == 0) {
				return;
			}

			Map.Entry<Integer, Player> entry = map.lowerEntry(Integer
					.parseInt(playerNum.getText()));
			if (entry == null) {
				JOptionPane
						.showMessageDialog(
								frame,
								"There are no more players.\n You have reached the end of the list",
								"End of List", JOptionPane.WARNING_MESSAGE);
			} else {
				getPlayer(entry.getValue());
			}

		}
	}

	private class TeamMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			JOptionPane.showMessageDialog(frame,
					"The Team View menu item was selected",
					"Team View Menu Item", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class PlayMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			JOptionPane.showMessageDialog(frame,
					"The Player View menu item was selected",
					"Player View Menu Item", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class SearchMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {

			findPlayer();

		}

	}

	public void getPlayer(Player p) {
		playerName.setText(p.getName());
		playerNum.setText("" + p.getNum());
		playerPosition.setText(p.getPosition());
		playerAvgPts.setText("" + p.getAvgPoints());
		playerAvgRbnds.setText("" + p.getAvgRebounds());
		playerAvgAssists.setText("" + p.getAvgAssists());
		playerAvgMins.setText("" + p.getAvgMins());
	}

}
