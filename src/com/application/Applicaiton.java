package com.application;

import com.donations.PortalDonation;
import com.donations.ProductDonation;
import com.donations.ProjectDonation;
import com.portalObjects.Donor;
import com.portalObjects.Portal;
import com.portalObjects.ProjectItem;
import com.portalObjects.Project;

/**
 * The application class runs the program with sample outputs.
 * 
 * @author mliao
 *
 */

public class Applicaiton {

  /**
 * Main static function which runs the application program. 
 * 
 * @param args input from the command
*/
  public static void main(String[] args) {

    Portal webPortal = new Portal("Philanthropy.com");

    System.out.println(webPortal);

    // Create Projects
    Project cureCancer = new Project(101, "Cure Cancer", "Cancer research facility", 1000);
    Project primaryEducation = new Project(102, "Primary Education", "School of primary education", 
        2000);
    Project oldAgeHome = new Project(103, "Old Age Home", "Home for old people", 6000);

    // Add projects to the portal
    webPortal.addProject(cureCancer);
    webPortal.addProject(primaryEducation);
    webPortal.addProject(oldAgeHome);

    // View all available projects
    webPortal.viewAvailableProjects();

    // Create Products 
    ProjectItem medicineOne = new ProjectItem(201, "Medicine 1", "picture_1");
    ProjectItem medicineTwo = new ProjectItem(202, "Medicine 2", "picture_2");
    ProjectItem medicineThree = new ProjectItem(203, "Medicine 3", "picture_3");
    ProjectItem medicineFour = new ProjectItem(204, "Medicine 4", "picture_4");

    // Adding products to Projects
    cureCancer.addProduct(medicineOne);
    cureCancer.addProduct(medicineTwo);
    cureCancer.addProduct(medicineThree);
    cureCancer.addProduct(medicineFour);
    
    ProjectItem educationOne = new ProjectItem(205, "Education 1", "picture_5");
    ProjectItem educationTwo = new ProjectItem(206, "Education 2", "picture_6");
    ProjectItem educationThree = new ProjectItem(207, "Education 3", "picture_7");
    ProjectItem educationFour = new ProjectItem(208, "Education 4", "picture_8");

    primaryEducation.addProduct(educationOne);
    primaryEducation.addProduct(educationTwo);
    primaryEducation.addProduct(educationThree);
    primaryEducation.addProduct(educationFour);

    ProjectItem oldManOne = new ProjectItem(209, "One Man 1", "picture_9");
    ProjectItem oldManTwo = new ProjectItem(209, "One Man 2", "picture_10");
    ProjectItem oldManThree = new ProjectItem(209, "One Man 3", "picture_11");
    ProjectItem oldManFour = new ProjectItem(209, "One Man 4", "picture_12");
    
    oldAgeHome.addProduct(oldManOne);
    oldAgeHome.addProduct(oldManTwo);
    oldAgeHome.addProduct(oldManThree);
    oldAgeHome.addProduct(oldManFour);

    // Create donors
    Donor donorOne = new Donor(101, "Person One", "person1@mail.com");
    Donor donorTwo = new Donor(102, "Person Two", "person2@mail.com");
    Donor donorThree = new Donor(103, "Person Three", "person3@mail.com");
    Donor donorFour = new Donor(104, "Person Four", "person4@mail.com");
    Donor donorFive = new Donor(105, "Person Five", "person5@mail.com");
    Donor donorSix = new Donor(106, "Person Six", "person6@mail.com");
    Donor donorSeven = new Donor(107, "Person Seven", "person7@mail.com");
    Donor donorEight = new Donor(108, "Person Eight", "person8@mail.com");

    // Create donations
    ProjectDonation donationOne = new ProjectDonation(donorOne, 500.00, cureCancer);
    ProjectDonation donationTwo = new ProjectDonation(donorOne, 50.00, primaryEducation);
    ProjectDonation donationThree = new ProjectDonation(donorTwo, 70.00, oldAgeHome);
    ProjectDonation donationFour = new ProjectDonation(donorThree, 900.00, cureCancer);
    ProductDonation donationFive = new ProductDonation(donorFour, 500.00, medicineOne);
    ProductDonation donationSix = new ProductDonation(donorFive, 500.00, educationOne);
    ProductDonation donationSeven = new ProductDonation(donorSix, 500.00, oldManOne);
    ProjectDonation donationEight = new ProjectDonation(donorSix, 500.00, cureCancer);
    ProjectDonation donationNine = new ProjectDonation(donorSeven, 500.00, cureCancer);
    PortalDonation donationTen = new PortalDonation(donorEight, 500.00, webPortal);
    PortalDonation donationEleven = new PortalDonation(donorEight, 500.00, webPortal);

    webPortal.addDonation(donationOne);
    webPortal.addDonation(donationTwo);
    webPortal.addDonation(donationThree);
    webPortal.addDonation(donationFour);
    webPortal.addDonation(donationFive);
    webPortal.addDonation(donationSix);
    webPortal.addDonation(donationSeven);
    webPortal.addDonation(donationEight);
    webPortal.addDonation(donationNine);
    webPortal.addDonation(donationTen);
    webPortal.addDonation(donationEleven);

    cureCancer.viewProducts();
    cureCancer.viewDonors();

    webPortal.viewAllProjectsDonors();
    webPortal.viewAllDonations();


  }

}
