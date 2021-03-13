
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
		
		//show total cose
		System.out.print("Total cost is:");
		System.out.println(anOrder.totalCost());
	}

}
