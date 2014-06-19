import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class LayoutBorder implements ActionListener {
	private JFrame frame;
	private JButton button1, button2, button3, button4;
	private JPanel panel;
	private JTextArea textArea;
	private JLabel label;
	private JScrollPane scrollArea;
	private final int count = 0;

	public static void main(String[] args) {
		LayoutBorder guiLayout = new LayoutBorder();
		guiLayout.start();
	}

	public void start() {
		// set pane
		frame = new JFrame("Border and Box Layouts");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		// set label
		label = new JLabel("Click a button to see its text appear below");
		contentPane.add(label, BorderLayout.NORTH);

		// set panel

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		// set buttons

		button1 = new JButton("button1");
		panel.add(button1);
		button1.addActionListener(this);

		button2 = new JButton("button2");
		panel.add(button2);
		button2.addActionListener(this);

		button3 = new JButton("button3");
		panel.add(button3);
		button3.addActionListener(this);

		button4 = new JButton("button4");
		panel.add(button4);
		button4.addActionListener(this);

		contentPane.add(panel, BorderLayout.WEST);

		/*
		 * for (int i = 0; i < 9; i++) { button = new JButton("");
		 * button.addActionListener(this); contentPane.add(button); }
		 */

		// add text area and set scroll area
		textArea = new JTextArea(10, 25);
		scrollArea = new JScrollPane(textArea);

		// setting horizontal and vertical scroll lines

		scrollArea
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollArea
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// add scroll to contentPane
		contentPane.add(scrollArea, BorderLayout.CENTER);

		// set frame
		frame.pack();
		// frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * count++; JButton b = (JButton) e.getSource(); // this determines
		 * which button was pressed using the getSource() method if (count % 2
		 * != 0) { b.setText("X");
		 * 
		 * } else if (count % 2 == 0) { b.setText("O"); }
		 */

		if (e.getSource() == button1) {
			textArea.append("button1 clicked \n");

		}

		else if (e.getSource() == button2) {
			textArea.append("button2 clicked \n");
		}

		else if (e.getSource() == button3) {
			textArea.append("button3 clicked \n");
		}

		else if (e.getSource() == button4) {
			textArea.append("button4 clicked \n");
		} else {
			textArea.append("don't click here \n");
		}

	}
}
