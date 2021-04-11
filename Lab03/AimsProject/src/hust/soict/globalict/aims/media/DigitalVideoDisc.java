
package hust.soict.globalict.aims.media;

import java.time.LocalDate;

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
		
		public void play() {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength()); }
		
		
}
