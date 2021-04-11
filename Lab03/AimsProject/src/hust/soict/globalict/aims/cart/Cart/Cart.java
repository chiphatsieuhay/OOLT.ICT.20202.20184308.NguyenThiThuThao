package hust.soict.globalict.aims.cart.Cart;

import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
import java.util.Comparator;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public ArrayList<Media> itemsOrdered = new
			ArrayList<Media>();

	public void searchforDVDsByTitle(String title) {
		int a =0;
		for (int i = 0;i < itemsOrdered.size();i++) {
			if (itemsOrdered.get(i).search(title)==true) {
				itemsOrdered.get(i).getDetail();
				a++;
				
			}
		}
		if (a ==0 ) {
			System.out.println("there is no matched items");
		}
		
		
	}
	public static Comparator<Media> MediaComparatorCost = new Comparator<Media>() {

		public int compare(Media s1, Media s2) {

		   float rollno1 = s1.getCost();
		   float rollno2 = s2.getCost();

		   /*For ascending order*/
		   return (int) (rollno1-rollno2);

		   /*For descending order*/
		   //rollno2-rollno1;
	   }};
	 public static Comparator<Media> MediaComparatorTitle = new Comparator<Media>() {
		 
		 
			public int compare(Media s1, Media s2) {
			   String MediaName1 = s1.getTitle().toUpperCase();
			   String MediaName2 = s2.getTitle().toUpperCase();

			   //ascending order
			   return MediaName1.compareTo(MediaName2);

			   //descending order
			   //return StudentName2.compareTo(StudentName1);
		    }};
	public Media searchById(int id) {
		for (int i = 0;i < itemsOrdered.size();i++) {
			if (id == itemsOrdered.get(i).getId() ) {
				itemsOrdered.get(i).getDetail();
				return itemsOrdered.get(i);
			}
		}
		System.out.println("Can not find this");
		return null;
	}

	public Media getALuckyItem() {
        return itemsOrdered.get((int) (Math.random() * itemsOrdered.size()));
    }

    public void clearCart() {
        itemsOrdered.clear();
    }
	public int existedMedia(Media media) {
		for (int i = 0;i < itemsOrdered.size();i++) {
			if (media.getId() == itemsOrdered.get(i).getId()) {
				System.out.println("media existed");
				return i;
			}
		}
		System.out.println("media did not exist");
		return -1;
	}
	public Boolean addMedia(Media media ) {
		if (itemsOrdered.size()== MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
			return false;
		}else {
			if (existedMedia(media)!=-1) {
				return false;
			}else {
			itemsOrdered.add(media);
			System.out.println("The media \"" + media.getTitle() + "\" has been added to the current cart!");
			return true;
			}
		}
		
	}
	public Boolean removeMedia(int id) {
		Media x = searchById(id);
		if (x!= null) {
			if (existedMedia(searchById(id))!=-1) {
				itemsOrdered.remove(existedMedia(searchById(id)));
				System.out.println("Remove done");
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
	}

   
	public void showCart() {
		for(int i = 0;i < itemsOrdered.size();i++) {
			itemsOrdered.get(i).getDetail();
		}
	}
	public float totalCost() {
		float cost=0;
		for(int i = 0;i < itemsOrdered.size();i++){
			cost = cost + itemsOrdered.get(i).getCost();
		}
		return cost;
	}
}
