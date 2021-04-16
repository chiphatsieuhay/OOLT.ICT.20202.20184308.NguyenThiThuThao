package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media {
	public void setCost(float cost) {
		this.cost = cost;
	}
	public abstract void play();
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected static int nbMedia = 0;
	private LocalDate addDate;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void getDetail() {
		System.out.println(this.id+"\t"+this.title+"\t"+this.category+"\t"+this.cost);
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public LocalDate getAddDate() {
		return addDate;
	}
	public boolean search(String title) {
//		System.out.println("\n-------------------------------------\n");
//		System.out.println("the title of this item is:"+title);
		
		String[] currencies = (this.title).split(" ");
//		System.out.println("the length of this title:"+currencies.length);
		for (int i=0;i<currencies.length;i++) {
//			System.out.println("currencies i"+i+":"+currencies[i]);
			if (currencies[i].equals(title)) return true;
		}
		return false;
	}
	public Media() {};
//	public Media(boolean isAdd ) {
//		
//	};
	

	public boolean equals(Object o) {
		if (o instanceof Media) {
			return this.id == ((Media) o).getId();
		}
		else return false;
	}
	public Media( String title, String category, float cost) {
		this.nbMedia++;
		this.id = nbMedia;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.addDate = LocalDate.now();
		
	}
	
}