package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

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
		
		
		//create combo box 
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
	
		String[] lafNames = new String[lafInfos.length];
		for (int i =0 ; i< lafInfos.length;i++) {
			lafNames[i] = lafInfos[i].getName();
		}
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		//handle change look and feel 
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					UIManager.setLookAndFeel(lafInfos[index].getClassName());
				//	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				}catch(Exception e){
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(lafInfos[index].getName()+" Look And Feel");
			}
			
		});
		
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
		new LookAndFeelDemo();
	}

}
