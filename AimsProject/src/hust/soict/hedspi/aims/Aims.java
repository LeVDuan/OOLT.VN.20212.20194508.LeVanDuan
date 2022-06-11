package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;

import java.util.Scanner;
public class Aims {
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("==============================");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("==============================");
		System.out.println("Plesea choose a number: 0-1-2-3-4");
	}
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int choice = 0;
    	do {
    		Aims.showMenu();
    		choice = sc.nextInt();
		} while (choice != 0);
    	
    }	
}