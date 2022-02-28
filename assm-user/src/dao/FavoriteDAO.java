package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Favorite;
import model.FavoriteReport;
import model.FavoriteUserReport;
import model.ShareReport;
import model.Video;
import utils.JpaUtils;

public class FavoriteDAO extends EntityDAO<Favorite> {

	public FavoriteDAO() {
		super(Favorite.class);
	}

	public List<ShareReport> reportShare(String videoId) {
		String jpql = "select new model.ShareReport(s.user.userId, s.user.email, s.emails, s.shareDate)"
				+ " from Share s where s.video.videoId = :videoId ";
		EntityManager em = JpaUtils.getEntityManager();

		List<ShareReport> list = null;
		try {
			TypedQuery<ShareReport> query = em.createQuery(jpql, ShareReport.class);
			query.setParameter("videoId", videoId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

	public List<FavoriteUserReport> reportFavoriteUsersByVideos(String videoId) {
		String jpql = "select new model.FavoriteUserReport(f.user.userId, f.user.fullname, f.user.email, f.likeDate)"
				+ " from Favorite f where f.video.videoId = :videoId ";
		EntityManager em = JpaUtils.getEntityManager();

		List<FavoriteUserReport> list = null;
		try {
			TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);
			query.setParameter("videoId", videoId);
			list = query.getResultList();

		} finally {
			em.close();
		}
		return list;
	}

	public List<FavoriteReport> reportFavoritesByVideos() {
		String jpql = "select new model.FavoriteReport(f.video.title, count(f), min(f.likeDate), max(f.likeDate))"
				+ " from Favorite f group by f.video.title ";
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteReport> list = null;
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

	public List<Favorite> findFavoriteByVideoIdAndUserId(String userId, String videoId) {
		String jpql = "select f from Favorite f where f.video.videoId = :videoId and f.user.userId = :userId";
		EntityManager em = JpaUtils.getEntityManager();
		List<Favorite> list = null;
		try {
			TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
			query.setParameter("videoId", videoId);
			query.setParameter("userId", userId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}

}
