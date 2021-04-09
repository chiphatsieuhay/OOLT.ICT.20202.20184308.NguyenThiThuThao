package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Disc extends Media {
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public Disc(String director, int length) {
//		super(true);
		this.director = director;
		this.length = length;
	}

	public Disc(int id, String title, String category, float cost, LocalDate addDate) {
		super(id, title, category, cost, addDate);
	}

}
