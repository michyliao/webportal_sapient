package com.donations;

import com.portalObjects.Donor;
import com.portalObjects.Item;

/**
 * Product Donation class that extends from the AbstractDonation
 * that accepts a donor, donoation amount and the product that the 
 * donor wants to donate to.
 * 
 * @author mliao
 *
 */
public class ItemDonation extends AbstractDonation {

  Item item;

  /**
 * Product Donation Constructor.
 * 
 * @param donor Donor object that wants to donate to a product
 * @param donationAmount the given amount that the donor wants to donate
 * @param item the product the donor wants to donate too
*/
  public ItemDonation(Donor donor, double donationAmount, Item item) {
    super(donor, donationAmount, item.getID(), Type.ITEM);
    this.item = item;

    updateItem();
  }

  public ItemDonation() {
  	super(null, 0.00D, null, null);
  }

	/**
   *  Product method to update the current product object which will update
   * the donation amount, and add the donor to the project donorlist.
   */
  private void updateItem() {
    item.addDonation(this);
  }

  @Override
  public String toString() {
    return super.toString() + "\t Donation Type: Item \t Item Name: "
        + item.getName();
  }

}
