package hust.soict.globalict.comparators;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media>{
	@Override
	public int compare(Media o1, Media o2) {
		int i =  o1.getTitle().compareTo(o2.getTitle());
		if (i != 0) return i;
		return i =(int) ( o2.getCost() - o1.getCost());    
	   
	    
	    
	}

}
