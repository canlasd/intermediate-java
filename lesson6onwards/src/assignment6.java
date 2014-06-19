import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class assignment6 implements ActionListener {
	private JFrame frame;
	private JButton button1, button2, button3, button4, button5, button6,
			button7, button8;
	private JPanel panel;
	private JTextArea textArea;
	private JLabel label;
	private JScrollPane scrollArea;

	public static void main(String[] args) {
		assignment6 guiLayout = new assignment6();
		guiLayout.start();
	}

	public void start() {
		// set pane
		frame = new JFrame("Assignment6");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());

		// set label
		label = new JLabel(
				"Use the buttons to control the layout of the text you type");
		contentPane.add(label, BorderLayout.NORTH);

		// set panel

		panel = new JPanel();
		panel.setLayout(new GridLayout(8, 1));

		// set buttons

		button1 = new JButton("Wrap Text");
		panel.add(button1);
		button1.addActionListener(this);

		button2 = new JButton("Do Not Wrap Text");
		panel.add(button2);
		button2.addActionListener(this);

		button3 = new JButton("");
		panel.add(button3);
		button3.addActionListener(this);

		button4 = new JButton("Clear Text");
		panel.add(button4);
		button4.addActionListener(this);

		button5 = new JButton("Scroll Vertically");
		panel.add(button5);
		button5.addActionListener(this);

		button6 = new JButton("Scroll Horizontally");
		panel.add(button6);
		button6.addActionListener(this);

		button7 = new JButton("Scroll Both Ways");
		panel.add(button7);
		button7.addActionListener(this);

		button8 = new JButton("Do Not Scroll");
		panel.add(button8);
		button8.addActionListener(this);

		contentPane.add(panel, BorderLayout.WEST);

		textArea = new JTextArea(10, 25);
		scrollArea = new JScrollPane(textArea);

		// setting horizontal and vertical scroll lines

		scrollArea
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollArea
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// add scroll to contentPane
		contentPane.add(scrollArea, BorderLayout.EAST);

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
			textArea.setLineWrap(true);

		}

		else if (e.getSource() == button2) {
			textArea.setLineWrap(false);
		}

		else if (e.getSource() == button3) {
			textArea.append("Don't Click Here\n");
		}

		else if (e.getSource() == button4) {
			textArea.setText("");

		} else if (e.getSource() == button5) {
			scrollArea
					.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		}

		else if (e.getSource() == button6) {
			scrollArea
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		}

		else if (e.getSource() == button7) {

			scrollArea
					.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scrollArea
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		}

		else if (e.getSource() == button8) {
			scrollArea
					.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollArea
					.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		}

	}
}
