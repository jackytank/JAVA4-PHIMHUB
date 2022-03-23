package test;

import java.util.Date;

import javax.persistence.RollbackException;

import org.testng.annotations.Test;

import dao.FavoriteDAO;
import model.Favorite;
import model.User;
import model.Video;

public class TestFavoriteDAO {

	// test khi cho videoId, userId là null
	@Test(expectedExceptions = RollbackException.class)
	public void testInsert1() {
		FavoriteDAO dao = new FavoriteDAO();
		Favorite favorite = new Favorite();
		Video video = new Video();
		video.setVideoId(null);
		favorite.setVideo(video);

		User user = new User();
		user.setUserId(null);
		favorite.setUser(user);

		favorite.setLikeDate(new Date());
		dao.insert(favorite);
	}

	// test khi cho videoId, userId đã tồn tại trong db
	@Test(expectedExceptions = RollbackException.class)
	public void testInsert2() {
		FavoriteDAO dao = new FavoriteDAO();
		Favorite favorite = new Favorite();
		Video video = new Video();
		video.setVideoId("VD03");
		favorite.setVideo(video);

		User user = new User();
		user.setUserId("batman");
		favorite.setUser(user);

		favorite.setLikeDate(new Date());
		dao.insert(favorite);
	}

	// test khi cho videoId, userId không tồn tại trong db
	@Test(expectedExceptions = RollbackException.class)
	public void testInsert3() {
		FavoriteDAO dao = new FavoriteDAO();
		Favorite favorite = new Favorite();
		Video video = new Video();
		video.setVideoId("VD03223");
		favorite.setVideo(video);

		User user = new User();
		user.setUserId("darknight");
		favorite.setUser(user);

		favorite.setLikeDate(new Date());
		dao.insert(favorite);
	}

	// test khi cho id là null
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDelete1() {
		FavoriteDAO dao = new FavoriteDAO();
		dao.delete(null);
	}

	// test khi cho id khác int và không tồn tại trong db
	@Test(expectedExceptions = Exception.class)
	public void testDelete2() {
		FavoriteDAO dao = new FavoriteDAO();
		dao.delete("asdasd");
	}

	// test khi cho id là int và không tồn tại trong db
	@Test(expectedExceptions = Exception.class)
	public void testDelete3() {
		FavoriteDAO dao = new FavoriteDAO();
		dao.delete(3);
	}

	// test khi cho id là int và không tồn tại trong db
	@Test(expectedExceptions = RollbackException.class)
	public void testUpdate1() {
		FavoriteDAO dao = new FavoriteDAO();
		Favorite favorite = new Favorite();
		favorite.setFavoriteId(99);
		favorite.setUser(new User());
		favorite.setVideo(new Video());
		favorite.setLikeDate(new Date());

		dao.update(favorite);
	}

	// test khi cho id là int và không tồn tại trong db
	@Test(expectedExceptions = RollbackException.class)
	public void testUpdate2() {
		FavoriteDAO dao = new FavoriteDAO();
		Favorite favorite = new Favorite();

		favorite.setFavoriteId(201);
		favorite.setUser(new User());
		favorite.setVideo(new Video());
		favorite.setLikeDate(new Date());

		dao.update(favorite);
	}

	// test khi cho id là int và không tồn tại trong db
	@Test(expectedExceptions = RollbackException.class)
	public void testUpdate3() {
		FavoriteDAO dao = new FavoriteDAO();
		Favorite favorite = new Favorite();

		favorite.setFavoriteId(20384);
		favorite.setUser(new User());
		favorite.setVideo(new Video());
		favorite.setLikeDate(new Date());

		dao.update(favorite);
	}
}
