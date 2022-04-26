package hedspi.oolt.labs;

public class Order {
    // Khai báo một hằng số là số lượng sản phẩm tối đa
	public static final int MAX_NUMBER_ORDERED = 10;
	// Khai báo 1 mảng các dvd 
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	// Khai báo 1 biến chứa số lượng dvd hiện có trong đơn hàng
	private int qtyOrdered = 0;
	
	// xây dựng các phương thức get, set
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		if(qtyOrdered > 0)
			this.qtyOrdered = qtyOrdered;
		else 
			this.qtyOrdered = 0;
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
}
