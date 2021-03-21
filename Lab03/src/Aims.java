
public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();
		
		
		//add dvd part
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
	
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladinn","Animation",18.99f);
		anOrder.addDigitalVideoDisc(dvd4);
		anOrder.addDigitalVideoDisc(dvd3);
		
		//show after add
		anOrder.showCart();
		
		
		//remove dvd
		anOrder.removeDigitalVideoDisc(dvd1);
		
		//show after remove
		anOrder.showCart();
		
		//show qty
		System.out.print("Qty is:");
		System.out.println(anOrder.qtyOrdered());
		
		//show total cost
		System.out.print("Total cost is:");
		System.out.println(anOrder.totalCost());
		
		DigitalVideoDisc[] sorted = DVDUtils.sortedByCost(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4});
		System.out.println("Sort by cost:");
		System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
		for (int i=0;i<sorted.length;i++) {
			System.out.println(sorted[i].getDetail());
		}
		
		sorted = DVDUtils.sortedByTitle(new DigitalVideoDisc[] {dvd1,dvd2,dvd3,dvd4});
		System.out.println("Sort by title:");
		System.out.println("DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
		for (int i=0;i<sorted.length;i++) {
			System.out.println(sorted[i].getDetail());
		}
		
		//show total cost
		System.out.print("Total cost is:");
		System.out.println(anOrder.totalCost());

	}

}
