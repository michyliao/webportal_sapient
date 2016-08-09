package com.managers;

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
import com.portalObjects.*;
import com.sqlConnection.MySQLConnection;

import oracle.jdbc.OracleTypes;

public class ItemManager implements IPortal<Item>, MyDAO<Item> {

	Hashtable<UUID, Item> itemList = new Hashtable<UUID, Item>();

	Connection conn;

	public ItemManager() throws NullPointerException {
		super();
		if ((this.conn = new MySQLConnection().getMyOracleConnection()) == null) {
			throw new NullPointerException();
		}
	}

	@Override
	public void add(Item projectItem) {
		UUID key = projectItem.getID();
		itemList.put(key, projectItem);
	}

	@Override
	public void print(Item projectItem) {
		System.out.println(projectItem);
	}

	@Override
	public Item find(String name) {
		Item returnProjectItem = null;

		for (Item projectItem : itemList.values()) {
			if (projectItem.getName().equals(name)) {
				returnProjectItem = projectItem;
			}
		}

		return returnProjectItem;
	}

	@Override
	public Hashtable<UUID, Item> returnAll() {
		return itemList;
	}

	@Override
	public void viewAll() {
		for (Item item : itemList.values()) {
			System.out.println(item);
		}
	}

	/**
	 * @param item
	 *          The item object that has just been created to be saved in the DB
	 * 
	 *          The method creates an instance in the item Table in the DB.
	 */
	@Override
	public int create(Item item) {
		try {
			CallableStatement stmt = conn.prepareCall("{call create_item(?,?,?,?,?)}");

			stmt.setString(1, item.getID().toString());
			stmt.setString(2, item.getProjectID().toString());
			stmt.setString(3, item.getName());
			stmt.setString(4, item.getImg());
			stmt.setFloat(5, (float) item.getTotalDonation());

			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * 
	 * @project Current item with the new updated values
	 * 
	 *          Method to update an existing item in the item table in the
	 *          database.
	 * 
	 */
	@Override
	public int update(Item item) {

		try {
			CallableStatement stmt = conn.prepareCall("{call update_item(?,?,?,?,?)}");

			stmt.setString(1, item.getID().toString());
			stmt.setString(2, item.getProjectID().toString());
			stmt.setString(3, item.getName());
			stmt.setString(4, item.getImg());
			stmt.setFloat(5, (float) item.getTotalDonation());

			stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * @project The item object to be delete
	 * 
	 *          Method to delete the item value in the Database
	 * 
	 * 
	 */
	@Override
	public int delete(Item item) {
		try {
			CallableStatement stmt = conn.prepareCall("{call delete_item(?)}");

			stmt.setString(1, item.getID().toString());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param UUID
	 *          id item ID
	 * @param String...
	 *          value List of string that can be found for project (Item name, Project name)
	 */
	@Override
	public Item find(UUID id, String... value) {
		Item item= null;

		try {
			CallableStatement stmt = conn.prepareCall("{call find_item(?,?,?,?,?,?,?)}");

			// Don't want a OutOfIndexArrayException
			if (value.length > 0) {
				stmt.setString(1, value[0]);
				stmt.setString(2, value[1]);
			} else {
				stmt.setString(1, "");
				stmt.setString(2, "");
			}

			stmt.registerOutParameter(1, Types.VARCHAR);
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.registerOutParameter(4, Types.VARCHAR);
			stmt.registerOutParameter(5, Types.FLOAT);

			stmt.executeQuery();

			item = new Item();

			item.setItemID((UUID) stmt.getObject(1));
			item.setProjectID((UUID) stmt.getObject(2));
			item.setName((String) stmt.getObject(3));
			item.setImg((String) stmt.getObject(4));
			item.setTotalDonation((Double) stmt.getObject(5));

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return item;
	}

	/**
	 * @return a list of items from the db
	 * 
	 *         Find all functionality for Item.
	 */
	
	@Override
	public List<Item> findAll() {
		List<Item> itemDonor = new ArrayList<Item>();

		try {
			CallableStatement stmt;

			stmt = conn.prepareCall("{call findAll_items(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);

			while (rs.next()) {
				Item item = new Item();

				item.setItemID(UUID.fromString(rs.getString(1)));
				item.setProjectID(UUID.fromString(rs.getString(2)));
				item.setName(rs.getString(3));
				item.setImg(rs.getString(4));
				item.setTotalDonation( rs.getFloat(5));

				itemDonor.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemDonor;
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
