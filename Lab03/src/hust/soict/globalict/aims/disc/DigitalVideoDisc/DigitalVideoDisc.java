
package hust.soict.globalict.aims.disc.DigitalVideoDisc;

import java.io.*;

public class DigitalVideoDisc {
		private String title;
		private String category;
		private String director;
		private int length;
		private float cost;
		private static int nbDigitalVideoDiscs = 0;
		private int id;
		public String getDetail() {
			return (this.title+"\t"+this.category+"\t"+this.director+"\t"+this.length+"\t"+this.cost);
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public void setDirector(String director) {
			this.director = director;
		}
		public void setLength(int length) {
			this.length = length;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public void setCost(float cost) {
			this.cost = cost;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getCategory() {
			return category;
		}
		public String getDirector() {
			return director;
		}
		public int getLength() {
			return length;
		}
		public float getCost() {
			return cost;
		}
		public String getTitle() {
			return title;
		}
		public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
			super();
			nbDigitalVideoDiscs++;
			this.id = nbDigitalVideoDiscs;
			this.title = title;
			this.category = category;
			this.director = director;
			this.length = length;
			this.cost = cost;
		}
		public DigitalVideoDisc(String title) {
			super();
			nbDigitalVideoDiscs++;
			this.id = nbDigitalVideoDiscs;
			this.title = title;
		}
		public DigitalVideoDisc(String title, String category, float cost) {
			super();
			nbDigitalVideoDiscs++;
			this.id = nbDigitalVideoDiscs;
			this.title = title;
			this.category = category;
			this.cost = cost;
		}
		public DigitalVideoDisc(String title, String category, String director, float cost) {
			super();
			nbDigitalVideoDiscs++;
			this.id = nbDigitalVideoDiscs;
			this.title = title;
			this.category = category;
			this.director = director;
			this.cost = cost;
		}
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
		
		
}
