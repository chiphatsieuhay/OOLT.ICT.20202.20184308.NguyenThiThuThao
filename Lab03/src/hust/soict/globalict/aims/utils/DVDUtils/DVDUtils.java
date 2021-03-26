package hust.soict.globalict.aims.utils.DVDUtils;

import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class DVDUtils {
	public static String compareByCost(DigitalVideoDisc disc1,DigitalVideoDisc disc2) {
		if (disc1.getCost()>disc2.getCost()) return disc1.getTitle();
		else return disc2.getTitle();
	}
	public static String compareByTitle(DigitalVideoDisc disc1,DigitalVideoDisc disc2) {
		if (disc1.getTitle().compareTo(disc2.getTitle())==1) return disc1.getTitle();
		else return disc2.getTitle();
	}
	public static void swapTwo(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		
		//tmp
		String title1 = dvd1.getTitle();
		String category1 = dvd1.getCategory();
		String director1 = dvd1.getDirector();
		int length1 = dvd1.getLength();
		float cost1 = dvd1.getCost();
		
		//set for dvd1
		dvd1.setTitle(dvd2.getTitle());
		dvd1.setCategory(dvd2.getCategory());
		dvd1.setDirector(dvd2.getDirector());
		dvd1.setLength(dvd2.getLength());
		dvd1.setCost(dvd2.getCost());
		
		//set for dvd2
		dvd2.setTitle(title1);
		dvd2.setCategory(category1);
		dvd2.setDirector(director1);
		dvd2.setLength(length1);
		dvd2.setCost(cost1);
	}
	public static DigitalVideoDisc[] sortedByCost( DigitalVideoDisc [] dvd) {
		for (int i=0;i< dvd.length-1;i++) {
			for (int j=i+1;j<dvd.length;j++)
			{
				if (compareByCost(dvd[i],dvd[j])==dvd[j].getTitle()) {
					swapTwo(dvd[i],dvd[j]);
				}
			}
		}
		return dvd;
	}
	public static DigitalVideoDisc[] sortedByTitle(DigitalVideoDisc [] dvd) {
		for (int i=0;i< dvd.length-1;i++) {
			for (int j=i+1;j<dvd.length;j++)
			{
				if (compareByTitle(dvd[i],dvd[j])==dvd[j].getTitle()) {
					swapTwo(dvd[i],dvd[j]);
				}
			}
		}
		return dvd;
	}
}
