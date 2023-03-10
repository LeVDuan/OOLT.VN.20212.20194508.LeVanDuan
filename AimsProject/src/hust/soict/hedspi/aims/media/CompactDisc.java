package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable, Comparable<CompactDisc> {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	 public String message;
	 public CompactDisc(String artist, ArrayList<Track> tracks) {
	        this.artist = artist;
	        this.tracks = tracks;
	 }
	public CompactDisc() {
		super();
	}
	
	public CompactDisc(String title, String artist, Track track) {
		super(title);
		this.artist = artist;
		this.addTrack(track);
	}
	
	public CompactDisc(int id,String title,String category,float cost ,String artist){
        super(id,title,category,cost);
        this.artist = artist;
    }

	public String getArtist() {
		return artist;
	}
	
	public String setArtist(String artist) {
		this.artist = artist;
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
	
	@Override
	public int getLength() {
		int sum = 0;
		for (Iterator<Track> iterator = tracks.iterator(); iterator.hasNext();) {
			 sum += iterator.next().getLength();
		}
		super.length = sum;
		return super.length;
	}
	
	public void play() throws PlayerException {
		if(this.getLength() <= 0) {
			System.out.println("ERROR: CD length is 0");
			throw (new PlayerException());
		}
		for (Iterator<Track> iterator = tracks.iterator(); iterator.hasNext();) {
			try {
			iterator.next().play();
			} catch(PlayerException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int searchTrack(Track cmpTrack) {
        for (int i = 0; i < this.tracks.size(); i++) {
            if (this.tracks.get(i).isEqualAll(cmpTrack)) {
                return i;
            }
        }
        
        return -1;
    }
	
	@Override 
	public int compareTo(CompactDisc obj) {
		return this.id - obj.id;
		
	}
	
}