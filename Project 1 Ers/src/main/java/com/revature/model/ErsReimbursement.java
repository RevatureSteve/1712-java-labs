package com.revature.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public class ErsReimbursement {

	private int id;
	private double amount;
	private String description;
	private byte[] receipt;		//TODO
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private Timestamp submitted;
	
	@JsonSerialize(using = JsonDateSerializer.class)
	private Timestamp resolved;
	
	private int authorId;
	private int resolverId;
	private ErsReimbursementType type;
	private ErsReimbursementStatus status;

	public ErsReimbursement() {
	}

	public ErsReimbursement(int id, double amount, String description, byte[] receipt, Timestamp submitted,
			Timestamp resolved, int authorId, int resolverId, ErsReimbursementType type,
			ErsReimbursementStatus status) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.type = type;
		this.status = status;
	}
	
	public ErsReimbursement(int id, double amount, String description, byte[] receipt, Timestamp submitted,
			Timestamp resolved, int authorId, int resolverId, int typeId,
			int statusId) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.authorId = authorId;
		this.resolverId = resolverId;
		this.type = ErsReimbursementType.findById(typeId);
		this.status = ErsReimbursementStatus.findById(statusId);
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

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getResolverId() {
		return resolverId;
	}

	public void setResolverId(int resolverId) {
		this.resolverId = resolverId;
	}

	public ErsReimbursementType getType() {
		return type;
	}

	public void setType(ErsReimbursementType type) {
		this.type = type;
	}

	public ErsReimbursementStatus getStatus() {
		return status;
	}

	public void setStatus(ErsReimbursementStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ErsReimbursement [id=" + id + ", amount=" + amount + ", description=" + description + ", receipt="
				+ receipt + ", submitted=" + submitted + ", resolved=" + resolved + ", authorId=" + authorId + ", resolverId="
				+ resolverId + ", type=" + type + ", status=" + status + "]";
	}

}
