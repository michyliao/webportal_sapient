package com.portalObjects;

import java.util.UUID;

import com.donations.ProductDonation;
import com.managers.DonorManager;

public class Item {
	
	UUID prodID;
	
	String productName;
	String img;
	
	double totalDonation;
	
	DonorManager donorMang;

	
	public Item(String productName, String img) {
		super();
		this.productName = productName;
		this.img = img;
		this.donorMang = new DonorManager();
	}

	public String getName() {
		return productName;
	}

	public void setName(String productName) {
		this.productName = productName;
	}
	
	public void setID(UUID id){
		this.prodID = id;
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
		return "Product: " + productName + "\t img path: " + img; 
	}
	
	

}
