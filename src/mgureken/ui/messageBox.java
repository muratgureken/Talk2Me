package mgureken.ui;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class messageBox extends JFrame{
	public messageBox() {
		getContentPane().setLayout(null);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(10, 11, 414, 214);
		getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(10, 236, 315, 31);
		getContentPane().add(textPane_1);
		
		JButton btnGonder = new JButton("G\u00F6nder");
		btnGonder.setBounds(335, 236, 89, 31);
		getContentPane().add(btnGonder);
	}
}
