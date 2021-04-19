package hust.soict.globalict.aims.disc.children;


import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.Interface.Playable;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.media.children.Disc;

public class CompactDisc extends Disc implements Playable{
	
	

	private String artist;
	private List<Track> Track = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	
	public int existedTrack(Track checkTrack) {
		for (int i = 0;i < Track.size();i++) {
			if (checkTrack == Track.get(i)) {
				System.out.println("Track existed");
				return i;
			}
		}
		System.out.println("Track did not exist");
		return -1;
	}
	public Boolean addTrack(Track addTrack ) {
		
	if (existedTrack(addTrack)!=-1) {
		return false;
	}else {
		Track.add(addTrack);
		System.out.println("The Track \"" + Track.get(Track.size()-1) + "\" has been added to the CompactDisc!");
		return true;
		}
	}	
	public Boolean removeTrack(Track removeTrack ) {
		int remove = existedTrack(removeTrack);
		if (remove != -1) {
			Track.remove(remove);
			System.out.println("The Track has been remove from the CompactDisc!");
			return true;
			
		}else {
			
			
			return false;
			}
		}
	
	public int getLength() {
		int sum =0 ;
		for (int i = 0;i < Track.size();i++) {
			sum = sum + Track.get(i).getLength();
		}
		return sum;
		}
	public CompactDisc( String title, String category, float cost, String artist,List<Track> Track) {
		super( title, category, cost);
		this.artist = artist;
		this.Track = Track;
		
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		for (int i = 0;i < Track.size();i++) {
			Track.get(i).play();
		}
		
	}

}
