package com.portalObjects;

import com.donations.*;
import com.managers.*;

public class Portal {
	
	private String name;
	private DonorManager donorMang;
	private ProjectManager projectMang;
	private DonationManager donationMang;
	private ItemManager itemMang;
	
	private double totalDonation;
	
	public Portal(String name){
		super();
		this.name = name;
		this.donorMang = new DonorManager();
		this.totalDonation = 0.00;
		this.donationMang = new DonationManager();
		this.projectMang = new ProjectManager();
		this.itemMang = new ItemManager();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalDonation() {
		return totalDonation;
	}

	public void setTotalDonation(double totalDonation) {
		this.totalDonation = totalDonation;
	}
	
	/**
	 * a method to add a Donor to
	 * @param donation
	 */
	public void updateDonation(PortalDonation donation){
		totalDonation += donation.getDonationAmount();
	}
	
	public void addProject(Project project){
		projectMang.add(project);
	}
	
	public void viewAllAvailableProjects(){
		projectMang.viewAll();
	}
	
	public void addDonor(Donor donor){
		donorMang.add(donor);
	}
	
	public void viewAllProjectsDonors(){
		projectMang.viewAllProjectsDonors();
	}
	
	public void viewSpecificProject(String projectName){
		projectMang.viewProjectDonors(projectName);
	}
	
	public void addDonation(AbstractDonation donation){
		donationMang.add(donation);
	}
	
	public void viewDonations(){
		donationMang.viewAll();
	}
	
	public void addItem(Item item){
		itemMang.add(item);
	}
	
	public void viewItems(){
		itemMang.viewAll();
	}
	
	public Project findProject(String projName){
		return projectMang.find(projName);
	}
	
	public Donor findDonor(String donorName){
		return donorMang.find(donorName);
	}
	
	public void viewDonors(){
		donorMang.viewAll();
	}
	
	public Item findItem(String itemName){
		return itemMang.find(itemName);
	}
	
	@Override
	public String toString(){
		return "Welcome to " + name + "\n" ;
	}
}
