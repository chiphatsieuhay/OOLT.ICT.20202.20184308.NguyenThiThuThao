package hust.soict.globalict.aims.media.children;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import hust.soict.globalict.aims.media.Media;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	private String content;
	private String[] contentTokens =   new String[1000];
	private HashMap<String,Integer> wordFrequency = new HashMap<String, Integer>();
	public void ProcessContent() {
		int lengthContent = 0;
		String[] ex;
		ex = content.split("[, ?.@]+");
		Arrays.sort(ex);
//		contentTokens = ex ;
//		for (String a:contentTokens) {
//			System.out.println(a);
//		}
//		//HashMap<String,Integer> wordFrequency1
//		wordFrequency.put("hello", 1);
//		 for (String a: ex) {
//			 System.out.println(a);
//		 }
		int x = 0;
		for (int i =1;i<ex.length;i++) {
			//System.out.println(ex[i]+"Ngoai if else ");
			if (!ex[i].equals(ex[i-1])) {
				contentTokens[lengthContent] = new String( ex[i]); 
				lengthContent++;
				 wordFrequency.put(ex[i-1], x+1);
				 x = 0;
				// System.out.println(ex[i]+"VAo ne if ");
			}else {
				//System.out.println(ex[i]+"VAo ne else ");
				x++;
			}
		}
			wordFrequency.put(ex[ex.length-1], x+1);
		

		
		//System.out.println(wordFrequency);
//		for (int i =0;i<wordFrequency.size();i++) {
//			System.out.println(wordFrequency[i])
//		}
//		 for (String a : subarray)
//			 System.out.println(a);
//			 if (a != contentTokens[contentTokens.length-1] ) {
//				 contentTokens[contentTokens.length] = a; 
//				 wordFrequency.put(contentTokens[contentTokens.length-1], x);
//				 x=0;
//			 }else {
//				 x++;
//			 }
			
		
	}
	public String toString() {
		return ("Info of this book is: "+this.id+"\t"+this.category+"\t"+this.authors+"\t"+this.content+"\t"+this.cost+"\t"+this.wordFrequency+"\t");
	
		
	}
	
	

	public Book( String title, String category, float cost, List<String> authors) {
		super(title,category,cost);
		this.authors = authors;
	}
	public Book( String title, String category, float cost, List<String> authors,String content) {
		super(title,category,cost);
		this.authors = authors;
		this.content = content;
		ProcessContent();
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
	public String[] getContentTokens() {
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