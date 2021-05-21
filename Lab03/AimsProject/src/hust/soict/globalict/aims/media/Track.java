package hust.soict.globalict.aims.media;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hust.soict.globalict.aims.Interface.Playable;
import hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable,Comparable<Track>{
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	@Override
	public void play() throws PlayerException{
		// TODO Auto-generated method stub
		if(this.getLength()>0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());
			JFrame f;  
			f=new JFrame();  
			JOptionPane.showMessageDialog(f,"Playing.");  
			 
		}else {
			throw new PlayerException();
		}
		
		
	}
	public boolean equals(Object o) {
		if (o instanceof Track) {
			return (this.title == ((Track) o).getTitle() && this.length == ((Track) o).getLength());
		}
		else return false;
	}

	@Override
	public int compareTo(Track o) {
		// TODO Auto-generated method stub
		//System.out.println("We are comparing "+o.getTitle()+"with"+this.title);
		int i =  this.title.compareTo(o.getTitle());
		if (i != 0) return i;
	    return i =(int) (this.length - o.getLength());
	}
}
