package com.EmailApp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int defaultPasswordLength=10;
	private int mailBoxCapacity;
	private String alternateMail;
    private String email;
    private String companySuffix="aeyCompany.com";
	
 //Constructor to receive the first name and last name 
	public Email(String firstName, String lastName){
		this.firstName=firstName;
		this.lastName=lastName;
		this.department=setDepartment();
		this.password=randomPassword(defaultPasswordLength);
		email=firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
	}
 
  //Ask for the department
	private String setDepartment() {
		Scanner sc =new Scanner(System.in);
		int depChoice=sc.nextInt();
		if(depChoice==1) return "Sales";
		else if(depChoice==2) return "Development";
		else if(depChoice==3) return "Accounting";
		else return " ";
		
	}
	
 //Generate the random password 
	private String randomPassword(int length) {
		String passwordSet="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789@#$%&!";
		char[] password =new char[length];
		for(int i=0; i<length; i++) {
			int rand=(int)(Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
			
		}
		return new String(password);
	}
 //Set the mail box capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailBoxCapacity= capacity;
	}
 //Set the alternate mail 
	public void setAlternateMail(String altMail) {
		this.alternateMail= altMail;
	}
 //change the password
    public void changePassword(String password) {
    	this.password=password;
    }
    public int getMailBoxCapacity(int capacity) {
		return mailBoxCapacity;
	}
    public String getAlternateMail(String altMail) {
    	return alternateMail;
	}
    public String getpassword(){
    	return password;
    }
    public String showInfo(){
    	return "Display Name: "+firstName+" "+lastName+
    		   "\nComapny Email: "+email+
    		   "\nMailBoxCapacity: "+mailBoxCapacity+"mb";
    }
}
