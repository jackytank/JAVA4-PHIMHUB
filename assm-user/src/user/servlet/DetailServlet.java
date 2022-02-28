package user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDAO;
import model.Video;

@WebServlet({ "/Detail", "/detail/*" })
public class DetailServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Show main video
			String URI = req.getRequestURI();
			String videoId = URI.substring(URI.indexOf("https://"));
			VideoDAO videoDAO = new VideoDAO();
			Video video = videoDAO.findById(videoId);
			// Show side videos
			List<Video> list = videoDAO.findAll();
			req.setAttribute("videos", list);

			req.setAttribute("video", video);
		} catch (Exception e) {
			req.setAttribute("error", e.getMessage());
		}
		req.getRequestDispatcher("/views/user/detail.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/user/detail.jsp").forward(req, resp);
	}
}
