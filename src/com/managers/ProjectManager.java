package com.managers;

import java.util.Hashtable;
import java.util.UUID;

import com.interfaces.IPortal;
import com.portalObjects.*;

public class ProjectManager implements IPortal<Project> {

	Hashtable<UUID, Project> projectList = new Hashtable<UUID, Project>();
	
	/**
	 * A method to add a project
	 * 
	 * @param newProject  A Project to be added
	 */
	@Override
	public void add(Project project) {
		UUID key = UUID.randomUUID();
		
		project.setID(key);
		
		projectList.put(key, project);
	}

	@Override
	public void print(Project project) {
		System.out.println(project);
	}

	@Override
	public Project find(String projectName) {
		Project returnProject = null;
		
		for (Project project : projectList.values()){
			if (project.getName().equals(projectName)){
				returnProject = project;
			}
		}
		
		return returnProject;
	}

	public void viewAllProjectsDonors(){
		for (Project project : projectList.values()){
			System.out.println("Project Name: " + project.getName());
			System.out.println(" ------ Donors ------");
			
			for (Donor donor : project.getDonorList()){
				System.out.println(donor);
			}
			System.out.println("\n");
			
		}
	}
	
	public void viewProjectDonors(String projectName){
		Project choosenProject = this.find(projectName);
		System.out.println("Project Name: " + choosenProject.getName());
		
		for (Donor donor : choosenProject.getDonorList()){
			System.out.println(donor);
		}
	}
	
	@Override
	public void viewAll(){
		for (Project project : projectList.values()){
			System.out.println("Project Name: " + project.getName());
		}
	}

	@Override
	public Hashtable<UUID, Project> returnAll() {
		return projectList;
	}
		
	

	
	
}
