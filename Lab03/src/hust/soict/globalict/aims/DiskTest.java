package hust.soict.globalict.aims;

import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils.DVDUtils;

public class DiskTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
	
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladinn","Animation",18.99f);
		
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladinn","Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd4);
		anOrder.addDigitalVideoDisc(dvd5);
		
		System.out.println("\n-------------------------------------\n");
		
		DigitalVideoDisc[] sorted = DVDUtils.sortedByTitle(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4});
		System.out.println("Sort by title:");
		System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
		for (int i=0;i<sorted.length;i++) {
			System.out.println(sorted[i].getDetail());
		}
		
		System.out.println("\n-------------------------------------\n");
		System.out.println("\nSearch by single word\n");
		anOrder.searchforDVDsByTitle("Star");
		
		System.out.println("\n-------------------------------------\n");
		System.out.println("\nSearch normal\n");
		anOrder.searchforDVDsByTitle("Ala");
	}

}
