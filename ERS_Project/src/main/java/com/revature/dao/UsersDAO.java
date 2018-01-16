package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.ERS_User_Roles;
import com.revature.model.ERS_Users;

public class UsersDAO implements UsersDAOContract {
	
	
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
	public boolean createUser(ERS_Users user) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			System.out.println("inserting user");
			CallableStatement statement = conn.prepareCall("{call insert_user_null_id(?,?,?,?,?,?)}");
			statement.setString(1, user.getU_username());
			statement.setString(2, user.getU_password());
			statement.setString(3, user.getU_firstname());
			statement.setString(4, user.getU_lastname());
			statement.setString(5, user.getU_email());
			statement.setInt(6, user.getUr_id());
			statement.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	@Override
	public ERS_Users selectUserById(int id) {
		
		List<ERS_Users> users = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_users WHERE u_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				users.add(new ERS_Users(rs.getInt("u_id") , 
							rs.getString("u_username"),
							rs.getString("u_password"),
							rs.getString("u_firstname"),
							rs.getString("u_lastname"),
							rs.getString("u_email"),
							rs.getInt("ur_id")
							));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//check if list is empty
		if(users.isEmpty() == false)
		{
			return users.get(0);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public List<ERS_Users> selectAllUsers() {
		List<ERS_Users> users = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				users.add(new ERS_Users(rs.getInt("u_id") , 
							rs.getString("u_username"),
							rs.getString("u_password"),
							rs.getString("u_firstname"),
							rs.getString("u_lastname"),
							rs.getString("u_email"),
							rs.getInt("ur_id")
							));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public List<ERS_Users> selectUsersByRole(ERS_User_Roles role) {
		List<ERS_Users> users = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_users WHERE ur_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, role.getUr_id());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				users.add(new ERS_Users(rs.getInt("u_id") , 
							rs.getString("u_username"),
							rs.getString("u_password"),
							rs.getString("u_firstname"),
							rs.getString("u_lastname"),
							rs.getString("u_email"),
							rs.getInt("ur_id")
							));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return users;
	}

	@Override
	public boolean updateUser(ERS_Users user) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "UPDATE ers_users SET u_firstname = ? ," +
			" u_lastname = ?, u_email=?, u_password=?, ur_id = ? WHERE u_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getU_firstname());
			ps.setString(2, user.getU_lastname());
			ps.setString(3, user.getU_email());
			ps.setString(4, user.getU_password());
			ps.setInt(5, user.getUr_id());
			ps.setInt(6, user.getU_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	@Override
	public boolean updateUserPassword(ERS_Users user) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "UPDATE ers_users SET u_password =? WHERE u_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, user.getU_password());
			ps.setInt(2, user.getU_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean deleteUser(ERS_Users user) {

		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "DELETE FROM ers_users WHERE u_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getU_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
	}

	@Override
	public ERS_Users selectUserByLogin(ERS_Users login) {
		
		List<ERS_Users> users = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_users WHERE u_username=? AND u_password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, login.getU_username());
			ps.setString(2, login.getU_password());
			ResultSet rs = ps.executeQuery();

			while(rs.next())
			{
				users.add(new ERS_Users(rs.getInt("u_id") , 
							rs.getString("u_username"),
							rs.getString("u_password"),
							rs.getString("u_firstname"),
							rs.getString("u_lastname"),
							rs.getString("u_email"),
							rs.getInt("ur_id")
							));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//check if list is empty
		if(users.isEmpty() == false)
		{
			return users.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public ERS_Users selectUserByUsername(ERS_Users user) {
		List<ERS_Users> users = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_users WHERE u_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getU_username());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				users.add(new ERS_Users(rs.getInt("u_id") , 
							rs.getString("u_username"),
							rs.getString("u_password"),
							rs.getString("u_firstname"),
							rs.getString("u_lastname"),
							rs.getString("u_email"),
							rs.getInt("ur_id")
							));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//check if list is empty
		if(users.isEmpty() == false)
		{
			return users.get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public ERS_Users selectUserByEmail(ERS_Users user) {
		List<ERS_Users> users = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_users WHERE u_email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getU_email());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				users.add(new ERS_Users(rs.getInt("u_id") , 
							rs.getString("u_username"),
							rs.getString("u_password"),
							rs.getString("u_firstname"),
							rs.getString("u_lastname"),
							rs.getString("u_email"),
							rs.getInt("ur_id")
							));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//check if list is empty
		if(users.isEmpty() == false)
		{
			return users.get(0);
		}
		else
		{
			return null;
		}
	}

}
