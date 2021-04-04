package hust.soict.globalict.aims.Aims;

import hust.soict.globalict.aims.Store;
import hust.soict.globalict.aims.cart.Cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.utils.DVDUtils.DVDUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Aims {
	public static void showStore(Store Store) {
		for(int i = 0;i < Store.itemsInStore.size();i++) {
			Store.MediaInfo(Store.itemsInStore.get(i));
		}
	}
	public static void cartMenu(Cart anOrder) {
		System.out.println("Options: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Get a lucky item from cart");
		System.out.println("5. Place order"); 
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
//				int qty=0;
//			
//				DigitalVideoDisc[] disc = Arrays.copyOfRange(anOrder.itemsOrder, 0, anOrder.qtyOrdered());
//				DigitalVideoDisc[] sorted = DVDUtils.sortedByCost(disc);
//				anOrder.itemsOrdered.sort
				Collections.sort(anOrder.itemsOrdered,Cart.MediaComparatorCost);
				System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
				for (int i=0; i< anOrder.itemsOrdered.size();i++) {
					anOrder.itemsOrdered.get(i).getDetail();
				}
				cartMenu(anOrder);
			}else if (sort == 2 ) {
				int qty=0;
				
				Collections.sort(anOrder.itemsOrdered,Cart.MediaComparatorTitle);
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
			anOrder.getALuckyItem().setCost(0f);
			break;
		case 5:
			System.out.println("Place order");
			break;
		case 0: System.exit(0);
		default: {
			System.out.println("\nYou must choose a number in 1 2 3 4\n");
			cartMenu(anOrder);
			break;
		}	
		}
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
		System.out.println("Do you want to add to cart?"); 
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
	public static void updateStore(Store Store,Cart anOrder) {
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
	public static void switchshowMenu(Store Store,Cart anOrder) {
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
				}else {
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
	 
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		
//		//add dvd part
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
//		anOrder.addDigitalVideoDisc(dvd1);
//		
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
//		anOrder.addDigitalVideoDisc(dvd2);
//	
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
//		anOrder.addDigitalVideoDisc(dvd3);
//		
//		
//		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladinn","Animation",18.99f);
//		anOrder.addDigitalVideoDisc(dvd4);
//		anOrder.addDigitalVideoDisc(dvd3);
//		
//		//show after add
//		anOrder.showCart();
//		
//		
//		//remove dvd
//		anOrder.removeDigitalVideoDisc(dvd4);
//		
//		//show after remove
//		anOrder.showCart();
//		
//		//show qty
//		System.out.print("Qty is:");
//		System.out.println(anOrder.qtyOrdered());
//		
//		//show total cost
//		System.out.print("Total cost is:");
//		System.out.println(anOrder.totalCost());
//		
//		DigitalVideoDisc[] sorted = DVDUtils.sortedByCost(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4});
//		System.out.println("Sort by cost:");
//		System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
//		for (int i=0;i<sorted.length;i++) {
//			System.out.println(sorted[i].getDetail());
//		}
//		
//		sorted = DVDUtils.sortedByTitle(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4});
//		System.out.println("Sort by title:");
//		System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
//		for (int i=0;i<sorted.length;i++) {
//			System.out.println(sorted[i].getDetail());
//		}
//		
//		//show total cost
//		System.out.print("Total cost is:");
//		System.out.println(anOrder.totalCost());
		
		
		//add dvd to Store
		Store Store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		Store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		Store.addMedia(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		Store.addMedia(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladinn","Animation",18.99f);
		Store.addMedia(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Bo gia","Comedy","Tran Thanh",90,10f);
		
		
		
		Store.addMedia(dvd5);
		
		System.out.println("\n-------------------------------------\n");
	
		
		switchshowMenu(Store,anOrder);
		

	}

}
