package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class LookAndFeelDemo extends JFrame{
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("TextField: "));
		cp.add(new JRadioButton("Radio Button:" ));
		cp.add(new JButton("Button:" ));
	}
	void addLookAndFeelComboBox() {
		Container cp = getContentPane();
		cp.add(new JLabel("Change look and feel here: "));
		
	}
	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,120);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
