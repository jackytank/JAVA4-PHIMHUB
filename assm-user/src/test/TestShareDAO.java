package test;

import java.util.Date;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.testng.annotations.Test;

import dao.ShareDAO;
import model.Email;
import model.Share;
import model.User;
import model.Video;

public class TestShareDAO {
	
		@Test()
		public void testInsert1() {
			Share sh = new Share();
			ShareDAO dao = new ShareDAO();
			Video vd = new Video();
			User u = new User();
			u.setUserId("flash");
			vd.setVideoId("https://www.youtube.com/embed/Ci6lMQNLKZU");
			sh.setUser(u);
			sh.setVideo(vd);
			sh.setEmails("dang@gmail.com");
			sh.setShareDate(new Date());
			dao.insert(sh);
		}
		// test khi không tồn tại email
		@Test()
		public void testInsert2() {
			Share sh = new Share();
			ShareDAO dao = new ShareDAO();
			Video vd = new Video();
			User u = new User();
			u.setUserId("batman");
			vd.setVideoId("https://www.youtube.com/embed/Ci6lMQNLKZU");
			sh.setUser(u);
			sh.setVideo(vd);
			sh.setEmails("omgkunzxc@gmail.com");
			sh.setShareDate(new Date());
			dao.insert(sh);
		}
		
		//test khi b�? trống video id
		@Test(expectedExceptions = PersistenceException.class)
		public void testInsert3() {
			Share sh = new Share();
			ShareDAO dao = new ShareDAO();
			Video vd = new Video();
			User u = new User();
			u.setUserId("batman");
			vd.setVideoId(null);
			sh.setUser(u);
			sh.setVideo(vd);
			sh.setEmails("balisongian@gmail.com");
			sh.setShareDate(new Date());
			dao.insert(sh);
		}
		
		//test khi video id không tồn tại
		@Test(expectedExceptions = EntityNotFoundException.class)
		public void testUpdate1() {
			Share sh = new Share();
			ShareDAO dao = new ShareDAO();
			Video vd = new Video();
			vd.setVideoId("https://www.youtube.com/embed/Y_zSSxVyK0U");
			sh.setUser(new User());
			sh.setVideo(vd);
			sh.setEmails((new Email()).toString());
			sh.setShareDate(new Date());
			dao.update(sh);
		}
		
		//test khi b�? trống video id
		@Test(expectedExceptions = PersistenceException.class)
		public void testUpdate2() {
			Share sh = new Share();
			ShareDAO dao = new ShareDAO();
			Video vd = new Video();
			vd.setVideoId(null);
			sh.setUser(new User());
			sh.setVideo(vd);
			sh.setEmails((new Email()).toString());
			sh.setShareDate(new Date());
			dao.update(sh);
		}
		
		//test khi b�? trống email
		@Test(expectedExceptions = PersistenceException.class)
		public void testUpdate3() {
			Share sh = new Share();
			ShareDAO dao = new ShareDAO();
			sh.setUser(new User());
			sh.setVideo(new Video());
			sh.setEmails(null);
			sh.setShareDate(new Date());
			dao.update(sh);
		}
		
		//test khi b�? trống user id
		@Test(expectedExceptions = IllegalArgumentException.class)
		public void testDelete1() {
			ShareDAO dao = new ShareDAO();
			dao.delete(null);
		}
		
		//test khi user id không tồn tại
		@Test(expectedExceptions = IllegalArgumentException.class)
		public void testDelete2() {
			ShareDAO dao = new ShareDAO();		
			dao.delete("ASDZZ");
		}
		
}
