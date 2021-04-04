package hust.soict.globalict.aims;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store Store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		Store.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		Store.addDVD(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		Store.addDVD(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladinn","Animation",18.99f);
		Store.addDVD(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Bo gia","Comedy","Tran Thanh",90,10f);
		
		
		
		Store.addDVD(dvd5);
		
		Store.removeDVD(dvd5);
		
	}

}
