package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable, Comparable<CompactDisc> {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String artist, Track track) {
		super(title);
		this.artist = artist;
		this.addTrack(track);
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track track) {
		if(!tracks.contains(track))
			tracks.add(track);
	}
	
	public void removeTrack(Track track) {
		if(tracks.contains(track))
			tracks.remove(track);
	}
	
	public int getLength() {
		int sum = 0;
		for (Iterator<Track> iterator = tracks.iterator(); iterator.hasNext();) {
			 sum += iterator.next().getLength();
		}
		super.length = sum;
		return super.length;
	}
	
	public void play() {
		for (Iterator<Track> iterator = tracks.iterator(); iterator.hasNext();) {
			iterator.next().play();
		}
	}
	
	@Override 
	public int compareTo(CompactDisc obj) {
		return this.id - obj.id;
		
	}
	
}
