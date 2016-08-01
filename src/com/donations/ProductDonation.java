package com.donations;

import com.portalObjects.Donor;
import com.portalObjects.ProjectItem;

/**
 * Product Donation class that extends from the AbstractDonation
 * that accepts a donor, donoation amount and the product that the 
 * donor wants to donate to.
 * 
 * @author mliao
 *
 */
public class ProductDonation extends AbstractDonation {

  ProjectItem product;

  /**
 * Product Donation Constructor.
 * 
 * @param donor Donor object that wants to donate to a product
 * @param donationAmount the given amount that the donor wants to donate
 * @param product the product the donor wants to donate too
*/
  public ProductDonation(Donor donor, double donationAmount, ProjectItem product) {
    super(donor, donationAmount);
    this.product = product;

    updateProduct();
  }

  /**
   *  Product method to update the current product object which will update
   * the donation amount, and add the donor to the project donorlist.
   */
  private void updateProduct() {
    product.addDonation(this);
  }

  @Override
  public String toString() {
    return super.toString() + "\t Donation Type: Product \t Product Name: "
        + product.getProductName();
  }

}
