package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.dialog.*;

import javax.naming.LimitExceededException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class AimsGui extends JFrame {
	private static final long serialVersionUID = 1L;
	
	JButton createBtn;
    JButton addBtn;
    JButton deleteBtn;
    JButton displayBtn;
    JButton thresholdsBtn;
    JButton luckyBtn;
    JButton exitBtn;
    JLabel orderIdBtn;
    JLabel dateLb;
    JComboBox<Integer> orderIdList = new JComboBox<Integer>();
    int orderId = 0;
    int minItem = Order.LUCKY_MIN_NUMBER_OF_ITEMS;
    float minTotalCost = Order.LUCKY_MIN_TOTAL_COST;
    int numOrder = 0;
    int luckyTimes = 0;
    private List<Order> orders = new ArrayList<Order>();
    public AimsGui(JFrame jFrame) {
    	getContentPane().setBackground(new Color(0, 128, 128));
    	getContentPane().setForeground(new Color(255, 255, 255));
    	setVisible(true);
    	 
    	 JLabel lblNewLabel = new JLabel("Order Management Application");
         lblNewLabel.setForeground(new Color(255, 255, 255));
         lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
         lblNewLabel.setFont(new Font("Zen Kurenaido", Font.BOLD, 25));
         lblNewLabel.setBounds(162, 10, 342, 64);
         getContentPane().add(lblNewLabel);
    	 
    	// create Button
    	createBtn = new JButton("Create a new order");
    	createBtn.setBackground(new Color(255, 255, 255));
    	createBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
        addBtn = new JButton("Add item");
        addBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
        addBtn.setBackground(new Color(255, 255, 255));
        deleteBtn = new JButton("Delete item");
        deleteBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
        deleteBtn.setBackground(new Color(255, 255, 255));
        displayBtn = new JButton("Display the items of list order");
        displayBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
        displayBtn.setBackground(new Color(255, 255, 255));
        luckyBtn = new JButton("Get lucky");
        luckyBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
        luckyBtn.setBackground(new Color(255, 255, 255));
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        exitBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
        exitBtn.setBackground(new Color(255, 255, 255));
       
        // set for Menu Frame 
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(665, 423);
        setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 500)) / 2;
        int y = (int) ((dimension.getHeight() - 800)) / 2;
        setLocation(x, y);
        setVisible(true);
        setTitle("Aims System");

        // set for Create Button
        createBtn.setSize(300, 81);
        createBtn.setLocation(10, 84);
        createBtn.setFocusPainted(false);
        createBtn.addActionListener(e -> {
        	if (orderIdList.getItemCount() == Order.MAX_LIMITED_ORDERS) {
        		  JOptionPane.showMessageDialog(null,"Warning: The number of order reached max!\n" +
                             "Cannot create new order.","\n Warning: ", JOptionPane.WARNING_MESSAGE);
            } 
        	if (numOrder < Order.MAX_LIMITED_ORDERS) {
                try {
                	numOrder++;
                	createOrder();
                    JOptionPane.showMessageDialog(null, "Create new order successfully with id: " + Integer.toString(numOrder));
                } catch (LimitExceededException e1) {
                    e1.printStackTrace();
                }                    
     		   orderIdList.addItem(numOrder);
            }
        	
        });
        getContentPane().add(createBtn);

        // set for Add item Button
        addBtn.setSize(300, 81);
        addBtn.setLocation(341, 84);
        addBtn.setFocusPainted(false);
        addBtn.addActionListener(e -> {
            if (orders.get(orderId) != null) {
                // Create Frame Dialog
                new MenuAddMedia(orders.get(orderId));
            } else {
                JOptionPane.showMessageDialog(null, "Please create an order first!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        getContentPane().add(addBtn);

        // set for Delete item Button
        deleteBtn.setSize(300, 81);
        deleteBtn.setLocation(10, 186);
        deleteBtn.setFocusPainted(false);
        deleteBtn.addActionListener(e -> {
            if (orders.get(orderId) != null) {
                String strID = JOptionPane.showInputDialog(null,
                        "Please enter ID of item you want to delete: ",
                        "Delete ID",
                        JOptionPane.INFORMATION_MESSAGE);
                int id = Integer.parseInt(strID);
                if (orders.get(orderId).removeMedia(id) != null) {
                    JOptionPane.showMessageDialog(null, "Delete item that has ID " + strID + " sucessfully !");
                } else {
                    JOptionPane.showMessageDialog(null, "Don't exist item that has ID " + strID, "\n Warning: ", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please create an order first!", "\n Warning: ", JOptionPane.WARNING_MESSAGE);
            }
        });
        getContentPane().add(deleteBtn);

        // set for Display item Button
        displayBtn.setSize(300, 81);
        displayBtn.setLocation(341, 186);
        displayBtn.setFocusPainted(false);
        displayBtn.addActionListener(e -> {
            if (orders.get(orderId) != null) {
                // Create frame of dialog
                JDialog displayDialog = new JDialog();
                displayDialog.setSize(600, 400);
                displayDialog.setLayout(null);
                displayDialog.setResizable(false);

                Dimension dimension1 = Toolkit.getDefaultToolkit().getScreenSize();
                int x1 = (int) ((dimension1.getWidth() - 600)) / 2;
                int y1 = (int) ((dimension1.getHeight() - 400)) / 2;
                displayDialog.setLocation(x1, y1);

                displayDialog.setVisible(false);
                displayDialog.setModal(true);
                displayDialog.setTitle("List items of Order");

                String[] column_names = {"ID", "Type", "Title", "Category", "Cost($)"};
                List<Media> items;
                items = orders.get(orderId).getItemsOrdered();
//                Collections.sort(items);
                DefaultTableModel model = new DefaultTableModel(null, column_names);
                JTable table = new JTable(model);
                float cost = 0;
                Media temp = null;
                for (Media media : items) {
                    String typeString;
                    if (media instanceof Book)
                        typeString = "Book";
                    else if (media instanceof DigitalVideoDisc) {
                        typeString = "DVD";
                    } else {
                        typeString = "CD";
                    }
                    if (media == temp) {
                        cost = media.getCost();
                        model.addRow(new Object[]{media.getId(), typeString,
                                media.getTitle(), media.getCategory(), 0.0});
                    } else {
                        model.addRow(new Object[]{media.getId(), typeString,
                                media.getTitle(), media.getCategory(), media.getCost()});
                    }
                }

                model.addRow(new Object[]{"", "", "", "Total: ", orders.get(orderId).totalCost() - cost});
                table.setSize(500, 300);
                table.setLocation(50, 30);
                displayDialog.setLayout(new BorderLayout());
                displayDialog.add(table.getTableHeader(), BorderLayout.PAGE_START);
                displayDialog.add(table, BorderLayout.CENTER);
                TableColumn column;
                for (int i = 0; i < 5; i++) {
                    column = table.getColumnModel().getColumn(i);
                    if (i == 0) {
                        column.setPreferredWidth(50);
                    }
                    if (i == 1) {
                        column.setPreferredWidth(50);
                    }
                    if (i == 2) {
                        column.setPreferredWidth(200);
                    }
                    if (i == 3) {
                        column.setPreferredWidth(150);
                    }
                    if (i == 4) {
                        column.setPreferredWidth(50);
                    }

                }
                displayDialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Please create an order first!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });
        getContentPane().add(displayBtn);
        
        //set for Lucky Button  
        luckyBtn.setSize(300, 81);
        luckyBtn.setLocation(10, 289);
        luckyBtn.setFocusPainted(false);
        getContentPane().add(luckyBtn);
       
        luckyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            	if (orders.get(orderId) != null) {
            		if (luckyTimes == 1) {
            			JOptionPane.showMessageDialog(null,"You have already taken a change to get Lucky Item\n See you next time !" 
                               );
                        return;
            		}
            	     if (orders.get(orderId).totalCost() < Order.LUCKY_MIN_TOTAL_COST) {
                     	JOptionPane.showMessageDialog(null,"The Total Cost of your order needs to have at least " + Order.LUCKY_MIN_TOTAL_COST + 
                                 "$ to get a lucky item!");
                         return;
                     }
                     
                     if (orders.get(orderId).getItemsOrdered().size() < Order.LUCKY_MIN_NUMBER_OF_ITEMS) {
                     	JOptionPane.showMessageDialog(null,"Your order needs to have at least " + Order.LUCKY_MIN_NUMBER_OF_ITEMS + 
                                 " items to get a lucky item!");
                         return;
                     }
                     
                     // set the Lucky Item frame
                     JFrame luckyFrame = new JFrame();
                     luckyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                     
                     JTextArea textLucky = new JTextArea();
                     textLucky.setEditable(false);
                     textLucky.setAlignmentX(CENTER_ALIGNMENT);
                     textLucky.setAlignmentY(CENTER_ALIGNMENT);
                     float luckyItemValue = orders.get(orderId).getALuckyItem();
                     if (luckyItemValue == 0.00f) {
                         luckyFrame.setTitle("Next time then!");
                         textLucky.setText(" Better luck next time!");
                     } else {
                         luckyFrame.setTitle("Congratulation!");
                         textLucky.setText(" You won a lucky item that costs " + luckyItemValue + "$ !");
                     }
                     luckyTimes = 1;
                     luckyFrame.getContentPane().add(textLucky);
                     luckyFrame.setBounds(680, 400, 300, 200);
                     luckyFrame.setVisible(true);
         
                 } else {
                	 JOptionPane.showMessageDialog(null, "Please create an order first!", "\n Warning: ", JOptionPane.WARNING_MESSAGE);
                 }
            	}
           
        });

        // set for exit Button
        exitBtn.setSize(300, 81);
        exitBtn.setLocation(341, 289);
        exitBtn.addActionListener(e -> System.exit(0));
        getContentPane().add(exitBtn);
        
    }

    public void createOrder() throws LimitExceededException {
        int newOrderId = orders.size();
        
        try {
            orders.add(new Order(newOrderId));
        } catch (LimitExceededException e) {
            throw e;
        }
    }
    public static void main(String[] args) {
        new AimsGui(new JFrame());
    }
}