import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

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
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Lists {
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

	// text fields
	private JTextField playerName;
	private JTextField playerNum;
	private JTextField playerPosition;
	private JTextField playerAvgPts;
	private JTextField playerAvgRbnds;
	private JTextField playerAvgAssists;

	// declare array
	private ArrayList<Player> list;

	// declare iterator
	private ListIterator<Player> lit;

	public static void main(String[] args) {
		Lists listGUI = new Lists();
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

		// player name

		nameLabel = new JLabel("Player Name:  ");
		nameLabel
				.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 14));
		contentPane.add(nameLabel);
		playerName = new JTextField();
		playerName.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		playerName.setForeground(Color.BLUE);
		contentPane.add(playerName);

		// player number

		numLabel = new JLabel("Player Number:  ");
		numLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC, 14));
		contentPane.add(numLabel);
		playerNum = new JTextField();
		playerNum.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		playerNum.setForeground(Color.BLUE);
		contentPane.add(playerNum);

		// player position

		positionLabel = new JLabel("Position:  ");
		positionLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC,
				14));
		contentPane.add(positionLabel);
		playerPosition = new JTextField();
		playerPosition.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		playerPosition.setForeground(Color.BLUE);
		contentPane.add(playerPosition);

		// average points

		avgPtsLabel = new JLabel("Average Points Per Game:  ");
		avgPtsLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC,
				14));
		contentPane.add(avgPtsLabel);
		playerAvgPts = new JTextField();
		playerAvgPts.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		playerAvgPts.setForeground(Color.BLUE);
		contentPane.add(playerAvgPts);

		// average rebounds

		avgRbndsLabel = new JLabel("Average Rebounds Per Game:  ");
		avgRbndsLabel.setFont(new Font("Trebuchet MS", Font.BOLD + Font.ITALIC,
				14));
		contentPane.add(avgRbndsLabel);
		playerAvgRbnds = new JTextField();
		playerAvgRbnds.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		playerAvgRbnds.setForeground(Color.BLUE);
		contentPane.add(playerAvgRbnds);

		// average assists

		avgAssistsLabel = new JLabel("Average Assists Per Game:  ");
		avgAssistsLabel.setFont(new Font("Trebuchet MS", Font.BOLD
				+ Font.ITALIC, 14));
		contentPane.add(avgAssistsLabel);
		playerAvgAssists = new JTextField();
		playerAvgAssists.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		playerAvgAssists.setForeground(Color.BLUE);
		contentPane.add(playerAvgAssists);

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

			list = new ArrayList<Player>();
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
					list.add(new Player(name, nbr, position, avgPoints,
							avgRebounds, avgAssists, avgMins));

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

			lit = list.listIterator();
			if (lit.hasNext()) {
				Player p = lit.next();
				getPlayer(p);
			}
		}

		private void getPlayer(Player p) {
			playerName.setText(p.getName());
			playerNum.setText("" + p.getNum());
			playerPosition.setText("" + p.getPosition());
			playerAvgPts.setText("" + p.getAvgPoints());
			playerAvgRbnds.setText("" + p.getAvgRebounds());
			playerAvgAssists.setText("" + p.getAvgAssists());

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
			JOptionPane.showMessageDialog(frame,
					"The Next menu item was selected", "Next Menu Item",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private class PrevMenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			JOptionPane.showMessageDialog(frame,
					"The Previous menu item was selected",
					"Previous Menu Item", JOptionPane.INFORMATION_MESSAGE);
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
}
