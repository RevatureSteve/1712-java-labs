package com.revature.dao;

import java.util.List;

import com.revature.model.ERS_Reimbursement_Type;

public interface ReimbursementTypeDAOContract {
	
	//Create
	public boolean createType(ERS_Reimbursement_Type type);
	//Read
	public ERS_Reimbursement_Type selectTypeById(int id);
	public List<ERS_Reimbursement_Type> selctAllTypes();
	//Update
	public boolean updateType(ERS_Reimbursement_Type type);
	//Delete
	public boolean deleteType(ERS_Reimbursement_Type type);
}
