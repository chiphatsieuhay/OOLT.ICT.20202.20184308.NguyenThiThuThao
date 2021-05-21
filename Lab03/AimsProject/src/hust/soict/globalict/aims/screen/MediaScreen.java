package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.aims.Interface.Playable;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;

public class MediaScreen extends JPanel{
	private Media media;
	private Cart cart;
	public MediaScreen(Media media,Cart cart) {
		this.media = media;
		this.cart =cart;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(),Font.PLAIN,20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost =  new JLabel(""+media.getCost()+"$");
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		BtnListener btnListener = new BtnListener();
		
		JButton addToCart = new JButton("Add to cart");
		container.add(addToCart);
		addToCart.addActionListener(btnListener);
		
		if (media instanceof Playable) {
			
			JButton play = new JButton("Play");
			container.add(play);
			play.addActionListener(btnListener);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
	}
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("action tap");
			String button = e.getActionCommand();
			if (button.equals("Add to cart")) {
				cart.addMedia(media);
				new AddToCart();  
			}else if (button.equals("Play")) {
				if (media instanceof Playable) {
					try {
						((Playable) media).play();
					} catch (PlayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			//	new Play();
			}
			
		}
		
	}
	public class AddToCart {  
		JFrame f;  
		AddToCart(){  
		    f=new JFrame();  
		    JOptionPane.showMessageDialog(f,"Add to cart done.");  
		}  
	
	}
	public class Play {  
		
	
	}
}
