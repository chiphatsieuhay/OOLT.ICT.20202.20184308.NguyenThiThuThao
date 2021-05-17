package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;


import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.disc.children.CompactDisc;
import hust.soict.globalict.aims.media.children.Book;

public class AddCompactDiscToStoreScreen extends  AddItemToStoreScreen {
	private CompactDisc compactDisc;
	private Cart cart;
	public AddCompactDiscToStoreScreen(Cart cart) {
		super("add CD",cart);
		//this.compactDisc= compactDisc;
		this.cart = cart;
		
		
	}
	@Override
	public JPanel createCenter() {
		// TODO Auto-generated method stub
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(15,2));
		
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
		
		JLabel artist = new JLabel("Artist:");
		JTextField tfArtist = new JTextField();
		center.add(artist);
		center.add(tfArtist);
		
		JLabel track1 = new JLabel("Track 1:");
		JTextField tfTrack1 = new JTextField();
		center.add(track1);
		center.add(tfTrack1);
		
		JLabel length1 = new JLabel("length 1:");
		JTextField tfLength1 = new JTextField();
		center.add(length1);
		center.add(tfLength1);
		
		JLabel track2 = new JLabel("Track 2:");
		JTextField tfTrack2 = new JTextField();
		center.add(track2);
		center.add(tfTrack2);
		
		JLabel length2 = new JLabel("length 2:");
		JTextField tfLength2 = new JTextField();
		center.add(length2);
		center.add(tfLength2);
		
		JLabel track3 = new JLabel("Track 3:");
		JTextField tfTrack3 = new JTextField();
		center.add(track3);
		center.add(tfTrack3);
		
		JLabel length3 = new JLabel("length 3:");
		JTextField tfLength3 = new JTextField();
		center.add(length3);
		center.add(tfLength3);
		
		JLabel track4 = new JLabel("Track 4:");
		JTextField tfTrack4 = new JTextField();
		center.add(track4);
		center.add(tfTrack4);
		
		JLabel length4 = new JLabel("length 4:");
		JTextField tfLength4 = new JTextField();
		center.add(length4);
		center.add(tfLength4);
		
	
	
		
		return center;
	}

	
	
}
