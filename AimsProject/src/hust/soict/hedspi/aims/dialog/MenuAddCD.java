package hust.soict.hedspi.aims.dialog;

import java.awt.*;      
import java.awt.event.*; 
import javax.swing.*;    

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.order.Order;

public class MenuAddCD extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private JTextField titleField;
    private JTextField idField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField artistField;
    private JTextField numOfTrackField;
    
    boolean result = false;
    boolean trackInputted = false;
    CompactDisc cd; 
    Order currentOrder;
    
    public MenuAddCD(Order order) {
    	getContentPane().setBackground(new Color(0, 128, 128));
    	currentOrder = order;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
        this.setTitle("Add a CD");
        // create grid bag layout
        GridBagLayout gridBagLayout = new GridBagLayout();
        
        gridBagLayout.columnWidths = new int[] {200, 0, 100, 0};
        gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
        getContentPane().setLayout(gridBagLayout);
        
        // create ID label and its field
        JLabel idLbl = new JLabel("ID ");
        idLbl.setForeground(new Color(255, 255, 255));
        idLbl.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_idLbl = new GridBagConstraints();
        gbc_idLbl.anchor = GridBagConstraints.EAST;
        gbc_idLbl.insets = new Insets(0, 0, 5, 5);
        gbc_idLbl.gridx = 0;
        gbc_idLbl.gridy = 1;
        getContentPane().add(idLbl, gbc_idLbl);
        idLbl.setVisible(false);
        
        idField = new JTextField();
        GridBagConstraints gbc_idField = new GridBagConstraints();
        gbc_idField.insets = new Insets(0, 0, 5, 0);
        gbc_idField.fill = GridBagConstraints.HORIZONTAL;
        gbc_idField.gridx = 2;
        gbc_idField.gridy = 1;
        getContentPane().add(idField, gbc_idField);
        idField.setColumns(10);
        idField.setVisible(false);
        
        // create Title label and its field
        JLabel lblTitle = new JLabel("Title ");
        lblTitle.setForeground(new Color(255, 255, 255));
        lblTitle.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.anchor = GridBagConstraints.EAST;
        gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitle.gridx = 0;
        gbc_lblTitle.gridy = 2;
        getContentPane().add(lblTitle, gbc_lblTitle);
        
        titleField = new JTextField();
        GridBagConstraints gbc_titleField = new GridBagConstraints();
        gbc_titleField.anchor = GridBagConstraints.WEST;
        gbc_titleField.fill = GridBagConstraints.HORIZONTAL;
        gbc_titleField.insets = new Insets(0, 0, 5, 0);
        gbc_titleField.gridx = 2;
        gbc_titleField.gridy = 2;
        getContentPane().add(titleField, gbc_titleField);
        titleField.setColumns(10);
        
        // create Cost label and its field
        JLabel lblCost = new JLabel("Cost ");
        lblCost.setForeground(new Color(255, 255, 255));
        lblCost.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_lblCost = new GridBagConstraints();
        gbc_lblCost.anchor = GridBagConstraints.EAST;
        gbc_lblCost.insets = new Insets(0, 0, 5, 5);
        gbc_lblCost.gridx = 0;
        gbc_lblCost.gridy = 3;
        getContentPane().add(lblCost, gbc_lblCost);
        
        costField = new JTextField();
        GridBagConstraints gbc_costField = new GridBagConstraints();
        gbc_costField.fill = GridBagConstraints.HORIZONTAL;
        gbc_costField.insets = new Insets(0, 0, 5, 0);
        gbc_costField.gridx = 2;
        gbc_costField.gridy = 3;
        getContentPane().add(costField, gbc_costField);
        costField.setColumns(10);
        
        // create Category label and its field
        JLabel lblCategory = new JLabel("Category ");
        lblCategory.setForeground(new Color(255, 255, 255));
        lblCategory.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_lblCategory = new GridBagConstraints();
        gbc_lblCategory.anchor = GridBagConstraints.EAST;
        gbc_lblCategory.insets = new Insets(0, 0, 5, 5);
        gbc_lblCategory.gridx = 0;
        gbc_lblCategory.gridy = 4;
        getContentPane().add(lblCategory, gbc_lblCategory);
        
        categoryField = new JTextField();
        GridBagConstraints gbc_categoryField = new GridBagConstraints();
        gbc_categoryField.fill = GridBagConstraints.HORIZONTAL;
        gbc_categoryField.insets = new Insets(0, 0, 5, 0);
        gbc_categoryField.gridx = 2;
        gbc_categoryField.gridy = 4;
        getContentPane().add(categoryField, gbc_categoryField);
        categoryField.setColumns(10);
        
        // create Artist label and its field
        JLabel lblArtist = new JLabel("Artist ");
        lblArtist.setForeground(new Color(255, 255, 255));
        lblArtist.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_lblArtist = new GridBagConstraints();
        gbc_lblArtist.anchor = GridBagConstraints.EAST;
        gbc_lblArtist.insets = new Insets(0, 0, 5, 5);
        gbc_lblArtist.gridx = 0;
        gbc_lblArtist.gridy = 5;
        getContentPane().add(lblArtist, gbc_lblArtist);
        lblArtist.setVisible(false);
        
        artistField = new JTextField();
        GridBagConstraints gbc_artistField = new GridBagConstraints();
        gbc_artistField.fill = GridBagConstraints.HORIZONTAL;
        gbc_artistField.insets = new Insets(0, 0, 5, 0);
        gbc_artistField.gridx = 2;
        gbc_artistField.gridy = 5;
        getContentPane().add(artistField, gbc_artistField);
        artistField.setColumns(10);
        artistField.setVisible(false);
        
        // create Number of Track label and its field
        JLabel lblNumOfTrack = new JLabel("Number of track ");
        lblNumOfTrack.setForeground(new Color(255, 255, 255));
        lblNumOfTrack.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_lblNumOfTrack = new GridBagConstraints();
        gbc_lblNumOfTrack.anchor = GridBagConstraints.EAST;
        gbc_lblNumOfTrack.insets = new Insets(0, 0, 5, 5);
        gbc_lblNumOfTrack.gridx = 0;
        gbc_lblNumOfTrack.gridy = 6;
        getContentPane().add(lblNumOfTrack, gbc_lblNumOfTrack);
        lblNumOfTrack.setVisible(false);
        
        JPanel pnlAddTrack = new JPanel();
        pnlAddTrack.setBackground(new Color(0, 128, 128));
        GridBagConstraints gbc_pnlAddTrack = new GridBagConstraints();
        gbc_pnlAddTrack.anchor = GridBagConstraints.WEST;
        gbc_pnlAddTrack.fill = GridBagConstraints.VERTICAL;
        gbc_pnlAddTrack.insets = new Insets(0, 0, 5, 0);
        gbc_pnlAddTrack.gridx = 2;
        gbc_pnlAddTrack.gridy = 6;
        getContentPane().add(pnlAddTrack, gbc_pnlAddTrack);
        pnlAddTrack.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlAddTrack.setVisible(false);
        
        numOfTrackField = new JTextField();
        pnlAddTrack.add(numOfTrackField);
        numOfTrackField.setColumns(10);
        
        // create Button Add Track
        JButton btnAddTrack = new JButton("Add Track");
        btnAddTrack.setFont(new Font("Zen Kurenaido", Font.BOLD, 15));
        btnAddTrack.setBackground(new Color(255, 255, 255));
        pnlAddTrack.add(btnAddTrack);
        
        JPanel pnlAddOrNotBtn = new JPanel();
        pnlAddOrNotBtn.setBackground(new Color(0, 128, 128));
        GridBagConstraints gbc_pnlAddOrNotBtn = new GridBagConstraints();
        gbc_pnlAddOrNotBtn.insets = new Insets(0, 0, 5, 0);
        gbc_pnlAddOrNotBtn.fill = GridBagConstraints.BOTH;
        gbc_pnlAddOrNotBtn.gridx = 2;
        gbc_pnlAddOrNotBtn.gridy = 8;
        getContentPane().add(pnlAddOrNotBtn, gbc_pnlAddOrNotBtn);
        pnlAddOrNotBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        btnAdd.setBackground(new Color(255, 255, 255));
        pnlAddOrNotBtn.add(btnAdd);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        btnCancel.setBackground(new Color(255, 255, 255));
        pnlAddOrNotBtn.add(btnCancel);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });
        JFrame thisFrame = this;
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check if basic fields are filled
                if (titleField.getText().isBlank() || categoryField.getText().isBlank() || costField.getText().isBlank()) {
                	JOptionPane.showMessageDialog(null, "Please complete all fields first!");
                    return;
                }
                
                // check cost > 0
                if (Float.valueOf(costField.getText()) <= 0) {
                	JOptionPane.showMessageDialog(null, "Please enter a positive number for length!");
                    return;
                }
                
                    // check empty field -> warning
                    if (artistField.getText().isBlank() || numOfTrackField.getText().isBlank()) {
                    	JOptionPane.showMessageDialog(null, "Please complete all fields first!");
                        return;
                    }
                    
                    // check if track list is inputed
                    if (!trackInputted) {
                    	JOptionPane.showMessageDialog(null, "Please input track(s)!");
                        return;
                    }
                    // add CD
                    try {
                    	currentOrder.addMedia(cd);
                    	 cd.play();
                         int result = JOptionPane.showConfirmDialog(null,"Do you want to play tracks in CD ?","Play",
                                 JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                         if(result == JOptionPane.YES_OPTION) {
                             JOptionPane.showMessageDialog(null, cd.message);
                         }
                    } catch (Exception e2) {
                    	JOptionPane.showMessageDialog(null, e2.getMessage() + "\n" + e2, "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                if (cd != null) {
                	JOptionPane.showMessageDialog(null,"Item " + cd.getTitle() + " has been added to Order!\n" 
                                        );            
                }
               thisFrame.dispose();
            }
        });
       
        
        // set Visible for label
        idLbl.setVisible(true);
        idField.setVisible(true);
        lblArtist.setVisible(true);
        artistField.setVisible(true);
        lblNumOfTrack.setVisible(true);
        pnlAddTrack.setVisible(true);
        
       
        
        btnAddTrack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // check empty field -> warning
                if (artistField.getText().isBlank() || numOfTrackField.getText().isBlank()) {
                	JOptionPane.showMessageDialog(null, "Please complete all fields first!");
                    return;
                }
                // check cost > 0
                if (Float.valueOf(costField.getText()) <= 0) {
                	JOptionPane.showMessageDialog(null, "Please enter a positive number for length!");
                    return;
                }
                // create new CD
                int num;
                float cost;
                int id;
                id = Integer.parseInt(idField.getText());
                cost = Float.parseFloat(costField.getText());
                cd = new CompactDisc(id, titleField.getText(),categoryField.getText(),cost,artistField.getText());
                num  = Integer.parseInt(numOfTrackField.getText());
                new MenuAddTrack(cd, num); 
                trackInputted = true;
           }
        });
     
        // Display the window 
        this.setBounds(590, 300, 540, 428);
        this.setVisible(true);
    }
 
}