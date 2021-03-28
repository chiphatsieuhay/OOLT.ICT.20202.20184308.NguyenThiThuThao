package hust.soict.globalict.aims;

import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Store {
	public DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[10000];
	private static int nbDigitalVideoDiscs = 0;
	public int qty = 0;
	public int existedDigital(DigitalVideoDisc disc) {
		for (int i = 0 ;i< qty;i++) {
			if (itemsInStore[i].getCategory() == disc.getCategory() 
					&&itemsInStore[i].getCost() == disc.getCost()
					&&itemsInStore[i].getDirector() == disc.getDirector()
					&&itemsInStore[i].getTitle() == disc.getTitle()
					&&itemsInStore[i].getLength() == disc.getLength()
					) {
				return i;
			}
		}
		return -1;
	}
	public void DiscInfo(DigitalVideoDisc disc) {
		System.out.print(disc.getId()+"\t"+disc.getTitle()+"\t"+disc.getCategory()+"\t"+disc.getDirector()+"\t"+disc.getCost()+"\t"+disc.getLength()+"\n");
	}
	public void DiscInfoName(DigitalVideoDisc disc) {
		System.out.print(disc.getId()+"\t"+disc.getTitle()+"\n");
	}
	public Boolean addDVD(DigitalVideoDisc disc) {
		if (existedDigital(disc)==-1) {
			itemsInStore[qty] = disc;
			nbDigitalVideoDiscs++;
			qty++;
//			System.out.println("Added item");
//			System.out.println("Number DVD"+nbDigitalVideoDiscs);
			DiscInfo(disc);
			return true;
		}else
		{
			System.out.println("item have already existed.");
			DiscInfo(disc);
			return false;
		}
			
	}
	public Boolean removeDVDbyID(int id) {
		for (int i = 0 ;i< qty;i++) {
			if (id == itemsInStore[i].getId()) {
				for(int j=i;j<qty;j++) {
					itemsInStore[j]=itemsInStore[j+1];
				}
				itemsInStore[qty-1]=null;
				qty--;
				
				System.out.println("Removed");
				return true;
			}
		}
		System.out.println("DVD is not in Store");
		
		return false;	
	}
	public Boolean removeDVD(DigitalVideoDisc disc) {
		int i = existedDigital(disc);
		if (i==-1) {
			System.out.println("DVD is not in Store");
			DiscInfo(disc);
			return false;
		}else
		{
			for(int j=i;j<qty;j++) {
				itemsInStore[j]=itemsInStore[j+1];
			}
			itemsInStore[qty-1]=null;
			qty--;
			DiscInfo(disc);
			System.out.println("Removed");
			return true;
		}
			
	}
	
}
