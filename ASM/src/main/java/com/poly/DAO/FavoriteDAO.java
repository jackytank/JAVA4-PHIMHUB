package com.poly.DAO;

import com.poly.Main.FavoriteReport;
import com.poly.Main.FavoriteUserReport;
import com.poly.Model.Favorite;
import com.poly.Model.Video;
import com.poly.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class FavoriteDAO {
    private EntityManager em = new JpaUtils().getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();//Đóng EntityManager khi DAO bị giải phóng
        super.finalize();
    }
    public Favorite create(Favorite entity){
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return entity;
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
    public Favorite update(Favorite entity){
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            return entity;
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
    public Favorite delete(String username){
        Favorite entity = this.findById(username);
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            return entity;
        }catch(Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException();
        }
    }
    public Favorite findById(String username){
        Favorite entity = em.find(Favorite.class, username);
        return entity;
    }
    public List<Favorite> findAll(){
        String jpql = "Select o From Favorite o";
        TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
        List <Favorite> list = query.getResultList();
        return list;
    }
public List<FavoriteUserReport> reportFavoriteUsersByVideo(String videoId){
    String jpql = "select new com.poly.Main.FavoriteUserReport(f.users.username, f.users.fullname, "
            + "f.users.email, f.likeDate) from Favorite f where f.users.username = :videoId";

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

    public List<FavoriteReport> reportFavoritesByVideos(){
        String jpql = "select new com.poly.Main.FavoriteReport(f.videoId.titile, count(f), min(f.likeDate), max(f.likeDate)) "
                + " from Favorite f group by f.videoId.titile";

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
    public List<Video> findAllByUsername(String videoId) {
        EntityManager em= JpaUtils.getEntityManager();
        em.clear();
        List<Video> list = null;
        try {
            String sql = "SELECT v.videoId FROM Favorite v WHERE v.users.username = :videoId";
            TypedQuery<Video> query = em.createQuery(sql, Video.class);
            query.setParameter("videoId", videoId);
            list = query.getResultList();
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
