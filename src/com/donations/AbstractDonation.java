package com.donations;

import java.sql.Date;
import java.util.UUID;

import com.portalObjects.Donor;

/**
 * Abstract class for Donations.
 *  
 * @author mliao
 *
 */
public abstract class AbstractDonation {

  private Donor donor;

  private double donationAmount;
  
  private UUID donationId;
  
  private Date time_created;

  /**
   * Construct method for Abstract.
   * 
   * @param donor Donor object that wants to donate
   * @param donationAmount Donation amount set by the user
   */
  public AbstractDonation(Donor donor, double donationAmount) {
    super();
    this.donor = donor;
    this.donationAmount = donationAmount;
    this.donationId = UUID.randomUUID();
    
  }
  
  public UUID getID(){
  	return donationId;
  }
  
  public Donor getDonor() {
    return donor;
  }

  public double getDonationAmount() {
    return donationAmount;
  }

  @Override
  public String toString() {
    return "Donor " + donor.getName() + " \t Donation amount: " + donationAmount;
  }


}
