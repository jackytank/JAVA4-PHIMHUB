package com.poly.DAO;

import com.poly.Model.Users;
import com.poly.Utils.JpaUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    private EntityManager em = new JpaUtils().getEntityManager();
    @Override
    protected void finalize() throws Throwable {
        em.close();//Đóng EntityManager khi DAO bị giải phóng
        super.finalize();
    }
    public Users create(Users entity){
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
    public Users update(Users entity){
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
    public Users delete(String id){
        Users entity = this.findById(id);
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
    public Users findById(String id){
        Users entity = em.find(Users.class, id);
        return entity;
    }
    public List<Users> findAll(){
        String jpql = "Select o From Users o";
        TypedQuery<Users> query = em.createQuery(jpql, Users.class);
        List <Users> list = query.getResultList();
        return list;
    }
}
