package user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import model.ChangePasswordForm;
import model.User;
import utils.SessionUtils;

@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = SessionUtils.getLoginUsername(req);

		if (userId == null) {
			req.getRequestDispatcher("/Login").forward(req, resp);
			return;
		}
		try {
			User user = new UserDAO().findById(userId);
			req.setAttribute("userId", userId);
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/user/changepassword.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userId = SessionUtils.getLoginUsername(req);
			ChangePasswordForm form = new ChangePasswordForm();
			BeanUtils.populate(form, req.getParameterMap());

			req.setAttribute("userId", userId);

			if (!form.getConfirmPassword().equals(form.getPassword())) {
				req.setAttribute("error", "New password and confirm password didn't matched!!");
			} else if (form.getPassword().equals("") || form.getConfirmPassword().equals("")) {
				req.setAttribute("error", "New password or confirm can't be empty!!");
			} else {
				UserDAO userDAO = new UserDAO();
				userDAO.changePassword(userId, form.getCurrentPassword(), form.getPassword());
				req.setAttribute("message", "User password updated!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/user/changepassword.jsp").forward(req, resp);
	}
}
