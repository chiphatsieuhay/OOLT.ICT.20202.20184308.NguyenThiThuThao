package hust.soict.globalict.test.media;

import hust.soict.globalict.aims.disc.children.DigitalVideoDisc;

public class TestMediaCompareTo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Collection collection = new java.util.ArrayList();
		
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation","Blablo",197,18.99f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin","Animationn","Blabloo",1977,18.999f);
		collection.add(dvd1);
		collection.add(dvd2);
		collection.add(dvd4);
		collection.add(dvd3);
		
		
		java.util.Iterator iterator = collection.iterator();
		
		System.out.println("-----------------------------------------");
		System.out.println("The DVDs currently in the order are:");
		
		while(iterator.hasNext()){
			// a = ((DigitalVideoDisc) iterator.next());
			System.out.println(((DigitalVideoDisc) iterator.next()).getCost());
		}
		
		
		//Collection.sort()
		java.util.Collections.sort((java.util.List)collection);
		
		iterator = collection.iterator();
		System.out.println("-----------------------------------------");
		System.out.println("The DVDs in sorted order are:");
		
		while(iterator.hasNext()){
			System.out.println(((DigitalVideoDisc) iterator.next()).getCost());
		}
		System.out.println("-----------------------------------------");
		
	}

}
