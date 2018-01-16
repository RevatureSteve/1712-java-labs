package com.revature.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementStatusDAO;
import com.revature.dao.ReimbursementTypeDAO;
import com.revature.dao.ReimbursementsDAO;
import com.revature.dao.UserRolesDAO;
import com.revature.dao.UsersDAO;
import com.revature.dto.ReimbursementBasicDTO;
import com.revature.dto.ReimbursementFullDTO;
import com.revature.model.ERS_Reimbursement_Status;
import com.revature.model.ERS_Reimbursement_Type;
import com.revature.model.ERS_Reimbursements;
import com.revature.model.ERS_User_Roles;
import com.revature.model.ERS_Users;

import oracle.sql.BLOB;

public class AppService {
	
	public static AppService appService = new AppService();
	
	private AppService() {
		super();
	}
	
	public ERS_Users getUserById(int id) {
		UsersDAO dao = new UsersDAO();
		return dao.selectUserById(id);
	}
	
	public List<ERS_Users> getAllEmployees(){
		UsersDAO dao = new UsersDAO();
		
		UserRolesDAO rDao = new UserRolesDAO();
		
		List<ERS_User_Roles> roles = rDao.selectAllRoles();
		ERS_User_Roles remp = null;
		
		for(ERS_User_Roles r : roles) {
			if(r.getUr_role().equals("Employee")) {
				remp = r;
			}
		}
		
		List<ERS_Users> employees = new ArrayList<>();
		
		employees = dao.selectUsersByRole(remp);
		
		return employees;
	}
	
	public boolean resolveReimbursement(ERS_Reimbursements rmbt) {
		
		ReimbursementsDAO dao = new ReimbursementsDAO();
		
		return dao.resolveReimbursement(rmbt);
	}
	
	public List<ERS_Reimbursements> getReimbursementsByUser(ERS_Users user) {
		ReimbursementsDAO dao = new ReimbursementsDAO();
		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		
		reimbursements = dao.selectReimbursementsByAuthor(user);
		return reimbursements;
		
	}
	
	public List<ReimbursementBasicDTO> getBasicRmbtByUser(ERS_Users user) {
		ReimbursementsDAO dao = new ReimbursementsDAO();
		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		List<ReimbursementBasicDTO> basics = new ArrayList<>();
		
		reimbursements = dao.selectReimbursementsByAuthor(user);
		
		for(ERS_Reimbursements r : reimbursements) {
			basics.add(new ReimbursementBasicDTO(
					r.getR_id(),
					r.getU_id_author(),
					r.getR_amount(),
					r.getR_submitted(),
					getTypeById(r.getRt_type()).getRt_type(),
					getStatusById(r.getRt_status()).getRs_status()));
		}
		return basics;
		
	}
	

	public List<ReimbursementBasicDTO> getAllBasicReimbursements() {
		ReimbursementsDAO dao = new ReimbursementsDAO();
		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		List<ReimbursementBasicDTO> basics = new ArrayList<>();
		
		reimbursements = dao.selectAllReimbursements();
		
		for(ERS_Reimbursements r : reimbursements) {
			basics.add(new ReimbursementBasicDTO(
					r.getR_id(),
					r.getU_id_author(),
					r.getR_amount(),
					r.getR_submitted(),
					getTypeById(r.getRt_type()).getRt_type(),
					getStatusById(r.getRt_status()).getRs_status()));
		}
		return basics;
		
	}
	
	public List<ERS_Reimbursements> getAllReimbursements() {
		ReimbursementsDAO dao = new ReimbursementsDAO();
		List<ERS_Reimbursements> reimbursements = new ArrayList<>();
		
		reimbursements = dao.selectAllReimbursements();
		return reimbursements;
		
	}
	
	public ERS_Users validateUser(ERS_Users user) {
		ERS_Users dbUser = null;
		
		UsersDAO userDAO = new UsersDAO();
		
		dbUser = userDAO.selectUserByLogin(user);
		if(dbUser != null) {
			return dbUser;
		}
		return null;
	}
	
	public ERS_User_Roles validateRole(ERS_Users user) {
		
		ERS_User_Roles dbRole = null;
		
		System.out.println("Validating role");
		//UsersDAO userDAO = new UsersDAO();
		UserRolesDAO roleDAO = new UserRolesDAO();
		
		try {
			dbRole = roleDAO.selectRoleById(user.getUr_id());
		}
		catch (NullPointerException e) {
			dbRole = null;
		}
		
		if(dbRole != null) {
			return dbRole;
			
		}
		return null;
	}
	
	public List<ERS_Reimbursement_Type> getTypes() {
		
		ReimbursementTypeDAO typeDAO = new ReimbursementTypeDAO();
		List<ERS_Reimbursement_Type> types = new ArrayList<>();
		
		types = typeDAO.selctAllTypes();
		return types;
		
	}
	
	public ERS_Reimbursement_Type getTypeById(int id) {
		
		ReimbursementTypeDAO typeDAO = new ReimbursementTypeDAO();
		ERS_Reimbursement_Type type = typeDAO.selectTypeById(id);
		
		return type;
		
	}
	
