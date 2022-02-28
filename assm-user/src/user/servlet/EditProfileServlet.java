package user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import model.User;
import utils.SessionUtils;

@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = SessionUtils.getLoginUsername(req);
		
		if (username == null) {
			req.getRequestDispatcher("/Login").forward(req, resp);
			return;
		}
		try {
			User user = new UserDAO().findById(username);
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/user/editprofile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			User user = new User();
			UserDAO userDAO = new UserDAO();
			BeanUtils.populate(user, req.getParameterMap());
			
			String username = SessionUtils.getLoginUsername(req);
			User oldUser = userDAO.findById(username);
			
			user.setAdmin(oldUser.getAdmin());
			userDAO.update(user);
			
			req.setAttribute("message", "User profile updated!!");
			req.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/user/editprofile.jsp").forward(req, resp);

	}
}
