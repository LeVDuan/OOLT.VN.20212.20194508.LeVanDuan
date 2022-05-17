package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {

	public static void main(String[] args) {
		
		DigitalVideoDisc dvd0 = new DigitalVideoDisc("Co vo dam dang");
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Co y ta tan tuy voi cong viec cham soc benh nhan");
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Anh tho cai win den dui gap co chu nha kho tinh");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Co thu ki va tinh yeu danh cho dong nghiep");
		// test search method
		if(dvd0.search("dam dang")) {
			System.out.println("Ton tai tieu de chua chuoi nay!");
		} else System.out.println("Khong ton tai dvd can tim!");
		
		
		Order order0 = new Order();
		order0.addDigitalVideoDisc(dvd0);
		order0.addDigitalVideoDisc(dvd1);
		order0.addDigitalVideoDisc(dvd2);
		order0.addDigitalVideoDisc(dvd3);
		
		// test getLuckyItem method
		DigitalVideoDisc tmp = order0.getLuckyItem();
		System.out.print("Lucky Item: \n");
		tmp.printInfo();
	}

}
