package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.ERS_User_Roles;

public class UserRolesDAO implements UserRolesDAOContract {

	private static String url = "jdbc:oracle:thin:@usfjava.cm2ler9nwgmt.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "ersdb";
	private static String password = "pass1234";
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean createRole(ERS_User_Roles role) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			CallableStatement statement = conn.prepareCall("{call insert_role_null_id(?)}");
			statement.setString(1, role.getUr_role());
			statement.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	//Select a single ERS_User_Roles object by the ur_id primary key value in the table
	@Override
	public ERS_User_Roles selectRoleById(int id) {

		List<ERS_User_Roles> roles = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_user_roles WHERE ur_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next())
			{
				roles.add(new ERS_User_Roles(rs.getInt("ur_id") , rs.getString("ur_role")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//check if list is empty
		if(roles.isEmpty() == false)
		{
			return roles.get(0);
		}
		else
		{
			return new ERS_User_Roles();
		}
	}

	@Override
	public List<ERS_User_Roles> selectAllRoles() {
		List<ERS_User_Roles> roles = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_user_roles";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				roles.add(new ERS_User_Roles(rs.getInt("ur_id") , rs.getString("ur_role")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return roles;
	}

	@Override
	public boolean updateRole(ERS_User_Roles role) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "UPDATE ers_user_roles SET ur_role = ? WHERE ur_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, role.getUr_role());
			ps.setInt(2, role.getUr_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}

	@Override
	public boolean deleteRole(ERS_User_Roles role) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "DELETE FROM ers_user_roles WHERE ur_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, role.getUr_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}

}
