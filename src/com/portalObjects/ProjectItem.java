package com.portalObjects;

import java.util.ArrayList;

import com.donations.ProductDonation;

public class ProjectItem {
	
	int prodID;
	
	String productName;
	String img;
	
	double totalDonation;
	
	ArrayList<Donor> donorList = new ArrayList<Donor>();

	
	public ProjectItem(int prodID, String productName, String img) {
		super();
		this.prodID = prodID;
		this.productName = productName;
		this.img = img;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public void addDonation(ProductDonation donation){
		totalDonation += donation.getDonationAmount();
		donorList.add(donation.getDonor());
	}
	
	@Override 
	public String toString(){
		return "Product: " + productName + "\t img path: " + img; 
	}
	
	

}
