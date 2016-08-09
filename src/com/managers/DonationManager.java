package com.managers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import com.donations.AbstractDonation;
import com.interfaces.IPortal;
import com.interfaces.MyDAO;
import com.sqlConnection.MySQLConnection;

public class DonationManager implements IPortal<AbstractDonation>, MyDAO<AbstractDonation> {

	Hashtable<UUID, AbstractDonation> donationList = new Hashtable<UUID, AbstractDonation>();

	Connection conn;

	/**
	 * DonationManager constructor that takes in no argument and instantiate SQL connection
	 * 
	 * @throws NullPointerException If SQL connection is not connected, a null pointer exception will be thrown
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

	@Override
	public int create(AbstractDonation t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AbstractDonation t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(AbstractDonation t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AbstractDonation find(UUID id, String... value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AbstractDonation> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
