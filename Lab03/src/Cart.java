
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 21;
	private int qty = 0;
	private DigitalVideoDisc itemsOrder[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public int qtyOrdered() {
		return qty;
	}
	public int existedDigital(DigitalVideoDisc disc) {
		for (int i = 0 ;i< qty;i++) {
			if (itemsOrder[i].getCategory() == disc.getCategory() 
					&&itemsOrder[i].getCost() == disc.getCost()
					&&itemsOrder[i].getDirector() == disc.getDirector()
					&&itemsOrder[i].getTitle() == disc.getTitle()
					&&itemsOrder[i].getLength() == disc.getLength()
					) {
				return i;
			}
		}
		return -1;
	}
	public Boolean addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered()+1>20) 
		{
			System.out.println("The cart is full");
			return false;	
		}
		else {
			if (existedDigital(disc)==-1) {
				itemsOrder[qty] = new DigitalVideoDisc(disc.getTitle(),disc.getCategory(),disc.getDirector(),disc.getLength(),disc.getCost());
				qty++;
				return true;
			}else {
				System.out.println("This dvd already exist.");
				return false;
			}
			
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
			int i = existedDigital(disc);
			if (i != -1) {
				for(int j=i;j<=qty;j++) {
					itemsOrder[j]=itemsOrder[j+1];
				}
				itemsOrder[qty-1]=null;
				qty--;
			}else {
				System.out.println("Can not delete");
			}
		
		
	}
	public void showCart() {
		for(int i = 1;i <= qty;i++) {
			System.out.print(i+"\t"+itemsOrder[i-1].getTitle()+"\t"+itemsOrder[i-1].getCategory()+"\t"+itemsOrder[i-1].getDirector()+"\t"+itemsOrder[i-1].getCost()+"\t"+itemsOrder[i-1].getLength()+"\n");
		}
	}
	public float totalCost() {
		float cost=0;
		for(int i = 0;i < qty;i++) {
			cost = cost + itemsOrder[i].getCost();
		}
		return cost;
	}
}
