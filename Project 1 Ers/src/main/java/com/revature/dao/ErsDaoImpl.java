package com.revature.dao;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dto.ErsReimbursementDTO;
import com.revature.dto.ErsUserDTO;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsReimbursementStatus;
import com.revature.model.ErsReimbursementType;
import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;

public class ErsDaoImpl implements ErsDao {
	
	private static ErsDao ersDao;
	
	private final String url = "jdbc:oracle:thin:@usfdbjava.cyrhutrhmjas.us-east-2.rds.amazonaws.com:1521:orcl";
	private final String username = "proj1";
	private final String password = "p4ssw0rd";
	
	static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }      
	
	private ErsDaoImpl() {
	}
	
	public static ErsDao getDao() {
		if (ersDao == null) ersDao = new ErsDaoImpl();
		return ersDao;
	}


	//-------------------------CREATE
	
	public int insertReimbursement(ErsReimbursement re) {
		if (re == null) return -1;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "INSERT INTO ers_reimbursements (r_amount, r_description, r_receipt, u_id_author, rt_type, rt_status) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, new String[] {"r_id"});
			ps.setDouble(1, re.getAmount());
			ps.setString(2, re.getDescription());
			if (re.getReceipt() != null) {
				ps.setBinaryStream(3, new ByteArrayInputStream(re.getReceipt()), re.getReceipt().length);
			}
			else ps.setBinaryStream(3, null);
			ps.setInt(4, re.getAuthorId());
			ps.setInt(5, re.getType().getId());
			ps.setInt(6, re.getStatus().getId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();	
			if (rs.next()) return rs.getInt(1);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	@Override
	public int insertUser(ErsUser user) {
		if (user == null) return -1;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "INSERT INTO ers_users (u_username, u_password, u_firstname, u_lastname, u_email, ur_id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql, new String[] {"u_id"});
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5,  user.getEmail());
			ps.setInt(6, user.getRole().getId());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();	
			if (rs.next()) return rs.getInt(1);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	//----------------------------------------READ
	
	public ErsUser getUserById(ErsUser user) {
		if (user == null) return null;
		ErsUser dbUser = null;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT * FROM ers_users WHERE u_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dbUser = new ErsUser(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"), 
									   rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"), 
									   rs.getInt("ur_id"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dbUser;
	}
	
	public ErsUser getUserById(int id) {
		ErsUser dbUser = null;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT * FROM ers_users WHERE u_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dbUser = new ErsUser(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"), 
									   rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"), 
									   rs.getInt("ur_id"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dbUser;
	}

	public ErsUser getUserByUsername(ErsUser user) {
		if (user == null) return null;
		ErsUser dbUser = null;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT * FROM ers_users WHERE u_username=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dbUser = new ErsUser(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"), 
									   rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"), 
									   rs.getInt("ur_id"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return dbUser;
	}
	
	@Override
	public List<ErsUser> getAllUsers() {
		List<ErsUser> lst = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT * FROM ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lst.add(new ErsUser(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"), 
						rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"), 
						rs.getInt("ur_id")));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public List<ErsUserDTO> getAllUsersDTO() {
		List<ErsUserDTO> lst = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT * FROM ers_users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lst.add(new ErsUserDTO(rs.getInt("u_id"), rs.getString("u_username"), 
						rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"), 
						ErsUserRole.findById(rs.getInt("ur_id")).toString()));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	
	@Override
	public List<ErsReimbursement> getAllReimbursementsByUser(ErsUser user) {
		if (user == null) return null;
		List<ErsReimbursement> lst = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT r_id, r_amount, r_description, r_submitted, r_resolved, u_id_author, u_id_resolver, rt_type, rt_status FROM ers_reimbursements WHERE u_id_author=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ErsReimbursement re = new ErsReimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_description"), 
						null, rs.getTimestamp("r_submitted"), rs.getTimestamp("r_resolved"), 
						rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), rs.getInt("rt_type"), rs.getInt("rt_status"));
//				Blob receiptBlob = rs.getBlob("r_receipt");
//				if (receiptBlob != null) {
//					byte[] receipt = receiptBlob.getBytes(1, (int) receiptBlob.length());
//					re.setReceipt(receipt);
//				}
				lst.add(re);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	@Override
	public ErsReimbursement getReimbursementById(int id) {
		ErsReimbursement re = null;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT r_id, r_amount, r_description, r_submitted, r_resolved, u_id_author, u_id_resolver, rt_type, rt_status FROM ers_reimbursements WHERE r_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
//				re = new ErsReimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_description"), 
//										  rs.getBlob("r_receipt"), rs.getTimestamp("r_submitted"),
//										  rs.getTimestamp("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), 
//										  rs.getInt("rt_type"), rs.getInt("rt_status"));
				re = new ErsReimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_description"), 
						null, rs.getTimestamp("r_submitted"), rs.getTimestamp("r_resolved"), 
						rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), rs.getInt("rt_type"), rs.getInt("rt_status"));
//				Blob receiptBlob = rs.getBlob("r_receipt");
//				if (receiptBlob != null) {
//					byte[] receipt = receiptBlob.getBytes(1, (int) receiptBlob.length());
//					re.setReceipt(receipt);
//				}
				return re;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return re;
	}
	
	@Override
	public List<ErsReimbursement> getAllReimbursements() {
		List<ErsReimbursement> lst = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT qr_id, r_amount, r_description, r_submitted, r_resolved, u_id_author, u_id_resolver, rt_type, rt_status FROM ers_reimbursements";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				lst.add(new ErsReimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_description"), 
//						rs.getBlob("r_receipt"), rs.getTimestamp("r_submitted"), rs.getTimestamp("r_resolved"), 
//						rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), rs.getInt("rt_type"), rs.getInt("rt_status")));
				ErsReimbursement re = new ErsReimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_description"), 
						null, rs.getTimestamp("r_submitted"), rs.getTimestamp("r_resolved"), 
						rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), rs.getInt("rt_type"), rs.getInt("rt_status"));
//				Blob receiptBlob = rs.getBlob("r_receipt");
//				if (receiptBlob != null) {
//					byte[] receipt = receiptBlob.getBytes(1, (int) receiptBlob.length());
//					re.setReceipt(receipt);
//				}
				lst.add(re);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public List<ErsReimbursementDTO> getAllReimbursementDTO() {
		List<ErsReimbursementDTO> lst = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String selectors = "u1.u_id, u1.u_username, u1.u_firstname, u1.u_lastname, u1.u_email, u1.ur_id, "
					+ "u2.u_id, u2.u_username, u2.u_firstname, u2.u_lastname, u2.u_email, u2.ur_id, "
					+ "r_id, r_amount, r_description, r_submitted, r_resolved, rt_type, rt_status";
			String sql = "SELECT " + selectors + " FROM (ers_users u1 INNER JOIN ers_reimbursements re ON u1.u_id=re.u_id_author) LEFT OUTER JOIN ers_users u2 ON u_id_resolver=u2.u_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ErsUserDTO author = new ErsUserDTO(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_firstname"),
						rs.getString("u_lastname"), rs.getString("u_email"), ErsUserRole.findById(rs.getInt("ur_id")).toString());
				ErsUserDTO resolver = new ErsUserDTO(rs.getInt(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), ErsUserRole.findById(rs.getInt(12)).toString());
				ErsReimbursementDTO re = new ErsReimbursementDTO(rs.getInt("r_id"), rs.getDouble("r_amount"), rs.getString("r_description"),
						null, rs.getTimestamp("r_submitted"), rs.getTimestamp("r_resolved"), author, resolver,
						ErsReimbursementType.findById(rs.getInt("rt_type")).toValue(), ErsReimbursementStatus.findById(rs.getInt("rt_status")).toValue());
				lst.add(re);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return lst;
		
	}
	
	public byte[] getReimbursementReceiptByReimbursementId(int id) {
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "SELECT r_receipt FROM ers_reimbursements WHERE r_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Blob receiptBlob = rs.getBlob("r_receipt");
				if (receiptBlob != null) return receiptBlob.getBytes(1, (int) receiptBlob.length());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	
	//------------------------------UPDATE
	
	@Override
	public void updateUser(ErsUser user) {
		if (user == null) return;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "UPDATE ers_users SET u_username=?, u_password=?, u_firstname=?, u_lastname=?, u_email=?, ur_id=? WHERE u_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstname());
			ps.setString(4, user.getLastname());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRole().getId());
			ps.setInt(7, user.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReimbursementDetails(ErsReimbursement re) {
		if (re == null) return;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "UPDATE ers_reimbursements SET r_amount=?, r_description=?, r_receipt=?, rt_type=? WHERE r_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, re.getAmount());
			ps.setString(2, re.getDescription());
			ps.setBlob(3, new ByteArrayInputStream(re.getReceipt()));
			ps.setInt(4, re.getType().getId());
			ps.setInt(5, re.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateReimbursementStatus(ErsReimbursement re) {
		if (re == null) return;
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "call update_reimbursement_status(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, re.getId());
			ps.setInt(2, re.getResolverId());
			ps.setInt(3, re.getStatus().getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//------------DELETE (ONLY USED FOR TESTING)
	
	public void deleteUserById(int id) {
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "DELETE FROM ers_users WHERE u_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteReimbursementById(int id) {
		try(Connection conn = DriverManager.getConnection(this.url, this.username, this.password)) {
			String sql = "DELETE FROM ers_reimbursements WHERE r_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
