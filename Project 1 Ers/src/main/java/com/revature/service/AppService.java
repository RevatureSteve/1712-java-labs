package com.revature.service;

import java.util.List;

import com.revature.dto.ErsReimbursementDTO;
import com.revature.dto.ErsUserDTO;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsReimbursementStatus;
import com.revature.model.ErsUser;
import com.revature.model.ErsUserRole;

public interface AppService {

	/**
	 * Checks whether [user]'s username and password match those of any existing user. If not, returns null
	 * @param user
	 * @return
	 */
	public ErsUser validateUser(ErsUser user);
	
	/**
	 * Gets all reimbursement requests submitted by [user]
	 * @param user Should not be null
	 * @return An ArrayList of ErsReimbursements authored by [user], or null if [user] = null
	 */
	public List<ErsReimbursement> getReimbursements(ErsUser user);
	
	/**
	 * Gets all reimbursement requests submitted by [user] whose status is [status]
	 * @param user 
	 * @param status
	 * @return An ArrayList of ErsReimbursements authored by [user] with status [status], or null if either [user] or [status] is null
	 */
	public List<ErsReimbursement> getReimbursements(ErsUser user, ErsReimbursementStatus status);
	
	/**
	 * Gets the reimbursement with id = [reId]
	 * @param reId
	 * @return The ErsReimbursement whose id is [reId], or null if no such ErsReimbursement exists
	 */
	public ErsReimbursement getReimbursement(int reId);
	
	/**
	 * Gets all reimbursements submitted by all employees
	 * @return
	 */
	public List<ErsReimbursement> getAllReimbursements();
	
	/**
	 * Gets all reimbursements submitted by all employees with status = [status]
	 * @param status
	 * @return
	 */
	public List<ErsReimbursement> getAllReimbursements(ErsReimbursementStatus status);
	
	/**
	 * Gets all reimbursements submitted by all employees as ErsReimbursementDTO objects with status = [status]
	 * @return
	 */
	public List<ErsReimbursementDTO> getAllReimbursementsDTO();
	
	/**
	 * Gets a user by username
	 * @param username
	 * @return The user whose username = [username], or null if none exists
	 */
	public ErsUser getUser(String username);
	
	/**
	 * Gets all registered users
	 * @return An ArrayList containing all users in the ers system
	 */
	public List<ErsUser> getAllUsers();
	
	/**
	 * Gets all registered users with the given role
	 * @param role
	 * @return An Arraylist containing all users in the ers system whose role = [role]
	 */
	public List<ErsUser> getAllUsers(ErsUserRole role);
	
	/**
	 * Gets all registered users as ErsUserDTO objects with role = [role]
	 * @param role An Arraylist of ErsUserDTO objects
	 * @return
	 */
	public List<ErsUserDTO> getAllUsersDTO(String role);
	
	/**
	 * Gets the receipt image of the reimbursement with id = [id] as a byte[]
	 * @param id
	 * @return A byte[] containing the image of the receipt for the reimbursement with id = [id]
	 */
	public byte[] getReceiptByReimbursementId(int id);
	
	/**
	 * Submits the given reimbursement with [user] as the author
	 * @param re Should not be null
	 */
	public int submitReimbursementRequest(ErsReimbursement re, ErsUser user);
	
	/**
	 * Persists [user]'s current state
	 * @param user
	 */
	public void updateUserInfo(ErsUser user);
	
	/**
	 * Persists [re]'s current state for description, receipt, amount, and type.
	 * @param re
	 */
	public void updateReimbursementDetails(ErsReimbursement re);
	
	/**
	 * Sets [user] as a manager, does nothing if [user] is already a manager
	 * @param user
	 */
	public void setAsManager(ErsUser user);
	
	/**
	 * Sets [re] as resolved and either approves (if [approve] == true) the request or denies it (if [approve] == false) 
	 * @param user The user (must be a manager) who is resolving the request
	 * @param re The reimbursement request to be resolved
	 * @param approve Whether to approve or deny the request, true = approve, false = deny
	 */
	public void resolveRequest(ErsUser user, ErsReimbursement re, boolean approve);
	
	/**
	 * Gets the ErsUser who resolved [re], or null if [re] is not resolved
	 * @param re
	 * @return
	 */
	public ErsUser getResolver(ErsReimbursement re);
	
	/**
	 * Gets the ErsUser who authored [re]
	 * @param re
	 * @return
	 */
	public ErsUser getAuthor(ErsReimbursement re);
	
	public List<ErsReimbursementDTO> toDTOLst(List<ErsReimbursement> lst);

}
