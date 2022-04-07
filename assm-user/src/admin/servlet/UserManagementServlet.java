package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import model.User;
import utils.SessionUtils;

@WebServlet({ "/user/index", "/user/edit/*", "/user/create", "/user/update", "/user/delete", "/user/reset", "/user" })
public class UserManagementServlet extends HttpServlet {
	UserDAO userDAO = new UserDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = SessionUtils.getLoginUsername(req);
		if (username != null) {
			req.setAttribute("isLogin", false);
		} else {
			req.setAttribute("isLogin", true);
		}
		String URI = req.getRequestURI();
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		if (URI.contains("edit")) {
			edit(req, resp);
			return;
		}
		if (URI.contains("delete")) {
			delete(req, resp);
			return;
		}
		if (URI.contains("update")) {
			update(req, resp);
			return;
		}
		if (URI.contains("reset")) {
//			reset(req, resp);
			return;
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
	}

	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();

		req.setAttribute("form", user);
		req.setAttribute("user", userDAO.findAll());
		req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			List<User> list = userDAO.findAll();
			req.setAttribute("users", list);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("message", e.getMessage());
		}

	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("userId");
		try {

			User user = userDAO.findById(id);

			if (user == null) {
				req.setAttribute("error", "User id not found!");
				req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
				return;
			}
			userDAO.delete(id);
			req.setAttribute("message", "User is deleted!");

			req.setAttribute("form", new User());
			req.setAttribute("user", userDAO.findAll());
			findAll(req, resp);

		} catch (Exception e) {
			e.getStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();

		try {
			BeanUtils.populate(user, req.getParameterMap());

			userDAO.update(user);

			req.setAttribute("form", user);
			req.setAttribute("message", "User is update!");

			req.setAttribute("user", userDAO.findAll());
			findAll(req, resp);
		} catch (Exception e) {
			e.getStackTrace();

			req.setAttribute("error", "Error: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String URI = req.getRequestURI();
		String id = URI.substring(URI.lastIndexOf("/") + 1);

		try {
			User user = userDAO.findById(id);

			req.setAttribute("form", user);
			findAll(req, resp);

		} catch (Exception e) {
			e.getStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/admin/users.jsp").forward(req, resp);
	}
}
