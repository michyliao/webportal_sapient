package com.portalObjects;

import java.util.ArrayList;

/**
 * Donor class that contains name and email.
 * 
 * @author mliao
 *
 */
public class Donor {
	
	int donorID;
	
	String name;
	String email;
	
	ArrayList<Project> projectListDonated = new ArrayList<Project>();
	
	/**
	 * Getter method for the name of the donor.
	 * 
	 * @return String name of the Donor
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Donor(int DonorID, String name, String email) {
		super();
		this.donorID = DonorID;
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "Donor Name: " + name + "\t Email: " + email;
	}

}
