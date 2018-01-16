package com.revature.dao;

import java.util.List;

import com.revature.model.ERS_Reimbursement_Status;

public interface ReimbursementStatusDAOContract {
	
	//Create
	public boolean createNewStatus(ERS_Reimbursement_Status status);
	//Read
	public ERS_Reimbursement_Status selectStatusById(int id);
	public List<ERS_Reimbursement_Status> selectAllStatuses();
	//Update
	public boolean updateStatus(ERS_Reimbursement_Status status);
	//Delete
	public boolean deleteStatus(ERS_Reimbursement_Status status);
	
}
