package com.managers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

import com.interfaces.IPortal;
import com.interfaces.MyDAO;
import com.portalObjects.*;
import com.sqlConnection.MySQLConnection;

import oracle.jdbc.OracleTypes;

/**
 * Project Manager class that handles project functionality of creating, and
 * storing project objects into the database - in the Projects Table.
 * 
 * @author mliao
 *
 */
public class ProjectManager implements IPortal<Project>, MyDAO<Project> {

	Hashtable<UUID, Project> projectList = new Hashtable<UUID, Project>();

	Connection conn;

	/**
	 * ProjectManager constructor that takes in no argument and instantiate SQL connection
	 * 
	 * @throws NullPointerException If SQL connection is not connected, a null pointer exception will be thrown
	 */
	public ProjectManager() throws NullPointerException {
		super();
		if ((this.conn = new MySQLConnection().getMyOracleConnection()) == null) {
			throw new NullPointerException();
		}
	}

	/**
	 * A method to add a project
	 * 
	 * @param newProject
	 *          A Project to be added
	 */
	@Override
	public void add(Project project) {
		UUID key = project.getProjID();
		projectList.put(key, project);
	}

	/**
	 * Method to print a project
	 */
	@Override
	public void print(Project project) {
		System.out.println(project);
	}

	@Override
	public Project find(String projectName) {
		Project returnProject = null;

		for (Project project : projectList.values()) {
			if (project.getName().equals(projectName)) {
				returnProject = project;
			}
		}

		return returnProject;
	}

	public void viewAllProjectsDonors() {
		for (Project project : projectList.values()) {
			System.out.println("Project Name: " + project.getName());
			System.out.println(" ------ Donors ------");

			for (Donor donor : project.getDonorList()) {
				System.out.println(donor);
			}
			System.out.println("\n");

		}
	}

	public void viewProjectDonors(String projectName) {
		Project choosenProject = this.find(projectName);
		System.out.println("Project Name: " + choosenProject.getName());

		for (Donor donor : choosenProject.getDonorList()) {
			System.out.println(donor);
		}
	}

	@Override
	public void viewAll() {
		for (Project project : projectList.values()) {
			System.out.println("Project Name: " + project.getName());
		}
	}

	@Override
	public Hashtable<UUID, Project> returnAll() {
		return projectList;
	}

	/**
	 * @param project
	 *          The project object that has just been created to be saved in the
	 *          DB
	 * 
	 *          The method creates an instance in the Project Table in the DB.
	 */
	@Override
	public int create(Project project) {
		try {
			CallableStatement stmt = conn.prepareCall("{call create_project(?,?,?,?,?)}");

			stmt.setString(1, project.getProjID().toString());
			stmt.setString(2, project.getName());
			stmt.setString(3, project.getDescription());
			stmt.setFloat(4, (float) project.getProjectCost());
			stmt.setFloat(5, (float) project.getTotalDonation());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @project Current project with the new updated values
	 * 
	 *          Method to update an existing project in the Project table in the
	 *          database.
	 * 
	 */
	@Override
	public int update(Project project) {
		try {
			CallableStatement stmt = conn.prepareCall("{call update_project(?,?,?,?,?)}");

			stmt.setString(1, project.getProjID().toString());
			stmt.setString(2, project.getName());
			stmt.setString(3, project.getDescription());
			stmt.setFloat(4, (float) project.getProjectCost());
			stmt.setFloat(5, (float) project.getTotalDonation());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @project The project object to be delete
	 * 
	 *          Method to delete the project value in the Database
	 * 
	 */
	@Override
	public int delete(Project project) {
		try {
			CallableStatement stmt = conn.prepareCall("{call delete_project(?)}");

			stmt.setString(1, project.getProjID().toString());

			stmt.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @param UUID
	 *          id Project ID
	 * @param String...
	 *          value List of string that can be found for project (name)
	 */

	@Override
	public Project find(UUID id, String... value) {

		Project project = null;

		try {
			CallableStatement stmt = conn.prepareCall("{call find_project(?,?,?,?,?,?,?,?,?,?)}");

			stmt.setString(1, id.toString());

			// Don't want a OutOfIndexArrayException
			if (value.length > 0) {
				stmt.setString(2, value[0]);
			} else {
				stmt.setString(2, "");
			}

			stmt.registerOutParameter(1, Types.VARCHAR);
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.registerOutParameter(4, Types.FLOAT);
			stmt.registerOutParameter(5, Types.FLOAT);

			stmt.executeQuery();

			project = new Project();

			project.setProjID((UUID) stmt.getObject(1));
			project.setName((String) stmt.getObject(2));
			project.setDescription((String) stmt.getObject(3));
			project.setProjectCost((Double) stmt.getObject(4));
			project.setTotalDonation((Double) stmt.getObject(5));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	/**
	 * @return a list of projects from the db
	 * 
	 *         Find all functionality for Projects.
	 */

	@Override
	public List<Project> findAll() {
		List<Project> projectList = new ArrayList<Project>();

		try {
			CallableStatement stmt;

			stmt = conn.prepareCall("{call findAll_projects(?)}");
			stmt.registerOutParameter(1, OracleTypes.CURSOR);

			stmt.execute();
			ResultSet rs = (ResultSet) stmt.getObject(1);

			while (rs.next()) {
				Project project = new Project();

				project.setProjID(UUID.fromString(rs.getString(1)));
				project.setName(rs.getString(2));
				project.setDescription(rs.getString(3));
				project.setProjectCost(rs.getFloat(4));
				project.setTotalDonation(rs.getFloat(5));

				projectList.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
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
