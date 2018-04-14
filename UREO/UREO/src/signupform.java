import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Container;

import javax.swing.Box;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSlider;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;

import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signupform extends JPanel {
	private JTextField nameField;
	private JPasswordField passwordField;
	private JPasswordField passwordConfirm;
	private JTextField emailField;
	private JTextField emailConfirm;
	private JTextField addressField;
	private JTextField mobileField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public signupform() {
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
		);
		
		JLabel lblRegistrationForm = new JLabel("Registration Form");
		lblRegistrationForm.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblName = new JLabel("Name");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Password");
		
		passwordField = new JPasswordField();
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		
		passwordConfirm = new JPasswordField();
		
		JLabel lblEmail = new JLabel("Email");
		
		emailField = new JTextField();
		emailField.setColumns(10);
		
		JLabel lblConfirmEmail = new JLabel("Confirm Email");
		
		emailConfirm = new JTextField();
		emailConfirm.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		
		addressField = new JTextField();
		addressField.setColumns(10);
		
		JLabel lblMobilePhone = new JLabel("Mobile Phone");
		
		mobileField = new JTextField();
		mobileField.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		
		JPanel datePanel = new JPanel();
		
		JSpinner daySpin = new JSpinner();
		daySpin.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		datePanel.add(daySpin);
		
		JSpinner monthSpin = new JSpinner();
		monthSpin.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		datePanel.add(monthSpin);
		
		JSpinner yearSpin = new JSpinner();
		yearSpin.setModel(new SpinnerNumberModel(2000, 1950, 2018, 1));
		datePanel.add(yearSpin);
		
		JLabel lblAccountType = new JLabel("Account Type");
		
		JPanel panel_3 = new JPanel();
		
		JRadioButton buyerBtn = new JRadioButton("Buyer");
		buttonGroup.add(buyerBtn);
		panel_3.add(buyerBtn);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(140)
							.addComponent(lblRegistrationForm)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblRegistrationForm)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
		);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("117px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("max(158dlu;pref)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(119dlu;default)"),},
			new RowSpec[] {
				RowSpec.decode("26px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("26px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("36px"),
				FormSpecs.LABEL_COMPONENT_GAP_ROWSPEC,
				RowSpec.decode("39px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		panel_1.add(lblName, "1, 1, fill, top");
		
		JLabel nameResponse = new JLabel("No Symbols or Spaces Allowed");
		panel_1.add(nameResponse, "5, 1");
		panel_1.add(lblNewLabel, "1, 3, fill, center");
		
		JLabel pswResponse = new JLabel("Longer than 5 Characters");
		panel_1.add(pswResponse, "5, 3");
		panel_1.add(lblConfirmPassword, "1, 5, fill, center");
		
		JLabel pswcResponse = new JLabel("");
		pswcResponse.setForeground(Color.RED);
		panel_1.add(pswcResponse, "5, 5");
		panel_1.add(lblEmail, "1, 7, fill, center");
		
		JLabel emailResponse = new JLabel("");
		panel_1.add(emailResponse, "5, 7");
		panel_1.add(lblConfirmEmail, "1, 9, fill, center");
		
		JLabel emailcResponse = new JLabel("");
		panel_1.add(emailcResponse, "5, 9");
		panel_1.add(lblAddress, "1, 11, fill, center");
		
		JLabel addressResponse = new JLabel("");
		panel_1.add(addressResponse, "5, 11");
		panel_1.add(lblMobilePhone, "1, 13, fill, center");
		panel_1.add(passwordField, "3, 3, fill, top");
		panel_1.add(passwordConfirm, "3, 5, fill, top");
		panel_1.add(emailField, "3, 7, fill, top");
		panel_1.add(emailConfirm, "3, 9, fill, top");
		panel_1.add(addressField, "3, 11, fill, top");
		panel_1.add(mobileField, "3, 13, fill, top");
		panel_1.add(nameField, "3, 1, fill, top");
		
		JLabel mobileResponse = new JLabel("Start with 05XXXXXXXX");
		panel_1.add(mobileResponse, "5, 13");
		panel_1.add(lblAccountType, "1, 17, fill, center");
		panel_1.add(panel_3, "3, 17, fill, top");
		
		JRadioButton sellerBtn = new JRadioButton("Seller");
		buttonGroup.add(sellerBtn);
		panel_3.add(sellerBtn);
		panel_1.add(lblDateOfBirth, "1, 15, fill, center");
		panel_1.add(datePanel, "3, 15, fill, top");
		
		JLabel typeResponse = new JLabel("");
		panel_1.add(typeResponse, "5, 17");
		
		JButton submitBtn = new JButton("Submit");

		panel_1.add(submitBtn, "3, 19");
		
		JLabel response = new JLabel("");
		panel_1.add(response, "3, 21");
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		/////////ACTIONLISTENER IMPLEMENTATION/////////
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource() == submitBtn) {
				Container parent = ((JButton)e.getSource()).getParent().getParent();
				try {
				boolean validInput = true;
				String name = nameField.getText();
				char[] password = passwordField.getPassword();
				char[] passwordc = passwordConfirm.getPassword();
				String type = "";
				if(buyerBtn.isSelected() ) {type = "Buyer"; typeResponse.setText("");}
				else if(sellerBtn.isSelected()) { type = "Seller";typeResponse.setText("");}
				else {response.setText("Choose an Account Type");{validInput = false;typeResponse.setText("Choose a Type!");typeResponse.setForeground(Color.red);}}
				String birth = daySpin.getValue().toString()+"."+monthSpin.getValue()+"."+yearSpin.getValue();
				String address = addressField.getText();
				String email = emailField.getText();
				String emailc = emailConfirm.getText();
				String mobile = mobileField.getText();
			
				// Stage 1: Check for empty or short fields!
				if(name.isEmpty() || password.length < 5 || password.length != passwordc.length ||address.isEmpty() || mobile.isEmpty() || email.isEmpty() || emailc.isEmpty() || !email.equals(emailc)) 
				{response.setText("Please Enter The Required Credentials Correctly"); 
				validInput = false;
				}
			
				
				//Stage 2: Match Password with its Confirmation Password
				boolean matchingPasswords = true;
				for(int i = 0; i<password.length&&matchingPasswords&&validInput;i++) {matchingPasswords = password[i] == passwordc[i];}
				if(!matchingPasswords) {validInput = false; pswcResponse.setText("Password is mismatched");pswcResponse.setForeground(Color.red);}
				else pswcResponse.setText("");
				//Stage 3: Check for database duplicates
				if(validInput) {
				if(!accountDB.getInstance().checkUsername(name)) {validInput = false; nameResponse.setText("Duplicate Username");}
				if(!accountDB.getInstance().checkEmail(email)) {validInput = false; emailResponse.setText("Duplicate Email");}
				if(!accountDB.getInstance().checkMobile(mobile)) {validInput = false; mobileResponse.setText("Duplicate Mobile");}
				}

				if(validInput) { // Display Success Message and create a new account request
					response.setText("Account Request has been created! Wait for account activation by UREO Staff.\n Thank you for using UREO!");
					response.setHorizontalAlignment(response.CENTER);
					response.setForeground(Color.green);
					parent.removeAll();
					parent.setLayout(new BorderLayout());
					parent.add(response, BorderLayout.NORTH);
					parent.repaint();
					parent.revalidate();
					accountDB.getInstance().createAccountRequest(name, String.valueOf(password), emailc, type, address, mobile, 1, "None", birth);
					
					
				}
				else {response.setForeground(Color.red);} // If the input is invalid, paint the response message red.
				
				}catch(NullPointerException ex) {response.setText("Please Enter Correct Non-Null Credentials");} // will never reach this
			}	
			
			}
		});
		
		/////////////////////END OF ACTIONLISTENER//////////
		
		
		
		
		
	}
}
