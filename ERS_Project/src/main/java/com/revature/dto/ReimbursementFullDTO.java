package com.revature.dto;

import javax.sql.rowset.serial.SerialBlob;

public class ReimbursementFullDTO {
	
	private String clientRole = "";
	
	private int r_id = 0;
	private double r_amount = 0; 
	private String r_description = "";
	//private SerialBlob r_receipt = null; // binary data
	private String r_submitted = "";
	private String r_resolved = "";
	private String u_author = "";
	private int u_id_author = 0;
	private String u_resolver = "";
	private int u_id_resolver = 0;
	private String rt_type = "";
	private String rt_status = "";
	
	public String getClientRole() {
		return clientRole;
	}
	public void setClientRole(String clientRole) {
		this.clientRole = clientRole;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public double getR_amount() {
		return r_amount;
	}
	public void setR_amount(double r_amount) {
		this.r_amount = r_amount;
	}
	public String getR_description() {
		return r_description;
	}
	public void setR_description(String r_description) {
		this.r_description = r_description;
	}
	public String getR_submitted() {
		return r_submitted;
	}
	public void setR_submitted(String r_submitted) {
		this.r_submitted = r_submitted;
	}
	public String getR_resolved() {
		return r_resolved;
	}
	public void setR_resolved(String r_resolved) {
		this.r_resolved = r_resolved;
	}
	public String getU_author() {
		return u_author;
	}
	public void setU_author(String u_author) {
		this.u_author = u_author;
	}
	public String getU_resolver() {
		return u_resolver;
	}
	public void setU_resolver(String u_resolver) {
		this.u_resolver = u_resolver;
	}
	public String getRt_type() {
		return rt_type;
	}
	public void setRt_type(String rt_type) {
		this.rt_type = rt_type;
	}
	public String getRt_status() {
		return rt_status;
	}
	public void setRt_status(String rt_status) {
		this.rt_status = rt_status;
	}
	
	
	
	
	
	
	
	
	
	
	public ReimbursementFullDTO(String clientRole, int r_id, double r_amount, String r_description,
			/*SerialBlob r_receipt,*/ String r_submitted, String r_resolved, String u_author, int u_id_author,
			String u_resolver, int u_id_resolver, String rt_type, String rt_status) {
		super();
		this.clientRole = clientRole;
		this.r_id = r_id;
		this.r_amount = r_amount;
		this.r_description = r_description;
		//this.r_receipt = r_receipt;
		this.r_submitted = r_submitted;
		this.r_resolved = r_resolved;
		this.u_author = u_author;
		this.u_id_author = u_id_author;
		this.u_resolver = u_resolver;
		this.u_id_resolver = u_id_resolver;
		this.rt_type = rt_type;
		this.rt_status = rt_status;
	}
	public ReimbursementFullDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*public SerialBlob getR_receipt() {
		return r_receipt;
	}
	public void setR_receipt(SerialBlob r_receipt) {
		this.r_receipt = r_receipt;
	}*/
	public int getU_id_author() {
		return u_id_author;
	}
	public void setU_id_author(int u_id_author) {
		this.u_id_author = u_id_author;
	}
	public int getU_id_resolver() {
		return u_id_resolver;
	}
	public void setU_id_resolver(int u_id_resolver) {
		this.u_id_resolver = u_id_resolver;
	}
		
}
