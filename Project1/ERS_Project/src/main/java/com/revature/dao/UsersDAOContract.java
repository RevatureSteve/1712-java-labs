package com.revature.dao;

import java.util.List;

import com.revature.model.ERS_User_Roles;
import com.revature.model.ERS_Users;

public interface UsersDAOContract {
	
	//Create
	public boolean createUser(ERS_Users user);
	//Read
	public ERS_Users selectUserById(int id);
	public ERS_Users selectUserByUsername(ERS_Users user);
	public ERS_Users selectUserByLogin(ERS_Users login);
	public ERS_Users selectUserByEmail(ERS_Users user);
	public List<ERS_Users> selectAllUsers();
	public List<ERS_Users> selectUsersByRole(ERS_User_Roles role);
	//Update
	public boolean updateUser(ERS_Users user);
	public boolean updateUserPassword(ERS_Users user);
	//Delete
	public boolean deleteUser(ERS_Users user); 
	
}
