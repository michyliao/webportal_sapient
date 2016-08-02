package com.application;

import com.donations.PortalDonation;
import com.donations.ProductDonation;
import com.donations.ProjectDonation;
import com.portalObjects.Donor;
import com.portalObjects.Portal;
import com.portalObjects.Item;
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
    Project cureCancer = new Project("Cure Cancer", "Cancer research facility", 1000);
    Project primaryEducation = new Project("Primary Education", "School of primary education", 
        2000);
    Project oldAgeHome = new Project("Old Age Home", "Home for old people", 6000);

    // Add projects to the portal
    webPortal.addProject(cureCancer);
    webPortal.addProject(primaryEducation);
    webPortal.addProject(oldAgeHome);

    // View all available projects
    webPortal.viewAllAvailableProjects();

    // Create Products 
    Item medicineOne = new Item("Medicine 1", "picture_1");
    Item medicineTwo = new Item("Medicine 2", "picture_2");
    Item medicineThree = new Item("Medicine 3", "picture_3");
    Item medicineFour = new Item("Medicine 4", "picture_4");

    // Adding products to Projects
    cureCancer.addItem(medicineOne);
    cureCancer.addItem(medicineTwo);
    cureCancer.addItem(medicineThree);
    cureCancer.addItem(medicineFour);
    
    Item educationOne = new Item("Education 1", "picture_5");
    Item educationTwo = new Item("Education 2", "picture_6");
    Item educationThree = new Item("Education 3", "picture_7");
    Item educationFour = new Item("Education 4", "picture_8");

    primaryEducation.addItem(educationOne);
    primaryEducation.addItem(educationTwo);
    primaryEducation.addItem(educationThree);
    primaryEducation.addItem(educationFour);

    Item oldManOne = new Item("One Man 1", "picture_9");
    Item oldManTwo = new Item("One Man 2", "picture_10");
    Item oldManThree = new Item("One Man 3", "picture_11");
    Item oldManFour = new Item("One Man 4", "picture_12");
    
    oldAgeHome.addItem(oldManOne);
    oldAgeHome.addItem(oldManTwo);
    oldAgeHome.addItem(oldManThree);
    oldAgeHome.addItem(oldManFour);

    // Create donors
    Donor donorOne = new Donor("Person One", "person1@mail.com");
    Donor donorTwo = new Donor("Person Two", "person2@mail.com");
    Donor donorThree = new Donor("Person Three", "person3@mail.com");
    Donor donorFour = new Donor("Person Four", "person4@mail.com");
    Donor donorFive = new Donor("Person Five", "person5@mail.com");
    Donor donorSix = new Donor("Person Six", "person6@mail.com");
    Donor donorSeven = new Donor("Person Seven", "person7@mail.com");
    Donor donorEight = new Donor("Person Eight", "person8@mail.com");

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

    cureCancer.viewItems();
    cureCancer.viewDonors();

    webPortal.viewAllAvailableProjects();;
    webPortal.viewDonations();


  }

}
