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

	public Disc(int id, String title,String category,float cost){
        super(id,title,category,cost);
    }

	public Disc(int id,String title,String category,float cost, String director, int length){
        super(id,title,category,cost);
        this.director = director;
        this.length = length;
    }	
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	public String setDirector(String director) {
		this.director = director;
		return director;
	}
	
	public int setLength(int length) {
		this.length = length;
		return length;
	}
	
}
