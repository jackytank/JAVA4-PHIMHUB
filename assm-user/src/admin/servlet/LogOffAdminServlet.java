package admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CookiesUtils;
import utils.SessionUtils;

@WebServlet("/LogOffAdmin")
public class LogOffAdminServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CookiesUtils.add("username", null, 0, resp);

		SessionUtils.invalidate(req);
		req.setAttribute("isLogin", false);
		req.getRequestDispatcher("/Login").forward(req, resp);
	}
}
