package com.managers;

import com.portalObjects.*;
import com.sqlConnection.MySQLConnection;

import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import com.interfaces.IPortal;
import com.interfaces.MyDAO;

public class DonorManager implements IPortal<Donor>, MyDAO<Donor> {

	Hashtable<UUID, Donor> donorList = new Hashtable<UUID, Donor>();

	Connection conn;

	public DonorManager() throws NullPointerException {
		super();
		if ((this.conn = new MySQLConnection().getMyOracleConnection()) == null) {
			throw new NullPointerException();
		}
	}

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

	/**
	 * @param donor
	 *          The donor object that has just been created to be saved in the DB
	 * 
	 *          The method creates an instance in the Donor Table in the DB.
	 */

	@Override
	public int create(Donor donor) {
		try {
			CallableStatement stmt = conn.prepareCall("{call create_donor(?,?,?) }");

			stmt.setString(1, donor.getID().toString());
			stmt.setString(2, donor.getName());
			stmt.setString(3, donor.getEmail());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @project Current Donor with the new updated values
	 * 
	 *          Method to update an existing donor in the Project table in the
	 *          database.
	 * 
	 */

	@Override
	public int update(Donor donor) {
		try {
			CallableStatement stmt = conn.prepareCall("{call update_donor(?,?,?) }");

			stmt.setString(1, donor.getID().toString());
			stmt.setString(2, donor.getName());
			stmt.setString(3, donor.getEmail());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * @project The donor object to be delete
	 * 
	 *          Method to delete the Donor value in the Database
	 * 
	 */
	@Override
	public int delete(Donor donor) {
		try {
			CallableStatement stmt = conn.prepareCall("{call delete_donor(?)}");

			stmt.setString(1, donor.getID().toString());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param String...
	 *          value values should be called as [name,email] if none is provided,
	 *          then put an empty string as the argument
	 */
	@Override
	public Donor find(UUID id, String... value) {
		Donor donor = null;

		try {
			CallableStatement stmt = conn.prepareCall("{call find_donor(?,?,?,?)}");
			if (!id.equals(null)){
				stmt.setString(1, id.toString());
			}else{
				stmt.setString(1, "");
			}
			
			// Don't want a OutOfIndexArrayException
			if (value.length > 0) {
				stmt.setString(2, value[0]);
				stmt.setString(3, value[1]);
			} else {
				stmt.setString(2, "");
				stmt.setString(3, "");
			}

			stmt.registerOutParameter(4, OracleTypes.CURSOR);

			stmt.executeQuery();
			ResultSet rs = (ResultSet) stmt.getObject(4);

			donor = new Donor();
			
			while (rs.next()) {	
				donor.setID(UUID.fromString(rs.getString(1)));
				donor.setName(rs.getString(2));
				donor.setEmail(rs.getString(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return donor;
	}

	/**
	 * @return a list of donors from the db
	 * 
	 *         Find all functionality for Donor.
	 */

	@Override
	public List<Donor> findAll() {
		List<Donor> donorList = new ArrayList<Donor>();

		try {
			CallableStatement stmt;

			stmt = conn.prepareCall("{call findAll_donors(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);

			while (rs.next()) {
				Donor donor = new Donor();

				donor.setID(UUID.fromString(rs.getString(1)));
				donor.setName(rs.getString(2));
				donor.setEmail(rs.getString(3));

				donorList.add(donor);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return donorList;
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
