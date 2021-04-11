package hust.soict.globalict.aims.media;


public abstract class Disc extends Media {
	private String director;
	private int length;
	public abstract void play();
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

	public Disc( String title, String category, float cost) {
		super( title, category, cost);
	}

}
