package hust.soict.hedspi.aims.order;
import java.time.LocalDateTime;
import java.util.Random;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
    // Khai báo một hằng số là số lượng sản phẩm tối đa
	public static final int MAX_NUMBER_ORDERED = 10;
	// Khai báo hằng số là số lượng tối đa order
	public static final int MAX_LIMITTED_ORDERS = 5;
	// Khai báo 1 mảng các dvd 
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	// Khai báo 1 biến chứa số lượng dvd hiện có trong đơn hàng
	private int qtyOrdered = 0;
	// khai báo biến chứa số order hiện có
	private static int nbOrders = 0;
	// khai báo biến chứa thời gian tạo order tương ứng
	private MyDate dateOrdered = new MyDate();
	
	// xây dựng các phương thức get, set
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		if(qtyOrdered > 0 && qtyOrdered < MAX_NUMBER_ORDERED)
			this.qtyOrdered = qtyOrdered;
		else 
			this.qtyOrdered = 0;
	}
	
	public static int getNbOrders() {
		return nbOrders;
	}
	public static void setNbOrders(int nbOrders) {
		if(nbOrders > 0 && nbOrders < MAX_LIMITTED_ORDERS)
			Order.nbOrders = nbOrders;
		else
			Order.nbOrders = 0;
	}
	// constructor
	public Order() {
		super();
		
        if(nbOrders < MAX_LIMITTED_ORDERS) {
        	LocalDateTime dateObj = LocalDateTime.now();
            dateOrdered.setDay(dateObj.getDayOfMonth());
            dateOrdered.setMonth(dateObj.getMonthValue());
            dateOrdered.setYear(dateObj.getYear());
            nbOrders++;
        } else {
        	System.out.println("Exceeded the number of orders allowed");
        } 
	}
	
	// xây dựng phương thức thêm 1 dvd vào đơn hàng
	// Nội dung: thêm 1 dvd vào mảng itemsOrdered
	// kiểm tra mảng đấy hay chưa?
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.qtyOrdered == MAX_NUMBER_ORDERED)
			System.out.println("The order is full");
		else {
			this.itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added");
			System.out.println("Total disc: " + this.qtyOrdered);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			addDigitalVideoDisc(dvdList[i]);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	// Phương thức xóa một dvd khỏi đơn hàng
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(this.qtyOrdered == 0)
			System.out.println("The order is empty");
		else {
			for (int i = 0; i < this.qtyOrdered; i++) {
				if(this.itemsOrdered[i] == disc) {
					for (int j = i; j < this.qtyOrdered; j++) {
						this.itemsOrdered[j] = this.itemsOrdered[j+1];
					}
					this.qtyOrdered--;
					System.out.println("The disc has been removed");
				}
			}
		}
	}
	
	// Phương thức tính tổng gía trị đơn hàng
	public float totalCost() {
		float total = 0;
		for (int i = 0; i < this.qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	
	
	// phuơng thức in onder 
	public void printOder() {
		System.out.println("***********************Order***********************\n"
				+ "Date: " + this.dateOrdered.getDay() + "/" +this.dateOrdered.getMonth() + "/" +this.dateOrdered.getYear() + "\n"
				+ "Ordered Items:");
		for (int i = 0; i < this.qtyOrdered; i++) {
			System.out.println((i+1) + ". DVD - " + this.itemsOrdered[i].getTitle() + 
											" - " + this.itemsOrdered[i].getCategory() +
											" - " + this.itemsOrdered[i].getDirector() +
											" - " + this.itemsOrdered[i].getLength() + 
											": " + this.itemsOrdered[i].getCost() + "$");
		}
		System.out.println("Total cost: " + this.totalCost() +"$\n"
				+ "***************************************************\n");
	}
	
	// xay dung phuong thuc chon mot san pham ngau nhien trong danh sach
		// va mien phi cho sp nay
		public DigitalVideoDisc getLuckyItem() {
			Random rd = new Random();
			int luckynumber = rd.nextInt(this.qtyOrdered);
			this.itemsOrdered[luckynumber].setCost(0);
			return this.itemsOrdered[luckynumber];
		}
}
