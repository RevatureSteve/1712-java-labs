package com.revature.dao;

import java.util.List;

import com.revature.model.ERS_User_Roles;

public interface UserRolesDAOContract {
	
	//Create
	public boolean createRole(ERS_User_Roles role);
	//Read
	public ERS_User_Roles selectRoleById(int id);
	public List<ERS_User_Roles> selectAllRoles();
	//Update
	public boolean updateRole(ERS_User_Roles role);
	//Delete
	public boolean deleteRole(ERS_User_Roles role);
}
