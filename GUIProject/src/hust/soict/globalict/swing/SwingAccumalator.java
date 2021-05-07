package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.*;


public class SwingAccumalator extends JFrame{
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0;
	
	public SwingAccumalator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2,2));
		
		cp.add(new JLabel("Enter an integer: "));
		
		tfInput = new JTextField(10);
		cp.add(tfInput);
		tfInput.addActionListener(new TFInputListener());
		
		cp.add(new Label("The Accumulated Sum is: "));
		
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		
		
		setTitle("Swing Accumulator");
		setSize(350,120);
		setVisible(true);
	}
	





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingAccumalator();
	}
	private class TFInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int numberIn = Integer.parseInt(tfInput.getText());
			sum +=  numberIn;
			tfInput.setText("");
			tfOutput.setText(sum+"");
		}
		
	}

}
