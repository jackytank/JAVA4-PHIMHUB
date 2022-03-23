package test;


import java.util.Date;

import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.testng.annotations.Test;

import dao.FavoriteDAO;
import dao.UserDAO;
import model.Favorite;
import model.User;
import model.Video;

public class TestUserDAO {

	@Test(expectedExceptions = PersistenceException.class)
	public void testInsertnull() {
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setUserId(null);
		
		dao.insert(user);
	}

	@Test(expectedExceptions = RollbackException.class)
	public void testInsert() {
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setUserId("batman");
		user.setFullname("Thuan");
		user.setEmail("Thuanle2425@gmail.com");
		user.setPassword("");
		user.setAdmin(false);
		user.setShares(null);
		dao.insert(user);
	}
	
	@Test(expectedExceptions = RollbackException.class)
	public void testInsert2() {
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setUserId("0123123");
		user.setFullname("Thuan");
		user.setEmail("Thuanle2425@gmail.com");
		user.setPassword("OK");
		user.setAdmin(false);
		user.setShares(null);
		dao.insert(user);
	}
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDelete1() {
		UserDAO dao = new UserDAO();
		dao.delete(null);
	}

	// test khi cho id khác int và không tồn tại trong db
	@Test(expectedExceptions = Exception.class)
	public void testDelete2() {
		UserDAO dao = new UserDAO();
		dao.delete("asdasd");
	}
	@Test(expectedExceptions = RollbackException.class)
	public void testUpdate1() {
		UserDAO dao = new UserDAO();
		User u = new User();
		u.setUserId("flash");
		dao.update(u);
	}

	// test khi cho id là int và không tồn tại trong db
	@Test(expectedExceptions = PersistenceException.class)
	public void testUpdate2() {
		UserDAO dao = new UserDAO();
		User u = new User();
		u.setUserId(null);
		dao.update(u);
	}
	
	
}
