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
import utils.CookiesUtils;
import utils.LoginForm;
import utils.SessionUtils;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = CookiesUtils.get("username", req);

		if (username == null) {
			req.getRequestDispatcher("/views/user/login.jsp").forward(req, resp);
			return;
		}
		SessionUtils.add(req, "username", username);
		req.getRequestDispatcher("/Home").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LoginForm loginForm = new LoginForm();
			BeanUtils.populate(loginForm, req.getParameterMap());

			UserDAO dao = new UserDAO();
			User user = dao.findById(loginForm.getUserId());

			if (user != null && user.getPassword().equals(loginForm.getPassword())) {

				SessionUtils.add(req, "username", user.getUserId());

				if (loginForm.isRemember()) {
					CookiesUtils.add("username", loginForm.getUserId(), 24, resp);
				} else {
					CookiesUtils.add("username", loginForm.getUserId(), 0, resp);
				}
				req.setAttribute("isLogin", true);
				if (user.getAdmin()) {
					req.getRequestDispatcher("/HomeAdmin").forward(req, resp);
				} else {
					req.getRequestDispatcher("/Home").forward(req, resp);
				}
				return;
			} else {
				req.getRequestDispatcher("/Login").forward(req, resp);
			}
			req.setAttribute("error", "Invalid username or password!!");
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
		}
	}
}
