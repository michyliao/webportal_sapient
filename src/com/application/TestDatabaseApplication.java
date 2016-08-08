package com.application;

import java.sql.*;

import oracle.jdbc.OracleTypes;
import sqlConnection.MySQLConnection;

public class TestDatabaseApplication {

	public static void main(String[] agrs) {
		Connection con = MySQLConnection.getMyOracleConnection();

		CallableStatement stmt;
		try {

			stmt = con.prepareCall("{call findALL_donations(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);

			while (rs.next()) {
				// System.out.println(rs.getString(1) + "\t" +
				// rs.getFloat(2) + "\t" +
				// rs.getDate(3).toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
