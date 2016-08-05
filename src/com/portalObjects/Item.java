package com.portalObjects;

import java.util.UUID;

import com.donations.ProductDonation;
import com.managers.DonorManager;

public class Item {
	
	private UUID itemID;
	private String name;
	private String img;
	private double totalDonation;
	private DonorManager donorMang;
	
	public Item(){
		super();
	}
	
	public Item(String name, String img) {
		super();
		this.name = name;
		this.img = img;
		this.donorMang = new DonorManager();
		this.itemID = UUID.randomUUID();
	}

	/**
	 * @return the totalDonation
	 */
	public double getTotalDonation() {
		return totalDonation;
	}

	/**
	 * @param totalDonation the totalDonation to set
	 */
	public void setTotalDonation(double totalDonation) {
		this.totalDonation = totalDonation;
	}

	public String getName() {
		return name;
	}

	public void setName(String productName) {
		this.name = productName;
	}
	
	public UUID getID(){
		return itemID;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void addDonation(ProductDonation donation){
		totalDonation += donation.getDonationAmount();
		donorMang.add(donation.getDonor());
	}
	
	@Override 
	public String toString(){
		return "Product: " + name + "\t img path: " + img; 
	}
	
	

}
