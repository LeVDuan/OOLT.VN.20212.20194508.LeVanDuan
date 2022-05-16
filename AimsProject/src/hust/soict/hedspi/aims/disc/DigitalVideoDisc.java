package hust.soict.hedspi.aims.disc;

import java.util.Random;

public class DigitalVideoDisc {
    // khai báo thuộc tính
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	
	// xây dựng các phương thức
	// 1. các phương thức get, set
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		if(length >= 0)
			this.length = length;
		else
			this.length = 0;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		if(cost > 0)
			this.cost = cost;
		else
			this.cost = 0.0f;
	}
	
	// 2. các phương thức khởi tạo (constructor)
	// constructor: tạo vùng nhớ chứa thông tin của object và gán giá trị thuộc tính
	// đặc điểm constructor:
	// + tên trùng với tên lớp
	// + không có dữ liệu trả về, ko dùng từ khóa void
	// Có thể xây dựng nhiều constructor với tham số khác nhau -> giúp khởi tạo nhiều đối tượng theo nhiều cách
	
	// 2.1 Constructor không tham số
	public DigitalVideoDisc() {
		this.title = "";
		this.category = "";
		this.director = "";
		this.length = 0;
		this.cost = 0.0f;
	}
	
	// 2.2 Constructor có 1 tham số 
	public DigitalVideoDisc(String title) {
		this.title = title;
	}
	
	// 2.3 Constructor có 2 tham số
	public DigitalVideoDisc(String title, String category) {
		super();
		this.title = title;
		this.category = category;
	}
	
	// 2.4 Constructor có 3 tham số
	
	public DigitalVideoDisc(String title, String category, String director) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
	}
	
	
	// 2.5 Constructor all tham số
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	// 3. Các phương thức khác
	// print information
	public void printInfo() {
		System.out.println("--------DVD INFORMATION--------");
		System.out.println("Title: " + this.title);
		System.out.println("Category: " + this.category);
		System.out.println("Director: " + this.director);
		System.out.println("Length: " + this.length);
		System.out.println("Cost: " + this.cost);
	}
	
	// xay dung phuong thuc tim kiem theo title
	public boolean search(String title) {
		// tach title cua tham so can tim thanh cac tu (word)
		//-> phuc vu cho viec xu ly tim kiem
		String sTitle[] = title.split(" ");
		for (int i = 0; i < sTitle.length; i++) {
			if(this.title.contains(sTitle[i]) == false) {
				return false;
			}
		}
		return true;
	}
	
	
	
}
