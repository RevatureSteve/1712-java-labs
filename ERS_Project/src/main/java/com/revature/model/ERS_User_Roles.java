package com.revature.model;

public class ERS_User_Roles {
	private int ur_id = 0;
	private String ur_role = "";
	
	public ERS_User_Roles(int ur_id, String ur_role) {
		super();
		this.ur_id = ur_id;
		this.ur_role = ur_role;
	}
	
	public ERS_User_Roles() {
		super();
	}

	public int getUr_id() {
		return ur_id;
	}

	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}

	public String getUr_role() {
		return ur_role;
	}

	public void setUr_role(String ur_role) {
		this.ur_role = ur_role;
	}
	
	
}
