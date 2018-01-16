package com.revature.dto;

import java.io.Serializable;

import com.revature.model.ErsUser;

public class ErsUserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2460874924906347848L;
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String role;
	
	public ErsUserDTO() {
	}

	public ErsUserDTO(int id, String username, String firstname, String lastname, String email, String role) {
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role.toLowerCase();
	}
	
	public ErsUserDTO(ErsUser user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.firstname = user.getFirstname();
		this.lastname = user.getLastname();
		this.email = user.getEmail();
		this.role = user.getRole().toString().toLowerCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "ErsUserDTO [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", role=" + role + "]";
	}
	
	
}
