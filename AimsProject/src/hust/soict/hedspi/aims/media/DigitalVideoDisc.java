package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {
    // khai báo thuộc tính
	private String director;
	private int length;
	
	
	// xây dựng các phương thức
	// 1. các phương thức get, set
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
	// 2. các phương thức khởi tạo (constructor)
	// constructor: tạo vùng nhớ chứa thông tin của object và gán giá trị thuộc tính
	// đặc điểm constructor:
	// + tên trùng với tên lớp
	// + không có dữ liệu trả về, ko dùng từ khóa void
	// Có thể xây dựng nhiều constructor với tham số khác nhau -> giúp khởi tạo nhiều đối tượng theo nhiều cách
	
	// 2.1 Constructor không tham số
	public DigitalVideoDisc() {
		super();
		this.director = "";
		this.length = 0;
	}
	
	// 2.2 Constructor có 1 tham số 
	public DigitalVideoDisc(String title) {
		super();
	}
	
	// 2.3 Constructor có 2 tham số
	public DigitalVideoDisc(String title, String category) {
		super();
	}
	
	// 2.4 Constructor có 3 tham số
	
	public DigitalVideoDisc(String title, String category, String director) {
		super();
		this.director = director;
	}
	
	
	// 2.5 Constructor all tham số
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.director = director;
		this.length = length;
	}
	
	// 3. Các phương thức khác
	// print information
	public void printInfo() {
		System.out.println("--------DVD INFORMATION--------");
		System.out.println("Director: " + this.director);
		System.out.println("Length: " + this.length);
	}
	
//	// xay dung phuong thuc tim kiem theo title
//	public boolean search(String title) {
//		// tach title cua tham so can tim thanh cac tu (word)
//		//-> phuc vu cho viec xu ly tim kiem
//		String sTitle[] = title.split(" ");
//		for (int i = 0; i < sTitle.length; i++) {
//			if(this.title.contains(sTitle[i]) == false) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	
	
}
