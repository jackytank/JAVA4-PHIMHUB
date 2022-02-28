package user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoriteDAO;
import dao.VideoDAO;
import model.Video;
import utils.SessionUtils;

@WebServlet("/Favorite")
public class FavoriteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String userId = SessionUtils.getLoginUsername(req);
			List<Video> list = new VideoDAO().findFavoriteVideosByUserId(userId);
			
			req.setAttribute("videos", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/views/user/favorite.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/favorite.jsp").forward(req, resp);
	}
}
