package hust.soict.globalict.aims.screen;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.disc.children.CompactDisc;
import hust.soict.globalict.aims.disc.children.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends  AddItemToStoreScreen {
	private DigitalVideoDisc dvd;
	public AddDigitalVideoDiscToStoreScreen() {
		super("add CD");
	//	this.dvd= dvd;
		
		
		
	}
	@Override
	public JPanel createCenter() {
		// TODO Auto-generated method stub
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(10,2));
		
		JLabel title = new JLabel("Title:");
		JTextField tfTitle = new JTextField();
		center.add(title);
		center.add(tfTitle);
		
		JLabel category = new JLabel("category:");
		JTextField tfCategory = new JTextField();
		center.add(category);
		center.add(tfCategory);
		
		JLabel cost = new JLabel("Cost:");
		JTextField tfCost = new JTextField();
		center.add(cost);
		center.add(tfCost);
		
		JLabel length = new JLabel("Length:");
		JTextField tfLength = new JTextField();
		center.add(length);
		center.add(tfLength);
		
		JLabel director = new JLabel("director:");
		JTextField tfDirector = new JTextField();
		center.add(director);
		center.add(tfDirector);
		
	
		
		return center;
	}
	
	
}
