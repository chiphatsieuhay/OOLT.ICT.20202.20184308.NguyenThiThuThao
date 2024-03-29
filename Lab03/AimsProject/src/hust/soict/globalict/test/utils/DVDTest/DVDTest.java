package hust.soict.globalict.test.utils.DVDTest;

import hust.soict.globalict.aims.disc.children.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils.DVDUtils;

public class DVDTest {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA","aaaa","aaaa",1,5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB","bbbb","bbbb",2,5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC","cccc","cccc",3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD","dddd","dddd",4, 7.1f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE","eeee","eeee",5, 3.3f);
		
		System.out.println(DVDUtils.compareByCost(dvd1,dvd2));
		System.out.println(DVDUtils.compareByTitle(dvd5,dvd3));
		
		DigitalVideoDisc[] sorted = DVDUtils.sortedByCost(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by cost:");
		for (int i=0;i<sorted.length;i++) {
			System.out.println(sorted[i].getDetail());
		}
		
		sorted = DVDUtils.sortedByTitle(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4,dvd5});
		System.out.println("Sort by title:");
		for (int i=0;i<sorted.length;i++) {
			System.out.println(sorted[i].getDetail());
		}
	}

}
