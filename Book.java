package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
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
}
