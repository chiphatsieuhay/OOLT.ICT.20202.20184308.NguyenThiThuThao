package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import hust.soict.globalict.aims.Store;
import hust.soict.globalict.aims.media.Media;




public class StoreScreen extends JFrame{
	private Store store;
	public StoreScreen(Store store) {
		this.store= store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(),BorderLayout.NORTH);
		cp.add(createCenter(),BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024,768);
	}
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2));
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0 ; i<9;i++) {
			MediaScreen cell = new MediaScreen(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}
	
	JMenuBar createMenuBar() {
JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		
		JMenuItem addBook = new JMenuItem("Add Book");
		smUpdateStore.add(addBook);
		JMenuItem addCD = new JMenuItem("Add CD");
		smUpdateStore.add(addCD);
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addDVD);
		ItemActionListener itemActionListener = new ItemActionListener();
		addBook.addActionListener(itemActionListener);
		addCD.addActionListener(itemActionListener);
		addDVD.addActionListener(itemActionListener);
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		menu.add(new JMenuItem("View Cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		
		return menuBar;
	}
	private class ItemActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("action tap");
			String button = e.getActionCommand();
			if (button.equals("Add Book")) {
				System.out.println("add book");
				new AddBookToStoreScreen();
			}else if (button.equals("Add CD")) {
				new AddCompactDiscToStoreScreen();
			}else if (button.equals("Add DVD")) {
				new AddDigitalVideoDiscToStoreScreen();
			}
			
		}
		
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header,BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("Aims");
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100,50));
		cart.setMaximumSize(new Dimension(100,50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10,10)));
		
		return header;
	}
	
	
	
}
