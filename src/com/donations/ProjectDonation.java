package com.donations;

import com.portalObjects.Donor;
import com.portalObjects.Project;

/**
 * Project Donation class that extends from the AbstractDonation
 * that accepts a donor, donoation amount and the product that the 
 * donor wants to donate to.
 * 
 * @author mliao
 *
 */
public class ProjectDonation extends AbstractDonation {

  Project project;

  /**
 * Project Donation Constructor.
 * 
 * @param donor Donor object that wants to donate to a project
 * @param donationAmount the given amount that the donor wants to donate
 * @param project the project the donor wants to donate too
*/
  public ProjectDonation(Donor donor, double donationAmount, Project project) {
    super(donor, donationAmount, project.getProjID(), Type.PROJECT);
    this.project = project;
    updateProject();
  }
  
  public ProjectDonation(){
  	super(null, 0.00D, null, null);
  }

	/**
 * Product method to update the current product object which will update the
 * donation amount, and add the donor to the project donorlist.
*/
  private void updateProject() {
    project.addDonation(this);
  }

  @Override
  public String toString() {
    return super.toString() + "\t Donation Type: Project \t Project Name: " + project.getName();
  }

}
