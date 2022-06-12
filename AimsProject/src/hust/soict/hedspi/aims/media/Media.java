package hust.soict.hedspi.aims.media;

public abstract class Media {
	
	private String title;
	private String category;
	private float cost;
	
	public Media(String title) {
		this.title = title;
		this.category = "";
		this.cost = 0.0f;
	}
	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}
}
