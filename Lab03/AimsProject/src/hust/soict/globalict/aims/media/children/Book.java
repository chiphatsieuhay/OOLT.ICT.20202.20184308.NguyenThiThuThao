package hust.soict.globalict.aims.media.children;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hust.soict.globalict.aims.media.Media;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private String content;
	private List<String> contentTokens;
	private Map<String,Integer> wordFrequency;
	public void ProcessContent() {
		
	}
	
	public Book( String title, String category, float cost, List<String> authors) {
		super(title,category,cost);
		this.authors = authors;
	}
	public List<String> getAuthors() {
		return authors;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getContentTokens() {
		return contentTokens;
	}
	public Map<String, Integer> getWordFrequency() {
		return wordFrequency;
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