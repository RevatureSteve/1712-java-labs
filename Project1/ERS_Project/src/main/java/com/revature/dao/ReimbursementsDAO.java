package com.revature.dao;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


import javax.sql.rowset.serial.SerialBlob;

import com.revature.model.ERS_Reimbursement_Status;
import com.revature.model.ERS_Reimbursement_Type;
import com.revature.model.ERS_Reimbursements;
import com.revature.model.ERS_Users;

public class ReimbursementsDAO implements ReimbursementsDAOContract {

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
	public boolean createReimbursement(ERS_Reimbursements rmbt) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			CallableStatement statement = conn.prepareCall("{call insert_reimbursements_null_id(?,?,?,?,?,?,?,?,?)}");
			statement.setDouble(1, rmbt.getR_amount());
			statement.setString(2, rmbt.getR_description());
			statement.setBinaryStream(3, new ByteArrayInputStream(rmbt.getR_receipt()), rmbt.getR_receipt().length);
			statement.setTimestamp(4, Timestamp.valueOf(rmbt.getR_submitted()));
			statement.setTimestamp(5, Timestamp.valueOf(rmbt.getR_resolved()));
			statement.setInt(6, rmbt.getU_id_author());
			statement.setInt(7, rmbt.getU_id_resolver());
			statement.setInt(8, rmbt.getRt_type());
			statement.setInt(9, rmbt.getRt_status());
			statement.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
		
	}
	
	
	@Override
	public boolean createBasicReimbursement(ERS_Reimbursements rmbt) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			CallableStatement statement = conn.prepareCall("{call insert_reimbursements_basic(?,?,?,?,?)}");
			statement.setDouble(1, rmbt.getR_amount());
			statement.setString(2, rmbt.getR_description());
			statement.setNull(3, java.sql.Types.BLOB);
			statement.setInt(4, rmbt.getU_id_author());
			statement.setInt(5, rmbt.getRt_type());
			statement.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
		
	}
	

	@Override
	public ERS_Reimbursements selectReimbursementById(int id) {
		
		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursements WHERE r_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				byte[] bytes = null;
				if(rs.getBlob("r_receipt") != null) {
					bytes = rs.getBlob("r_receipt").getBytes(1, (int)rs.getBlob("r_receipt").length());
				}
				else
				{
					bytes = new byte[1];
				}
				
				reimbursements.add(new ERS_Reimbursements(rs.getInt("r_id") , 
				rs.getDouble("r_amount"),
				rs.getString("r_description"),
				bytes,
				rs.getString("r_submitted"),
				rs.getString("r_resolved"),
				rs.getInt("u_id_author"),
				rs.getInt("u_id_resolver"),
				rs.getInt("rt_type"),
				rs.getInt("rt_status")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		//check if list is empty
		if(reimbursements.isEmpty() == false)
		{
			return reimbursements.get(0);
		}
		else
		{
			return new ERS_Reimbursements();
		}
		 
	}

	@Override
	public List<ERS_Reimbursements> selectAllReimbursements() {

		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursements";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				byte[] bytes = null;
				if(rs.getBlob("r_receipt") != null) {
					bytes = rs.getBlob("r_receipt").getBytes(1, (int)rs.getBlob("r_receipt").length());
				}
				else
				{
					bytes = new byte[1];
				}
				
				reimbursements.add(new ERS_Reimbursements(rs.getInt("r_id") , 
				rs.getDouble("r_amount"),
				rs.getString("r_description"),
				bytes,
				rs.getString("r_submitted"),
				rs.getString("r_resolved"),
				rs.getInt("u_id_author"),
				rs.getInt("u_id_resolver"),
				rs.getInt("rt_type"),
				rs.getInt("rt_status")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<ERS_Reimbursements> selectReimbursementsByAuthor(ERS_Users author) {

		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursements WHERE u_id_author=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, author.getU_id());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				byte[] bytes = null;
				if(rs.getBlob("r_receipt") != null) {
					bytes = rs.getBlob("r_receipt").getBytes(1, (int)rs.getBlob("r_receipt").length());
				}
				else
				{
					bytes = new byte[1];
				}
				
				reimbursements.add(new ERS_Reimbursements(rs.getInt("r_id") , 
				rs.getDouble("r_amount"),
				rs.getString("r_description"),
				bytes,
				rs.getString("r_submitted"),
				rs.getString("r_resolved"),
				rs.getInt("u_id_author"),
				rs.getInt("u_id_resolver"),
				rs.getInt("rt_type"),
				rs.getInt("rt_status")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<ERS_Reimbursements> selectReimbursementsByResolver(ERS_Users resolver) {

		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursements WHERE u_id_resolver=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, resolver.getU_id());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				byte[] bytes = null;
				if(rs.getBlob("r_receipt") != null) {
					bytes = rs.getBlob("r_receipt").getBytes(1, (int)rs.getBlob("r_receipt").length());
				}
				else
				{
					bytes = new byte[1];
				}
				
				reimbursements.add(new ERS_Reimbursements(rs.getInt("r_id") , 
				rs.getDouble("r_amount"),
				rs.getString("r_description"),
				bytes,
				rs.getString("r_submitted"),
				rs.getString("r_resolved"),
				rs.getInt("u_id_author"),
				rs.getInt("u_id_resolver"),
				rs.getInt("rt_type"),
				rs.getInt("rt_status")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<ERS_Reimbursements> selectReimbursementsByType(ERS_Reimbursement_Type type) {

		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursements WHERE rt_type=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, type.getRt_id());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				byte[] bytes = null;
				if(rs.getBlob("r_receipt") != null) {
					bytes = rs.getBlob("r_receipt").getBytes(1, (int)rs.getBlob("r_receipt").length());
				}
				else
				{
					bytes = new byte[1];
				}
				
				reimbursements.add(new ERS_Reimbursements(rs.getInt("r_id") , 
				rs.getDouble("r_amount"),
				rs.getString("r_description"),
				bytes,
				rs.getString("r_submitted"),
				rs.getString("r_resolved"),
				rs.getInt("u_id_author"),
				rs.getInt("u_id_resolver"),
				rs.getInt("rt_type"),
				rs.getInt("rt_status")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public List<ERS_Reimbursements> selectReimbursementsByStatus(ERS_Reimbursement_Status status) {

		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "SELECT * FROM ers_reimbursements WHERE rt_status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, status.getRs_id());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				byte[] bytes = null;
				if(rs.getBlob("r_receipt") != null) {
					bytes = rs.getBlob("r_receipt").getBytes(1, (int)rs.getBlob("r_receipt").length());
				}
				else
				{
					bytes = new byte[1];
				}
				
				reimbursements.add(new ERS_Reimbursements(rs.getInt("r_id") , 
				rs.getDouble("r_amount"),
				rs.getString("r_description"),
				bytes,
				rs.getString("r_submitted"),
				rs.getString("r_resolved"),
				rs.getInt("u_id_author"),
				rs.getInt("u_id_resolver"),
				rs.getInt("rt_type"),
				rs.getInt("rt_status")));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return reimbursements;
	}
// r_amount = ?, r_description = ?, r_receipt = ? , r_submitted = ?, r_resolved = ?, u_id_author = ?, u_id_resolver = ?, rt_type = ?, rt_status = ? WHERE
	@Override
	public boolean updateReimbursement(ERS_Reimbursements rmbt) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "UPDATE ers_reimbursements SET r_amount = ?, r_description = ?, r_receipt = ? , r_submitted = ?, r_resolved = ?, u_id_author = ?, u_id_resolver = ?, rt_type = ?, rt_status = ? WHERE r_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(rmbt.getR_resolved() == null) {
				rmbt.setR_resolved("");
			}
			
			
			ps.setDouble(1, rmbt.getR_amount());
			ps.setString(2, rmbt.getR_description());
			ps.setBinaryStream(1, new ByteArrayInputStream(rmbt.getR_receipt()), rmbt.getR_receipt().length);
			ps.setTimestamp(4, Timestamp.valueOf(rmbt.getR_submitted()));
			
			if(!rmbt.getR_resolved().equals("")) {
				ps.setTimestamp(5, Timestamp.valueOf(rmbt.getR_resolved()));
			}
			else
			{
				ps.setTimestamp(5, null);
			}
			ps.setInt(6, rmbt.getU_id_author());
			ps.setInt(7, rmbt.getU_id_resolver());
			ps.setInt(8, rmbt.getRt_type());
			ps.setInt(9, rmbt.getRt_status());
			ps.setInt(10, rmbt.getR_id());
			
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
public boolean updateReimbursementAddReceipt(ERS_Reimbursements rmbt) {
		
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "UPDATE ers_reimbursements SET r_receipt = ? WHERE r_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			//ps.setBlob(1, (Blob)rmbt.getR_receipt());
			
			
			ps.setBinaryStream(1, new ByteArrayInputStream(rmbt.getR_receipt()), rmbt.getR_receipt().length);
			
			ps.setInt(2, rmbt.getR_id());
			
			ps.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	

	@Override
	public boolean deleteReimbursement(ERS_Reimbursements rmbt) {
		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "DELETE FROM ers_reimbursements WHERE r_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, rmbt.getR_id());
			
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
	}


	@Override
	public boolean resolveReimbursement(ERS_Reimbursements rmbt) {

		try(Connection conn = DriverManager.getConnection(url, username, password)) 
		{
			String sql = "UPDATE ers_reimbursements SET r_resolved = CURRENT_TIMESTAMP, u_id_resolver = ?, rt_status = ? WHERE r_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, rmbt.getU_id_resolver());
			ps.setInt(2, rmbt.getRt_status());
			ps.setInt(3, rmbt.getR_id());
			
			ps.executeQuery();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return true;
		
		
	}

}
