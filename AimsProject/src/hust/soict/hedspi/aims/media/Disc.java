package hust.soict.hedspi.aims.media;

public class Disc extends Media{
	protected int length;
	protected String director;
	
	public Disc() {
		super();
	}
	
	 public Disc(int length, String director, String title, String category) {
	        super(title, category);
	        this.length = length;
	        this.director = director;
	    }
	
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
