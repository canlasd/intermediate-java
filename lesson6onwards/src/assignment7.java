import java.awt.Container;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class assignment7 {
	private JFrame frame;

	public static void main(String[] args) {
		assignment7 gui = new assignment7();
		gui.start();
	}

	public void start() {
		frame = new JFrame("GUI Menus");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		makeMenus();

		frame.setSize(300, 300);
		frame.setVisible(true);
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

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(new openListener());
		menuItem.setDisplayedMnemonicIndex(0);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				Event.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new saveListener());
		menuItem.setDisplayedMnemonicIndex(0);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				Event.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem("Save As");
		menuItem.addActionListener(new saveasListener());
		menuItem.setDisplayedMnemonicIndex(5);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				Event.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(new exitListener());
		menuItem.setDisplayedMnemonicIndex(1);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				Event.CTRL_MASK));
		menu.add(menuItem);

		// setup edit menu
		menu = new JMenu("Edit");
		menuBar.add(menu);
		menu.setMnemonic(KeyEvent.VK_E);

		// add items to edit menu
		menuItem = new JMenuItem("Select");
		menuItem.addActionListener(new selectListener());
		menuItem.setDisplayedMnemonicIndex(3);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
				Event.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem("Replace");
		menuItem.addActionListener(new replaceListener());
		menuItem.setDisplayedMnemonicIndex(3);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				Event.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(new cutListener());
		menuItem.setDisplayedMnemonicIndex(2);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
				Event.CTRL_MASK));
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(new pasteListener());
		menuItem.setDisplayedMnemonicIndex(0);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
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

	private class openListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "File - Open menu clicked",
					"Open Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class saveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "File - Save menu clicked",
					"Save Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class saveasListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "File - Save As menu clicked",
					"Save As Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class selectListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Edit - Select menu clicked",
					"Select Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class replaceListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Edit - Replace menu clicked",
					"Replace Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class cutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Edit - Cut menu clicked",
					"Cut Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class pasteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Edit - Paste menu clicked",
					"Select Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class aboutListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "Help - About menu clicked",
					"About Menu Clicked", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private class exitListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}
	}

}