	public ERS_Reimbursement_Status getStatusById(int id) {
		
		ReimbursementStatusDAO statDAO = new ReimbursementStatusDAO();
		ERS_Reimbursement_Status status = statDAO.selectStatusById(id);
		
		return status;
	}
	
	public List<ERS_Reimbursement_Status> getStatuses() {
		ReimbursementStatusDAO statDAO = new ReimbursementStatusDAO();
		List<ERS_Reimbursement_Status> statuses = new ArrayList<>();
		statuses = statDAO.selectAllStatuses();
		
		return statuses;
	}
	
	public boolean submitRequest(ERS_Reimbursements rRequest) {
		
		ReimbursementsDAO dao = new ReimbursementsDAO();
		dao.createBasicReimbursement(rRequest);
		return true;
	}
	
	public ERS_Users validateUserUpdate(ERS_Users user) {
		
		ERS_Users dbUser = null; //used to hold value from database
		ERS_Users updateUser = null; //used to hold input value when changing email to keep unique
		UsersDAO userDAO = new UsersDAO();
		ERS_Users returnUser = null;
		
		dbUser = userDAO.selectUserByEmail(user);
		
		if(dbUser != null)
		{
			if(dbUser.getU_id() != user.getU_id())
			{
				System.err.println("Email is not unique.");
				updateUser = user;
				updateUser.setU_email(userDAO.selectUserById(user.getU_id()).getU_email());
				
				userDAO.updateUser(updateUser);
				returnUser = userDAO.selectUserById(user.getU_id());
			}
			else
			{
				updateUser = user;
				userDAO.updateUser(updateUser);
				returnUser = userDAO.selectUserById(user.getU_id());
			}
		}
		else
		{
			userDAO.updateUser(user);
			returnUser = userDAO.selectUserById(user.getU_id());
		}
		
		return returnUser;
	}

	public ERS_Reimbursements getReimbursementById(int id) {
		ReimbursementsDAO dao = new ReimbursementsDAO();
		ERS_Reimbursements rmbt = dao.selectReimbursementById(id);
		return rmbt;
	}
	
	public ReimbursementFullDTO getReimbursementDetailsById(int id, ERS_Users clientUser) {
		ReimbursementsDAO dao = new ReimbursementsDAO();
		UsersDAO uDao = new UsersDAO();
		ERS_Reimbursements rmbt = dao.selectReimbursementById(id);
		
		ERS_User_Roles role = validateRole(clientUser);
		String roleString = role.getUr_role();
		
		
		ERS_Users resolver = uDao.selectUserById(rmbt.getU_id_resolver());
		
		String resolverString = "";
		int resolverId = 0;
		
		if(resolver != null) {
			resolverString = resolver.getU_firstname() + " " + resolver.getU_lastname();
			resolverId = resolver.getU_id();
		}
		String requesterString = clientUser.getU_firstname() + " " + clientUser.getU_lastname();
		ERS_Users authorUser = getUserById(rmbt.getU_id_author());
		String authorString = authorUser.getU_firstname() + " " + authorUser.getU_lastname();
		
		ReimbursementFullDTO dto = new ReimbursementFullDTO(roleString, rmbt.getR_id(), 
				rmbt.getR_amount(), rmbt.getR_description(), /*rmbt.getR_receipt(),*/ rmbt.getR_submitted(), 
				rmbt.getR_resolved(), authorString , rmbt.getU_id_author() , resolverString, resolverId, 
				getTypeById(rmbt.getRt_type()).getRt_type(), getStatusById(rmbt.getRt_status()).getRs_status());
		
		
		return dto;
	}
	/*
	public ERS_Reimbursements putInBlob(ERS_Reimbursements rmbt, byte[] data) {
		
		String url = "jdbc:oracle:thin:@usfjava.cm2ler9nwgmt.us-east-2.rds.amazonaws.com:1521:orcl";
		String username = "ersdb";
		String password = "pass1234";
		
		BLOB blob = null;
		
		try {
		Connection conn = DriverManager.getConnection(url, username, password);
		
		blob = new BLOB((oracle.jdbc.OracleConnection)conn, data);
		
		rmbt.setR_receipt(blob);
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rmbt;
	}
	*/
	
	public boolean updateReimbursement(ERS_Reimbursements rmbt) {
		
		ReimbursementsDAO dao = new ReimbursementsDAO();
		
		try {
			return dao.updateReimbursement(rmbt);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean updateReimbursementAddReceipt(ERS_Reimbursements rmbt) {
		
		ReimbursementsDAO dao = new ReimbursementsDAO();
		
		try {
			return dao.updateReimbursementAddReceipt(rmbt);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean registerEmployee(ERS_Users newUser) {
		
		UsersDAO dao = new UsersDAO();
		UserRolesDAO rDao = new UserRolesDAO();
		
		List<ERS_User_Roles> roles = rDao.selectAllRoles();
		
		for(ERS_User_Roles r : roles) {
			if(r.getUr_role().equals("Employee")) {
				newUser.setUr_id(r.getUr_id());
				break;
			}
		}
		try {
			return dao.createUser(newUser);
		}
		catch (Exception e) {
			System.err.println("could not insert value.");
			return false;
		}
	}


}
