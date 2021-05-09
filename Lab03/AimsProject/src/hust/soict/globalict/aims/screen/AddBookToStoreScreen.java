package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

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

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.children.Book;


public class AddBookToStoreScreen extends AddItemToStoreScreen{
	private Book book;
	public AddBookToStoreScreen() {
		super("add Book");
		//this.book= book;
		
	}
	@Override
	public JPanel createCenter() {
		// TODO Auto-generated method stub
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(15,2));
		
		
		JLabel author1 = new JLabel("Author1:");
		JTextField tfAuthor1 = new JTextField();
		center.add(author1);
		center.add(tfAuthor1);
		
		JLabel author2 = new JLabel("Author2:");
		JTextField tfAuthor2 = new JTextField();
		center.add(author2);
		center.add(tfAuthor2);
		
		JLabel author3 = new JLabel("Author3:");
		JTextField tfAuthor3 = new JTextField();
		center.add(author3);
		center.add(tfAuthor3);
		
		JLabel author4 = new JLabel("Author4:");
		JTextField tfAuthor4 = new JTextField();
		center.add(author4);
		center.add(tfAuthor4);
		
		JLabel author5 = new JLabel("Author5:");
		JTextField tfAuthor5 = new JTextField();
		center.add(author5);
		center.add(tfAuthor5);
		
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
		
		JLabel content = new JLabel("Content");
		JTextField tfContent = new JTextField();
		center.add(content);
		center.add(tfContent);
		
		return center;
		
	}

	
}
