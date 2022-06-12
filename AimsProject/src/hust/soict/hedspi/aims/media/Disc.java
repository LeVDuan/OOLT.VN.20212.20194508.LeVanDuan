package hust.soict.hedspi.aims.media;

public class Disc extends Media{
	private int length;
	private String director;
	
	public Disc(String title) {
		super(title);
	}

	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	
}
