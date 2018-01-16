package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ErsDao;
import com.revature.dao.ErsDaoImpl;
import com.revature.dto.ErsReimbursementDTO;
import com.revature.dto.ErsUserDTO;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsReimbursementStatus;
import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;

public class AppServiceImpl implements AppService {
	
	private static AppService service;
	private ErsDao dao = ErsDaoImpl.getDao();
	
	private AppServiceImpl() {
	}
	
	public static AppService getService() {
		if (service == null) service = new AppServiceImpl();
		return service;
	}
	
	//-------------------------------------------------

	@Override
	public ErsUser validateUser(ErsUser user) {
		ErsUser dbUser = dao.getUserByUsername(user);
		if (dbUser != null) {
			if (dbUser.getPassword().equals(user.getPassword())) return dbUser;
		}
		return null;
	}

	@Override
	public List<ErsReimbursement> getReimbursements(ErsUser user) {
		if (user == null) return null;
		return dao.getAllReimbursementsByUser(user);
	}
	
	@Override
	public ErsReimbursement getReimbursement(int reId) {
		return dao.getReimbursementById(reId);
	}
	
	@Override
	public List<ErsReimbursement> getReimbursements(ErsUser user, ErsReimbursementStatus status) {
		if (user == null || status == null) return null;
		List<ErsReimbursement> allReimbursements = dao.getAllReimbursementsByUser(user);
		List<ErsReimbursement> filtered = new ArrayList<>();
		for(ErsReimbursement re: allReimbursements) {
			if (re.getStatus().equals(status)) filtered.add(re);
		}
		return filtered;
	}
	
	@Override
	public List<ErsReimbursement> getAllReimbursements() {
		return dao.getAllReimbursements();
	}

	@Override
	public List<ErsReimbursement> getAllReimbursements(ErsReimbursementStatus status) {
		List<ErsReimbursement> allReimbursements = dao.getAllReimbursements();
		List<ErsReimbursement> filtered = new ArrayList<>();
		for(ErsReimbursement re : allReimbursements) {
			if (re.getStatus().equals(status)) filtered.add(re);
		}
		return filtered;
	}
	
	public List<ErsReimbursementDTO> getAllReimbursementsDTO() {
		return dao.getAllReimbursementDTO();
	}

	
	@Override
	public ErsUser getUser(String username) {
		ErsUser user = new ErsUser();
		user.setUsername(username);
		return dao.getUserByUsername(user);
		
	}
	
	@Override
	public List<ErsUser> getAllUsers() {
		return dao.getAllUsers();
	}
	
	@Override
	public List<ErsUser> getAllUsers(ErsUserRole role) {
		List<ErsUser> allUsers = dao.getAllUsers();
		List<ErsUser> filtered = new ArrayList<>();
		for(ErsUser user : allUsers) {
			if (user.getRole() == role) filtered.add(user);
		}
		return filtered;
	}
	
	@Override
	public List<ErsUserDTO> getAllUsersDTO(String role) {
		List<ErsUserDTO> allUsers = dao.getAllUsersDTO();
		List<ErsUserDTO> filtered = new ArrayList<>();
		for(ErsUserDTO user : allUsers) {
			if (user.getRole().equals(role)) filtered.add(user);
		}
		return filtered;
	}
	
	public byte[] getReceiptByReimbursementId(int id) {
		return dao.getReimbursementReceiptByReimbursementId(id);

	}

	
	@Override
	public int submitReimbursementRequest(ErsReimbursement re, ErsUser user) {
		if (re == null || user == null || user.getRole() != ErsUserRole.EMPLOYEE) return -1;
		re.setAuthorId(user.getId());
		re.setStatus(ErsReimbursementStatus.PENDING);
		return dao.insertReimbursement(re);
	}

	@Override
	public void updateUserInfo(ErsUser user) {
		dao.updateUser(user);
	}
	
	@Override
	public void updateReimbursementDetails(ErsReimbursement re) {
		dao.updateReimbursementDetails(re);
	}

	@Override
	public void setAsManager(ErsUser user) {
		user.setRole(ErsUserRole.MANAGER);
		dao.updateUser(user);
	}
	
	@Override
	public void resolveRequest(ErsUser user, ErsReimbursement re, boolean approve) {
		if (user == null || re == null || user.getRole() != ErsUserRole.MANAGER) return;
		re.setResolverId(user.getId());
		if (approve) re.setStatus(ErsReimbursementStatus.APPROVED);
		else re.setStatus(ErsReimbursementStatus.DENIED);
		dao.updateReimbursementStatus(re);
	}
	
	@Override
	public ErsUser getResolver(ErsReimbursement re) {
		if (re == null || re.getStatus() == ErsReimbursementStatus.PENDING) return null;
		ErsUser resolver = new ErsUser();
		resolver.setId(re.getResolverId());
		return dao.getUserById(resolver);
	}

	@Override
	public ErsUser getAuthor(ErsReimbursement re) {
		if (re == null) return null;
		ErsUser author = new ErsUser();
		author.setId(re.getAuthorId());
		return dao.getUserById(author);
	}
	
	public List<ErsReimbursementDTO> toDTOLst(List<ErsReimbursement> lst) {
		List<ErsReimbursementDTO> dtoLst = new ArrayList<>();
		for(ErsReimbursement re : lst) {
			dtoLst.add(new ErsReimbursementDTO(re, getAuthor(re), getResolver(re)));
		}
		return dtoLst;
	}
	
}
