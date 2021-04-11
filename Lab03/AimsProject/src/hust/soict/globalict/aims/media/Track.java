package hust.soict.globalict.aims.media;

public class Track implements Playable{
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public Track(String director, int length) {
		super();
		this.director = director;
		this.length = length;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getDirector());
		System.out.println("DVD length: " + this.getLength());
	}
}
