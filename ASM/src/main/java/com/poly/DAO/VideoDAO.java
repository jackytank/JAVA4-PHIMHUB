package com.poly.DAO;

import com.poly.Model.Video;
import com.poly.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VideoDAO {
    private EntityManager em = new JpaUtils().getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();//Đóng EntityManager khi DAO bị giải phóng
        super.finalize();
    }
    public Video create(Video entity){
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
    public Video update(Video entity){
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
    public Video delete(String id){
        Video entity = this.findById(id);
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
    public Video findById(String id){
        Video entity = em.find(Video.class, id);
        return entity;
    }
    public List<Video> findAll(){
        String jpql = "Select o From Video o";
        TypedQuery<Video> query = em.createQuery(jpql, Video.class);
        List <Video> list = query.getResultList();
        return list;
    }
}
