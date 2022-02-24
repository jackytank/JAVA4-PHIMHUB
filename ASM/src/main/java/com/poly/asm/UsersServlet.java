package com.poly.asm;

import com.poly.DAO.UserDAO;
import com.poly.Model.Users;
import com.poly.Utils.PageInfo;
import com.poly.Utils.PageType;
import com.poly.Utils.SessionUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet({ "/UserManagementServlet", "/UserManagementServlet/create", "/UserManagementServlet/update",
        "/UserManagementServlet/delete", "/UserManagementServlet/reset", "/UserManagementServlet/edit",})
public class UsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    userDAO.findAll();
    String userName = SessionUtils.getLoginedUsername(request);
    if (userName != null) {
        request.setAttribute("isLogin", false);
    }else{
        request.setAttribute("isLogin", true);
    }
    String url = request.getRequestURL().toString();
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
        if(url.contains("edit")) {
            edit(request, response);
            return;
        }
        if(url.contains("delete")) {
            delete(request, response);
            return;
        }
        if(url.contains("reset")) {
            reset(request, response);
            return;
        }

        PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
    }

    private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Users user = new Users();

        req.setAttribute("user", user);
        findAll(req, resp);
        PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        String id = req.getParameter("username");

        if (id == null) {
            req.setAttribute("error", "User id is required!");
            PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
            return;
        }
        try {

            UserDAO userDAO = new UserDAO();
            Users users = userDAO.findById(id);

            if (users == null) {
                req.setAttribute("error", "User id not found!");
                PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
                return;
            }

            userDAO.delete(id);
            req.setAttribute("message", "user is deleted!");

            req.setAttribute("user", new Users());
            findAll(req, resp);


        } catch (Exception e) {
            e.getStackTrace();

            req.setAttribute("error", "Error: "+ e.getMessage());
        }
        PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String id = req.getParameter("username");

        if (id == null) {
            req.setAttribute("error", "Video id is required!");
            PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
            return;
        }
        try {

            UserDAO userDAO = new UserDAO();
            Users user = userDAO.findById(id);

            req.setAttribute("user", user);
            findAll(req, resp);


        } catch (Exception e) {
            e.getStackTrace();

            req.setAttribute("error", "Error: "+ e.getMessage());
        }
        PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
    }
    private void findAll(HttpServletRequest req, HttpServletResponse resp) {

        try {

            UserDAO userDAO = new UserDAO();

            List<Users> list = userDAO.findAll();

            req.setAttribute("listUser", list);
        } catch (Exception e) {
            e.getStackTrace();

            req.setAttribute("error", "Error: "+ e.getMessage());
        }

    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = SessionUtils.getLoginedUsername(req);
        if(username == null) {
            req.setAttribute("isLogin", false);
        }
        else {
            req.setAttribute("isLogin", true);
        }
        String url = req.getRequestURL().toString();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        if(url.contains("create")) {
            create(req, resp);
            return;
        }
        if(url.contains("delete")) {
            delete(req, resp);
            return;
        }
        if(url.contains("update")) {
            update(req, resp);
            return;
        }
        if(url.contains("reset")) {
            reset(req, resp);
            return;
        }

    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Users users = new Users();

        try {
            BeanUtils.populate(users, req.getParameterMap());

            UserDAO userDAO = new UserDAO();
            Users oldUser = userDAO.findById(users.getId());

            userDAO.update(users);

            req.setAttribute("user", users);
            req.setAttribute("message", "User is update!");

            findAll(req, resp);
        } catch (Exception e) {
            e.getStackTrace();

            req.setAttribute("error", "Error: "+ e.getMessage());
        }
        PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        Users user = new Users();
        try {
            BeanUtils.populate(user, req.getParameterMap());

            UserDAO userDAO = new UserDAO();
            userDAO.create(user);

            req.setAttribute("user", user);
            req.setAttribute("message", "User is inserted! " );

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
        }
        findAll(req, resp);
        PageInfo.prepareAndForward(req, resp, PageType.USER_MANAGEMENT_PAGE);
    }
}
