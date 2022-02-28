package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Video;
import utils.JpaUtils;

public class VideoDAO extends EntityDAO<Video> {

	public VideoDAO() {
		super(Video.class);
	}

	public List<Video> findFavoriteVideosByUserId(String userId) {
		String jpql = "select v from Video v, Favorite f where v.videoId = f.video.videoId and f.user.userId = :userId";
		EntityManager em = JpaUtils.getEntityManager();
		List<Video> list = null;
		try {
			TypedQuery<Video> query = em.createQuery(jpql, Video.class);
			query.setParameter("userId", userId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
}
