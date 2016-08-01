package com.portalObjects;

import java.util.ArrayList;

import com.donations.*;

public class Portal {
	
	String name;
	
	ArrayList<Project> projectList = new ArrayList<Project>();
	ArrayList<ProjectItem> productList = new ArrayList<ProjectItem>();
	ArrayList<Donor> donorList = new ArrayList<Donor>();
	ArrayList<AbstractDonation> donationList = new ArrayList<AbstractDonation>();
	
	double totalDonation = 0.00;
	
	public Portal(String name){
		super();
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Project> getProjectList() {
		return projectList;
	}


	public void setProjectList(ArrayList<Project> projectList) {
		this.projectList = projectList;
	}


	public ArrayList<ProjectItem> getProductList() {
		return productList;
	}


	public void setProductList(ArrayList<ProjectItem> productList) {
		this.productList = productList;
	}


	public ArrayList<Donor> getDonorList() {
		return donorList;
	}


	public void setDonorList(ArrayList<Donor> donorList) {
		this.donorList = donorList;
	}


	public ArrayList<AbstractDonation> getDonationList() {
		return donationList;
	}


	public void setDonationList(ArrayList<AbstractDonation> donationList) {
		this.donationList = donationList;
	}


	public double getTotalDonation() {
		return totalDonation;
	}


	public void setTotalDonation(double totalDonation) {
		this.totalDonation = totalDonation;
	}


	/**
	 * Add a project a the portal
	 * 
	 * @param project  The project object to be added to the portal 
	 */
	public void addProject(Project project){
		//TODO: check if the project is valid with the information
		projectList.add(project);		
	}
	
	/**
	 * A method to add multiple projects at once
	 * 
	 * @param newProjects  An array of Projects to be added
	 */
	public void addProjects(ArrayList<Project> newProjects){
		for (Project project : newProjects){
			//TODO: check if it exists or not
			projectList.add(project);
		}
	}
	
	public void addDonation(AbstractDonation donation){
		donationList.add(donation);
	}
	
	public void addProduct(ProjectItem product){
		productList.add(product);
	}
	
	/**
	 * A method to print all the projects associated to this portal
	 */
	public void viewAvailableProjects(){
		for (Project project : projectList){
			System.out.println(project);
		}
	}
	
	
	public void viewAllProjectsDonors(){
		for (Project project : projectList){
			
			System.out.println(project);
			System.out.println("Donors:");
			
			if (project.getDonorList().size() > 0){
				project.viewDonors();	
			} else {
				System.out.println("There are currently no donors");
			}
			
		}
	}
	
	public void viewAllDonations(){
		for (AbstractDonation donation : donationList){
			System.out.println(donation);
		}
	}
	
	public void viewAllDonors(){
		for (Donor donor : donorList){
			System.out.println(donor);
		}
	}
	
	public void viewProducts(){
		for (ProjectItem product : productList){
			System.out.println(product);
		}
	}
	
	/**
	 * a method to add a Donor to
	 * @param donation
	 */
	public void updateDonation(PortalDonation donation){
		totalDonation += donation.getDonationAmount();
		donorList.add(donation.getDonor());
	}
	
	public Project findProject(String projectName){
		Project returnProject = null;
		
		for (Project project : projectList){
			if (project.getName().equals(projectName)){
				returnProject = project;
			}
		}
		
		return returnProject;
	}
	
	public ProjectItem findProduct(String productName){
		ProjectItem returnProduct = null;
		
		for (ProjectItem product : productList){
			if (product.getProductName().equals(productName)){
				returnProduct = product;
			}
		}
		
		return returnProduct;
	}
	
	public Donor findDonor(String donorName){
		Donor returnDonor = null;
		
		for (Donor donor : donorList){
			if (donor.getName().equals(donorName)){
				returnDonor = donor;
			}
		}
		return returnDonor;
	}
	
	@Override
	public String toString(){
		return "Welcome to " + name + "\n" ;
	}
	

}
