package com.revature.dao;

import java.util.List;

import com.revature.model.ERS_Reimbursement_Status;
import com.revature.model.ERS_Reimbursement_Type;
import com.revature.model.ERS_Reimbursements;
import com.revature.model.ERS_Users;

public interface ReimbursementsDAOContract {
	
	//Create
	public boolean createReimbursement(ERS_Reimbursements rmbt);
	public boolean createBasicReimbursement(ERS_Reimbursements rmbt);
	//Read
	public ERS_Reimbursements selectReimbursementById(int id);
	public List<ERS_Reimbursements> selectAllReimbursements();
	public List<ERS_Reimbursements> selectReimbursementsByAuthor(ERS_Users author);
	public List<ERS_Reimbursements> selectReimbursementsByResolver(ERS_Users resolver);
	public List<ERS_Reimbursements> selectReimbursementsByType(ERS_Reimbursement_Type type);
	public List<ERS_Reimbursements> selectReimbursementsByStatus(ERS_Reimbursement_Status status);
	//Update
	public boolean updateReimbursement(ERS_Reimbursements rmbt);
	public boolean resolveReimbursement(ERS_Reimbursements rmbt);
	//Delete
	public boolean deleteReimbursement(ERS_Reimbursements rmbt);
}
