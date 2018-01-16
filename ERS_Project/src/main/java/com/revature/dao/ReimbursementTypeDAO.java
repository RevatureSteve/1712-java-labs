package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.ERS_Reimbursement_Type;

public class ReimbursementTypeDAO implements ReimbursementTypeDAOContract {

	
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
	public boolean createType(ERS_Reimbursement_Type type) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			CallableStatement statement = conn.prepareCall("{call insert_type_null_id(?)}");
			statement.setString(1, type.getRt_type());
			statement.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
	}

	@Override
	public ERS_Reimbursement_Type selectTypeById(int id) {

		List<ERS_Reimbursement_Type> types = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursement_type WHERE rt_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				types.add(new ERS_Reimbursement_Type(rs.getInt("rt_id"), rs.getString("rt_type")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//check if list is empty
		if(types.isEmpty() == false)
		{
			return types.get(0);
		}
		else
		{
			return new ERS_Reimbursement_Type();
		}
	}

	@Override
	public List<ERS_Reimbursement_Type> selctAllTypes() {
		
		List<ERS_Reimbursement_Type> types = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursement_type";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				types.add(new ERS_Reimbursement_Type(rs.getInt("rt_id"), rs.getString("rt_type")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return types;
		
	}

	@Override
	public boolean updateType(ERS_Reimbursement_Type type) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "UPDATE ers_reimbursement_type SET rt_type = ? WHERE rt_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, type.getRt_type());
			ps.setInt(2, type.getRt_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
	}

	@Override
	public boolean deleteType(ERS_Reimbursement_Type type) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "DELETE FROM ers_reimbursement_type WHERE rt_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, type.getRt_id());
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
	}

}
