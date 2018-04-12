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
import javax.swing.border.EtchedBorder;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class home {

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
		panel.add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblContent = new JLabel("CONTENT");
		contentPanel.add(lblContent);
		///////ACTION LISTENERS/////////
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
				if(e.getSource() == loginBtn) {
		
					lblContent.setText("Login!");
					lblContent.repaint();
					
				}
			}
		});		
		
///////////////////END OF ACTIONLISTENER///////////////////
		
		
	}

}
