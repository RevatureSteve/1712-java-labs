////package com.revature.test;
////
////import static org.junit.Assert.assertEquals;
////import static org.junit.Assert.assertFalse;
////import static org.junit.Assert.assertNotNull;
////import static org.junit.Assert.assertNull;
////import static org.junit.Assert.assertTrue;
////
////import java.util.List;
////
////import org.junit.Test;
////
////import com.revature.model.ErsReimbursement;
////import com.revature.model.ErsReimbursementStatus;
////import com.revature.model.ErsReimbursementType;
////import com.revature.model.ErsUser;
////import com.revature.model.ErsUserRole;
////import com.revature.service.AppService;
////import com.revature.service.AppServiceImpl;
////
//public class AppServiceTest {
////	
////	private AppService service = AppServiceImpl.getService();
////
////	
////	//--------------------validateUser tests
////	@Test
////	public void validateUserShouldReturnUser() {
////		ErsUser user = new ErsUser();
////		user.setUsername("test");
////		user.setPassword("1234");
////		ErsUser dbUser = service.validateUser(user);
////		assertNotNull(dbUser);
////		assertEquals("test", dbUser.getUsername());
////		assertEquals("1234", dbUser.getPassword());
////		assertEquals("testtest@test.test", dbUser.getEmail());
////		assertEquals("Testy", dbUser.getFirstname());
////		assertEquals("McTesterston", dbUser.getLastname());
////		assertEquals(0, dbUser.getRole().getId());
////	}
////	
////	@Test
////	public void valideUserShouldReturnNullInvalidUsername() {
////		ErsUser user = new ErsUser();
////		user.setUsername("username");
////		user.setPassword("1234");
////		ErsUser dbUser = service.validateUser(user);
////		assertNull(dbUser);
////	}
////	
////	@Test
////	public void valideUserShouldReturnNullInvalidPassword() {
////		ErsUser user = new ErsUser();
////		user.setUsername("test");
////		user.setPassword("password");
////		ErsUser dbUser = service.validateUser(user);
////		assertNull(dbUser);
////	}
////	
////	//------------------------getReimbursements Tests
////	
////	
////	@Test
////	public void getReimbursementsShouldGetReimbursements() {
////		ErsUser user = new ErsUser();
////		user.setUsername("test");
////		user.setPassword("1234");
////		ErsUser dbUser = service.validateUser(user);
////		List<ErsReimbursement> lst = service.getReimbursements(dbUser);
////		assertNotNull(lst);
////		assertEquals(lst.size(), 2);
////		ErsReimbursement re = lst.get(0);
////		assertEquals("description", re.getDescription());
////		assertNull(re.getReceipt());
////		assertEquals(1, re.getAuthorId());
////		assertEquals(0, re.getResolverId());
////		assertEquals(ErsReimbursementType.DEFAULT, re.getType());
////		assertEquals(ErsReimbursementStatus.PENDING, re.getStatus());
////		re = lst.get(1);
////		assertEquals(25, re.getAmount(), .001);
////		assertEquals("another description", re.getDescription());
////		assertEquals(null, re.getReceipt());
////		assertEquals(1, re.getAuthorId());
////		assertEquals(0, re.getResolverId());
////		assertEquals(ErsReimbursementType.DEFAULT, re.getType());
////		assertEquals(ErsReimbursementStatus.APPROVED, re.getStatus());
////	}
////	
////	@Test
////	public void getReimbursementsWithStatusTest() {
////		ErsUser user = new ErsUser();
////		user.setUsername("test");
////		user.setPassword("1234");
////		ErsUser dbUser = service.validateUser(user);
////		List<ErsReimbursement> lst = service.getReimbursements(dbUser, ErsReimbursementStatus.PENDING);
////		assertNotNull(lst);
////		assertEquals(1, lst.size());
////		ErsReimbursement re = lst.get(0);
////		assertEquals("description", re.getDescription());
////		assertNull(re.getReceipt());
////		assertEquals(1, re.getAuthorId());
////		assertEquals(0, re.getResolverId());
////		assertEquals(ErsReimbursementType.DEFAULT, re.getType());
////		assertEquals(ErsReimbursementStatus.PENDING, re.getStatus());
////		lst = service.getReimbursements(dbUser, ErsReimbursementStatus.APPROVED);
////		assertNotNull(lst);
////		assertEquals(lst.size(), 1);
////		re = lst.get(0);
////		assertEquals(25, re.getAmount(), .001);
////		assertEquals("another description", re.getDescription());
////		assertEquals(null, re.getReceipt());
////		assertEquals(1, re.getAuthorId());
////		assertEquals(0, re.getResolverId());
////		assertEquals(ErsReimbursementType.DEFAULT, re.getType());
////		assertEquals(ErsReimbursementStatus.APPROVED, re.getStatus());
////	}
////	
////	@Test
////	public void getReimbursementsShouldReturnNull() {
////		ErsUser user = new ErsUser();
////		user.setUsername("test");
////		user.setPassword("1234");
////		user = service.validateUser(user);
////		assertNull(service.getReimbursements(null));
////		assertNull(service.getReimbursements(null, ErsReimbursementStatus.PENDING));
////		assertNull(service.getReimbursements(null, ErsReimbursementStatus.APPROVED));
////		assertNull(service.getReimbursements(user, null));
////		assertNull(service.getReimbursements(null, null));
////	}
////	
////	@Test
////	public void getAllReimbursementsTest() {
////		System.out.println("\nTesting getAllReimbursements()\n");
////		List<ErsReimbursement> lst = service.getAllReimbursements();
////		for(ErsReimbursement re : lst) System.out.println(re);
////	}
////	
////	@Test
////	public void getAllReimbursementsWithStatusTest() {
////		System.out.println("\nTesting getAllReimbursements(PENDING)\n");
////		List<ErsReimbursement> lst1 = service.getAllReimbursements(ErsReimbursementStatus.PENDING);
////		for(ErsReimbursement re: lst1) System.out.println(re);
////		
////		System.out.println("\nTesting getAllReimbursements(APPROVED)\n");
////		List<ErsReimbursement> lst2 = service.getAllReimbursements(ErsReimbursementStatus.APPROVED);
////		for(ErsReimbursement re: lst2) System.out.println(re);
////		
////		System.out.println("\nTesting getAllReimbursements(DENIED)\n");
////		List<ErsReimbursement> lst3 = service.getAllReimbursements(ErsReimbursementStatus.DENIED);
////		for(ErsReimbursement re: lst3) System.out.println(re);
////		
////		System.out.println("\nTesting getAllReimbursements(RESOLVED)\n");
////		List<ErsReimbursement> lst4 = service.getAllReimbursements(ErsReimbursementStatus.RESOLVED);
////		for(ErsReimbursement re: lst4) System.out.println(re);
////	}
////	
////	//------------------GET USER TESTS
////	
////	@Test
////	public void getUserTest() {
////		ErsUser user = service.getUser("test");
////		assertNotNull(user);
////		assertEquals("test", user.getUsername());
////		assertEquals("1234", user.getPassword());
////		assertEquals("testtest@test.test", user.getEmail());
////		assertEquals("Testy", user.getFirstname());
////		assertEquals("McTesterston", user.getLastname());
////		assertEquals(0, user.getRole().getId());
////	}
////	
////	@Test
////	public void getAllUsersTest() {
////		System.out.println("\nTesting getAllUsers()");
////		List<ErsUser> lst = service.getAllUsers();
////		for(ErsUser user: lst) System.out.println(user);
////		
////		System.out.println("\nTesting getAllUsers(EMPLOYEE)");
////		List<ErsUser> lst2 = service.getAllUsers(ErsUserRole.EMPLOYEE);
////		for(ErsUser user: lst2) System.out.println(user);
////		
////		System.out.println("\nTesting getAllUsers(MANAGER)");
////		List<ErsUser> lst3 = service.getAllUsers(ErsUserRole.MANAGER);
////		for(ErsUser user: lst3) System.out.println(user);
////	}
////	
////	@Test 
////	public void statusEqualsTest() {
////		ErsReimbursementStatus pending = ErsReimbursementStatus.PENDING;
////		ErsReimbursementStatus approved = ErsReimbursementStatus.APPROVED;
////		ErsReimbursementStatus denied = ErsReimbursementStatus.DENIED;
////		ErsReimbursementStatus resolved = ErsReimbursementStatus.RESOLVED;
////		ErsReimbursementStatus all = ErsReimbursementStatus.ALL;
////		assertTrue(pending.equals(ErsReimbursementStatus.PENDING));
////		assertTrue(approved.equals(resolved));
////		assertTrue(denied.equals(resolved));
//////		assertTrue(resolved.equals(approved));
//////		assertTrue(resolved.equals(denied));
////		assertTrue(pending.equals(all));
////		assertTrue(approved.equals(all));
////		assertTrue(denied.equals(all));
////		assertTrue(resolved.equals(all));
////		assertTrue(all.equals(all));
////		assertFalse(pending.equals(approved));
////		assertFalse(approved.equals(denied));
////	}
////	
////
////	
////	
////	
////
//}
