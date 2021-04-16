package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public Book( String title, String category, float cost, List<String> authors) {
		super(title,category,cost);
		this.authors = authors;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public boolean addAuthor(String authorName) {
		for (int i = 0; i< authors.size();i++) {
			if (authors.get(i) == authorName) {
				System.out.println("author Name existed");
				return false;
			}
		}
		authors.add(authorName);
		return true;
	}
	public boolean removeAuthor(String authorName) {
		for (int i = 0; i< authors.size();i++) {
			if (authors.get(i) == authorName) {
				System.out.println("author deleted");
				authors.remove(i);
				return true;
			}
		}
		System.out.println("cant delete");
		return false;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}
}