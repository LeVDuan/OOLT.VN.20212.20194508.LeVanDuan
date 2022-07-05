package hust.soict.hedspi.aims.dialog;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.exceptions.InputException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.order.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuAddMedia { 
	
    private final JDialog selectDialog = new JDialog();
    private final JButton bookBtn;
    private final JButton dvdBtn;
    private final JButton cdBtn;
    boolean trackInputted = false;
    CompactDisc cd;
    Order currentOrder;
    private JLabel lblNewLabel;
    public MenuAddMedia(Order order) {
        // set for Dialog
    	currentOrder = order;
        selectDialog.getContentPane().setBackground(new Color(0, 128, 128));
        selectDialog.setSize(499,451);
        selectDialog.getContentPane().setLayout(null);
        selectDialog.setResizable(false);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - 500))/2;
        int y = (int) ((dimension.getHeight() - 450))/2;
        selectDialog.setLocation(x, y);
		selectDialog.setVisible(false);
        selectDialog.setModal(true);
        selectDialog.setTitle("Select Media");

        // create add Book button
        bookBtn = new JButton("Book");
        bookBtn.setBackground(new Color(255, 255, 255));
        bookBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        bookBtn.setSize(300, 60);
        bookBtn.setLocation(100,143);
        bookBtn.setFocusPainted(false);
        selectDialog.getContentPane().add(bookBtn);
        addBookAction();

        // create add DVD button
        dvdBtn = new JButton("DVD");
        dvdBtn.setBackground(new Color(255, 255, 255));
        dvdBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        dvdBtn.setSize(300, 60);
        dvdBtn.setLocation(100,224);
        dvdBtn.setFocusPainted(false);
        selectDialog.getContentPane().add(dvdBtn);
        addDVDAction();

        // create add CD button
        cdBtn = new JButton("CD");
        cdBtn.setBackground(new Color(255, 255, 255));
        cdBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        cdBtn.setSize(300, 60);
        cdBtn.setLocation(100,307);
        cdBtn.setFocusPainted(false);
        selectDialog.getContentPane().add(cdBtn);
        
        lblNewLabel = new JLabel("Select Media Items");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Zen Kurenaido", Font.BOLD, 29));
        lblNewLabel.setBounds(119, 53, 255, 52);
        selectDialog.getContentPane().add(lblNewLabel);
        addCDAction();

        selectDialog.setVisible(true);
    }

    public void addBookAction() {
        bookBtn.addActionListener(e -> {
            selectDialog.setVisible(false);
            JDialog bookDialog = new JDialog();
            bookDialog.setTitle("Add a book");
            bookDialog.getContentPane().setBackground(new Color(0, 128, 128));

            // Create book media dialog
            MediaDialog bookMedia = new MediaDialog(bookDialog);

            // Create author field 
            JTextField authorField = new JTextField();
            JLabel authorLb = new JLabel("Author");
            authorLb.setSize(100,30);
            authorLb.setLocation(90,180);
            authorLb.setForeground(new Color(255, 255, 255));
            authorLb.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            bookDialog.add(authorLb);

            authorField.setSize(250, 30);
            authorField.setLocation(200,180);
            bookDialog.add(authorField);
            
            // Create book's content field 
            JTextField contentField = new JTextField();
            JLabel contentLb = new JLabel("Book's content");
            contentLb.setForeground(new Color(255, 255, 255));
            contentLb.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            contentLb.setSize(300,30);
            contentLb.setLocation(90,220);
            bookDialog.add(contentLb);

            contentField.setSize(250, 30);
            contentField.setLocation(200,220);
            bookDialog.add(contentField);
            
            // Note 
            JLabel noteJLabel = new JLabel("* Authors must be separated by ' , '");
            noteJLabel.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            noteJLabel.setForeground(new Color(255, 255, 255));
            noteJLabel.setSize(300,40);
            noteJLabel.setLocation(100,260);
            bookDialog.add(noteJLabel);

            // Handler Add button
            bookMedia.addBtn.addMouseListener(new MouseAdapter() {
            	@Override
                public void mouseClicked(MouseEvent e) {	
                bookDialog.setVisible(false);
                // check if all fields are filled
                if (bookMedia.idField.getText().isBlank() ||bookMedia.titleField.getText().isBlank() || bookMedia.categoryField.getText().isBlank() 
                		|| bookMedia.costField.getText().isBlank() || authorField.getText().isBlank() || contentField.getText().isBlank()) {
                	JOptionPane.showMessageDialog(null, "Please complete all fields first!");
                    return;
                }
                // check cost > 0
                if (Float.valueOf(bookMedia.costField.getText()) <= 0) {
                	JOptionPane.showMessageDialog(null, "Please enter a positive number for cost!");
                	return;
                }
                ArrayList<String> authors = new ArrayList<String>();
                String[] authorName = authorField.getText().split(",");
                for (int i = 0; i < authorName.length; i++) {
                    if (authors.contains(authorName[i].trim())) {
                    	JOptionPane.showMessageDialog(null, "Author's name must be unique!");
                        return;
                    }
                    authors.add(authorName[i]);
                }
                // add Book to order 
                try {
                	  float cost = bookMedia.getCost();
                      int id = Integer.parseInt(bookMedia.getId());
                      Book book = new Book(id, bookMedia.getTitle(), bookMedia.getCategory(), cost, authors, contentField.getText());
                      currentOrder.addMedia(book);
                      JOptionPane.showMessageDialog(null,"Item " + bookMedia.getTitle() +" has been added to Order!") ;
                } catch (Exception e2) {
                  JOptionPane.showMessageDialog(null, e2.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                	}
            	}
            });
            bookDialog.setVisible(true);
        });
    }

    public void addDVDAction() {
        dvdBtn.addActionListener(e -> {
            selectDialog.setVisible(false);
            JDialog dvdDialog = new JDialog();
            dvdDialog.setTitle("Add a DVD");
            dvdDialog.getContentPane().setBackground(new Color(0, 128, 128));
            // Create DVD Dialog
            MediaDialog dvdMedia = new MediaDialog(dvdDialog);

            // Create length field
            JTextField lengthField = new JTextField();
            JLabel lengthLb = new JLabel("Length");
            lengthLb.setSize(100,30);
            lengthLb.setLocation(90, 180);
            lengthLb.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            lengthLb.setForeground(new Color(255, 255, 255));
            dvdDialog.add(lengthLb);
            
            lengthField.setSize(250,30);
            lengthField.setLocation(200,180);
            dvdDialog.add(lengthField);
            
            // Create director field
            JTextField directorField = new JTextField();
            JLabel directorLb = new JLabel("Director");
            directorLb.setSize(100,30);
            directorLb.setLocation(90,220);
            directorLb.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            directorLb.setForeground(new Color(255, 255, 255));
            dvdDialog.add(directorLb);

            directorField.setSize(250, 30);
            directorField.setLocation(200,220);
            dvdDialog.add(directorField);

            // handler button Add
            dvdMedia.addBtn.addMouseListener(new MouseAdapter() {
            	@Override
                public void mouseClicked(MouseEvent e) {	
            		dvdDialog.setVisible(false);
            		// check if all fields are filled
            		if (dvdMedia.idField.getText().isBlank() ||dvdMedia.titleField.getText().isBlank() || dvdMedia.categoryField.getText().isBlank() 
                		|| dvdMedia.costField.getText().isBlank() || lengthField.getText().isBlank() || 
                        directorField.getText().isBlank()) {
            			JOptionPane.showMessageDialog(null, "Please complete all fields first!");
            			return;
            		}
            		// check cost > 0
            		if (Float.valueOf(dvdMedia.costField.getText()) <= 0) {
            			JOptionPane.showMessageDialog(null, "Please enter a positive number for cost!");
            			return;
            		}
            		// check length > 0
            		if (Integer.valueOf(lengthField.getText()) <= 0) {
            			JOptionPane.showMessageDialog(null, "Please enter a positive number for length!");
            			return;
            		}	
            		// add DVD to order 	
            		try {
            			float cost = dvdMedia.getCost();
            			int length = Integer.parseInt(lengthField.getText());
            			String director = directorField.getText();
            			int id = Integer.parseInt(dvdMedia.getId());
            			DigitalVideoDisc dvd = new DigitalVideoDisc(id, dvdMedia.getTitle(), dvdMedia.getCategory(),cost,director, length);
            			dvd.play();
            			currentOrder.addMedia(dvd);
            			int result = JOptionPane.showConfirmDialog(null,"Do you want to play DVD ?","Play",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            			if(result == JOptionPane.YES_OPTION) {
            				JOptionPane.showMessageDialog(null, "Playing DVD: " + dvd.getTitle() + "\nDVD length: " + dvd.getLength());
            			}	
            			JOptionPane.showMessageDialog(null,"Item " + dvdMedia.getTitle() +" has been added to Order!");
            		} catch (Exception e2) {
            			JOptionPane.showMessageDialog(null, e2.getMessage() + "\n" + e2, "ERROR", JOptionPane.ERROR_MESSAGE);
            		}
            	}
            });
            dvdDialog.setVisible(true);
        });
    }

    public void addCDAction() {
      cdBtn.addActionListener(e -> {
    	  selectDialog.setVisible(false);
    	  new MenuAddCD(currentOrder);
      });
    }

    public static class MediaDialog{
        JLabel idLb = new JLabel("ID");
        JLabel costLb = new JLabel("Cost");
        JLabel categoryLb = new JLabel("Category");
        JLabel titleLb = new JLabel("Title");
        JPanel pnlAddTrack = new JPanel();

        JTextField idField = new JTextField();
        JTextField costField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField titleField = new JTextField();

        JButton addBtn = new JButton("Add");       

        public String getId() {
            return idField.getText();
        }
        public Float getCost() throws InputException{
            float f;
            try {
                f = Float.parseFloat(costField.getText());
                return f;
            } catch (Exception e) {
                throw new InputException(e.getMessage() + "\nError Input");
            }
        }
        public String getCategory() throws InputException{
            if(!categoryField.getText().equals("")) {
                return categoryField.getText();
            }else {
                throw new InputException("ERROR: Catagory Field is empty");
            }

        }
        public String getTitle() throws InputException{
            if(!titleField.getText().equals("")) {
                return titleField.getText();
            }else {
                throw new InputException("ERROR: Title Field is empty");
            }
        }

        public MediaDialog(JDialog mediaDialog) {
            mediaDialog.setSize(500,450);
            mediaDialog.getContentPane().setLayout(null);
            mediaDialog.setResizable(false);

            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - 500))/2;
            int y = (int) ((dimension.getHeight() - 450))/2;
            mediaDialog.setLocation(x, y);
            
           
            GridBagConstraints gbc_pnlAddTrack = new GridBagConstraints();
            gbc_pnlAddTrack.anchor = GridBagConstraints.WEST;
            gbc_pnlAddTrack.fill = GridBagConstraints.VERTICAL;
            gbc_pnlAddTrack.insets = new Insets(0, 0, 5, 0);
            gbc_pnlAddTrack.gridx = 1;
            gbc_pnlAddTrack.gridy = 10;
            mediaDialog.getContentPane().add(pnlAddTrack, gbc_pnlAddTrack);
            pnlAddTrack.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
            pnlAddTrack.setVisible(false);
            
            // set for id label
            idLb.setSize(100,30);
            idLb.setLocation(90,20);
            mediaDialog.getContentPane().add(idLb);
            idLb.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            idLb.setForeground(new Color(255, 255, 255));
            idField.setSize(250, 30);
            idField.setLocation(200,20);
            mediaDialog.getContentPane().add(idField);

            // set for cost label
            costLb.setSize(100,30);
            costLb.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            costLb.setForeground(new Color(255, 255, 255));
            costLb.setLocation(90,60);
            mediaDialog.getContentPane().add(costLb);
            costField.setSize(250, 30);
            costField.setLocation(200,60);
            mediaDialog.getContentPane().add(costField);
            

            // set for category label
            categoryLb.setSize(100,30);
            categoryLb.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            categoryLb.setForeground(new Color(255, 255, 255));
            categoryLb.setLocation(90,100);
            mediaDialog.getContentPane().add(categoryLb);
            categoryField.setSize(250, 30);
            categoryField.setLocation(200,100);
            mediaDialog.getContentPane().add(categoryField);

            // set for title label
            titleLb.setSize(100,30);
            titleLb.setLocation(90,140);
            mediaDialog.getContentPane().add(titleLb);
            titleField.setSize(250, 30);
            titleField.setLocation(200,140);
            mediaDialog.getContentPane().add(titleField);
            titleLb.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
            titleLb.setForeground(new Color(255, 255, 255));

            // set for add button
            addBtn.setSize(100,30);
            addBtn.setLocation(200,330);
            addBtn.setFocusPainted(false);
            mediaDialog.getContentPane().add(addBtn);
            addBtn.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
            addBtn.setBackground(new Color(255, 255, 255));

            mediaDialog.setVisible(false);
            mediaDialog.setModal(true);
        }

    }

}