package com.revature.model;

import java.sql.Blob;

import oracle.sql.BLOB;
import javax.sql.rowset.serial.SerialBlob;



public class ERS_Reimbursements {
	private int r_id = 0;
	private double r_amount = 0; 
	private String r_description = "";
	private byte[] r_receipt = null; // binary data
	private String r_submitted = "";
	private String r_resolved = "";
	private int u_id_author = 0;
	private int u_id_resolver = 0;
	private int rt_type = 0;
	private int rt_status = 0;
	
	//full constructor
	public ERS_Reimbursements(int r_id, double r_amount, String r_description, byte[] r_receipt, String r_submitted,
			String r_resolved, int u_id_author, int u_id_resolver, int rt_type, int rt_status) {
		super();
		this.r_id = r_id;
		this.r_amount = r_amount;
		this.r_description = r_description;
		this.r_receipt = r_receipt;
		this.r_submitted = r_submitted;
		this.r_resolved = r_resolved;
		this.u_id_author = u_id_author;
		this.u_id_resolver = u_id_resolver;
		this.rt_type = rt_type;
		this.rt_status = rt_status;
	}

	
	//constructor without receipt
	public ERS_Reimbursements(int r_id, double r_amount, String r_description, String r_submitted, String r_resolved,
			int u_id_author, int u_id_resolver, int rt_type, int rt_status) {
		super();
		this.r_id = r_id;
		this.r_amount = r_amount;
		this.r_description = r_description;
		this.r_submitted = r_submitted;
		this.r_resolved = r_resolved;
		this.u_id_author = u_id_author;
		this.u_id_resolver = u_id_resolver;
		this.rt_type = rt_type;
		this.rt_status = rt_status;
	}
	
	//default constructor
	public ERS_Reimbursements() {
		super();
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


	public byte[] getR_receipt() {
		return r_receipt;
	}


	public void setR_receipt(byte[] r_receipt) {
		this.r_receipt = r_receipt;
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


	public int getRt_type() {
		return rt_type;
	}


	public void setRt_type(int rt_type) {
		this.rt_type = rt_type;
	}


	public int getRt_status() {
		return rt_status;
	}


	public void setRt_status(int rt_status) {
		this.rt_status = rt_status;
	}
	
	
	
}
