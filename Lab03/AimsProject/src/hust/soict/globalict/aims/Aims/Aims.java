package hust.soict.globalict.aims.Aims;

import hust.soict.globalict.MemoryDaemon.MemoryDaemon;
import hust.soict.globalict.aims.Store;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.disc.children.CompactDisc;
import hust.soict.globalict.aims.disc.children.DigitalVideoDisc;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.children.Book;
import hust.soict.globalict.aims.media.children.Disc;
import hust.soict.globalict.aims.screen.AddBookToStoreScreen;
import hust.soict.globalict.aims.screen.CartScreen;
import hust.soict.globalict.aims.screen.StoreScreen;
import hust.soict.globalict.aims.utils.DVDUtils.DVDUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Aims {
	public static void showStore(Store Store) {
		for(int i = 0;i < Store.itemsInStore.size();i++) {
			Store.MediaInfo(Store.itemsInStore.get(i));
		}
	}
	public static void cartMenu(Cart anOrder) throws PlayerException {
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Get a lucky item from cart");
		System.out.println("5. Place order"); 
		System.out.println("6. Play Media"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
		Scanner keyboard = new Scanner(System.in);
		int Menuchoose = keyboard.nextInt();
		switch (Menuchoose) {
		case 1:
			System.out.println("1: filter by id\n2: filter by title");
			int filter = keyboard.nextInt();
			
			if (filter == 1) {
				
				int id = keyboard.nextInt();
				anOrder.searchById(id);
				cartMenu(anOrder);
			}else if (filter == 2 ) {
				String title = keyboard.nextLine();
				anOrder.searchforDVDsByTitle(title);
				cartMenu(anOrder);
			}else {
				System.out.println("Must choose 1 2");
				cartMenu(anOrder);
			}
		case 2:
			System.out.println("1: Sort by cost\n2: sort by title");
			int sort = keyboard.nextInt();
			if (sort == 1) {

				Collections.sort(anOrder.itemsOrdered, Media.COMPARE_BY_COST_TITLE);
				System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
				for (int i=0; i< anOrder.itemsOrdered.size();i++) {
					anOrder.itemsOrdered.get(i).getDetail();
				}
				cartMenu(anOrder);
			}else if (sort == 2 ) {
				int qty=0;
				
				Collections.sort(anOrder.itemsOrdered,Media.COMPARE_BY_TITLE_COST);
				System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
				for (int i=0; i< anOrder.itemsOrdered.size();i++) {
					anOrder.itemsOrdered.get(i).getDetail();
				}
				cartMenu(anOrder);
			}else {
				System.out.println("Must choose 1 2");
				cartMenu(anOrder);
			}
		case 3:
			anOrder.showCart();
			System.out.println("Enter id you want remove");
			int id=keyboard.nextInt();
			anOrder.removeMedia(id);
			cartMenu(anOrder);
		case 4:
			try {
				anOrder.getALuckyItem().setCost(0f);
			}catch(Exception e) {
				
			}
			
			break;
		case 5:
			System.out.println("Place order");
			break;
		case 6:
			playMedia(anOrder);
			cartMenu(anOrder);
			break;
		case 0: System.exit(0);
		default: {
			System.out.println("\nYou must choose a number in 1 2 3 4\n");
			cartMenu(anOrder);
			break;
		}	
		}
		}
		
	public static void playMedia(Cart anOrder,Store Store) throws PlayerException {
		showStore(Store);
		System.out.println("Which one want to play?"); 
		Scanner keyboard = new Scanner(System.in);
		int id = keyboard.nextInt();
		for(int i = 0;i < Store.itemsInStore.size();i++) {
			if (id == Store.itemsInStore.get(i).getId()) {
				if (Store.itemsInStore.get(i) instanceof DigitalVideoDisc) {
					DigitalVideoDisc b = (DigitalVideoDisc) Store.itemsInStore.get(i);
					try {
						b.play();
					}
					catch (PlayerException e) {
						throw new PlayerException("ERROR:DVD length is non-positive");
					}
					
					return;
				}else {
					System.out.println("Can not play this type of Media");
				}
				
			}
		} 
		System.out.println("Id not existed");
	}
	public static void playMedia(Cart anOrder) throws PlayerException {
		Collections.sort(anOrder.itemsOrdered,Media.COMPARE_BY_TITLE_COST);
		System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
		for (int i=0; i< anOrder.itemsOrdered.size();i++) {
			anOrder.itemsOrdered.get(i).getDetail();
		}
		System.out.println("Which one want to play?"); 
		Scanner keyboard = new Scanner(System.in);
		int id = keyboard.nextInt();
		for (int i=0; i< anOrder.itemsOrdered.size();i++) {
			if (id == anOrder.itemsOrdered.get(i).getId()) {
				if (anOrder.itemsOrdered.get(i) instanceof DigitalVideoDisc) {
					DigitalVideoDisc b = (DigitalVideoDisc) anOrder.itemsOrdered.get(i);
					
					b.play();
					return;
				}else {
					System.out.println("Can not play this type of Media");
				}
			
			}
		} 
		System.out.println("Id not existed");
	}
	public static void addToCart(Cart anOrder,Store Store) {
		showStore(Store);
		System.out.println("Which one want to add?"); 
		Scanner keyboard = new Scanner(System.in);
		int id = keyboard.nextInt();
		for(int i = 0;i < Store.itemsInStore.size();i++) {
			if (id == Store.itemsInStore.get(i).getId()) {
				anOrder.addMedia(Store.itemsInStore.get(i));
				System.out.println("Success to add");
				return;
			}
		} 
		System.out.println("Id not existed");
	}
	
	public static int showStoreDetail(Store Store) {
		for(int i = 0;i < Store.itemsInStore.size();i++) {
			Store.MediaInfo(Store.itemsInStore.get(i));
		}
		System.out.println("1 to add to cart,2 to play them"); 
		Scanner keyboard = new Scanner(System.in);
		int bool = keyboard.nextInt();
		return bool;
	}
	public static int showMenu() { 
		System.out.println("AIMS: ");
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3:");
		Scanner keyboard = new Scanner(System.in);
		int Menuchoose = keyboard.nextInt();
		return Menuchoose;
	}
	
	public static int storeMenu() { 
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details"); 
		System.out.println("2. Add a DVD to cart"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3");
		Scanner keyboard = new Scanner(System.in);
		int Menuchoose = keyboard.nextInt();
		return Menuchoose;
		
	}
	public static void showCart(Cart anOrder) {
		anOrder.showCart();
	}
	public void toStoreScreen() {
		
	}
	public static void updateStore(Store Store,Cart anOrder) throws PlayerException {
		System.out.println("Press 1 to remove, 0 to add -1 to exit:");
		Scanner keyboard = new Scanner(System.in);
		int addRemove = keyboard.nextInt();
		if (addRemove == 0 || addRemove==1 || addRemove==-1) {
			if (addRemove == 0) {
				System.out.println("What's dvd name?");
				String title=keyboard.nextLine();
				System.out.println("What's dvd category?");
				String category=keyboard.nextLine();
				System.out.println("What's dvd director?");
				String director=keyboard.nextLine();
				System.out.println("What's dvd length?");
				int length=keyboard.nextInt();
				System.out.println("What's dvd cost?");
				float cost=keyboard.nextFloat();
				DigitalVideoDisc dvd1 = new DigitalVideoDisc(title,category,director,length,cost);
				Store.addMedia(dvd1);
				switchshowMenu(Store,anOrder);
			}else if (addRemove==1) {
				System.out.println("Enter id you want remove");
				int id=keyboard.nextInt();
				Store.removeMedia(id);
				switchshowMenu(Store,anOrder);
			}else {
				switchshowMenu(Store,anOrder);
			}
		}else {
			System.out.println("Must choose 0 -1 1");
			updateStore(Store,anOrder);
		}
	}
	public static void switchshowMenu(Store Store,Cart anOrder) throws PlayerException {
		int Menuchoose=showMenu();
		switch (Menuchoose) {
		case 1:
			showStore(Store);
			Menuchoose=storeMenu();
			switch(Menuchoose) {
			case 1:
				int bool=showStoreDetail(Store);
				if (bool == 1 ) {
					addToCart(anOrder,Store);
					switchshowMenu(Store,anOrder);
					break;
				}else if (bool == 2) {
					playMedia(anOrder,Store);
					switchshowMenu(Store,anOrder);
					break;
				}
				else {
					System.out.println("\nSo you dont want add\n");
					switchshowMenu(Store,anOrder);
					break;
				}
			case 2:
				addToCart(anOrder,Store);
				switchshowMenu(Store,anOrder);
				break;
			case 3:
				cartMenu(anOrder);
				break;
			case 0:System.exit(0);
			default: {
				System.out.println("\nYou must choose a number in 0 1 2 3\n");
				switchshowMenu(Store,anOrder);
				break;
			}	
			}
		case 2:
			updateStore(Store,anOrder);
			break;
		case 3:
			cartMenu(anOrder);
			break;
		case 0:System.exit(0);
		default: {
			System.out.println("\nYou must choose a number in 0 1 2 3\n");
			Menuchoose=showMenu();
			break;
		}
		}
	}
	 
	public static void main(String[] args)throws InterruptedException, PlayerException {
		Cart anOrder = new Cart();
		
		Store Store = new Store();
		
		//add dvd to Store
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",-87,19.95f);
		Store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		Store.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation","Blablo",197,18.99f);
//		Store.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladinn","Animation","ximaxo",817,181.99f);
//		Store.addMedia(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Bo gia","Comedy","Tran Thanh",90,10f);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin","Animationn","Blabloo",1977,12.5f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("What is love","Romance","Blabloo",1977,12.5f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("Taste of love","Romance","Blabloo",197,12.5f);
		DigitalVideoDisc dvd9 = new DigitalVideoDisc("Instagram","Animationn","Blabloo",977,12.5f);
		DigitalVideoDisc dvd10 = new DigitalVideoDisc("take to moon","hihii","Blabloo",1977,12.5f);
		
		Store.addMedia(dvd5);
//		Store.addMedia(dvd6);
		Store.addMedia(dvd7);
		Store.addMedia(dvd8);
//		Store.addMedia(dvd9);
//		Store.addMedia(dvd10);
//		
		
		//add compactDisc
		List<Track> Track1 = new ArrayList<Track>();
		Track Trackx = new Track("Song1: Leave the door open", 26);
		Track1.add(Trackx);
		Trackx = new Track("Song2: Leave the door open", 15);
		Track1.add(Trackx);
		Trackx = new Track("Song3: Leave the door open", 20);
		Track1.add(Trackx);
		Trackx = new Track("Song4: Leave the door open", 20);
		Track1.add(Trackx);
		
		CompactDisc disc1 = new CompactDisc("Leave the door open","Ballad",12.5f,"Bruno Mars",Track1);
		
		List<Track> Track2 = new ArrayList<Track>();
		Track Trackx2 = new Track("Song1: 2002", 26);
		Track2.add(Trackx2);
		Trackx2 = new Track("Song2: 2002", 15);
		Track2.add(Trackx2);
		Trackx2 = new Track("Song3: 2002", 20);
		Track2.add(Trackx2);
		Trackx2 = new Track("Song4: 2002", 20);
		Track2.add(Trackx2);
		
		CompactDisc disc2 = new CompactDisc("2002","Ballad",12.5f,"Anne",Track2);
		Store.addMedia(disc1);
		Store.addMedia(disc2);
		
		
		//add book
		List<String> authors = new ArrayList<String>();
		List<String> authors1 = new ArrayList<String>();
		authors.add("Thao");
		authors.add("Chipp");
		authors.add("Cross");
		authors1.add("Thao");
		authors1.add("Chipp");
		authors1.add("Cross");
		Book Book1 = new Book("Wars", "Story", 30f, authors,"i can can the can. But you, see you");
		Book Book2 = new Book("Take it slow", "Fanfic", 30f, authors,"Cha eun woo is for life");
		
		
		
		
		Store.addMedia(Book1);
		Store.addMedia(Book2);
		
		
		StoreScreen storeScreen = new StoreScreen(Store,anOrder);
		//test cart screen
//		anOrder.addMedia(Store.itemsInStore.get(2));
//		anOrder.addMedia(Store.itemsInStore.get(3));
//		anOrder.addMedia(Store.itemsInStore.get(4));
//		new ;
		
		 Thread dt = new Thread(new MemoryDaemon());
	     dt.setDaemon(true);
	     dt.start();
		
		switchshowMenu(Store,anOrder);
		
		
	}

}
