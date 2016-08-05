package com.portalObjects;

import java.util.Collection;
import java.util.UUID;

import com.donations.*;
import com.managers.*;

public class Project{
	private UUID projID;
	private String name;
	private String description;
	
	private double projectCost;
	private double totalDonation = 0.00;
	
	private ItemManager itemMang;
	private DonorManager donorMang;
	
	public Project(){
		super();
	}
	
	public Project(String name, String description, double projectCost) {
		super();
		this.name = name;
		this.description = description;
		this.projectCost = projectCost;
		this.donorMang = new DonorManager();
		this.itemMang = new ItemManager();
		this.projID = UUID.randomUUID(); 
	}

	/**
	 * @return the projID
	 */
	public UUID getProjID() {
		return projID;
	}

	/**
	 * @param projID the projID to set
	 */
	public void setProjID(UUID projID) {
		this.projID = projID;
	}

	/**
	 * @param totalDonation the totalDonation to set
	 */
	public void setTotalDonation(double totalDonation) {
		this.totalDonation = totalDonation;
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
	
	/**
	 * @return the itemMang
	 */
	public ItemManager getItemMang() {
		return itemMang;
	}

	/**
	 * @param itemMang the itemMang to set
	 */
	public void setItemMang(ItemManager itemMang) {
		this.itemMang = itemMang;
	}

	/**
	 * @return the donorMang
	 */
	public DonorManager getDonorMang() {
		return donorMang;
	}

	/**
	 * @param donorMang the donorMang to set
	 */
	public void setDonorMang(DonorManager donorMang) {
		this.donorMang = donorMang;
	}

	public void addDonation(ProjectDonation donation){
		totalDonation += donation.getDonationAmount();
		donorMang.add(donation.getDonor());
	}
	
	public void viewDonors(){
		for (Donor donor : donorMang.returnAll().values()){
			System.out.println(donor);
		}
	}
	
	public Collection<Donor> getDonorList(){
		return donorMang.returnAll().values();
	}
	
	public void viewItems(){
		for (Item item : itemMang.returnAll().values()){
			System.out.println(item);
		}
	}
	
	public void addItem(Item item){
		itemMang.add(item);
	}
	
	@Override
	public String toString(){
		return "Project name: " + name + "\n" + "Project Description: " + description + "\n";
	}

}
