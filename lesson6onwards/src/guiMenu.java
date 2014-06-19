import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class guiMenu implements ActionListener {
	private JFrame frame;

	public static void main(String[] args) {
		guiMenu gui = new guiMenu();
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

		// add items to file menu
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save As");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("New")) {
			newMethod();
		} else if (e.getActionCommand().equals("Open")) {
			openMethod();
		} else if (e.getActionCommand().equals("Save")) {
			saveMethod();
		} else if (e.getActionCommand().equals("Save As")) {
			saveasMethod();
		} else if (e.getActionCommand().equals("Exit")) {
			exitMethod();
		}

	}

	private void exitMethod() {
		System.exit(0);

	}

	private void saveasMethod() {
		JOptionPane.showMessageDialog(frame,
				"The File > Save As option was clicked Open Item Clicked",
				"Save as item clicked", JOptionPane.INFORMATION_MESSAGE);

	}

	private void saveMethod() {
		JOptionPane.showMessageDialog(frame,
				"The File > Save option was clicked Open Item Clicked",
				"Save item clicked", JOptionPane.INFORMATION_MESSAGE);

	}

	private void openMethod() {
		JOptionPane.showMessageDialog(frame,
				"The File > Open option was clicked", "Open Item Clicked",
				JOptionPane.INFORMATION_MESSAGE);

	}

	private void newMethod() {
		JOptionPane.showMessageDialog(frame,
				"The File >New menu option was clicked", "Menu Item Clicked",
				JOptionPane.INFORMATION_MESSAGE);

	}
}
