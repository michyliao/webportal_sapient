package com.managers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import com.donations.AbstractDonation.Type;
import com.donations.*;
import com.interfaces.IPortal;
import com.interfaces.MyDAO;
import com.portalObjects.Donor;
import com.sqlConnection.MySQLConnection;

import oracle.jdbc.OracleTypes;

public class DonationManager implements IPortal<AbstractDonation>, MyDAO<AbstractDonation> {

	Hashtable<UUID, AbstractDonation> donationList = new Hashtable<UUID, AbstractDonation>();

	Connection conn;

	/**
	 * DonationManager constructor that takes in no argument and instantiate SQL
	 * connection
	 * 
	 * @throws NullPointerException
	 *           If SQL connection is not connected, a null pointer exception will
	 *           be thrown
	 */
	public DonationManager() throws NullPointerException {
		super();
		if ((this.conn = new MySQLConnection().getMyOracleConnection()) == null) {
			throw new NullPointerException();
		}
	}

	@Override
	public void add(AbstractDonation donation) {
		UUID key = donation.getID();
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

	/**
	 * @param project
	 *          The donation object that has just been created to be saved in the
	 *          DB
	 * 
	 *          The method creates an instance in the Donations Table in the DB.
	 */
	@Override
	public int create(AbstractDonation donation) {
		try {
			CallableStatement stmt = conn.prepareCall("{call create_donation(?,?,?,?,?)}");

			stmt.setString(1, donation.getID().toString());
			stmt.setString(2, donation.getDonor().getID().toString());
			stmt.setString(3, donation.getType_id().toString());
			stmt.setString(4, donation.getType().toString());
			stmt.setFloat(5, (float) donation.getDonationAmount());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 
	 * @project Current donation with the new updated values
	 * 
	 *          Method to update an existing donation in the Donation table in the
	 *          database.
	 * 
	 */
	@Override
	public int update(AbstractDonation donation) {
		try {
			CallableStatement stmt = conn.prepareCall("{call update_donation(?,?,?,?,?)}");

			stmt.setString(1, donation.getID().toString());
			stmt.setString(2, donation.getDonor().getID().toString());
			stmt.setString(3, donation.getType_id().toString());
			stmt.setString(4, donation.getType().toString());
			stmt.setFloat(5, (float) donation.getDonationAmount());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * @project The donation object to be delete
	 * 
	 *          Method to delete the donation value in the Database
	 * 
	 */
	@Override
	public int delete(AbstractDonation donation) {
		try {
			CallableStatement stmt = conn.prepareCall("{call delete_donation(?)}");

			stmt.setString(1, donation.getID().toString());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param UUID
	 *          id Donation ID
	 * @param String...
	 *          value List of donations that can be found from (donor_name,
	 *          project_name, item_name, portal_name)
	 */
	@Override
	public AbstractDonation find(UUID id, String... value) {
		AbstractDonation donation = null;

		try {
			CallableStatement stmt = conn.prepareCall("{call find_donation(?,?,?,?,?,?,?,?,?,?)}");

			if (value.length > 0) {
				stmt.setString(1, value[0]);
				stmt.setString(2, value[1]);
				stmt.setString(3, value[2]);
				stmt.setString(4, value[3]);
			} else {
				stmt.setString(1, "");
				stmt.setString(2, "");
				stmt.setString(3, "");
				stmt.setString(4, "");
			}
			
			stmt.registerOutParameter(1, Types.VARCHAR);
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.registerOutParameter(4, Types.VARCHAR);
			stmt.registerOutParameter(5, Types.FLOAT);
			stmt.registerOutParameter(6, Types.DATE);
			
			stmt.executeQuery();
			
			String type = stmt.getObject(4).toString();
			
			if (type.equals(Type.PORTAL.toString())){
				donation = new PortalDonation(null, 0.00D, null);
			} else if (type.equals(Type.PROJECT.toString())){
				donation = new ProjectDonation(null, 0.00D, null);
			} else {
				donation = new ItemDonation(null, 0.00D, null);
			}
			
			//Get Donor first
			DonorManager tempManager = new DonorManager();
			Donor donor = tempManager.find((UUID) stmt.getObject(2), "", "");
			
			donation.setDonationId((UUID) stmt.getObject(1));
			donation.setDonor(donor);
			donation.setType_id((UUID) stmt.getObject(3));
			donation.setType((Type) stmt.getObject(4));
			donation.setDonationAmount((Double) stmt.getObject(5));
			donation.setTime_created((Date) stmt.getObject(6));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return donation;
	}

	@Override
	public List<AbstractDonation> findAll() {
		List<AbstractDonation> donationList = new ArrayList<AbstractDonation>();

		try {
			CallableStatement stmt;

			stmt = conn.prepareCall("{call findAll_donations(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);

			while (rs.next()) {
				AbstractDonation donation = null;
				
				String type = rs.getString(4);
				
				if (type.equals(Type.PORTAL.toString())){
					donation = new PortalDonation(null, 0.00D, null);
				} else if (type.equals(Type.PROJECT.toString())){
					donation = new ProjectDonation(null, 0.00D, null);
				} else {
					donation = new ItemDonation(null, 0.00D, null);
				}
				
				//Get Donor first
				DonorManager tempManager = new DonorManager();
				Donor donor = tempManager.find((UUID) stmt.getObject(2), "", "");
				
				donation.setDonationId((UUID) stmt.getObject(1));
				donation.setDonor(donor);
				donation.setType_id((UUID) stmt.getObject(3));
				donation.setType((Type) stmt.getObject(4));
				donation.setDonationAmount((Double) stmt.getObject(5));
				donation.setTime_created((Date) stmt.getObject(6));
			
				donationList.add(donation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return donationList;
	}

	@Override
	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
