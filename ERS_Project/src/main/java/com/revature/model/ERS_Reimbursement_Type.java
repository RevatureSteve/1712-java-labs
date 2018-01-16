package com.revature.model;

public class ERS_Reimbursement_Type {
	private int rt_id = 0;
	private String rt_type = "";
	
	public ERS_Reimbursement_Type() {
		super();
	}
	
	public ERS_Reimbursement_Type(int rt_id, String rt_type) {
		super();
		this.rt_id = rt_id;
		this.rt_type = rt_type;
	}
	public int getRt_id() {
		return rt_id;
	}
	public void setRt_id(int rt_id) {
		this.rt_id = rt_id;
	}
	public String getRt_type() {
		return rt_type;
	}
	public void setRt_type(String rt_type) {
		this.rt_type = rt_type;
	}
	
	
}
