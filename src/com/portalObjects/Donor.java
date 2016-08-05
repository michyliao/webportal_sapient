package com.portalObjects;

import java.util.UUID;

/**
 * Donor class that contains name and email.
 * 
 * @author mliao
 *
 */
public class Donor {
	
	private UUID donorID;
	private String name;
	private String email;
	
	public Donor(){
		super();
	}
	
	public Donor(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		this.donorID = UUID.randomUUID();
	}
	
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
	
	public UUID getID(){
		return donorID;
	}
	
	@Override
	public String toString(){
		return "Donor ID: " + donorID + " Donor Name: " + name + "\t Email: " + email;
	}

}
