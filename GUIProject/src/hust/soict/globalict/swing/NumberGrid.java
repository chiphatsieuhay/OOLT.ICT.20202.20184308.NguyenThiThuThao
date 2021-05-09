package hust.soict.globalict.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class NumberGrid extends JFrame{
	private JButton[] btnNumbers = new JButton[10];
	private JButton btnDelete,btnReset,btnResult,btnAdd,btnSub;
	private JTextField tfDisplay;
	private String rmb1 = new String(" ");
	private int rmb=0;
	
	void addButtons(JPanel panelButtons) {
		ButtonListener btnListener = new ButtonListener();
		for (int i= 1;i<=9;i++) {
			btnNumbers[i] = new JButton(""+i);
			panelButtons.add(btnNumbers[i]);
			btnNumbers[i].addActionListener(btnListener);
		}
		
		btnDelete = new JButton("DEL");
		panelButtons.add(btnDelete);
		btnDelete.addActionListener(btnListener);
		
		btnNumbers[0] = new JButton("0");
		panelButtons.add(btnNumbers[0]);
		btnNumbers[0].addActionListener(btnListener);
		
		btnReset = new JButton("C");
		panelButtons.add(btnReset);
		btnReset.addActionListener(btnListener);
		
		btnAdd = new JButton("+");
		panelButtons.add(btnAdd);
		btnAdd.addActionListener(btnListener);
		
		btnSub = new JButton("-");
		panelButtons.add(btnSub);
		btnSub.addActionListener(btnListener);
		
		btnResult = new JButton("=");
		panelButtons.add(btnResult);
		btnResult.addActionListener(btnListener);
		
	}
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String button = e.getActionCommand();
			if(button.charAt(0)>='0'&&button.charAt(0)<='9') {
				tfDisplay.setText(tfDisplay.getText()+button);
			}else if (button.equals("DEL")) {
				tfDisplay.setText(tfDisplay.getText().substring(0,tfDisplay.getText().length()-1));
				
			}else if (button.equals("C")){
				tfDisplay.setText("");
				rmb1="";
				rmb = 0;
			}else if (button.equals("=")) {
				if (rmb1 =="+")
				{
					rmb += Integer.parseInt(tfDisplay.getText());	
					tfDisplay.setText(Integer.toString(rmb));
				}else if (rmb1 =="-") {
					rmb -= Integer.parseInt(tfDisplay.getText());
					tfDisplay.setText(Integer.toString(rmb));
				}
				rmb1="=";
				
				
			}else if (button.equals("+")) {
				
				if (rmb1.equals("+"))
				{
					System.out.print(rmb1);
					
					rmb += Integer.parseInt(tfDisplay.getText()) ;	
					System.out.print(rmb);
					tfDisplay.setText("");
				}else if (rmb1.equals("-")) {
					System.out.print(rmb1);
					rmb -= Integer.parseInt(tfDisplay.getText());
					System.out.print(rmb);
					tfDisplay.setText("");
				}else if (rmb1.equals(" ")||rmb1.equals("=")) {
					System.out.print(rmb1);
					rmb +=Integer.parseInt(tfDisplay.getText());
					System.out.print(rmb);
					tfDisplay.setText("");
				}
				rmb1="+";
				System.out.print(rmb1);
				System.out.print(rmb);
			}else if (button.equals("-")) {
				if (rmb1.equals("+"))
				{
					rmb += Integer.parseInt(tfDisplay.getText());	
					tfDisplay.setText("");
				}else if (rmb1.equals("-")) {
					rmb -= Integer.parseInt(tfDisplay.getText());
					tfDisplay.setText("");
				}else if (rmb1.equals(" ")||rmb1.equals("=")) {
					rmb -=Integer.parseInt(tfDisplay.getText());	
					tfDisplay.setText("");
				}
				rmb1="-";
				System.out.print(rmb1);
			}
		}
		
	}
	public NumberGrid() {
		
		tfDisplay = new JTextField();
		tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		tfDisplay.setEditable(false);
		
		
		JPanel panelButtons = new JPanel(new GridLayout(5,3));
		addButtons(panelButtons);
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(tfDisplay, BorderLayout.NORTH);
		cp.add(panelButtons, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Number Grid");
		setSize(300,400);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberGrid();
	}

}
