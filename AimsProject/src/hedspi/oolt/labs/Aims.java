package hedspi.oolt.labs;


public class Aims {
    public static void main(String[] args) {
    	
		DigitalVideoDisc dvd0 = new DigitalVideoDisc();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("title1");
		dvd1.setCategory("18+");
		dvd1.setDirector("DuanLe");
		dvd1.setLength(123);
		dvd1.setCost(69.96f);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Anh tho sua ong nuoc", "18+", "DuanLe", 150, 70.32f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Anh chong bat luc", "Jav", "DuanLe", 200, 64.34f);
		
//		dvd0.printInfo();
//		dvd1.printInfo();
//		dvd2.printInfo();
//		dvd3.printInfo();
		
		// Tạo đơn hàng mới
		Order anOrder = new Order();
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.println("Total cost: " + anOrder.totalCost() + "$");
		
		anOrder.removeDigitalVideoDisc(dvd3);
		anOrder.removeDigitalVideoDisc(dvd2);
		
		System.out.println("Total cost: " + anOrder.totalCost() + "$");
		
		
		// Tạo order test overloading
		Order order2 = new Order();
		
		DigitalVideoDisc dvdList[] = new DigitalVideoDisc[5];
		
		for (int i = 0; i < dvdList.length; i++) {
			dvdList[i] = new DigitalVideoDisc("title1", "18+", "DuanLe", 150, 70f);
		}
		order2.addDigitalVideoDisc(dvdList);
		
		order2.addDigitalVideoDisc(dvd2, dvd3);
		order2.printOder();
	}
}
