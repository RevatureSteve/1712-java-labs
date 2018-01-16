package com.revature.dto;

public class ReimbursementBasicDTO {
	
	private int r_id = 0;
	private int u_id_author = 0;
	private double r_amount = 0; 
	private String r_submitted = "";
	private String rt_type = "";
	private String rt_status = "";
	
	
	
	
	public ReimbursementBasicDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReimbursementBasicDTO(int r_id, int u_id_author, double r_amount, String r_submitted, String rt_type, String rt_status) {
		super();
		this.r_id = r_id;
		this.u_id_author = u_id_author;
		this.r_amount = r_amount;
		this.r_submitted = r_submitted;
		this.rt_type = rt_type;
		this.rt_status = rt_status;
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
	public String getR_submitted() {
		return r_submitted;
	}
	public void setR_submitted(String r_submitted) {
		this.r_submitted = r_submitted;
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


	public int getU_id_author() {
		return u_id_author;
	}


	public void setU_id_author(int u_id_author) {
		this.u_id_author = u_id_author;
	}
	
	
	
	
}
