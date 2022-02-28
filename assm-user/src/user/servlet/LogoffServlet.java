package user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CookiesUtils;
import utils.SessionUtils;

@WebServlet("/Logoff")
public class LogoffServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CookiesUtils.add("username", null, 0, resp);
		
		SessionUtils.invalidate(req);
		req.setAttribute("isLogin", false);
		req.getRequestDispatcher("/Home").forward(req, resp);
	}
}
