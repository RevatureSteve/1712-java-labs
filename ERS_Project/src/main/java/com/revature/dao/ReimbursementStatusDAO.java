package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.ERS_Reimbursement_Status;
import com.revature.model.ERS_User_Roles;

public class ReimbursementStatusDAO implements ReimbursementStatusDAOContract {
	
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
	public boolean createNewStatus(ERS_Reimbursement_Status status) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			CallableStatement statement = conn.prepareCall("{call insert_status_null_id(?)}");
			statement.setString(1, status.getRs_status());
			statement.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
	}

	@Override
	public ERS_Reimbursement_Status selectStatusById(int id) {
		
		List<ERS_Reimbursement_Status> statuses = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursement_status WHERE rs_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				statuses.add(new ERS_Reimbursement_Status(rs.getInt("rs_id") , rs.getString("rs_status")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//check if list is empty
		if(statuses.isEmpty() == false)
		{
			return statuses.get(0);
		}
		else
		{
			return new ERS_Reimbursement_Status();
		}
		
	}

	@Override
	public List<ERS_Reimbursement_Status> selectAllStatuses() {
		
		List<ERS_Reimbursement_Status> statuses = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursement_status";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				statuses.add(new ERS_Reimbursement_Status(rs.getInt("rs_id") , rs.getString("rs_status")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return statuses;
		
	}

	@Override
	public boolean updateStatus(ERS_Reimbursement_Status status) {
	
	try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "UPDATE ers_reimbursement_status SET rs_status = ? WHERE rs_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, status.getRs_status());
			ps.setInt(2, status.getRs_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	return true;
	
	}

	@Override
	public boolean deleteStatus(ERS_Reimbursement_Status status) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "DELETE FROM ers_reimbursement_status WHERE rs_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status.getRs_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	return true;
	}

}
