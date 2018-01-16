//package com.revature.test;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//
//import java.util.List;
//
//import org.junit.Test;
//
//import com.revature.dao.ErsDao;
//import com.revature.dao.ErsDaoImpl;
//import com.revature.model.ErsReimbursement;
//import com.revature.model.ErsReimbursementStatus;
//import com.revature.model.ErsReimbursementType;
//import com.revature.model.ErsUser;
//import com.revature.model.ErsUserRole;
//
//public class ErsDaoTest {
//
//	private ErsDao dao = ErsDaoImpl.getDao();
//
//	// READ TESTS
//
//	@Test
//	public void getUserByUsernameShouldReturnUser() {
//		ErsUser user = new ErsUser();
//		user.setUsername("test");
//		ErsUser dbUser = dao.getUserByUsername(user);
//		assertNotNull(dbUser);
//		assertEquals("test", dbUser.getUsername());
//		assertEquals("1234", dbUser.getPassword());
//		assertEquals("testtest@test.test", dbUser.getEmail());
//		assertEquals("Testy", dbUser.getFirstname());
//		assertEquals("McTesterston", dbUser.getLastname());
//		assertEquals(0, dbUser.getRole().getId());
//	}
//
//	@Test
//	public void getUserByIdShouldReturnUser() {
//		ErsUser user = new ErsUser();
//		user.setId(1);
//		ErsUser dbUser = dao.getUserById(user);
//		assertNotNull(dbUser);
//		assertEquals("test", dbUser.getUsername());
//		assertEquals("1234", dbUser.getPassword());
//		assertEquals("testtest@test.test", dbUser.getEmail());
//		assertEquals("Testy", dbUser.getFirstname());
//		assertEquals("McTesterston", dbUser.getLastname());
//		assertEquals(0, dbUser.getRole().getId());
//	}
//
//	@Test
//	public void getAllUsersTest() {
//		System.out.println("\nTESTING getAllUsers()...\n");
//		List<ErsUser> lst = dao.getAllUsers();
//		for (ErsUser user : lst)
//			System.out.println(user);
//	}
//
//	@Test
//	public void getReimbursmentByIdShouldReturnReimbursement() {
//		ErsReimbursement re = dao.getReimbursementById(4);
//		assertNotNull(re);
//		assertEquals(10, re.getAmount(), .001);
//		assertEquals("description", re.getDescription());
//		assertEquals(null, re.getReceipt());
//		assertEquals(1, re.getAuthorId());
//		assertEquals(0, re.getResolverId());
//		assertEquals(ErsReimbursementType.DEFAULT, re.getType());
//		assertEquals(ErsReimbursementStatus.PENDING, re.getStatus());
//	}
//
//	@Test
//	public void getAllReimbursementsByUserShouldReturnReimbursements() {
//		ErsUser user = new ErsUser();
//		user.setId(1);
//		List<ErsReimbursement> lst = dao.getAllReimbursementsByUser(user);
//		assertNotNull(lst);
//		assertEquals(2, lst.size());
//		ErsReimbursement re = lst.get(0);
//		assertEquals(10, re.getAmount(), .001);
//		assertEquals("description", re.getDescription());
//		assertEquals(null, re.getReceipt());
//		assertEquals(1, re.getAuthorId());
//		assertEquals(0, re.getResolverId());
//		assertEquals(ErsReimbursementType.DEFAULT, re.getType());
//		assertEquals(ErsReimbursementStatus.PENDING, re.getStatus());
//		re = lst.get(1);
//		assertEquals(25, re.getAmount(), .001);
//		assertEquals("another description", re.getDescription());
//		assertEquals(null, re.getReceipt());
//		assertEquals(1, re.getAuthorId());
//		assertEquals(0, re.getResolverId());
//		assertEquals(ErsReimbursementType.DEFAULT, re.getType());
//		assertEquals(ErsReimbursementStatus.APPROVED, re.getStatus());
//	}
//
//	@Test
//	public void getAllReimbursementsTest() {
//		System.out.println("\nTESTING getAllReimbursements()...\n");
//		List<ErsReimbursement> lst = dao.getAllReimbursements();
//		for (ErsReimbursement re : lst)
//			System.out.println(re);
//	}
//
//	// CREATE TESTS : THESE ONLY WORK IF READ TESTS PASS
//
//	@Test
//	public void insertReimbursementShouldInsertReimbursement() {
//		ErsReimbursement re = new ErsReimbursement();
//		re.setAmount(100);
//		re.setAuthorId(2);
//		re.setDescription("This is a description");
//		re.setStatus(ErsReimbursementStatus.PENDING);
//		re.setType(ErsReimbursementType.DEFAULT);
//		int rId = dao.insertReimbursement(re);
//		ErsReimbursement dbRe = dao.getReimbursementById(rId);
//		assertNotNull(dbRe);
//		assertEquals(100, dbRe.getAmount(), .001);
//		assertEquals("This is a description", dbRe.getDescription());
//		assertEquals(2, dbRe.getAuthorId());
//		assertEquals(ErsReimbursementStatus.PENDING, dbRe.getStatus());
//		assertEquals(ErsReimbursementType.DEFAULT, dbRe.getType());
//		dao.deleteReimbursementById(rId);
//	}
//
//	@Test
//	public void insertReimbursementShouldReturnNegativeOne() {
//		int id = dao.insertReimbursement(null);
//		assertEquals(-1, id);
//	}
//
//	@Test
//	public void insertUserShouldInsertUser() {
//		ErsUser user = new ErsUser();
//		user.setUsername("insert username");
//		user.setPassword("insert password");
//		user.setFirstname("insert firstname");
//		user.setLastname("insert lastname");
//		user.setEmail("insert email");
//		user.setRole(ErsUserRole.EMPLOYEE);
//		int uId = dao.insertUser(user);
//		ErsUser dbUser = new ErsUser();
//		dbUser.setId(uId);
//		dbUser = dao.getUserById(dbUser);
//		assertNotNull(dbUser);
//		assertEquals("insert username", dbUser.getUsername());
//		assertEquals("insert password", dbUser.getPassword());
//		assertEquals("insert firstname", dbUser.getFirstname());
//		assertEquals("insert lastname", dbUser.getLastname());
//		assertEquals("insert email", dbUser.getEmail());
//		assertEquals(ErsUserRole.EMPLOYEE, dbUser.getRole());
//		dao.deleteUserById(uId);
//	}
//
//	// UPDATE TESTS
//	@Test
//	public void updateUserShouldUpdateUser() {
//		ErsUser user = new ErsUser();
//		user.setUsername("test3");
//		user = dao.getUserByUsername(user);
//		user.setUsername("username changed");
//		user.setPassword("password changed");
//		user.setFirstname("firstname changed");
//		user.setLastname("lastname changed");
//		user.setEmail("email changed");
//		user.setRole(ErsUserRole.getOppositeRole(user.getRole()));
//		dao.updateUser(user);
//		ErsUser dbUser = new ErsUser();
//		dbUser.setUsername("username changed");
//		dbUser = dao.getUserByUsername(dbUser);
//		assertNotNull(dbUser);
//		assertEquals("username changed", dbUser.getUsername());
//		assertEquals("password changed", dbUser.getPassword());
//		assertEquals("firstname changed", dbUser.getFirstname());
//		assertEquals("lastname changed", dbUser.getLastname());
//		assertEquals("email changed", dbUser.getEmail());
//		assertEquals(ErsUserRole.EMPLOYEE, dbUser.getRole());
//		dbUser.setUsername("test3");
//		dbUser.setPassword("test3");
//		dbUser.setFirstname("test3");
//		dbUser.setLastname("test3");
//		dbUser.setEmail("test3");
//		dbUser.setRole(ErsUserRole.MANAGER);
//		dao.updateUser(dbUser);
//	}
//
//	@Test
//	public void updateReimbursementDetailsTest() {
//		ErsReimbursement re = dao.getReimbursementById(20);
//		re.setAmount(100);
//		re.setDescription("new description");
//		dao.updateReimbursementDetails(re);
//		ErsReimbursement dbRe = dao.getReimbursementById(20);
//		assertNotNull(dbRe);
//		assertEquals(dbRe.getAmount(), 100, .001);
//		assertEquals(dbRe.getDescription(), "new description");
//		dbRe.setAmount(1);
//		dbRe.setDescription("description");
//		dbRe.setType(ErsReimbursementType.DEFAULT);
//		dao.updateReimbursementDetails(dbRe);
//	}
//
//	@Test
//	public void updateReimbursementStatusTest() {
//		ErsReimbursement re = dao.getReimbursementById(20);
//		re.setResolverId(2);
//		re.setStatus(ErsReimbursementStatus.APPROVED);
//		dao.updateReimbursementStatus(re);
//		ErsReimbursement dbRe = dao.getReimbursementById(20);
//		assertNotNull(dbRe);
//		assertEquals(dbRe.getResolverId(), 2);
//		assertEquals(dbRe.getStatus(), ErsReimbursementStatus.APPROVED);
//		assertNotNull(dbRe.getResolved());
//		dbRe.setResolverId(1);
//		dbRe.setStatus(ErsReimbursementStatus.PENDING);
//		dao.updateReimbursementStatus(dbRe);
//	}
//
//}
