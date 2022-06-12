package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.utils.*;

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
	public static Book addBook(String title) {
		Scanner sc = new Scanner(System.in);
		String author;
		System.out.println("Book's author: ");
		author = sc.nextLine();
		sc.close();
		return new Book(title,author);
		
	}
	
	public static CompactDisc addCD(String title) {
		Scanner sc = new Scanner(System.in);
		String artist;
		System.out.println("Book's author: ");
		artist = sc.nextLine();
		Track track = new Track(title);
		sc.close();
		return new CompactDisc(title, artist, track);
	}

	public static DigitalVideoDisc addDVD(String title) {
		return new DigitalVideoDisc(title);
	}
	
    public static void main(String[] args) {
    	Thread t1 = new Thread(new MemoryDaemon(), "Memory observation");
    	t1.setDaemon(true);
    	t1.start();
    	
    	Order order1 = null;
    	Scanner sc = new Scanner(System.in);
    	Scanner sc2 = new Scanner(System.in);
    	int choice = 0, type = 0;
    	String title;
    	
    	do {
    		Aims.showMenu();
    		choice = sc.nextInt();
    		
    		switch (choice) {
			case 1:
				order1 = new Order();
				break;
			case 2:
				System.out.println("Enter item's title: ");
				title = sc2.nextLine();
				
				System.out.println("Item's type: ");
				System.out.println("=============");
				System.out.println("1. Book");
				System.out.println("2. CD");
				System.out.println("3. DVD");
				System.err.println("Your choice: ");
				
				type = sc.nextInt();
				switch (type) {
				case 1:
					 order1.addMedia( (Media)Aims.addBook(title) );
					break;
				case 2:
					order1.addMedia( (Media)Aims.addCD(title) );
					break;
				case 3:
					order1.addMedia((Media) Aims.addDVD(title));
					System.out.println("add item successfully");
					break;
				default:
					System.out.println("Invalid type, add item fail!");
					break;
				}
				break;
			case 3:
				System.out.println("Enter item's title to delete: ");
				title = sc2.nextLine();
				// remove
				break;
			case 4:
				// display
				break;
			default:
				System.out.println("Invalid choice!");
			}
    		
		} while (choice != 0);
    	sc.close();
    	sc2.close();
    }	
}