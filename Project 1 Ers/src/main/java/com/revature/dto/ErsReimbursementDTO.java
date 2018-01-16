package com.revature.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUser;
import com.revature.model.JsonDateSerializer;

public class ErsReimbursementDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2865151751544080385L;
	private int id;
	private double amount;
	private String description;
	
	@JsonIgnore
	private byte[] receipt;		//TODO
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private Timestamp submitted;
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private Timestamp resolved;
	
//	private String submitted;
//	private String resolved;
	private ErsUserDTO author;
	private ErsUserDTO resolver;
	private String type;
	private String status;
	
	public ErsReimbursementDTO() {
	}
	
	public ErsReimbursementDTO(int id, double amount, String description, byte[] receipt, Timestamp submitted, Timestamp resolved,
			ErsUserDTO author, ErsUserDTO resolver, String type, String status) {
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}
	
	public ErsReimbursementDTO(ErsReimbursement re, ErsUser author, ErsUser resolver) {
		this.id = re.getId();
		this.amount = re.getAmount();
		this.description = re.getDescription();
		this.receipt = re.getReceipt();
		this.submitted = re.getSubmitted();
		if (re.getResolved() != null) this.resolved = re.getResolved();
		this.author = new ErsUserDTO(author);
		if (resolver != null) this.resolver = new ErsUserDTO(resolver);
		this.type = re.getType().toValue();
		this.status = re.getStatus().toValue();
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReceipt() {
		return receipt;
	}

	public void setReceipt(byte[] receipt) {
		this.receipt = receipt;
	}

	public Timestamp getSubmitted() {
		return submitted;
	}

	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}

	public Timestamp getResolved() {
		return resolved;
	}

	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public ErsUserDTO getAuthor() {
		return author;
	}

	public void setAuthor(ErsUserDTO author) {
		this.author = author;
	}

	public ErsUserDTO getResolver() {
		return resolver;
	}

	public void setResolver(ErsUserDTO resolver) {
		this.resolver = resolver;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ErsReimbursementDTO [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt=" + receipt
				+ ", submitted=" + submitted + ", resolved=" + resolved + ", author=" + author + ", resolver="
				+ resolver + ", type=" + type + ", status=" + status + "]";
	}
	
//	private String formatDate(Timestamp timestamp) {
//		String date = timestamp.toString();
//		return date.substring(0, 10);
//	}
	
	
}
