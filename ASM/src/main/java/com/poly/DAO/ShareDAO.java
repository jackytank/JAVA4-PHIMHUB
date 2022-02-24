package com.poly.DAO;

import com.poly.Model.Share;
import com.poly.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ShareDAO {
    private EntityManager em = new JpaUtils().getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();//Đóng EntityManager khi DAO bị giải phóng
        super.finalize();
    }
    public Share create(Share entity){
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
    public Share update(Share entity){
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
    public Share delete(String id){
        Share entity = this.findById(id);
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
    public Share findById(String id){
        Share entity = em.find(Share.class, id);
        return entity;
    }
    public List<Share> findAll(){
        String jpql = "Select o From Share o";
        TypedQuery<Share> query = em.createQuery(jpql, Share.class);
        List <Share> list = query.getResultList();
        return list;
    }
}
