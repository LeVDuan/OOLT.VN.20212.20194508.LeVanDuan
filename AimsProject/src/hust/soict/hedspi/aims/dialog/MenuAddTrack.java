package hust.soict.hedspi.aims.dialog;

import java.awt.*;       
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;    
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

public class MenuAddTrack extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private int trackInputted = 0;
    
    private JTextField txtName;
    private JTextField txtLength;

    @SuppressWarnings("unused")
    private JLabel lblNumOfTrack;
    
    public MenuAddTrack(CompactDisc newCD, int numOfTrack) {
    	getContentPane().setBackground(new Color(0, 128, 128));	
        JFrame thisFrame = this;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Add Track To CD");
        
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{84, 259, 49, 0};
        gridBagLayout.rowHeights = new int[]{41, 0, 0, 0, 0, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
        getContentPane().setLayout(gridBagLayout);
        
        JPanel pnlInfo = new JPanel();
        pnlInfo.setForeground(new Color(255, 255, 255));
        pnlInfo.setBackground(new Color(0, 128, 128));
        GridBagConstraints gbc_pnlInfo = new GridBagConstraints();
        gbc_pnlInfo.anchor = GridBagConstraints.SOUTHWEST;
        gbc_pnlInfo.insets = new Insets(0, 0, 5, 5);
        gbc_pnlInfo.gridx = 1;
        gbc_pnlInfo.gridy = 0;
        getContentPane().add(pnlInfo, gbc_pnlInfo);
        pnlInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JLabel lblInfo = new JLabel("Enter information of track:");
        lblInfo.setForeground(new Color(255, 255, 255));
        lblInfo.setFont(new Font("Zen Kurenaido", Font.BOLD, 29));
        pnlInfo.add(lblInfo);
        
        JLabel lblNumOfTrack = new JLabel("0/" + numOfTrack);
        lblNumOfTrack.setForeground(new Color(255, 255, 255));
        pnlInfo.add(lblNumOfTrack);
        
        JLabel lbltxtName = new JLabel("  Track's Name:");
        lbltxtName.setForeground(new Color(255, 255, 255));
        lbltxtName.setHorizontalAlignment(SwingConstants.CENTER);
        lbltxtName.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_lbltxtName = new GridBagConstraints();
        gbc_lbltxtName.insets = new Insets(0, 0, 5, 5);
        gbc_lbltxtName.anchor = GridBagConstraints.EAST;
        gbc_lbltxtName.gridx = 0;
        gbc_lbltxtName.gridy = 1;
        getContentPane().add(lbltxtName, gbc_lbltxtName);
        
        JPanel blankPanel1 = new JPanel();
        blankPanel1.setBackground(new Color(0, 128, 128));
        GridBagConstraints gbc_blankPanel1 = new GridBagConstraints();
        gbc_blankPanel1.insets = new Insets(0, 0, 5, 0);
        gbc_blankPanel1.gridheight = 4;
        gbc_blankPanel1.anchor = GridBagConstraints.NORTHWEST;
        gbc_blankPanel1.gridx = 2;
        gbc_blankPanel1.gridy = 1;
        getContentPane().add(blankPanel1, gbc_blankPanel1);
        
        txtName = new JTextField();
        txtName.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.insets = new Insets(0, 0, 5, 5);
        gbc_txtName.gridx = 1;
        gbc_txtName.gridy = 2;
        getContentPane().add(txtName, gbc_txtName);
        txtName.setColumns(10);
        
        JLabel lbltxtLength = new JLabel("    Track's Length:");
        lbltxtLength.setForeground(new Color(255, 255, 255));
        lbltxtLength.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_lbltxtLength = new GridBagConstraints();
        gbc_lbltxtLength.anchor = GridBagConstraints.EAST;
        gbc_lbltxtLength.insets = new Insets(0, 0, 5, 5);
        gbc_lbltxtLength.gridx = 0;
        gbc_lbltxtLength.gridy = 3;
        getContentPane().add(lbltxtLength, gbc_lbltxtLength);
        
        txtLength = new JTextField();
        txtLength.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        GridBagConstraints gbc_txtLength = new GridBagConstraints();
        gbc_txtLength.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtLength.insets = new Insets(0, 0, 5, 5);
        gbc_txtLength.gridx = 1;
        gbc_txtLength.gridy = 4;
        getContentPane().add(txtLength, gbc_txtLength);
        txtLength.setColumns(10);
        
        JPanel pnlBtn = new JPanel();
        pnlBtn.setToolTipText("");
        pnlBtn.setBackground(new Color(0, 128, 128));
        GridBagConstraints gbc_pnlBtn = new GridBagConstraints();
        gbc_pnlBtn.fill = GridBagConstraints.BOTH;
        gbc_pnlBtn.insets = new Insets(0, 0, 0, 5);
        gbc_pnlBtn.gridx = 1;
        gbc_pnlBtn.gridy = 5;
        getContentPane().add(pnlBtn, gbc_pnlBtn);
        pnlBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        pnlBtn.add(btnAdd);
        
        JPanel blankPanel2 = new JPanel();
        blankPanel2.setBackground(new Color(0, 128, 128));
        pnlBtn.add(blankPanel2);
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Zen Kurenaido", Font.BOLD, 20));
        btnCancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisFrame.dispose();
            }
        });
        pnlBtn.add(btnCancel);
        
        // add listener
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtName.getText().isBlank() || txtLength.getText().isBlank()) {
                	JOptionPane.showMessageDialog(null, "Please complete all fields first!");
                    return;
                }
                
                if (Integer.valueOf(txtLength.getText()) <= 0) {
                	JOptionPane.showMessageDialog(null, "Please enter a positive number for length!");
                    return;
                }
                
                Track newTrack = new Track(txtName.getText(), Integer.parseInt(txtLength.getText()));
                if (newCD.searchTrack(newTrack) != -1) {
                	JOptionPane.showMessageDialog(null, "Track already exists!");
                    return;
                } else {
                    newCD.addTrack(newTrack);
                }

                trackInputted++;
                lblNumOfTrack.setText(trackInputted + "/" + numOfTrack);
                	
                if (trackInputted == numOfTrack) {
                    lblInfo.setText("              Inputting track(s) completed:");
                    lbltxtName.setVisible(false);
                    txtName.setVisible(false);
                    lbltxtLength.setVisible(false);
                    txtLength.setVisible(false);
                    btnAdd.setVisible(false);
                    blankPanel2.setVisible(false);
                    btnCancel.setText("OK");
                }
               
                txtName.setText("");
                txtLength.setText("");
            }
        });
        
        this.setBounds(590, 350, 628, 315);
        this.setVisible(true);
 }
    
    
}