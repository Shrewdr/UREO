import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JPanel {
	private JTextField loginUsername;
	private JPasswordField passwordLogin;
	private boolean login = false;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public login() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{119, 0};
		gridBagLayout.rowHeights = new int[]{292, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel loginPanel = new JPanel();
		GridBagConstraints gbc_loginPanel = new GridBagConstraints();
		gbc_loginPanel.gridx = 0;
		gbc_loginPanel.gridy = 0;
		add(loginPanel, gbc_loginPanel);
		
		JLabel label = new JLabel("Username");
		
		loginUsername = new JTextField();
		loginUsername.setColumns(10);
		
		JLabel label_1 = new JLabel("Password");
		
		passwordLogin = new JPasswordField();
		
		JButton signupButton = new JButton("Sign Up");

		buttonGroup.add(signupButton);
		
		JButton loginButton = new JButton("Login");
		buttonGroup.add(loginButton);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 32));
		GroupLayout gl_loginPanel = new GroupLayout(loginPanel);
		gl_loginPanel.setHorizontalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(signupButton, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
								.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(label, Alignment.TRAILING)
								.addComponent(label_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
							.addGap(9)
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(passwordLogin, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE)
								.addComponent(loginUsername, GroupLayout.PREFERRED_SIZE, 353, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(9))
				.addGroup(Alignment.TRAILING, gl_loginPanel.createSequentialGroup()
					.addContainerGap(208, Short.MAX_VALUE)
					.addComponent(lblLogin)
					.addGap(136))
		);
		gl_loginPanel.setVerticalGroup(
			gl_loginPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_loginPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_loginPanel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(loginUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_loginPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_loginPanel.createSequentialGroup()
									.addGap(8)
									.addComponent(passwordLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(loginButton)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(signupButton))
								.addGroup(gl_loginPanel.createSequentialGroup()
									.addGap(11)
									.addComponent(label_1)))
							.addContainerGap())
						.addGroup(gl_loginPanel.createSequentialGroup()
							.addComponent(lblLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(166))))
		);
		gl_loginPanel.linkSize(SwingConstants.VERTICAL, new Component[] {loginUsername, passwordLogin, signupButton, loginButton});
		gl_loginPanel.linkSize(SwingConstants.HORIZONTAL, new Component[] {passwordLogin, signupButton, loginButton});
		gl_loginPanel.linkSize(SwingConstants.HORIZONTAL, new Component[] {label, label_1});
		loginPanel.setLayout(gl_loginPanel);

		/////////// ACTIONLISTENER IMPLEMENTATION ////////
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == signupButton) { // Upon clicking the signup button, show the signup form
			Container parent = ((Component)(e.getSource())).getParent().getParent().getParent();
			parent.removeAll();
			signupform signup= new signupform();
			parent.add(signup, BorderLayout.CENTER);
			parent.repaint();
			parent.revalidate();
			}
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == loginButton) { // Upon clicking the login button with correct credentials. Login!
			double cookie = accountDB.getInstance().validate(loginUsername.getText(), String.valueOf(passwordLogin.getPassword()));
			
			System.out.println(cookie);
			if(cookie != 0) {
			
			Container changeParent = ((JButton)(e.getSource())).getTopLevelAncestor();

			changeParent.firePropertyChange("cookie", 0, cookie); // To inform the main frame of the login success
 
			
			
			
			}}}
		});
		
		/////////// END OF ACTION LISTENERS
		
		
		
		
		
		
		
		
		
	}
 
}
