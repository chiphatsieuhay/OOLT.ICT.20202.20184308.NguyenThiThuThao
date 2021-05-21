
package hust.soict.globalict.aims.disc.children;

import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.Interface.Playable;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.children.Disc;

public class DigitalVideoDisc extends Disc implements Playable{
		private String director;
		private int length;
//		private static int nbDigitalVideoDiscs = 0;
//		public String getDetail() {
//			return (this.title+"\t"+this.category+"\t"+this.director+"\t"+this.length+"\t"+this.cost);
//		}
		public void setDirector(String director) {
			this.director = director;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public String getDirector() {
			return director;
		}
		public int getLength() {
			return length;
		}
		public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
			super(title,category,cost);
			
			
//			this.title = title;
//			this.category = category;
			this.director = director;
			this.length = length;
//			this.cost = cost;
		}
//		public DigitalVideoDisc(String title) {
//			super();
//			nbMedia++;
//			this.id = nbMedia;
//			this.title = title;
//		}
//		public DigitalVideoDisc(String title, String category, float cost) {
//			super();
//			nbMedia++;
//			this.id = nbMedia;
//			this.title = title;
//			this.category = category;
//			this.cost = cost;
//		}
//		public DigitalVideoDisc(String title, String category, String director, float cost) {
//			super();
//			nbMedia++;
//			this.id = nbMedia;
//			this.title = title;
//			this.category = category;
//			this.director = director;
//			this.cost = cost;
//		}
		public boolean search2(String title) {
			 return (this.title).indexOf(title) > -1;
		}
	
		public boolean search(String title) {
//			System.out.println("\n-------------------------------------\n");
//			System.out.println("the title of this item is:"+title);
			
			String[] currencies = (this.title).split(" ");
//			System.out.println("the length of this title:"+currencies.length);
			for (int i=0;i<currencies.length;i++) {
//				System.out.println("currencies i"+i+":"+currencies[i]);
				if (currencies[i].equals(title)) return true;
			}
			return false;
		}
		
		public void play() throws PlayerException{
			if(this.getLength()>0){
				System.out.println("Playing DVD: " + this.getTitle());
				System.out.println("DVD length: " + this.getLength()); 
				
				JFrame f;  
				f=new JFrame();  
				JOptionPane.showMessageDialog(f,"Playing.");  
			}else {
				throw new PlayerException();
			}
			
		}

		
		
		
}
