package com.revature.model;

public class ERS_Reimbursement_Status {
	private int rs_id = 0;
	private String rs_status = "";
	
	public ERS_Reimbursement_Status(int rs_id, String rs_status) {
		super();
		this.rs_id = rs_id;
		this.rs_status = rs_status;
	}
	
	public ERS_Reimbursement_Status() {
		
	}

	public int getRs_id() {
		return rs_id;
	}

	public void setRs_id(int rs_id) {
		this.rs_id = rs_id;
	}

	public String getRs_status() {
		return rs_status;
	}

	public void setRs_status(String rs_status) {
		this.rs_status = rs_status;
	}
	
	
}
