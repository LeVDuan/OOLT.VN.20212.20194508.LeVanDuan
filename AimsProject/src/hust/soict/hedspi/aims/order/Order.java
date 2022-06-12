package hust.soict.hedspi.aims.order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
    // Khai báo một hằng số là số lượng sản phẩm tối đa
	public static final int MAX_NUMBER_ORDERED = 10;
	// Khai báo hằng số là số lượng tối đa order
	public static final int MAX_LIMITTED_ORDERS = 5;
	// Khai báo 1 mảng các media 
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	// khai báo biến chứa số order hiện có
	private static int nbOrders = 0;
	// khai báo biến chứa thời gian tạo order tương ứng
	private MyDate dateOrdered = new MyDate();
	
	// xây dựng các phương thức get, set
	
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
	
	// add and remove media items
	public void addMedia(Media item) {
		if(itemsOrdered.size() == MAX_NUMBER_ORDERED)
				itemsOrdered.add(item);
	}
	
	public void addMedia(ArrayList<Media> items) {
		for (Iterator<Media> iterator = items.iterator(); iterator.hasNext();) {
			itemsOrdered.add(iterator.next());
		}
	}
	public void removeMedia(Media item) {
		if(itemsOrdered.contains(item))
			itemsOrdered.remove(item);
	}
	
	public float totalCost() {
		float total = 0;
		for (Iterator<Media> iterator = itemsOrdered.iterator(); iterator.hasNext();) {
			total+= iterator.next().getCost();
		}
		return total;
	}
	
	public static Order createOrder() {
        if (nbOrders >= MAX_LIMITTED_ORDERS) {
            System.out.println("Max ordered!");
            return null;
        } else {
            nbOrders++;
            return new Order();
        }
    }
    
    public Media getALuckyItem(){
        Random rd = new Random();
        int luckyNumber = rd.nextInt(this.itemsOrdered.size());
        itemsOrdered.get(luckyNumber).setCost(0);
        return itemsOrdered.get(luckyNumber);
    }
}

