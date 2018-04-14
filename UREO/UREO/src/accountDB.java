import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class accountDB { // A Singleton
	private static accountDB accountsUI;
	private int id=0;
	private HashMap<Double, account>  loggedinUser;	// Online\Loggedin Users list
	private ArrayList<account> accountList = new ArrayList<account>(); // List of VERIFIED accounts
	private ArrayList<account> accountRequests = new ArrayList<account>(); // List of Accounts awaiting verification
	// WIP -- need to implement methods such as Confirm Account Request, Create Account..etc + constructing from textfile 
	//and save back in textfile.
	
private accountDB() {this.initialize();}
public static accountDB getInstance() {
	if(accountsUI == null) {
		accountsUI = new accountDB();
	}
	return accountsUI;
}
private void initialize() {
	int maxID = 0; //tmp variable to locate the maximum ID found in the textfiles of old accounts in order give unconflicting IDs to new Accounts
	loggedinUser = new HashMap<Double, account>();
	String[] line = new String[11];//Could increase size more, depending on need.
	try {
		BufferedReader bf = new BufferedReader(new FileReader("accountRequests.txt"));
		while(bf.ready()) {
			line = bf.readLine().split(":");// 	ID						username  password ..... etc.. follows the same order as the variable defined in the Account class
			accountRequests.add(new account(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], line[5], line[6], Integer.parseInt(line[7]), line[8], line[9], line[10]));
			maxID = Integer.parseInt(line[0]);
		}
		bf.close();
		bf = new BufferedReader(new FileReader("accounts.txt"));
		while(bf.ready()) {
			line = bf.readLine().split(":");
			accountList.add(new account(Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], line[5], line[6], Integer.parseInt(line[7]), line[8], line[9], line[10]));
			{if(maxID < Integer.parseInt(line[0])) {maxID = Integer.parseInt(line[0]);}}
		}

	
		bf.close();
		id = maxID;
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
	
public void createAccountRequest(String username, String password, String email, String type, String address, String mobile, int rating, String properties, String birthDate)	{
	Calendar clndr = Calendar.getInstance();	// To record the account creation date
	accountRequests.add(new account(++id, username, password, email, type, address, mobile, rating, properties, birthDate, String.valueOf(clndr.MONTH)+"/"+String.valueOf(clndr.YEAR)) );
	save();	//Update database once a new account request is created
}

public void save() {
	// Saves the current state of the accountList & Requests in textfiles
	try {		
		PrintWriter writer = new PrintWriter(new FileOutputStream("accountRequests.txt", false));
		for(int i = 0;i<accountRequests.size();i++){
		writer.println(accountRequests.get(i).getId() + ":" + (accountRequests.get(i).getUsername() + ":" + accountRequests.get(i).getPassword() +":"+ accountRequests.get(i).getEmail() + ":" + accountRequests.get(i).getType() + ":" + accountRequests.get(i).getAddress() + ":" + accountRequests.get(i).getMobile()+":"+accountRequests.get(i).getRating()+":"+accountRequests.get(i).getProperties()+":"+accountRequests.get(i).getBirthDate()+":"+accountRequests.get(i).getJoinDate()));
		writer.flush();
		}
		writer.close();
		writer = new PrintWriter(new FileOutputStream("accounts.txt", false));
		for(int i = 0;i<accountList.size();i++){
		writer.println(accountList.get(i).getId() + ":" + (accountList.get(i).getUsername() + ":" + accountList.get(i).getPassword() +":"+ accountList.get(i).getEmail() + ":" + accountList.get(i).getType() + ":" + accountList.get(i).getAddress() + ":" + accountList.get(i).getMobile()+":"+accountList.get(i).getRating()+":"+accountList.get(i).getProperties()+":"+accountList.get(i).getBirthDate()+":"+accountList.get(i).getJoinDate()));
		writer.flush();
		}
		writer.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
	}

	
}
	
public double validate(String username, String password) { // Used for Login Verification. Generates Cookies for each login session
	double cookie = 0;
	for(account acc: accountList) {if(acc.getUsername().equals(username) && acc.getPassword().equals(password)) { cookie = Math.random()*1000; addLoggedinUser(cookie, username);}}
	return cookie;
	
}
private void addLoggedinUser(double cookie, String username) {//Used by validate()^. Updates the online users list. Used internally
	account loggedinAccount = null;
	for(account acc: accountList) {if(acc.getUsername().equals(username)) loggedinAccount = acc;}
	loggedinUser.put(cookie, loggedinAccount);
}
public void removeLoggedinUser(double cookie) {//Removes users from online users list upon logout. Used by home.java
	loggedinUser.remove(cookie);
	
}

public account getUserAccount(double cookie) {//Getter for online user accounts
	return loggedinUser.get(cookie);
}


public boolean checkUsername(String username) {//Used for Signup
	boolean response = true;
	for(account acc: accountList) {if(acc.getUsername().equals(username)) response = false;}
	return response;
}
public boolean checkEmail(String email) {//Used for Signup
	boolean response = true;
	for(account acc: accountList) {if(acc.getEmail().equals(email)) response = false;}
	return response;
}
public boolean checkMobile(String mobile) {//Used for Signup
	boolean response = true;
	for(account acc: accountList) {if(acc.getMobile().equals(mobile)) response = false;}
	return response;	
}
}


class account{

private int id;
private String username;
private String password;
private String email;
private String type;
private String address;
private String mobile;
private int rating;
private String properties;
private String birthDate;
private String joinDate;
public account(int id, String username, String password, String email, String type, String address, String mobile, int rating, String properties, String birthDate, String joinDate) {
this.id = id;
this.username = username;
this.password = password;
this.email = email;
this.type = type;
this.address = address;
this.mobile = mobile;
this.rating = rating;
this.properties = properties;
this.birthDate = birthDate;
this.joinDate = joinDate;
}
public int getId() {
	return id;
}
public String getUsername() {
	return username;
}
public String getPassword() {
	return password;
}
public String getEmail() {
	return email;
}
public String getType() {
	return type;
}
public String getAddress() {
	return address;
}
public String getMobile() {
	return mobile;
}
public int getRating() {
	return rating;
}
public String getProperties() {
	return properties;
}
public String getBirthDate() {
	return birthDate;
}
public String getJoinDate() {
	return joinDate;
}
public void setAddress(String address) {
	this.address = address;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public void setEmail(String email) {
	this.email = email;
}
}