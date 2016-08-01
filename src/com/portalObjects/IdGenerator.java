package com.portalObjects;

public class IdGenerator {
	
	int projectId;
	int productId;
	int donorId;
	
	public IdGenerator(){
		super();
		projectId = 100;
		productId = 500;
		donorId = 1000;
	}
	
	public int newProjectId(){
		projectId += 1;
		return projectId;
	}
	
	public int newProductId(){
		productId += 1;
		return productId;
	}
	
	public int newDonorId(){
		donorId += 1;
		return donorId;
	}
	

}
