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
	
	public enum Type {
		PORTAL, PROJECT, ITEM
	}

  private Donor donor;

  private double donationAmount;
  
  private UUID donationId;
  
  private UUID type_id;
 
	private Type type;
  
  private Date time_created;

  /**
   * Construct method for Abstract.
   * 
   * @param donor Donor object that wants to donate
   * @param donationAmount Donation amount set by the user
   */
  public AbstractDonation(Donor donor, double donationAmount, UUID uuid, Type item) {
    super();
    this.donor = donor;
    this.donationAmount = donationAmount;
    this.donationId = UUID.randomUUID();
    this.type = item;
    this.type_id = uuid;
    
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

  /**
 	 * @return the donationId
 	 */
 	public UUID getDonationId() {
 		return donationId;
 	}

 	/**
 	 * @param donationId the donationId to set
 	 */
 	public void setDonationId(UUID donationId) {
 		this.donationId = donationId;
 	}

 	/**
 	 * @return the type_id
 	 */
 	public UUID getType_id() {
 		return type_id;
 	}

 	/**
 	 * @param type_id the type_id to set
 	 */
 	public void setType_id(UUID type_id) {
 		this.type_id = type_id;
 	}

 	/**
 	 * @return the type
 	 */
 	public Type getType() {
 		return type;
 	}

 	/**
 	 * @param type the type to set
 	 */
 	public void setType(Type type) {
 		this.type = type;
 	}

 	/**
 	 * @return the time_created
 	 */
 	public Date getTime_created() {
 		return time_created;
 	}

 	/**
 	 * @param time_created the time_created to set
 	 */
 	public void setTime_created(Date time_created) {
 		this.time_created = time_created;
 	}

 	/**
 	 * @param donor the donor to set
 	 */
 	public void setDonor(Donor donor) {
 		this.donor = donor;
 	}

 	/**
 	 * @param donationAmount the donationAmount to set
 	 */
 	public void setDonationAmount(double donationAmount) {
 		this.donationAmount = donationAmount;
 	}

  
  @Override
  public String toString() {
    return "Donor " + donor.getName() + " \t Donation amount: " + donationAmount;
  }

	public void setType(String string) {
		// TODO Auto-generated method stub
		this.type = type.PROJECT;
		
	}


}
