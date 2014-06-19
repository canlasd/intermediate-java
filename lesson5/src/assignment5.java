import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class assignment5 implements ActionListener {
	private JFrame frame;
	private JButton button;
	private int numClicks = 5;
	private JLabel label;
	private Container contentPane;

	public static void main(String[] args) {
		assignment5 guiButton = new assignment5();
		guiButton.start();
	}

	public void start() {
		frame = new JFrame("GUI Countdown");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = frame.getContentPane();

		button = new JButton("Click Me");
		button.addActionListener(this);
		this.contentPane.add(button);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		button.setText(Integer.toString(numClicks));

		if (numClicks <= 0) {
			label = new JLabel("you have reached zero");
			this.contentPane.add(label);
			button.setVisible(false);

		}
		numClicks--;
	}

}
