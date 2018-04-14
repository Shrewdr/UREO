import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextField;

public class accountCP extends JPanel {
	private double cookie;
	/**
	 * Create the panel.
	 */
	public accountCP(double cookie) {
		this.cookie = cookie;
		account userAccount = accountDB.getInstance().getUserAccount(cookie);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblAccountInformation = new JLabel("Profile");
		lblAccountInformation.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JPanel avatar = new JPanel();
		
		JLabel avatarDisplay = new JLabel();					
		avatarDisplay.setVerticalAlignment(SwingConstants.CENTER);
		avatar.add(avatarDisplay, BorderLayout.CENTER);
		avatar.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnChangePicture = new JButton("Change Picture");

		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		
		JButton btnLogOut = new JButton("Log out");

		
		JButton btnEditAccountInformation = new JButton("Edit Account Information");

		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("left:105px:grow"),
				ColumnSpec.decode("123px:grow"),},
			new RowSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(27dlu;default):grow"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(14dlu;default)"),}));
		
		JLabel lblName = new JLabel("Username");
		panel_1.add(lblName, "1, 2, center, center");
		
		JLabel nameProfile = new JLabel("<USERNAME>");
		panel_1.add(nameProfile, "2, 2, center, default");
		
		JLabel lblRating = new JLabel("Rating");
		panel_1.add(lblRating, "1, 4, center, default");
		
		JLabel ratingDisplay = new JLabel("");
		panel_1.add(ratingDisplay, "2, 4, center, default");
		
		JLabel lblMemberSince = new JLabel("Member since");
		panel_1.add(lblMemberSince, "1, 6, center, default");
		
		JLabel regDate = new JLabel("");
		panel_1.add(regDate, "2, 6, center, default");
		
		JLabel lblEmail = new JLabel("Email");
		panel_1.add(lblEmail, "1, 8, center, default");
		
		JTextField emailDisplay = new JTextField("<EMAIL>");
		emailDisplay.setBorder(null);
		emailDisplay.setEditable(false);
		panel_1.add(emailDisplay, "2, 8, center, default");
		
		JLabel lblAddress = new JLabel("Address");
		panel_1.add(lblAddress, "1, 10, center, default");
		
		JTextArea addressDisplay = new JTextArea();
		addressDisplay.setLineWrap(true);
		addressDisplay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addressDisplay.setEditable(false);
		addressDisplay.setBackground(UIManager.getColor("Button.background"));
		addressDisplay.setText("<ADDRESS>");
		panel_1.add(addressDisplay, "2, 10, left, top");
		
		JLabel lblMobile = new JLabel("Mobile");
		panel_1.add(lblMobile, "1, 12, center, default");
		
		JTextField mobileDisplay = new JTextField("<MOBILE>");
		mobileDisplay.setBorder(null);
		mobileDisplay.setEditable(false);
		panel_1.add(mobileDisplay, "2, 12, center, default");
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("153px"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("262px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("41px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("129px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("67px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("29px"),}));
		panel.add(avatar, "2, 4, center, center");
		panel.add(btnChangePicture, "2, 6, center, top");
		panel.add(panel_1, "4, 4, 1, 3, fill, top");
		panel.add(lblAccountInformation, "2, 2, left, top");
		panel.add(btnLogOut, "4, 2, right, bottom");
		panel.add(btnEditAccountInformation, "4, 8, center, top");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lblPropertiesHistory = new JLabel("Properties History");
		lblPropertiesHistory.setFont(new Font("Tahoma", Font.PLAIN, 32));
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new FormLayout(new ColumnSpec[] {},
			new RowSpec[] {}));
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("470px"),},
			new RowSpec[] {
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("39px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("518px"),}));
		panel_2.add(lblPropertiesHistory, "2, 2, left, top");
		panel_2.add(panel_3, "2, 4, fill, fill");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 436, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(1)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 505, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.linkSize(SwingConstants.HORIZONTAL, new Component[] {panel, panel_4});
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblControlPanel = new JLabel("Control Panel");
		lblControlPanel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		panel_4.add(lblControlPanel, "2, 2");
		setLayout(groupLayout);
		///////////////MY CODE//////////////////////////////
 
	
		ImageIcon avatarIMG = new ImageIcon("images/default.png"); // Load the default image
		if(isImage("images/".concat(userAccount.getUsername()).concat(".png"))) { // If user has his OWN image, then load it
			avatarIMG = new ImageIcon("images/".concat(userAccount.getUsername()).concat(".png"));
			//Idk, but.. image has to be rescaled on each user profile load in order to ACTUALLY load it and detect changes
			Image scaledImage = avatarIMG.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
			avatarIMG = new ImageIcon(scaledImage);
		}
		// Display account information taken from userAccount
		avatarDisplay.setIcon(avatarIMG);	// Default Avatar for User
		nameProfile.setText(userAccount.getUsername());	
		emailDisplay.setText(userAccount.getEmail());
		addressDisplay.setText(userAccount.getAddress());
		mobileDisplay.setText(userAccount.getMobile());
		regDate.setText(userAccount.getJoinDate());
		ratingDisplay.setIcon(new ImageIcon("images/star".concat(String.valueOf(userAccount.getRating())).concat(".png")));
	
		
		
		///////////////////////////////////////////////////

	////LISTENERS START///////
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnLogOut) {//Upon logout, clear contentPanel and move to home(Browse Properties)
					Container parent = ((JButton)(e.getSource())).getParent().getParent();
					Container changeParent = ((JButton)(e.getSource())).getTopLevelAncestor();
					
					parent.removeAll();	
					changeParent.firePropertyChange("cookie", cookie, 0); // Inform the main frame of the logout attempt!
			
					parent.revalidate();
				}
			}
		});
		btnEditAccountInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Toggle Button
			
				if(e.getSource() == btnEditAccountInformation && btnEditAccountInformation.getText().equals("Edit Account Information")) {
					btnEditAccountInformation.setText("Submit Changes");
					// Allow the fields to be editable
					emailDisplay.setEditable(true);
					addressDisplay.setEditable(true);
					addressDisplay.setBackground(Color.white);
					mobileDisplay.setEditable(true);
					
					
				}
				else if(e.getSource() == btnEditAccountInformation && btnEditAccountInformation.getText().equals("Submit Changes")) {
				
					btnEditAccountInformation.setText("Edit Account Information");
					//Disable the fields and revert back to the defaults.
				emailDisplay.setEditable(false);
				addressDisplay.setEditable(false);
	 
				addressDisplay.setBackground(Color.decode("#f0f0f0")); // Revert back to the orignial color
				mobileDisplay.setEditable(false);
				// Change the account credentials if there was actual change and then save the changes.
				String newAddress = addressDisplay.getText();
				String newEmail = emailDisplay.getText();
				String newMobile = mobileDisplay.getText();
				if(!newAddress.equals(userAccount.getAddress()) && !newAddress.isEmpty()) userAccount.setAddress(newAddress);
				if(!newEmail.equals(userAccount.getEmail()) && !newEmail.isEmpty()) userAccount.setEmail(newEmail);
				if(!newMobile.equals(userAccount.getMobile()) && !newMobile.isEmpty()) userAccount.setMobile(newMobile);
				accountDB.getInstance().save();
				}
			}
		});
		btnChangePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnChangePicture) {//Allows the user to change his profile picture
					JFileChooser fc = new JFileChooser();
					fc.setDialogTitle("Select an image");
					fc.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png"); // Accept only .png
					fc.addChoosableFileFilter(filter);	// Add the filter
					int returnVal = fc.showDialog((Component) e.getSource(), "Select");	// Show the dialog
					if (returnVal == JFileChooser.APPROVE_OPTION) {	// If valid file was chosen,
						try {
						////////////////////////////
 
			//		    File newFile = new File("images/"+userAccount.getUsername()+".png");
					    BufferedImage userAvatar = ImageIO.read(fc.getSelectedFile());	// Read the image file 
					 // get its type(Used for internal resizing algorthim processing)
				        int type = userAvatar.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : userAvatar.getType(); 
				        
				        BufferedImage resizedImage = resizeImage(userAvatar, type, 100, 100); // Resize the image
				     // Save the resized in localdirectory with the name <USERNAME>.png
					    File outputfile = new File("images/"+userAccount.getUsername()+".png"); 
					    ImageIO.write(resizedImage, "png", outputfile);	
					    // Then load and display the image
					    ImageIcon userImage = new ImageIcon(resizedImage);
					    avatarDisplay.setIcon(userImage);
					    avatarDisplay.revalidate();
						}catch(Exception excp) {excp.printStackTrace();}
					
					
					
					}
					
				
			}
			}
		});	
	
	}
	
	
	
    private static boolean isImage(String image_path){ // Helper variable; to identify if personal user avatar exists or not.
    Image image = new ImageIcon(image_path).getImage();
    if(image.getWidth(null) == -1){
         return false;
    }
    else{
         return true;
    }
}
    
    //Helper method for image resizing
    private static BufferedImage resizeImage(BufferedImage originalImage, int type, int IMG_WIDTH, int IMG_HEIGHT) { 
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }
	
}
