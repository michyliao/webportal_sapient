package com.donations;

import com.donations.AbstractDonation.Type;
import com.portalObjects.Donor;
import com.portalObjects.Portal;

/**
 * Portal Donation class that extends from the Abstract Donation class
 * where they accept donations for the Portal.
 * 
 * @author mliao
 *
 */

public class PortalDonation extends AbstractDonation {
  Portal portal;

  /**
 * Portal Donation constructor where the donor & donationAmount are passed into
 * the super class and the portal object is saved.
 * 
 * @param donor donor object associated with the donation
 * @param donationAmount amount of donation the donor wants to donate
 * @param portal the portal object that is associated with the donation
*/
  public PortalDonation(Donor donor, double donationAmount, Portal portal) {
    super(donor, donationAmount, portal.getPortal_id(), Type.PORTAL);
    this.portal = portal;

    updatePortal();
  }
 
  public PortalDonation() {
  	super(null, 0.00D, null, null);
  }

	/**
   * Portal method to update the current portal object which will update
   * the donation amount, and add the donor to the project donorlist.
   */
  private void updatePortal() {
    portal.updateDonation(this);
  }
  
  private Portal getPortal(){
  	return portal;
  }

  @Override
  public String toString() {
    return super.toString() + "\t Donation Type: Portal";
  }
}
