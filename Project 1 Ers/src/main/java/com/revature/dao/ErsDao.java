package com.revature.dao;

import java.util.List;

import com.revature.dto.ErsReimbursementDTO;
import com.revature.dto.ErsUserDTO;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUser;

public interface ErsDao {
	
	//CREATE
	/**
	 * Inserts [re] into the database
	 * @param re Should not be null
	 * @return The auto-generated primary key
	 */
	public int insertReimbursement(ErsReimbursement re);						//WORKING
	
	/**
	 * Inserts [user] into the database
	 * @param user Should not be null
	 * @return The auto-generated primary key
	 */
	public int insertUser(ErsUser user);
	
	//READ
	/**
	 * Retrieves the user from the DB whose id matches [user.id]
	 * @param user
	 * @return A new ErsUser object or null if no such user exists
	 */
	public ErsUser getUserById(ErsUser user);									//WORKING
	
	/**
	 * Retrieves the user from the DB whose username matches [user.username]
	 * @param user
	 * @return A new ErsUser object or null if no such user exists
	 */
	public ErsUser getUserByUsername(ErsUser user);								//WORKING
	
	/**
	 * Gets all users from the database
	 * @return An ArrayList of ErsUsers
	 */
	public List<ErsUser> getAllUsers();
	
	/**
	 * Gets all users from the databse as ErsUserDTO objects
	 * @return An arraylist of ErsUserDTO objects
	 */
	public List<ErsUserDTO> getAllUsersDTO();
	
	/**
	 * Retrieves all reimbursement requests authored by [user]
	 * @param user Should not be null
	 * @return A list of all [user]'s reimbursement requests or null if [user] is null
	 */
	public List<ErsReimbursement> getAllReimbursementsByUser(ErsUser user);		//WORKING
	
	/**
	 * Retrieves the reimbursement from the DB whose id matches [id]
	 * @param id
	 * @return A new ErsReimbursement object or null if no such reimbursement exists
	 */
	public ErsReimbursement getReimbursementById(int id);						//WORKING
	
	/**
	 * Gets all reimbursement requests from the database
	 * @return An ArrayList containing every reimbursement request in the databse
	 */
	public List<ErsReimbursement> getAllReimbursements();
	
	/**
	 * Gets all reimbursements requests from the database as ErsReimbursementDTO objects
	 * @return An arraylist of ErsReimbursementDTO objects 
	 */
	public List<ErsReimbursementDTO> getAllReimbursementDTO();
	
	/**
	 * Gets the receipt image of the reimbursement request whose id is [id] as a byte array
	 * @param id
	 * @return A byte[] containing the image of the receipt for the reimbursement with id = [id]
	 */
	public byte[] getReimbursementReceiptByReimbursementId(int id);
	
	//UPDATE
	
	/**
	 * Updates the following columns of the entry in ers_users where u_id matches [user.id], if any:
	 * u_username, u_password, u_email, u_firstname, u_lastname, and ur_id
	 * @param user
	 */
	public void updateUser(ErsUser user);										//WORKING
	
	/**
	 * Updates the following columns of the entry in ers_reimbursements whose r_id matches [re.id], if any:
	 * r_amount, r_description, r_receipt, r_type
	 * @param re The reimbursement type of [re] should be PENDING
	 */
	public void updateReimbursementDetails(ErsReimbursement re);
	
	/**
	 * Updates the following columns of the entry in ers_reimbursements whose r_id matches [re.id], if any:
	 * r_resolved, u_id_resolver, rt_status
	 * @param re The reimbursement type of [re] should be PENDING
	 */
	public void updateReimbursementStatus(ErsReimbursement re);
	
	
	//DELETE (ONLY USED FOR TESTING)
	
	public void deleteUserById(int id);
	
	public void deleteReimbursementById(int id);
	

}
