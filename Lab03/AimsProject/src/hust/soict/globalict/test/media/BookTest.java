package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.children.Book;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> authors = new ArrayList<String>();
		authors.add("Thao");
		authors.add("Chipp");
		authors.add("Cross");
		Book Book1 = new Book("Wars", "Story", 30f, authors,"i can can the can. But you, see you");
//		System.out.println("This test for contentsTokens",Book1.getContentTokens());
	
		System.out.print(Book1.toString());
	}

}
