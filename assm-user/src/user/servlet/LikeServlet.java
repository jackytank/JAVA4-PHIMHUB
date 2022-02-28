package user.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FavoriteDAO;
import model.Favorite;
import model.User;
import model.Video;
import utils.SessionUtils;

@WebServlet("/LikeVideo")
public class LikeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!SessionUtils.isLogin(req)) {
			resp.sendRedirect("Login");
			return;
		}
		String page = req.getParameter("page");
		String videoId = req.getParameter("videoId");

		if (videoId == null) {
			resp.sendRedirect("Home");
			return;
		}
		try {
			FavoriteDAO dao = new FavoriteDAO();
			Favorite favorite = new Favorite();
			Video video = new Video();
			video.setVideoId(videoId);
			favorite.setVideo(video);

			String userId = SessionUtils.getLoginUsername(req);
			User user = new User();
			user.setUserId(userId);
			favorite.setUser(user);

			favorite.setLikeDate(new Date());
			dao.insert(favorite);

			req.setAttribute("message", "Video is added to favorite!");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", e.getMessage());
		}
		req.setAttribute("videoId", videoId);
		req.getRequestDispatcher("/Home").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Home");
	}
}
