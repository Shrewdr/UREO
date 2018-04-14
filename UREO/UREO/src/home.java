import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import java.awt.Panel;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.CardLayout;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.MatteBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;


public class home {
	private double cookie = 0;
	private boolean loggedin = false;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public home() {
		//initialize propertyList i.e.: propretyDB propertyList = new propertyDB();
		//initialize accountList i.e.: accountDB accountList = new accountDB();
		accountDB.getInstance();
		initialize(/* propertyList, accountList, ... etc*/);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() // This constructor needs to be filled with things like AccountList,PropertyList
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel headerPanel = new JPanel();
		headerPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setContinuousLayout(false);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		headerPanel.add(splitPane_1);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane_1.setLeftComponent(splitPane);
		splitPane.setEnabled(false);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JPanel headerTitlePanel = new JPanel();
		splitPane.setLeftComponent(headerTitlePanel);
		
		JLabel lblUnitedRealEstate = new JLabel("United Real Estate Online");
		lblUnitedRealEstate.setFont(new Font("Tahoma", Font.PLAIN, 21));
		headerTitlePanel.add(lblUnitedRealEstate);
		
		JPanel headerButtonPanel = new JPanel();
		splitPane.setRightComponent(headerButtonPanel);
		headerButtonPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton browseBtn = new JButton("Browse Properties");
		headerButtonPanel.add(browseBtn);
		
		JButton searchBtn = new JButton("Search");
		headerButtonPanel.add(searchBtn);
		
		JButton contactBtn = new JButton("Contact Us");
		headerButtonPanel.add(contactBtn);
		
		JButton loginBtn = new JButton("Login");

		headerButtonPanel.add(loginBtn);
		
		JPanel headerAdPanel = new JPanel();
		splitPane_1.setRightComponent(headerAdPanel);
		
		JLabel lblHeaderAdvertisement = new JLabel("Header Advertisement");
		headerAdPanel.add(lblHeaderAdvertisement);
		
		JPanel adLeftPanel = new JPanel();
		panel.add(adLeftPanel, BorderLayout.WEST);
		adLeftPanel.setLayout(new BoxLayout(adLeftPanel, BoxLayout.X_AXIS));
		
		JLabel lblAdleft = new JLabel("ADLEFT");
		adLeftPanel.add(lblAdleft);
		
		JPanel adRightPanel = new JPanel();
		panel.add(adRightPanel, BorderLayout.EAST);
		adRightPanel.setLayout(new BoxLayout(adRightPanel, BoxLayout.X_AXIS));
		
		JLabel lblAdright = new JLabel("ADRIGHT");
		adRightPanel.add(lblAdright);
		
		JPanel footerPanel = new JPanel();
		panel.add(footerPanel, BorderLayout.SOUTH);
		
		JLabel lblFooter = new JLabel("FOOTER");
		footerPanel.add(lblFooter);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		panel.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblContent = new JLabel("content");
		contentPanel.add(lblContent);

		/////// LISTENERS/////////
		browseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == browseBtn) {
					//Do the calculations here to display each property in the property list..maybe a loop
					lblContent.setText("Property Browser!");
					lblContent.repaint();
					
				}
			}
		});
		
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == searchBtn) {
		
					lblContent.setText("Search!");
					lblContent.repaint();
					
				}
			}
		});
		
		contactBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == contactBtn) {
		
					lblContent.setText("ContactUs!");
					lblContent.repaint();
					
				}
			}
		});
				
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Login button behaves as a togglebutton for Login / Account.
				if(e.getSource() == loginBtn && loginBtn.getText().equals("Login")) {
					// If clicked, while it is named Login button, clear & add the login interface to the contentPanel
					login loginPanel = new login();
			
					
				
					contentPanel.removeAll();
					contentPanel.add(loginPanel);
					contentPanel.repaint();
					contentPanel.revalidate();
					
				}
				if(e.getSource() == loginBtn && loginBtn.getText().equals("Account")) {
					// If clicked, while it is named Account button, clear & add the Account Control Panel to the contentPanel
					accountCP CP = new accountCP(cookie);
					contentPanel.removeAll();
					contentPanel.add(CP);
					contentPanel.repaint();
					contentPanel.revalidate();
				
				}
			}});
		frame.addPropertyChangeListener(new PropertyChangeListener() {
			// Added a propertyChangeListener that fires once user has successfully logged in! 
			// Important: Make USE of this in your assigned functional requirement as program behavior changes when user
			// is logged in.
			@Override
			public void propertyChange(PropertyChangeEvent ch) {
				// TODO Auto-generated method stub
				// Cookie is a randomly generated address assigned to each successfully logged in account
				if(ch.getPropertyName().equals("cookie") && (Double)ch.getNewValue() != 0) {	// Once it detects the signal from login.java file..
					loginBtn.setText("Account");
					cookie = (double) ch.getNewValue();
					accountCP CP = new accountCP(cookie);	//Upon Successful Login, Transition to User Account Control Panel
					contentPanel.removeAll();
					contentPanel.add(CP);
					contentPanel.repaint();
					contentPanel.revalidate();
					loggedin = true;
					
			
				}
				if(ch.getPropertyName().equals("cookie") && (Double) ch.getNewValue() == 0) {
					// Upon Log out, reset the cookie to zero. and toggle back the "Account" button into Login button
					loginBtn.setText("Login");
					accountDB.getInstance().removeLoggedinUser(cookie);
					cookie = 0;
	 
					loggedin = false;	// Make use of this or the cookie in your other classes to regulate behavior
					//contentPanel.add(new propertyBrowser());
					
				}
			}
			
			
			
		});
		
///////////////////END OF LISTENRERS///////////////////


	}
 
}
