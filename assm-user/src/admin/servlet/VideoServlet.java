package admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.VideoDAO;
import model.Video;
import utils.SessionUtils;
import utils.UploadUtils;

@WebServlet({ "/video/index", "/video/edit/*", "/video/create", "/video/update", "/video/delete", "/video/reset",
		"/video" })
public class VideoServlet extends HttpServlet {
	VideoDAO videoDAO = new VideoDAO();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = SessionUtils.getLoginUsername(req);
		if (username == null) {
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
		if (URI.contains("create")) {
			create(req, resp);
			return;
		}
		if (URI.contains("reset")) {
			reset(req, resp);
			return;
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("videoId");
		try {

			Video video = videoDAO.findById(id);

			if (video == null) {
				req.setAttribute("error", "Video id not found!");
				req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
				return;
			}

			videoDAO.delete(id);
			req.setAttribute("message", "Video is deleted!");

			req.setAttribute("form", new Video());
			req.setAttribute("videos", videoDAO.findAll());
			findAll(req, resp);

		} catch (Exception e) {
			e.getStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();

		try {
			BeanUtils.populate(video, req.getParameterMap());
			Video oldVideo = videoDAO.findById(video.getVideoId());
			video.setPoster(oldVideo.getPoster());
			videoDAO.update(video);

			req.setAttribute("form", video);
			req.setAttribute("message", "Video is update!");

			findAll(req, resp);
		} catch (Exception e) {
			e.getStackTrace();

			req.setAttribute("error", "Error: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Video> list = videoDAO.findAll();
			req.setAttribute("videos", list);
		} catch (Exception e) {
			e.getStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("form", new Video());
		findAll(req, resp);
		req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String URI = req.getRequestURI();
		String id = "https://www.youtube.com/embed/" + URI.substring(URI.lastIndexOf("/") + 1);
		try {
			Video video = videoDAO.findById(id);
			req.setAttribute("form", video);
			findAll(req, resp);

		} catch (Exception e) {
			e.getStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
		req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
	}

	private void create(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, req.getParameterMap());
			String youtubeId = video.getVideoId().substring(video.getVideoId().lastIndexOf("/") + 1);
			video.setPoster("https://i1.ytimg.com/vi/" + youtubeId + "/hqdefault.jpg");

			videoDAO.insert(video);

			req.setAttribute("form", video);
			req.setAttribute("message", "Video is inserted! ");

		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Error: " + e.getMessage());
		}
		findAll(req, resp);
		req.getRequestDispatcher("/views/admin/videos.jsp").forward(req, resp);
	}
}
