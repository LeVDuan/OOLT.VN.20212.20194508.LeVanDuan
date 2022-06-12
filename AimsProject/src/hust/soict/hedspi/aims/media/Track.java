package hust.soict.hedspi.aims.media;

public class Track implements Playable, Comparable<Track>{
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public Track() {
		this.title = "";
		this.length = 0;
	}
	
	public Track(String title) {
		this.title = title;
	}
	
	public Track(String title, int length) {
		this(title);
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
	}
	
	@Override
	
	public boolean equals(Object obj) {
		return ( ((Track) obj).getTitle() == this.title && ((Track) obj).getLength() == this.length);
	}
	
	@Override
	public int compareTo(Track obj) {
		return this.title.compareTo(obj.getTitle());
	}
}
