package com.managers;

import java.util.Hashtable;
import java.util.UUID;

import com.donations.AbstractDonation;
import com.interfaces.IPortal;

public class DonationManager implements IPortal<AbstractDonation> {

	Hashtable<UUID, AbstractDonation> donationList = new Hashtable<UUID, AbstractDonation>();

	@Override
	public void add(AbstractDonation donation) {
		UUID key = UUID.randomUUID();

		donation.setDonation(key);

		donationList.put(key, donation);
	}

	@Override
	public void print(AbstractDonation donation) {
		System.out.println(donation);
	}

	@Override
	public Hashtable<UUID, AbstractDonation> returnAll() {
		return donationList;
	}

	@Override
	public AbstractDonation find(String name) {
		return null;
	}

	@Override
	public void viewAll() {
		for (AbstractDonation donation : donationList.values()) {
			System.out.println(donation);
		}
	}

}
