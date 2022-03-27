package test;

import org.testng.annotations.Test;

import dao.VideoDAO;
import model.Video;

public class TestVideoDAO {
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testInsert1() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId(null);
		video.setDescription(null);
		video.setFavorites(null);
		video.setPoster(null);
		video.setShares(null);
		video.setTitle(null);

		dao.insert(video);
	}

	@Test
	public void testInsert2() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId("VD01");
		video.setDescription("abcfh");
		video.setFavorites(null);
		video.setPoster("Mancity");
		video.setShares(null);
		video.setTitle("VIP");

		dao.insert(video);
	}

	@Test
	public void testInsert3() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId(null);
		video.setDescription("xzxas");
		video.setFavorites(null);
		video.setPoster("ádasdacwc");
		video.setShares(null);
		video.setTitle(null);

		dao.insert(video);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDelete1() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId(null);
		video.setDescription(null);
		video.setFavorites(null);
		video.setPoster(null);
		video.setShares(null);
		video.setTitle(null);

		dao.delete(video);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testDelete2() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId("VD02");
		video.setDescription("vietnammuionnam");
		video.setFavorites(null);
		video.setPoster("VN");
		video.setShares(null);
		video.setTitle("VIP1");

		dao.delete(video);
	}

	@Test
	public void testDelete3() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId("VD01");
		video.setDescription("12312");
		video.setFavorites(null);
		video.setPoster("23123123");
		video.setShares(null);
		video.setTitle("2222112");

		dao.delete(video);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testUpdate1() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId(null);
		video.setDescription(null);
		video.setFavorites(null);
		video.setPoster(null);
		video.setShares(null);
		video.setTitle(null);

		dao.update(video);
	}

	@Test
	public void testUpdate2() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId("VD03");
		video.setDescription("tamnt");
		video.setFavorites(null);
		video.setPoster("161123123");
		video.setShares(null);
		video.setTitle("VIP1213123");

		dao.update(video);
	}

	@Test
	public void testUpdate3() {
		VideoDAO dao = new VideoDAO();
		Video video = new Video();

		video.setVideoId("123");
		video.setDescription("22222");
		video.setFavorites(null);
		video.setPoster(null);
		video.setShares(null);
		video.setTitle("2121212");

		dao.update(video);
	}
}
