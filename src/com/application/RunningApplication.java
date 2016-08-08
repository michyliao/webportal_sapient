package com.application;

import java.util.*;
import com.donations.*;
import com.portalObjects.*;

public class RunningApplication {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Welcome! Please enter the name you would like to name your Web Portal");

		String portalName = sc.nextLine();

		Portal webportal = new Portal(portalName);
		boolean exit = false;

		try {
			printOptions();

			while (sc.hasNext()) {
				switch (sc.nextInt()) {
				case 1:
					System.out.println("Enter name of the new project: ");
					sc.nextLine();

					String projectName = sc.nextLine();

					System.out.println("Enter a description for the project: ");
					String projectDescription = sc.nextLine();

					try {
						System.out.println("Enter the total cost of the project: ");
						double cost = Double.parseDouble(sc.nextLine());
						Project newProject = new Project(projectName, projectDescription, cost);

						webportal.addProject(newProject);

						System.out.println(newProject);
					} catch (NumberFormatException e) {
						System.out.println("Try Again for inputting the wrong format for the cost of the project");
						System.out.println("Reason:");
						System.out.println(e.getMessage());
					}

					break;
				case 2:
					System.out.println("Enter name of the new product: ");
					sc.nextLine();

					String productName = sc.nextLine();

					System.out.println("Enter the path for the img: ");
					String img = sc.nextLine();

					Item newProduct = new Item(productName, img);

					webportal.addItem(newProduct);

					System.out.println(newProduct);

					System.out.println("Would you like to add the product to a project? [Y/N]");

					if (sc.nextLine().equalsIgnoreCase("y")) {
						System.out.println("Please enter the Project Name that would like to add the product to: ");
						String projName = sc.nextLine();

						try {
							Project requestedProject = webportal.findProject(projName);
							requestedProject.addItem(newProduct);
						} catch (NullPointerException e) {
							System.out.println("The project name that you had entered does not exist. Try Again.");
							System.out.println(e.getMessage());
						}

					}
					break;
				case 3:
					System.out.println("Enter the name of the Donor: ");
					sc.nextLine();

					String donorName = sc.nextLine();

					System.out.println("Enter the email of the Donor: ");
					String donorEmail = sc.nextLine();

					Donor newDonor = new Donor(donorName, donorEmail);
					
					webportal.addDonor(newDonor);

					System.out.println(newDonor);
					break;

				case 4:
					System.out.println(" --- List of Donors --- \n");
					webportal.viewDonors();
					
					System.out.println("Enter the donor name that would like to donate: ");
					sc.nextLine();
					String donationDonorName = sc.nextLine();
					Donor donationDonor = webportal.findDonor(donationDonorName);

					System.out.println("Enter the donation amount: ");
					double donationAmount = Double.parseDouble(sc.nextLine());

					System.out.println("Enter the type of donation you would like to donate [project/product/portal]");
					if (sc.nextLine().equalsIgnoreCase("project")) {
						try {

							webportal.viewAllAvailableProjects();

							System.out.println("Enter the name of the project that you would like to donate: ");
							String donatingProjectName = sc.nextLine();

							Project donatingProject = webportal.findProject(donatingProjectName);
							ProjectDonation projectDonation = new ProjectDonation(donationDonor, donationAmount, donatingProject);

							webportal.addDonation(projectDonation);

						} catch (NullPointerException e) {
							System.out.println("The donor you entered does not exist");
							System.out.println(e.getMessage());
						}

					} else if (sc.nextLine().equalsIgnoreCase("product")) {
						webportal.viewItems();

						System.out.println("Enter the name of the product that you like to to donate: ");
						String donatingProductName = sc.nextLine();

						Item donatingProduct = webportal.findItem(donatingProductName);
						ItemDonation productDonation = new ItemDonation(donationDonor, donationAmount, donatingProduct);

						webportal.addDonation(productDonation);

					} else if (sc.nextLine().equalsIgnoreCase("portal")) {
						PortalDonation portalDonation = new PortalDonation(donationDonor, donationAmount, webportal);

						webportal.addDonation(portalDonation);
					}

					break;
				case 5:
					System.out.println("Enter the project name: ");
					String requestedProjectName = sc.nextLine();

					sc.nextLine();

					System.out.println("Enter the name of the product that you want to add to a project: ");
					String requestedProductName = sc.nextLine();

					Project accquiredProject = webportal.findProject(requestedProjectName);
					Item accquiredProduct = webportal.findItem(requestedProductName);

					accquiredProject.addItem(accquiredProduct);
					break;
				case 6:
					webportal.viewDonors();
					break;
				case 7:
					webportal.viewAllProjectsDonors();
					break;
				case 8:
					System.out.println("Please enter the name of the project that you would like to view all the donors for: ");
					String viewProj = sc.nextLine();

					//TODO try catch for finding project
					
					webportal.findProject(viewProj).viewDonors();
					break;
				case 9:
					exit = true;
				default:
					System.out.println("Invalid input. Please input 1-9");
					break;
				}

				if (exit) {
					break;
				}

				printOptions();
			}
		} catch (InputMismatchException e) {
			System.out.println("The input that you had enter is invalid. Quitting Program.");
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}

	public static void printOptions() {
		System.out.println("Please enter the option that you would like to: ");

		System.out.println("1 : Enter a new Project");
		System.out.println("2 : Enter a new Product");
		System.out.println("3 : Enter a new Donor");
		System.out.println("4 : Enter a new Donation");
		System.out.println("5 : Add a product to a project");
		System.out.println("6 : View Donors");
		System.out.println("7 : Print all projects and their donors");
		System.out.println("8 : View Donors for a specific Project");
		System.out.println("9 : Exit/Quit");
	}
}
