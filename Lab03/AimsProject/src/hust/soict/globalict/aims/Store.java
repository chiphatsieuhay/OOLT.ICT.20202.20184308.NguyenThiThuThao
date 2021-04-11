package hust.soict.globalict.aims;

import java.util.ArrayList;


import hust.soict.globalict.aims.media.Media;

public class Store {
//	public Media itemsInStore[] = new Me[10000];
	public ArrayList<Media> itemsInStore = new
			ArrayList<Media>();
	public int qty = 0;
	public int existedMedia(Media media) {
		for (int i = 0;i < itemsInStore.size();i++) {
			if (media.getId() == itemsInStore.get(i).getId()) {
				System.out.println("media existed");
				return i;
			}
		}
		System.out.println("media did not exist");
		return -1;
	}
	public void MediaInfo(Media media) {
		System.out.print(media.getId()+"\t"+media.getTitle()+"\t"+media.getCategory()+"\t"+media.getCost()+"\n");
	}
//	public void DiscInfoName(DigitalVideoDisc disc) {
//		System.out.print(disc.getId()+"\t"+disc.getTitle()+"\n");
//	}
	
		public Boolean addMedia(Media media ) {
			if (existedMedia(media)!=-1) {
				return false;
			}else {
				itemsInStore.add(media);
			System.out.println("The media \"" + media.getTitle() + "\" has been added to the current cart!");
			return true;
			}
			
		}
		public Media searchById(int id) {
			for (int i = 0;i < itemsInStore.size();i++) {
				if (id == itemsInStore.get(i).getId() ) {
					itemsInStore.get(i).getDetail();
					return itemsInStore.get(i);
				}
			}
			System.out.println("Can not find this");
			return null;
		}
		public Boolean removeMedia(int id) {
			Media x = searchById(id);
			if (x!= null) {
				if (existedMedia(searchById(id))!=-1) {
					itemsInStore.remove(existedMedia(searchById(id)));
					System.out.println("Remove done");
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
			
		}

	
}
