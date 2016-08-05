package com.managers;

import com.portalObjects.*;
import java.util.Hashtable;
import java.util.UUID;

import com.interfaces.IPortal;

public class DonorManager implements IPortal<Donor> {

	Hashtable<UUID, Donor> donorList = new Hashtable<UUID, Donor>();

	@Override
	public void add(Donor donor) {
		UUID key = donor.getID();
		donorList.put(key, donor);
	}

	@Override
	public void print(Donor donor) {
		System.out.println(donor);
	}

	@Override
	public Donor find(String donorName) {
		Donor returnDonor = null;

		for (Donor donor : donorList.values()) {
			if (donor.getName().equals(donorName)) {
				returnDonor = donor;
			}
		}

		return returnDonor;
	}

	@Override
	public Hashtable<UUID, Donor> returnAll() {
		return donorList;
	}

	@Override
	public void viewAll() {
		for (Donor donor : donorList.values()) {
			System.out.println(donor);
		}
	}

}
