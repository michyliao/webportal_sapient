package com.application;

import java.sql.*;
import java.util.List;

import com.managers.DonorManager;
import com.managers.ProjectManager;
import com.portalObjects.Donor;
import com.portalObjects.Project;
import com.sqlConnection.MySQLConnection;

import oracle.jdbc.OracleTypes;

public class TestDatabaseApplication {

	public static void main(String[] agrs) {
//		Connection con = MySQLConnection.getMyOracleConnection();
//
//		CallableStatement stmt;
//		try {
//
//			stmt = con.prepareCall("{call findALL_donations(?)}");
//			stmt.registerOutParameter(1, OracleTypes.CURSOR);
//
//			stmt.execute();
//			ResultSet rs = (ResultSet) stmt.getObject(1);
//
//			while (rs.next()) {
//				// System.out.println(rs.getString(1) + "\t" +
//				// rs.getFloat(2) + "\t" +
//				// rs.getDate(3).toString());
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//    Project cureCancer = new Project("Cure Cancer", "Cancer research facility", 1000);
//    Project oldAgeHome = new Project("Old Age Home", "Home for old people", 6000);

    ProjectManager manager = new ProjectManager();
    
//    manager.create(oldAgeHome);
    
    List<Project> list = manager.findAll();
    for(Project project : list){
    	System.out.println(project);
    }
    
    Donor donorOne = new Donor("Person One", "person1@mail.com");
    Donor donorTwo = new Donor("Person Two", "person2@mail.com");
    
    DonorManager dManager = new DonorManager();
//    dManager.create(donorOne);
//    dManager.create(donorTwo);
    
    for (Donor donor : dManager.findAll()){
    	System.out.println(donor);
    }
	
	}

}
