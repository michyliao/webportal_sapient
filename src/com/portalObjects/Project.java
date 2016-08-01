package com.portalObjects;

import java.util.ArrayList;

import com.donations.*;

public class Project {
	
	int projID;
	
	String name;
	String description;
	
	double projectCost;
	double totalDonation = 0.00;
	
	ArrayList<ProjectItem> productList = new ArrayList<ProjectItem>();
	ArrayList<Donor> donorList = new ArrayList<Donor>();
	
	public Project(int proID, String name, String description, double projectCost) {
		super();
		this.projID = proID;
		this.name = name;
		this.description = description;
		this.projectCost = projectCost;
	}

	public double getProjectCost() {
		return projectCost;
	}

	public void setProjectCost(double projectCost) {
		this.projectCost = projectCost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTotalDonation() {
		return totalDonation;
	}

	public void setTotalDonation(double totalDonation) {
		this.totalDonation = totalDonation;
	}

	public ArrayList<ProjectItem> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<ProjectItem> productList) {
		this.productList = productList;
	}
	
	public ArrayList<Donor> getDonorList(){
		return donorList;
	}
	
	public void addDonor(Donor donor){
		this.donorList.add(donor);
	}
	
	public void addDonation(ProjectDonation donation){
		totalDonation += donation.getDonationAmount();
		donorList.add(donation.getDonor());
	}
	
	public void viewDonors(){
		for (Donor donor : donorList){
			System.out.println(donor);
		}
	}
	
	public void viewProducts(){
		for (ProjectItem product : productList){
			System.out.println(product);
		}
	}
	
	public void addProduct(ProjectItem product){
		productList.add(product);
	}
	
	@Override
	public String toString(){
		return "Project name: " + name + "\n" + "Project Description: " + description + "\n";
	}
	
}
