package com.portalObjects;

import java.util.UUID;

/**
 * Donor class that contains name and email.
 * 
 * @author mliao
 *
 */
public class Donor {
	
	UUID donorID;
	
	String name;
	String email;
		
	
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
	
	public void setID(UUID id){
		this.donorID = id;
	}
	
	public Donor(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	@Override
	public String toString(){
		return "Donor Name: " + name + "\t Email: " + email;
	}

}
