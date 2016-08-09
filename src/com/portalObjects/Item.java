package com.portalObjects;

import java.util.UUID;

import com.donations.ItemDonation;
import com.managers.DonorManager;

public class Item {
	
	private UUID itemID;
	private UUID projectID;
	private String name;
	private String img;
	private double totalDonation;
	private DonorManager donorMang;
	
	public Item(){
		super();
	}
	
	public Item(String name, String img, UUID proj_id) {
		super();
		this.name = name;
		this.img = img;
		this.projectID = proj_id;
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

	/**
	 * @return the itemID
	 */
	public UUID getItemID() {
		return itemID;
	}

	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(UUID itemID) {
		this.itemID = itemID;
	}

	/**
	 * @return the projectID
	 */
	public UUID getProjectID() {
		return projectID;
	}

	/**
	 * @param projectID the projectID to set
	 */
	public void setProjectID(UUID projectID) {
		this.projectID = projectID;
	}
	
	public void addDonation(ItemDonation donation){
		totalDonation += donation.getDonationAmount();
		donorMang.add(donation.getDonor());
	}
	
	@Override 
	public String toString(){
		return "Product: " + name + "\t img path: " + img; 
	}
	
	

}
