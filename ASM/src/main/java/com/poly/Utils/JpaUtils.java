package com.poly.Utils;

import java.io.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/home")
public class JpaUtils extends HttpServlet {
    static EntityManagerFactory factory;
    public static EntityManager getEntityManager() {
        EntityManager entityManager = null;
        if (factory == null || !factory.isOpen()) {
            factory = Persistence.createEntityManagerFactory("DVGiatTri");
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }
    public void shutdown(){
        if (factory != null && factory.isOpen()){
            factory.close();
        }
        factory = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        req.getRequestDispatcher("/views/account/signup.jsp").forward(req, resp);
    }
}